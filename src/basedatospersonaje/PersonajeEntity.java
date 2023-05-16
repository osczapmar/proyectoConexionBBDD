
package basedatospersonaje;

/**
 *
 * @author ausias
 */
public class PersonajeEntity extends ORMEntity {
    private int id;
    private String nombre;
    private int vida;
    private double dmg;
    
    private BDConnection c;

    public PersonajeEntity(int id, String nombre, int vida, double dmg) {
        this.id = id;
        this.nombre = nombre;
        this.vida = vida;
        this.dmg = dmg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getDmg() {
        return dmg;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }
    
    
}
