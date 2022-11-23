package Proyecto_FileBinary;

import static Proyecto_FileBinary.Utilidades.mostrarPorPantalla;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Sistemita implements Serializable {

    private static final long serialVersionUID = -1000L;
    BaseDeUsuario usuarios;
    
    /**
     * Metodo Contructor
     */    
    public Sistemita() {
        usuarios = new BaseDeUsuario();
    }

    /**
     * Des-serializa el achivo binario para cargar los datos de la anterior ejecucion
     * 
     * @param archivo
     * @return {@link Sistemita}
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Sistemita deSerializar(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Sistemita s = (Sistemita) ois.readObject();
        return s;
    }

    /**
     * Ejecuta funciones para el inicio del sistema
     */
    public void creacion() {
        Utilidades.mostrarPorPantalla(" EL SISTEMA SE HA ARRANCADO. ");
        
        Empleado e = new Empleado( usuarios , 0, Puestos.Gerente, 0, new Date(0000, 00, 00), "empleado", "empleado", "", 0, Genero.SG, "0000-0000");
        Socio s = new Socio( usuarios , TipoMembrecia.Bronce, 0, new Date(0000,00,00), "socio", "socio", "", 0, Genero.SG, "0000-0000");

        usuarios.agregarUsuario( e );
        usuarios.agregarUsuario( s );

    }

    /**
     * Serializa la ejecucion del programa en un archivo binario (realiza un DAM de memoria)
     * 
     * @param archivo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void serializar(String archivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();
    }

    
    /**
     * ESTE PASARIA A SER NUETRO MAIN
     */
    public void prender() {
        // aca vamos a hacer un menu
        boolean corriendo = true;
                
        while( corriendo )
        {
            //Utilidades.mostrarMenu();
            corriendo = mostrarMenu();    
        }
        Utilidades.mostrarPorPantalla("GRACIAS POR USAR MI PROGRAMA.");
              
    }

    /**
     * Muestra un menu de opciones disponibles
     * @return {@link Boolean}
     */
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                mostrarPorPantalla(
                        "MENÚ PRINCIPAL\n\n"
                        + "[1] Menu de Empleados\n"
                        + "[2] Menu de Socios\n"
                        + "[3] Salir\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '3');

            switch (op) {
                case '1':
                    continuar = usuarios.devolverUsurio(0).mostrarMenu() ;
                    break;
                case '2':
                    continuar = usuarios.devolverUsurio(1).mostrarMenu() ;
                    break;
                case '3':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }     
    
}
