package TP1_0;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistema {
    PrintStream ps;
    FlujoDeDatos f;
    File archivo;

    public Sistema() {
        ps = new PrintStream(System.out);
        f = new FlujoDeDatos();
    }
    
    public File origen1(){
        ps.println("Ingrese la cantidad de valores que desea guardar en el archivo:");
        
        int a = Integer.parseInt(f.leer());
        archivo = new File("Archivo.txt");

        
        ps.println("Ingrese " + a + " Elementos:");
        archivo.delete();
        
        for (int i = 0; i < a; i++) {
            f.escribirArchivo(  f.leer()   ,   archivo  );
        }
        return archivo;
    }
    
    public int[] origen2(){
        ps.println("Ingrese la cantidad de elementos que desea guardar en un vector:");
        int n = Integer.parseInt(f.leer());
        
        int[] vector = new int[n];
        
        ps.println("Ingrese " + n + " numeros:");
        
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer.parseInt(f.leer());
        }
        
//        ps.println("Los valores ingresados son:");
//        
//        for (int i = 0; i < vector.length; i++) {
//            ps.println(vector[i]);
//        }
        
        return vector;
    }
    
    
    public void ejercicio2(int[] vector){
        archivo = new File("resultados.txt");
        File error = new File("error.txt");
        if(archivo.exists() | error.exists()){
            archivo.delete();
            error.delete();
        }
        double rta = (vector[0]*1.0) / (vector[1]*1.0);
        f.escribirArchivo(vector[0] + "/" + vector[1] + "=" + rta, archivo);
        for (int i = 2; i < vector.length; i++) {            
            try{
                if(vector[i]==0)
                {
                    throw new ArithmeticException();
                }else{
                    f.escribirArchivo(rta + "/" + vector[i] + "=" + rta/vector[i], archivo); 
                    rta /= vector[i];
                }
            }catch(ArithmeticException | NullPointerException ex){            
                f.escribirArchivo((rta + "/" + vector[i] + "=error"), error);
            }
        }            
    }    
}
