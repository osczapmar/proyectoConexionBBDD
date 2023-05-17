/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatospersonaje;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Llibreria d'utilitats
 *
 * @author author
 * @version version
 *
 */

public class Utils {
    public static final String USER = "a22joaguesan_proy";
    public static final String PWD = "proyectoBD1";
    public static final String URL = "labs.inspedralbes.cat";
    public static final String PORT = "3306";
    public static final String BD_NAME = "a22joaguesan_proyecto";
// <editor-fold defaultstate="collapsed" desc="Implementació de LlegirInt()">

    private static Scanner scan=null;
       
    public static int LlegirInt() {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan);

        return result;
    }
    public static int LlegirInt(String missatge) {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan, missatge);
        
        return result;
    }

    public static int LlegirInt(Scanner scan) {
        return LlegirInt(scan, null);
    }
    
    public static int LlegirInt(Scanner scan, String missatge, int valorMin, int valorMax)
    {
        int result =0;
        do {
            result = LlegirInt(scan, missatge);
        } while (result < valorMin || result > valorMax);
        
        return result;
    }

    public static int LlegirInt(Scanner scan, String missatge) {
        boolean dadesCorrectes;
        int result = 0;
        do {
            if (missatge != null) {
                System.out.print(missatge);
            }
            dadesCorrectes = scan.hasNextInt();
            if (dadesCorrectes) {
                result = scan.nextInt();
            } else if (scan.hasNext()) {
                scan.nextLine();
            }
        } while (!dadesCorrectes);

        return result;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Implementació de Imprimir arrays()">
    /**
     * Imprime un vector de ints
     * @param a vector
     */
public static void vectorint(int[] a){
    for(int i=0;i<a.length;++i){
        System.out.print(a[i]+" ");
    }
    System.out.println("");
}
/**
 * Imprime un vector de doubles
 * @param a vector
 */
public static void vectordouble(double[] a){
    for(int i=0;i<a.length;++i){
        System.out.print(a[i]+" ");
    }
    System.out.println("");
}
/**
 * Imprime un vector de strings
 * @param a vector
 */
public static void vectorString(String[] a){
    for(int i=0;i<a.length;++i){
        System.out.print(a[i]+" ");
    }
    System.out.println("");
}
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Implementació de Imprimir matrices()">
/**
 * Imprime matrices tipo int
 * @param a Es la matriz a imprimir
 */
public static void matrizint(int[][] a){
    for(int i=0;i<a.length;++i){
        for(int j=0;j<a[i].length;++j){
            System.out.print(a[i][j]+" ");
        }
        System.out.println("");
    }
}
/**
 * Imprime matrices tipo double
 * @param a Es la matriz a imprimir
 */
public static void matrizdouble(double[][] a){
    for(int i=0;i<a.length;++i){
        for(int j=0;j<a[i].length;++j){
            System.out.print(a[i][j]+" ");
        }
        System.out.println("");
    }
}
/**
 * Imprime matrices tipo string
 * @param a Es la matriz a imprimir
 */
public static void matrizString(String[][] a){
    for(int i=0;i<a.length;++i){
        for(int j=0;j<a[i].length;++j){
            System.out.print(a[i][j]+" ");
        }
        System.out.println("");
    }
}
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Pedir numeros">
/**
 * Pide numeros tipo double
 * @param a Mensaje que quieres mostrar antes de pedir valores
 * @return 
 */
public static double pedirnumD(String a) {
        double num;
        Scanner s=new Scanner(System.in);
        System.out.print(a);
        while (!s.hasNextDouble()) {
            s.next();
            System.out.println("ERROR");
            System.out.print(a);
        }
        num = s.nextDouble();
        return num;
    }
public static int escollirOpcio(int min, int max) {
		int opcio = 0;
		boolean valid = false;
		do {
			opcio = LlegirInt();
			if (opcio <= max && opcio >= min) {
				valid = true;
			} else {
				System.out.println("Opcio incorrecta");
			}
		} while (!valid);
		return opcio;
	}
public static int pedirnum(String a) {
        int num;
        Scanner s=new Scanner(System.in);
        System.out.print(a);
        while (!s.hasNextInt()) {
            s.next();
            System.out.println("ERROR");
            System.out.print(a);
        }
        num = s.nextInt();
        return num;
    }

    /**
     * Agafa un int entre un rang de valors
     *
     * @param max int més gran
     * @param min int més petit
     * @param mensaje Mensaje que se mostrara cuando el numero no cumpla las condiciones
     * @return int que es trobi en el rang especificat
     */
    public static int escollirOpcio(int min, int max, String mensaje) {
        int opcio = 0;
        boolean valid = false;
        do {
            opcio = pedirnum("");
            if (opcio <= max && opcio >= min) {
                valid = true;
            } else {
                System.out.println(mensaje);
            }
        } while (!valid);
        return opcio;
    }

// </editor-fold>    	
// <editor-fold defaultstate="collapsed" desc="Colores">
        
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Ficheros de texto">
    public static void BorrarLinea() {
        int numLineaBorrar = scan.nextInt();
        int numLinea = 1;
        // Creamos el enlace con el fichero en el disco para leer
        BufferedReader buf = AbrirFicheroLectura("fichero", true);
        // Creamos el enlace con el fichero en el disco para escribir
        PrintWriter pw = AbrirFicheroEscritura("fichero" + "_copia", true, false);

        String linea = LeerLinea(buf);
        while (linea != null) {
            if (numLinea != numLineaBorrar) {
                EscribirLinea(pw, linea);
            }
            linea = LeerLinea(buf);
            numLinea++;
        }

        CerrarFichero(buf);
        CerrarFichero(pw);

        BorrarFichero("fichero");
        RenombrarFichero("fichero" + "_copia", "fichero");
    }

    public static void LeerFichero() {
        // Creamos el enlace con el fichero en el disco
        BufferedReader buf = AbrirFicheroLectura("fichero", true);

        String linea = LeerLinea(buf);
        while (linea != null) {
            System.out.println(linea);
            linea = LeerLinea(buf);
        }

        CerrarFichero(buf);

    }

    /**
     * Funcion que abre un fichero y, opcionalmente, lo crea si no existe
     * 
     * @param nomFichero Nombre del fichero a abrir
     * @param crear Si lo que queremos crear en el caso que no exista
     * @return 
     */
    public static File AbrirFichero(String nomFichero, boolean crear) {
        File result = null;

        result = new File(nomFichero);

        if (!result.exists()) {
            if (crear) {
                try {
                    result.createNewFile();
                } catch (IOException ex) {                    
                    result = null;
                }
            } else {
                result = null;
            }
        }

        return result;
    }

    /**
     * Abre un fichero para lectura
     *
     * @param nomFichero Nombre del fichero
     * @param crear Indica si queremos crear el fichero o no, en el caso que no
     * exista
     * @return BufferedReader apuntando al fichero
     */
    public static BufferedReader AbrirFicheroLectura(String nomFichero, boolean crear) {
        BufferedReader br = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el reader para poder leer el fichero¡
            FileReader reader;
            try {
                reader = new FileReader(f);
                // Buffered reader para poder leer más comodamente
                br = new BufferedReader(reader);
            } catch (FileNotFoundException ex) {
                System.out.println("BOOM");
            }
        }

        return br;
    }

    /**
     * Abre un fichero para escritura
     *
     * @param nomFichero Nombre del fichero
     * @param crear Indica si queremos crear el fichero o no, en el caso que no
     * exista
     * @return BufferedReader apuntando al fichero
     */
    public static PrintWriter AbrirFicheroEscritura(String nomFichero, boolean crear, boolean blnAnyadir) {
        PrintWriter pw = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el writer para poder escribir en el fichero¡
            FileWriter writer;
            try {
                writer = new FileWriter(f, blnAnyadir);
                // PrintWriter para poder escribir más comodamente
                pw = new PrintWriter(writer);
            } catch (IOException ex) {
                System.out.println("BOOM");
            }
        }

        return pw;
    }

    /**
     * Cierra el fichero
     *
     * @param br fichero a cerrar
     */
    public static void CerrarFichero(BufferedReader br) {
        try {
            br.close();
        } catch (IOException ex) {
            System.out.println("BOOM");
        }
    }

    /**
     * Cierra el fichero
     *
     * @param pw fichero a cerrar
     */
    public static void CerrarFichero(PrintWriter pw) {
        pw.flush();
        pw.close();
    }

    /**
     * Lee una linea del fichero
     *
     * @param br BufferedReader con el fichero a leer
     * @return String
     */
    public static String LeerLinea(BufferedReader br) {
        String linea = "";

        try {
            linea = br.readLine();
        } catch (IOException ex) {
            System.out.println("BOOM");
        }

        return linea;
    }

    /**
     * Lee una linea del fichero
     *
     * @param pw PrintWrite con el fichero a leer
     * @linea Linea a escribir
     */
    public static void EscribirLinea(PrintWriter pw, String linea) {
        pw.println(linea);
    }

    public static void EscribirFichero(boolean blnAnyadir) {
        // Creamos el enlace con el fichero en el disco
        PrintWriter pw = AbrirFicheroEscritura("fichero", true, blnAnyadir);

        String linea = PedirLineaTeclado();
        while (!linea.equals("")) {
            EscribirLinea(pw, linea);
            linea = PedirLineaTeclado();
        }

        CerrarFichero(pw);
    }

    public static String PedirLineaTeclado() {
        return scan.nextLine();
    }

    public static void BorrarFichero(String filename) {
        File f = new File(filename);
        f.delete();
    }

    public static void RenombrarFichero(String filename_origen, String filename_final) {
        File f = new File(filename_origen);
        File f2 = new File(filename_final);
        f.renameTo(f2);
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Ficheros binarios">
public static DataOutputStream AbrirFicheroEscrituraBinario1(String nomFichero, boolean crear, boolean blnAnyadir) {
        DataOutputStream dos = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el writer para poder escribir en el fichero¡
            FileOutputStream writer;
            try {
                writer = new FileOutputStream(f, blnAnyadir);
                // PrintWriter para poder escribir más comodamente
                dos = new DataOutputStream(writer);
            } catch (IOException ex) {
                System.out.println("BOOM");
            }
        }

        return dos;
    }
