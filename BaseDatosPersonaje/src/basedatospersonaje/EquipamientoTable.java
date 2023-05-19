package basedatospersonaje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class EquipamientoTable extends ORMTable {

    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public EquipamientoTable() {
        super("equipamiento");
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters i Setters">
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Operacions amb la Base de Dades">
    /**
     * Inserta l'objecte a la taula de Personajes
     *
     * @return int: nombre de files afectades
     * @throws NullConnectionException: La connexió és nul·la o es troba tancada
     * @throws SQLException: Qualsevol altra excepció SQL
     */
    @Override
    public int Insert(ORMEntity o) throws NullConnectionException, SQLException {
        if (getBDConnection() == null) {
            throw new NullConnectionException();
        }

        if (getBDConnection().getConnection() == null) {
            throw new NullConnectionException();
        }

        try {
            if (getBDConnection().getConnection().isClosed()) {
                throw new NullConnectionException();
            }
        } catch (SQLException e) {
            throw new NullConnectionException();
        }
        EquipamientoEntity p = (EquipamientoEntity) o;
        String sqlCommand = "INSERT INTO equipamiento (arma, equipado, id) "
                + "VALUES ('" + p.getArma()+ "'," + p.isEquipado()+ "," + p.getId()+")";

        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();

        //Confirma els canvis
        getBDConnection().getConnection().commit();

        return numFilesAfectades;
    }

    /**
     * Obté tots els registres de la taula
     * @return Retorna una llista amb tots els registres de la taula
     * @throws NullConnectionException
     * @throws SQLException 
     */
    @Override
    public ArrayList<EquipamientoEntity> GetAll() throws NullConnectionException, SQLException {

        ArrayList<EquipamientoEntity> resultList = new ArrayList<EquipamientoEntity>();

        Statement consulta = getBDConnection().getConnection().createStatement();
        ResultSet resultat = consulta.executeQuery("SELECT * FROM equipamiento");

        while (resultat.next()) {
            EquipamientoEntity e = new EquipamientoEntity(
                    resultat.getString("arma"), 
                    resultat.getBoolean("equipado"), 
                    resultat.getInt("id"));
            resultList.add(e);
        }

        //Tancar resultat i consulta
        resultat.close();
        consulta.close();

        return resultList;
    }
    // </editor-fold>

    @Override
    public int Delete(ORMEntity o) throws NullConnectionException, SQLException {
        if (getBDConnection() == null) {
            throw new NullConnectionException();
        }

        if (getBDConnection().getConnection() == null) {
            throw new NullConnectionException();
        }

        try {
            if (getBDConnection().getConnection().isClosed()) {
                throw new NullConnectionException();
            }
        } catch (SQLException e) {
            throw new NullConnectionException();
        }
        PersonajeEntity p = (PersonajeEntity) o;
        String sqlCommand = "DELETE FROM equipamiento WHERE id = " + p.getId();
        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();

        //Confirma els canvis
        getBDConnection().getConnection().commit();

        return numFilesAfectades;
    }

    @Override
    public int Update(ORMEntity o,String nombre) throws NullConnectionException, SQLException {
        return -1;
    }
    public String EncontrarPersonaje(int id) throws NullConnectionException, SQLException {

        String nombre = "";

        Statement consulta = getBDConnection().getConnection().createStatement();
        ResultSet resultat = consulta.executeQuery("SELECT * FROM personaje");

        while (resultat.next()) {
            PersonajeEntity p = new PersonajeEntity(
                    resultat.getInt("id"), 
                    resultat.getString("nombre"), 
                    resultat.getInt("vida"), 
                    resultat.getDouble("dmg"));
            if(p.getId()==id){
                nombre = p.getNombre();
            }
        }

        //Tancar resultat i consulta
        resultat.close();
        consulta.close();

        return nombre;
    }

}
