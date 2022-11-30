
package tpfinal;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlujoDeDatos {
    PrintStream ps;
    InputStreamReader is;
    BufferedReader br;
    
    //constructor
    public FlujoDeDatos() {
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );
        ps = new PrintStream(System.out);
    }
    
    public String LeerFileConBuffer(File f) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String linea = "", texto = "";
        while ((linea = br.readLine()) != null) {
            texto += "\n" + linea;
        }

        br.close();
        fr.close();

        return texto;
    }
    
    //metodos
    /**
     * Crea un archivo .txt en blanco. El nombre del archivo es el parametro
     * 
     * @param str 
     */
    public File crearTxt(String nombreArchivo){
        File archivo = new File( nombreArchivo );
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try {
            if(archivo.exists()){
                archivo.delete();
                archivo.createNewFile();
            }

            fw = new FileWriter(archivo, true);
            pw = new PrintWriter(fw);

            //pw.println( "Hola" );
            
            escribir( "Archivo '"+nombreArchivo+"' creado con exito" );
        } catch (IOException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return archivo;
    }
    
    
    /**
     * Devuelve un ArrayList con los codigos ascii (int) de cada caracter ingresado
     * 
     * @return 
     */
    ArrayList leerEnBytes(){
        ArrayList<Integer> caracteresList = new ArrayList<Integer>();
        String texto = "";
        int Byte = -1;
        
        try {
            while(  (Byte = System.in.read()) != '\n'  )
            {
                //texto = texto + (char)Byte;
                caracteresList.add( Byte );
                //System.out.println(Byte);
            }
        } catch (IOException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caracteresList;
    }
    
    String leer() {
        try {
            String a = br.readLine();
            return a;
            //ps.println( a );
            
        } catch (IOException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    void escribir( String str ){
        String aux = str;
        ps.println( aux );
    }
    void escribir2( String str ){
        String aux = str;
        ps.print( aux );
    }
    void escribir( int I ){
        int aux = I;
        ps.println( aux );
    }
    void escribir( double d ){
        double aux = d;
        ps.println( aux );
    }
}