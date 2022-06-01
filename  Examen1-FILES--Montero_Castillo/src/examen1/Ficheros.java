/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * ESTA PARTE VA A ESTAR EN LA HOJA HTML. Esto tamibien va a estar en el HTML,
 * pero en la parte de la descripcion (aca puse ENTER) de la clase no como
 * titular, y aca podemos dar una (aca puse ENTER) descripcion Gral. del uso y
 * funcionamiento de esta CLASS.
 *
 * @author Software-Notebook
 * @version %I%, %G%
 * @serial
 * @since v1.0
 */
public class Ficheros {

    File archivo;
    String nombre;
    String direccion;
    PrintStream ps;

    /**
     * Crea un archivo en una direccion determinada Ademas se verifica si existe
     *
     * @param direccion
     * @param nombre
     */
    public Ficheros(String direccion, String nombre) {
        ps = new PrintStream(System.out);
        archivo = new File(direccion + nombre);
        if (!archivo.exists()) {

            System.out.println("Se creo el archivo: '" + nombre + "'");
        } else {
            System.out.println("Existe el archivo: '" + nombre + "'");
        }

        try {
            System.setErr(new PrintStream(new File("C:\\Users\\Soft 10\\Desktop\\crash.log")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Guarda un archivo de String en el archivo
     *
     * @param texto
     */
    public void guardarArchivo(String texto) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);

            bw.write(texto);
            bw.newLine();
            bw.flush();

        } catch (IOException ex) {

            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }

                if (bw != null) {
                    bw.close();
                }

            } catch (IOException ex) {

                Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param f
     * @return
     */
    public String leerFileCaracterAcaractet(File f) throws IOException {
        FileReader fr;
        String texto = "", aux = "";
        fr = new FileReader(f);
        try {
            

            int caracter;
            while ((caracter = fr.read()) != -1) {
                char valor = (char) caracter;
                if (valor == '+') {
                    texto += ';';
                } else {

                    texto += valor;
                }
                
            }
            fr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);

        }finally{
            fr.close();
        }
        return texto;
    }

    void eliminar() {
        archivo.delete();
        
    }

}
