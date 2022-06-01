/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;

/**
 *
 * @author Soft-02
 */
public class Funciones {

    public Funciones() {
    }

    /**
     * En esta parte se lee el archivo y se elimina para volverse a crear y
     * devuelve el texto leido
     *
     * @return @throws IOException
     */
    public String restructurado() throws IOException {
        Ficheros archivo = new Ficheros("C:\\Users\\Soft 10\\Desktop\\", "juegos.dat");
        String texto = archivo.leerFileCaracterAcaractet(new File("C:\\Users\\Soft 10\\Desktop\\juegos.dat"));
        archivo.eliminar();
        System.out.println(texto);
        Ficheros error = new Ficheros("C:\\Users\\Soft 10\\Desktop\\", "crash.log");

        archivo.guardarArchivo(texto);
        return texto;
    }

    /**
     * muetra las victorias por fechas
     *
     * @param texto
     * @return
     */
    public String mostrarvictorias(String texto) {

        LinkedList<String> fechas = new LinkedList<String>();
        LinkedList<String> victorias = new LinkedList<String>();
        char caracter;
        int i = -1;
        boolean valor = true;
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        while (i <= 30) {
            i++;
            fechas.add(i, texto.split(";")[(i * 6)]);
            victorias.add(i, texto.split(";")[(i * 6 + 1)]);
    

        }
        i = -1;
        while (i <= 15) {
            i++;
            System.out.println(fechas.get(i*2));
            //System.out.println(victorias.get(i));
        }

        return texto;

    }
}
