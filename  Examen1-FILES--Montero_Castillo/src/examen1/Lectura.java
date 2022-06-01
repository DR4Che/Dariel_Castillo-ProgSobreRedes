package examen1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lectura {

    InputStreamReader is;
    BufferedReader br;
    PrintStream ps;

    public Lectura() {

        is = new InputStreamReader(System.in);
        br = new BufferedReader(is);

        ps = new PrintStream(System.out);
    }

    /**
     * Lee datos ingresados por pantalla y los devuelve como String.
     *
     * @return
     */
    public String leer() {
        String temp = "";
        try {
            temp = br.readLine().trim();
        } catch (IOException ex) {
            Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    /**
     * Lee datos ingresados por pantalla y los devuelve como Int.
     *
     * @return
     */
    public int leerInt() {
        int temp = 0;
        try {
            temp = Integer.parseInt(br.readLine().trim());
        } catch (IOException ex) {
            Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;

    }

    /**
     * Lee datos ingresados por pantalla y los devuelve como float.
     *
     * @return
     */
    public float leerFloat() {
        float temp = 0;
        try {
            temp = Float.parseFloat(br.readLine().trim());
        } catch (IOException ex) {
            Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;

    }

}