public static void CerrarFicheroBinario(DataOutputStream dos) {
        try {
            dos.flush();
            dos.close();
        } catch (IOException ex) {
            System.out.println("BOOM");
        }
    }

    public static void CerrarFicheroBinario(DataInputStream dis) {
        try {
            dis.close();
        } catch (IOException ex) {
            System.out.println("BOOM");
        }
    }
    public static DataInputStream AbrirFicheroLecturaBinario1(String nomFichero, boolean crear) {
        DataInputStream dis = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el writer para poder escribir en el fichero¡
            FileInputStream reader;
            try {
                reader = new FileInputStream(f);
                // PrintWriter para poder escribir más comodamente
                dis = new DataInputStream(reader);
            } catch (IOException ex) {
                System.out.println("BOOM");
            }
        }

        return dis;
    }

    

    
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Ficheros binarios acceso directo">
    public static RandomAccessFile AbrirRAF(String archivo, String mode) {
        RandomAccessFile raf = null;
        File f = AbrirFichero(archivo, true);
        try {
            raf = new RandomAccessFile(f, mode);
        } catch (FileNotFoundException ex) {
            System.out.println("BOOM");
        }
        return raf;
    }

    public static void CerrarRAF(RandomAccessFile raf) {
        try {
            raf.close();
        } catch (IOException ex) {
            System.out.println("BOOM");
        }
    }
    /*RandomAccessFile.seek(long)
    RandomAccessFile.length()-Para llegar al final del fichero*/
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Menus">
public static int Menu(String ...opciones) {
        int opcio;
        int num=1;
        System.out.println("---------------");
        for(String a:opciones){
            System.out.println(num+". "+a);
            num++;
        }
        opcio = escollirOpcio(1, num,"Invalid");
        return opcio;
    }
    
    /**
     * Funcion para mostrar por pantalla un menu y elegir una opcion
     * @param datos ArrayList de Strings con las opciones
     * @return la opcion
     */
    public static int MenuAL(ArrayList<?> datos) {
        int opcio;
        int num=1;
        System.out.println("--------------");
        for (var a : datos) {
            System.out.println(num+". "+a);
            num++;
        }
        opcio = escollirOpcio(1, num,"Invalid");
        return opcio;
    }    
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="ArrayLists">    
    public static void PrintAL(ArrayList<?> lista){
        for(var a: lista){
            System.out.print(a + " ");
        }
        System.out.println("");
    }
// </editor-fold>
    public static String llegirString(String f) {
        String texto = null;
        Scanner s=new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            System.out.print(f);
                texto = s.nextLine();
                valido = true;
        }
        return texto;
    }
}