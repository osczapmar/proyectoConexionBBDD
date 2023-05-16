/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basedatospersonaje;

import static basedatospersonaje.Utils.llegirString;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ausias
 */
public class main {

    static final String USER = "a22joaguesan_proy";
    static final String PWD = "proyectoBD1";
    static final String URL = "labs.inspedralbes.cat";
    static final String PORT = "3306";
    static final String BD_NAME = "a22joaguesan_proyecto";
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            
            //Crear la connexió a la BD
            BDConnection bdCon = new BDConnection(URL, PORT, BD_NAME, USER, PWD);
            
            
            //Crear l'objecte de la taula persona i assignar la connexió
            PersonajeTable pt = new PersonajeTable();
            pt.setConnection(bdCon);  
                     
            System.out.println("Vols inserir una nova persona?");
            if (scan.nextLine().equalsIgnoreCase("S"))
            {
                // inserir una Persona            
                PersonajeEntity p = new PersonajeEntity(8, "Nova",700,25.5);
                              
                pt.Insert(p);
                
                System.out.println("Segur que vols validar els canvis realitzats?");    
                if (scan.nextLine().equalsIgnoreCase("S")) 
                    //Confirma els canvis
                    bdCon.confirmarCanvis();
                else
                    //Desfà els canvis
                    bdCon.desferCanvis();
            }
            ArrayList<PersonajeEntity> listaPersonas = pt.GetAll();
            
            for (PersonajeEntity p : listaPersonas)
            {
                System.out.println("----");
                System.out.println("ID: " + p.getId());
                System.out.println("Nom: " + p.getNombre());
                System.out.println("Vida: " + p.getVida());
                System.out.println("Daño: " + p.getDmg());
                System.out.println("----");
            }
                     
            System.out.println("Vols cambiar el nombre?");
            if (scan.nextLine().equalsIgnoreCase("S"))
            {
                String nom = llegirString("nombre nuevo: ");
                listaPersonas = pt.GetAll();
                // inserir una Persona            
                PersonajeEntity p = listaPersonas.get(0);
                              
                pt.Update(p,nom);
                
                System.out.println("Segur que vols validar els canvis realitzats?");    
                if (scan.nextLine().equalsIgnoreCase("S")) 
                    //Confirma els canvis
                    bdCon.confirmarCanvis();
                else
                    //Desfà els canvis
                    bdCon.desferCanvis();
            }
            
            // Consultar totes les persones
            listaPersonas = pt.GetAll();
            
            for (PersonajeEntity p : listaPersonas)
            {
                System.out.println("----");
                System.out.println("ID: " + p.getId());
                System.out.println("Nom: " + p.getNombre());
                System.out.println("Vida: " + p.getVida());
                System.out.println("Daño: " + p.getDmg());
                System.out.println("----");
            }
            
            System.out.println("Vols eliminar?");
            if (scan.nextLine().equalsIgnoreCase("S"))
            {
                listaPersonas = pt.GetAll();
                // inserir una Persona            
                PersonajeEntity p = listaPersonas.get(0);
                              
                pt.Delete(p);
                
                System.out.println("Segur que vols validar els canvis realitzats?");    
                if (scan.nextLine().equalsIgnoreCase("S")) 
                    //Confirma els canvis
                    bdCon.confirmarCanvis();
                else
                    //Desfà els canvis
                    bdCon.desferCanvis();
            }

            // Desconnexio de la base de dades
            bdCon.closeConnection();
            
            
            System.out.println("Rollback i desconnexio realitzats correctament.");
        } catch (ClassNotFoundException ce) {
            System.out.println("Error al carregar el driver");
        } catch (SQLException se) {
            System.out.println("Excepcio: ");
            System.out.println();
            System.out.println("El getSQLState es: " + se.getSQLState());
            System.out.println();
            System.out.println("El getMessage es: " + se.getMessage());
        } catch (NullConnectionException ex) {
            System.out.println("Fallo");
        }
    }    
    
}
