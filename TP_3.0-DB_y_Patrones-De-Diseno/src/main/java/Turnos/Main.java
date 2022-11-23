package Turnos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Ejecutable
 *
 */
public class Main {

    /**
     * Metodo ejecutable
     * @param args args
     */
    public static void main(String[] args) {
        Sistemita s = new Sistemita();
        String archivo = "datos.bin";

        try {
            s = s.deSerializar(archivo);
            System.out.println("Sistema recuperado");
        } catch (IOException | ClassNotFoundException ex) {
            s.creacion();
            System.out.println("Sistema nuevo inicializado");
        } finally {
            s.prender();
        }

        try {
            s.serializar(archivo);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
