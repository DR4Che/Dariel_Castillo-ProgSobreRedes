package Proyecto_FileBinary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilidades {

    private static PrintStream ps = null;
    private static InputStreamReader isr = null;
    private static BufferedReader br = null;

    /**
     * Muestra por pantalla el mensaje dado como parametro de entrada
     * @param mensaje 
     */
    public static void mostrarPorPantalla(String mensaje) {
        ps = new PrintStream(System.out);

        ps.println(mensaje);
    }
    
    /**
     * Guarda el error dado como parametro de entrada en un archivo de registro de errores
     * @param ex
     * @param error 
     */
    public static void mensajeError(String ex, String error) {        
        try {
            System.setErr(
                        new PrintStream(
                                new FileOutputStream(
                                        new File("Error.log")), true)
                );
            Object[] msg = {ex, error};
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, msg);
        }catch (FileNotFoundException e) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Devuelve la opcion ingresada por pantalla
     * @return {@link Character}
     */
    static char obtenerOpcion() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        char opt = 0;
        try {
            opt = br.readLine().charAt(0);
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        return opt;
    }

    /**
     * Devuelve el numero ingresado por pantalla
     * @return {@link Integer}
     */
    static int leerNumero() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        try {
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            return 0;
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Devuelve el puesto seleccionado por pantalla
     * @return {@link Puestos}
     */
    public static Puestos elegirPuesto() {
        char op;
        do {
            String opciones = "\n\t\tMENU DE OPCIONES\n\n";
            for (Puestos p : Puestos.values()) {
                opciones += "\t\t\t[" + (p.ordinal() + 1) + "] " + p.name() + "\n";
            }
            mostrarPorPantalla(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < '1' || Character.getNumericValue(op) > Puestos.values().length);

        return Puestos.values()[Character.getNumericValue(op) - 1];
    }

    /**
     * Devuelve la fecha ingresada por pantalla
     * @return {@link Date}
     */
    static Date leerFecha() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        Date fecha;

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            fecha = df.parse(br.readLine());

            return fecha;
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            return (new Date("00/00/0000"));
        }
    }

    /**
     * Devuelve el texto ingresado por pantalla
     * @return {@link Puestos}
     */    
    static String leerTexto() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        String texto = "";
        try {
            texto = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        return texto;
    }

    /**
     * Devuelve el genero seleccionado por pantalla
     * @return {@link Genero}
     */    
    static Genero leerGenero() {
        char op;
        do {
            String opciones = "\n\t\tMENU DE OPCIONES\n\n";
            for (Genero g : Genero.values()) {
                opciones += "\t\t\t[" + (g.ordinal() + 1) + "] " + g.name() + "\n";
            }
            mostrarPorPantalla(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < '1' || Character.getNumericValue(op) > Puestos.values().length);

        return Genero.values()[Character.getNumericValue(op) - 1];
    }

    /**
     * Devuelve la membresia seleccionada por pantalla
     * @return {@link TipoMembrecia}
     */
    static TipoMembrecia elegirMembresia() {
        char op;
        do {
            String opciones = "\n\t\tMENU DE OPCIONES\n\n";
            for (TipoMembrecia i : TipoMembrecia.values()) {
                opciones += "\t\t\t[" + (i.ordinal() + 1) + "] " + i.name() + "\n";
            }
            mostrarPorPantalla(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < '1' || Character.getNumericValue(op) > Puestos.values().length);

        return TipoMembrecia.values()[Character.getNumericValue(op) - 1];
    }

    /**
     * Devuelve por pantalla la clave y el valor de la lista de diccionarios dada como parametro de entrada
     * @param partidasJugadas 
     */
    static void mostrarListaArray(ArrayList<Map<Integer, Integer>> partidasJugadas) {
        int i = 0;
        for (Map<Integer, Integer> partida : partidasJugadas){
            
            Utilidades.mostrarPorPantalla("\tPartida N°: " + (i+1));

            for (Map.Entry<Integer, Integer> play : partida.entrySet()) {
                Utilidades.mostrarPorPantalla("\t\tHoyo N°: " + play.getKey() + "\t\tPuntaje: " + play.getValue());
            }
            i++;
        }
    }

}
