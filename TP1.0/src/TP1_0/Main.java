package TP1_0;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    

    
    public static void main(String[] args) {
        
        Sistema s = new Sistema();
        
        s.ejercicio2(s.f.leerArchivo(s.origen1()));
    }
}
