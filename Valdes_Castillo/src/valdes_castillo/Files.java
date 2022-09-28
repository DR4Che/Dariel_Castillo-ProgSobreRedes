package valdes_castillo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

/**
 *
 * @author Agustin Winer
 */
public class Files {
    PrintStream ps;
    InputStreamReader is;
    BufferedReader br;
    
    //constructor
    public Files() {
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );
        ps = new PrintStream( System.out );
    }
    
    //metodos
    /**
     * Crea un archivo .txt en blanco. El nombre del archivo es el parametro
     * 
     * @param str 
     */
    public File newFile(String fileName){
        File file = new File( fileName );
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try {
            if(file.exists()){
                file.delete();
                file.createNewFile();
            }

            fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);

            ps.println( "File '"+fileName+"' created" );
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return file;
    }
    public File getFile(String fileName){
        File file = new File( fileName );
        
        if(file.exists()){
            return file;
        }else{
            ps.println( "File not found" );
            return null;
        }
    }
    public String readFile(File file) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        String text = "";
        while ((line = br.readLine()) != null) {
            text += "\n" + line;
        }

        br.close();
        fr.close();

        return text;
    }
    public void deleteFile(String fileName){
        File file = new File( fileName );
        
        if(file.exists()){
            file.delete();
            ps.println( "File deleted" );
        }else{
            ps.println( "File not found" );
        }
    }
    public void deleteFile(File file){
        if(file.exists()){
            file.delete();
            ps.println( "File deleted" );
        }else{
            ps.println( "File not found" );
        }
    }
    public void writeFile( File file,String text ){
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {

            if( file.exists() ){
                fw = new FileWriter(file, true);
                bw = new BufferedWriter(fw);
                
                bw.write( text );
                bw.newLine();
                ps.println( "File '"+file.getName()+"' modified succesfully" );
            }

        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}