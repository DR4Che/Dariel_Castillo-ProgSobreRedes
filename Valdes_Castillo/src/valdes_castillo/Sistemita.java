/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valdes_castillo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Soft 06
 */
public class Sistemita implements Serializable {
    private static final long serialVersionUID = -1000L;
    private Librero librero;
        
    public Sistemita() {
        librero = new Librero();
    }

    public Sistemita deSerializar(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Sistemita s = (Sistemita) ois.readObject();
        return s;
    }

    public void serializar(String archivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();
    }

    public void prender() {
        
        Articulos a1 = new Libro(new Date(2003,10,05), "autor1", 300, 1, "nombre1", "genero1");
        Articulos a2 = new Libro(new Date(2001,10,05), "autor2", 400, 2, "nombre2", "genero2");
        Articulos a3 = new Libro(new Date(2002,10,05), "autor3", 600, 3, "nombre3", "genero3");
        
        librero.agregarArticulo(a1);
        librero.agregarArticulo(a2);
        librero.agregarArticulo(a3);
    }

    void mostrar() {
        System.out.println(librero.devolverArticulo(0).nombre);
    }
 
}
