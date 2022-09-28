package valdes_castillo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManejoDeDatos {
    PrintStream ps;
    InputStreamReader is;
    BufferedReader br;
    
    //constructor
    public ManejoDeDatos() {
        is = new InputStreamReader( System.in );
        ps = new PrintStream( System.out );
        br = new BufferedReader( is );
    }
    
    //metodos
    public char obtenerOpcion() {
        char opt = 0;
        try {
            opt = br.readLine().charAt(0);
        } catch (IOException ex) {
            Logger.getLogger(ManejoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return opt;
    }
    
    /**
     * @return 
     */
    public ArrayList readBytes(){
        ArrayList<Integer> caracteresList = new ArrayList<Integer>();
        String texto = "";
        int Byte = -1;
        
        try {
            while(  (Byte = System.in.read()) != '\n'  ){
                //texto = texto + (char)Byte;
                caracteresList.add( Byte );
                //System.out.println(Byte);
            }
        } catch (IOException ex) {
            Logger.getLogger(ManejoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return caracteresList;
    }
    
    String read() {
        try {
            String a = br.readLine();
            return a;
            
        } catch (IOException ex) {
            Logger.getLogger(ManejoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
