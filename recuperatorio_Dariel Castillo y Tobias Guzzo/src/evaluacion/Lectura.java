/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Software-Notebook
 */
public class Lectura {

    InputStreamReader is;
    BufferedReader br;
    PrintStream ps;
    
    public Lectura() {
        
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );
        
        ps = new PrintStream(System.out);
    }
    
    void leer() {
        
        try {
            String a = br.readLine();
            
            ps.println( a );
            
        } catch (IOException ex) {
            Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
}
