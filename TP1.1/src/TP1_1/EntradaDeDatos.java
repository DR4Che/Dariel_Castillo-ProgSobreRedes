package TP1_1;

import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntradaDeDatos {
    
    InputStreamReader is;
    PrintStream ps;
    BufferedReader br = null;

    public EntradaDeDatos() {
        ps = new PrintStream(System.out);
    }
    
    public void menu(){

        String texto = "";
        
        while(!"0".equals(texto)){
            ps.println("Ingrese una operacion matematica (0 para salir)");
            texto = leer();
            
            char[] aux = texto.toCharArray();  
            String signo = "";
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] == '+' || aux[i] == '-'|| aux[i] == '*' || aux[i] == '/') {

                    signo = String.valueOf(aux[i]);
                }

            }            
            StringTokenizer st = new StringTokenizer( texto , signo );

            switch(signo){
                case "+":
                    ps.println( texto+ "=" + (Integer.parseInt(st.nextToken())*1.0 + Integer.parseInt(st.nextToken())*1.0) );
                    break;
                case "-":
                    ps.println( texto+ "=" + (Integer.parseInt(st.nextToken())*1.0 - Integer.parseInt(st.nextToken())*1.0) );
                    break;
                case "*":
                    ps.println( texto+ "=" + (Integer.parseInt(st.nextToken())*1.0 * Integer.parseInt(st.nextToken())*1.0) );
                    break;
                case "/":
                    ps.println( texto+ "=" + (Integer.parseInt(st.nextToken())*1.0 / Integer.parseInt(st.nextToken())*1.0) );
                    break;
            }   
        }      
    }
  
    String leer(){
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );

        String texto = "";

        try {
            texto = br.readLine();

        } catch (IOException ex) {
            Logger.getLogger(EntradaDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return texto;
        }
    }
}
