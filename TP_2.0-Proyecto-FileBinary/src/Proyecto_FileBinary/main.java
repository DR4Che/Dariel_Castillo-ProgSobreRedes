package Proyecto_FileBinary;

import java.io.IOException;

public class main {
    
    public static void main(String[] args) {
        
        Sistemita s = new Sistemita();
        String archivo = "datos.bin";
        
        try
        {
            s = s.deSerializar( archivo );
            Utilidades.mostrarPorPantalla("VIEJO");
        }catch( IOException | ClassNotFoundException ex ){
            s.creacion();
            Utilidades.mostrarPorPantalla("NUEVO");
        }finally{
            //s.usuarios.elegirSocio().mostrarDatos();
            s.prender();
        }
        
        try
        {
            s.serializar( archivo );
        }catch(IOException ex){
            Utilidades.mensajeError( ex.getMessage() , "ERROR: No se pudo Serializar." );
        }
        
    }
    
}
