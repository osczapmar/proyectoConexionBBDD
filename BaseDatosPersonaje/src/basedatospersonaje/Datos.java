/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package basedatospersonaje;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public interface Datos {
    public static final String USER = "a22joaguesan_proy";
    public static final String PWD = "proyectoBD1";
    public static final String URL = "labs.inspedralbes.cat";
    public static final String PORT = "3306";
    public static final String BD_NAME = "a22joaguesan_proyecto";
    
    public static void GestionDatos (BDConnection bdCon, PersonajeTable pt,JFrame ventana, EquipamientoTable et,boolean dispose) {
        try {
            String missatge = "¿Deseas guardar los cambios?";
            int guardado =JOptionPane.showConfirmDialog(null, missatge,
                    "DATOS", JOptionPane.YES_NO_OPTION);
            
            if (guardado==0) {
                try {
                    bdCon.confirmarCanvis();
                    if (dispose) {
                        ventana.dispose();
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            else{
                bdCon.desferCanvis();
                
            }
            // Desconnexio de la base de dades
            bdCon.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
