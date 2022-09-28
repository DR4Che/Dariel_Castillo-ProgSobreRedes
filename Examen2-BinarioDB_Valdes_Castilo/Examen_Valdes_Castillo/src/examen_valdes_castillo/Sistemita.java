package examen_valdes_castillo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    void leerDatosDelDump() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        File archivo = new File( "datos.bin" );

        try {
            Sistemita datos = null;

            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                datos = (Sistemita) ois.readObject();

                //guarda en la base de datos
                for (Articulos articulo : librero.getArticulos() ) {
                    LibroDAO dao = new LibroDAO();
                    
                    dao.agregar( (Libro)articulo  );
                }
               
            }
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sistemita.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Sistemita.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (archivo.exists()) {
                archivo.delete();
            }
        }
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
        this.leerDatosDelDump();
    }
 
}
