package Turnos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En esta clase pondremos funcionalidaes basicas de comun uso.
 *
 */
public class Utilidades {

    private static InputStreamReader isr = null;
    private static BufferedReader br = null;

    /**
     * Devuelve la opcion ingresada por pantalla
     *
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
     *
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
     * Devuelve el texto ingresado por pantalla
     *
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
     * Devuelve la fecha ingresada por pantalla
     *
     * @return {@link Date}
     */
    static Date leerFecha() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            return df.parse(br.readLine());
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            return (new Date("00/00/0000"));
        }
    }

    /**
     * Devuelve el genero seleccionado por pantalla
     *
     * @return {@link Genero}
     */
    static Genero leerGenero() {
        int op;
        do {
            String opciones = "\n\t\tMENU DE OPCIONES\n\n";
            for (Genero g : Genero.values()) {
                opciones += "\t\t\t[" + (g.ordinal() + 1) + "] " + g.name() + "\n";
            }
            System.out.println(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < 1 || Character.getNumericValue(op) > Genero.values().length);

        return Genero.values()[Character.getNumericValue(op) - 1];
    }

    /**
     * Devuelve la cobertura seleccionada por pantalla
     *
     * @return {@link Cobertura}
     */
    static Cobertura leerCobertura() {
        int op;
        do {
            String opciones = "\n\t\tMENU DE OPCIONES\n\n";
            for (Cobertura c : Cobertura.values()) {
                opciones += "\t\t\t[" + (c.ordinal() + 1) + "] " + c.name() + "\n";
            }
            System.out.println(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < 1 || Character.getNumericValue(op) > Cobertura.values().length);

        return Cobertura.values()[Character.getNumericValue(op) - 1];
    }

    /**
     * Devuelve la especialidad seleccionada por pantalla
     *
     * @return {@link Especialidad}
     */
    static Especialidad leerEspecialidad() {
        int op;
        do {
            String opciones = "\n\t\tMENU DE OPCIONES\n\n";
            for (Especialidad e : Especialidad.values()) {
                opciones += "\t\t\t[" + (e.ordinal() + 1) + "] " + e.name() + "\n";
            }
            System.out.println(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < 1 || Character.getNumericValue(op) > Especialidad.values().length);

        return Especialidad.values()[Character.getNumericValue(op) - 1];
    }

}
