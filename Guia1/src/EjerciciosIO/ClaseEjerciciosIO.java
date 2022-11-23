package EjerciciosIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClaseEjerciciosIO {
    PrintStream ps;
    InputStreamReader is;
    BufferedReader br;
    File archivo;
    FileOutputStream fos;
    PrintStream fps;
    FileReader fr;

    public ClaseEjerciciosIO() {
        ps = new PrintStream(System.out);
    }

    String entrada1(){
        int Byte = -1;
        int dato = -1;

        String texto = "";
        try{
            while(  (Byte = System.in.read()) != '\n'  )
            {
                texto = texto + (char)Byte;
            }
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return texto;
        }
    }

    String entrada2(){
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );

        String texto,textoArreglado = "";

        try {
            ps.print(">");

            texto = br.readLine();

            char[] textoVec = texto.toCharArray();
            for (int i = 0; i < textoVec.length; i++) {
                if (textoVec[i] == 65533 ) {
                    textoVec[i] = '\u00f1';
                }
            }

            for (int i = 0; i < textoVec.length; i++) {
                textoArreglado += textoVec[i];
            }
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return textoArreglado;
        }
    }

    public void ejercicio1a(){
        ps.println("Ingrese el sueldo de una hora de trabajo:");
        int sueldoXHora = Integer.parseInt(entrada1());
        ps.println("Ingrese la cantidad de horas trabajadas:");
        int cantH = Integer.parseInt(entrada1());
        ps.println("Sueldo Bruto del trabajador: $" + (sueldoXHora * cantH));
    }

    public void ejercicio1b(){
        ps.println("Escriba dos angulos de un triangulo:");
        int anguloA = Integer.parseInt(entrada1());
        int anguloB = Integer.parseInt(entrada1());
        int anguloC = anguloA + anguloB;
        ps.print("Lado restante: ");
        ps.println((180 - anguloC) + "°");
    }

    public void ejercicio1c(){
        ps.println("Ingrese el area de un cuadrado (en m²)");
        double area = Integer.parseInt(entrada1())*1.0;
        ps.print("Perimetro del cuadrado: ");
        ps.println((Math.sqrt(area))*4 + "m");
    }

    public void ejercicio1d(){
        ps.println("Ingrese la temperatura (en Fahrenheit)");
        int temp = Integer.parseInt(entrada1());
        ps.print("Temperatura en grados centigrados: ");
        ps.println((temp - 32) * 5/9 + "°C");
    }

    public void ejercicio1e(){
        ps.println("Ingrese un tiempo en Segundos");
        int tiempo = Integer.parseInt(entrada1());
        ps.println("Tiempo en dias: " + (tiempo/86400));
        ps.println("Tiempo en horas: " + (tiempo/3600));
        ps.println("Tiempo en minutos: " + (tiempo/60));
        ps.println("Tiempo en segundos: " + tiempo);
    }

    public void ejercicio1f(){
        ps.println("Ingrese el precio del producto");
        double precio = Double.parseDouble(entrada1());
        ps.println("Planes disponibles:");
        double plan1 = precio - (precio * 0.10);//900
        ps.println("Plan 1: \n    Al contado: $" + plan1);
        double plan2 = precio + (precio * 0.10);//1100
        ps.println("Plan 2: \n    Al contado: $" + (plan2/2) + " + 2 cuotas: $" + ((plan2/2)/2) + " c/u");
        double plan3 = precio + (precio * 0.15);//1150
        ps.println("Plan 3: \n    Al contado: $" + (plan3/4) + " + 5 cuotas: $" + (plan3 - (plan3/4)) /5 + " c/u");
        double plan4 = precio + (precio * 0.25);//1250
        ps.println("Plan 4 - 8 cuotas totales: \n    4 cuotas: $" + (plan4 * 0.60)/4 + " c/u + 4 cuotas: $" + (plan4 -(plan4 * 0.60))/4 + " c/u");
    }

    public void ejercicio1g(){
        ps.println("Ingrese su signo zodiacal:");
        String signo = entrada1();
        ps.print("Nacimiento entre el ");
        switch(signo){
            case "Aries":
                ps.println("18 de abril y 13 de mayo");
                break;
            case "Tauro":
                ps.println("13 de mayo y 21 de junio");
                break;
            case "Geminis":
                ps.println("21 de junio y 20 de julio");
                break;
            case "Cancer":
                ps.println("20 de julio y 10 de agosto");
                break;
            case "Leo":
                ps.println("10 de agosto y 16 de septiembre");
                break;
            case "Virgo":
                ps.println("16 de septiembre y 30 de octubre");
                break;
            case "Libra":
                ps.println("30 de octubre y 23 de noviembre");
                break;
            case "Escorpio":
                ps.println("23 de noviembre y 29 de noviembre");
                break;
            case "Ofiuco":
                ps.println("29 de noviembre y 17 de diciembre");
                break;
            case "Sagitario":
                ps.println("17 de diciembre y 20 de enero");
                break;
            case "Capricornio":
                ps.println("20 de enero y 16 de febrero");
                break;
            case "Acuario":
                ps.println("16 de febrero y 11 de marzo");
                break;
            case "Piscis":
                ps.println("11 de marzo y 18 de abril");
                break;
        }
    }

    /*-PUNTO 2-*/

    public void ejercicio2a(){
        ps.println("Ingrese tres apellidos:");
        String apellido1 = entrada2();
        String apellido2 = entrada2();
        String apellido3 = entrada2();

        String[] apellidos = {apellido1, apellido2, apellido3};
        Arrays.sort(apellidos);
        ps.println("Apellidos ordenados alfabeticamente:");

        for (String i : apellidos) {
            ps.println("    -"+i);
        }
    }

    public void ejercicio2b(){
        ps.println("Ingrese 4 numeros:");
        int n1 = Integer.parseInt(entrada2());
        int n2 = Integer.parseInt(entrada2());
        int n3 = Integer.parseInt(entrada2());
        int n4 = Integer.parseInt(entrada2());

        int[] aux = {n1, n2, n3, n4};

        Arrays.sort(aux);

        ps.print("El menor numero es ");
        ps.println(aux[0]);
    }

    public void ejercicio2c(){
        ps.println("Ingrese un numero para saber si es par o impar:");

        int n = Integer.parseInt(entrada2());
        if (n % 2 == 0) {
            ps.println("El numero es par");
        }else{
            ps.println("El numero es impar");
        }
    }
    
    public void ejercicio2d(){
        ps.println("Ingrese dos numeros reales:");
        
        int n1 = Integer.parseInt(entrada2());
        int n2 = Integer.parseInt(entrada2()); 
        
        if(n1 >= n2){
            if(n1 % n2 == 0){
                ps.println(n1 + " es divisible por " + n2);
            }else{
                ps.println(n1 + " no es divisible por " + n2);
            }
            
        }else if(n1 <= n2){
            if(n2 % n1 == 0){
                ps.println(n2 + " es divisible por " + n1);
            }else{
                ps.println(n2 + " no es divisible por " + n1);
            }            
        } 
    }

    public void ejercicio2e(){
        ps.println("Ingrese su fecha de nacimiento separado por barras(ej: 1/1/2000)");
        String fecha = entrada2();

        String[] aux = fecha.split("/");
        int dia = Integer.parseInt(aux[0]);
        int mes = Integer.parseInt(aux[1]);

        switch (mes) {
            case 1:
                if(dia >= 1 && dia <= 19){
                    ps.println("Tu signo es capricornio");
                }else if(dia >= 20 && dia <= 31){
                    ps.println("Tu signo es acuario");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 2:
                if(dia >= 1 && dia <= 18){
                    ps.println("Tu signo es acuario");
                }else if(dia >= 19 && dia <= 28){
                    ps.println("Tu signo es piscis");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 3:
                if(dia >= 1 && dia <= 20){
                    ps.println("Tu signo es piscis");
                }else if(dia >= 21 && dia <= 31){
                    ps.println("Tu signo es aries");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 4:
                if(dia >= 1 && dia <= 19){
                    ps.println("Tu signo es aries");
                }else if(dia >= 20 && dia <= 30){
                    ps.println("Tu signo es tauro");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 5:
                if(dia >= 1 && dia <= 21){
                    ps.println("Tu signo es tauro");
                }else if(dia >= 22 && dia <= 31){
                    ps.println("Tu signo es geminis");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 6:
                if(dia >= 1 && dia <= 20){
                    ps.println("Tu signo es geminis");
                }else if(dia >= 21 && dia <= 30){
                    ps.println("Tu signo es cancer");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 7:
                if(dia >= 1 && dia <= 22){
                    ps.println("Tu signo es cancer");
                }else if(dia >= 23 && dia <= 31){
                    ps.println("Tu signo es leo");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 8:
                if(dia >= 1 && dia <= 22){
                    ps.println("Tu signo es leo");
                }else if(dia >= 23 && dia <= 31){
                    ps.println("Tu signo es virgo");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 9:
                if(dia >= 1 && dia <= 22){
                    ps.println("Tu signo es virgo");
                }else if(dia >= 23 && dia <= 30){
                    ps.println("Tu signo es libra");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 10:
                if(dia >= 1 && dia <= 22){
                    ps.println("Tu signo es libra");
                }else if(dia >= 23 && dia <= 31){
                    ps.println("Tu signo es escorpio");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 11:
                if(dia >= 1 && dia <= 21){
                    ps.println("Tu signo es escorpio");
                }else if(dia >= 22 && dia <= 30){
                    ps.println("Tu signo es sagitario");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            case 12:
                if(dia >= 1 && dia <= 21){
                    ps.println("Tu signo es sagitario");
                }else if(dia >= 22 && dia <= 31){
                    ps.println("Tu signo es capricornio");
                }else{
                    ps.println("Dia ingresado incorrecto");
                }   break;
            default:
                if(dia >= 32){
                    ps.println("Dia y mes ingresados incorrector");

                }else{
                    ps.println("Mes ingresado incorrecto");
                }   break;
        }
    }

    public void ejercicio2f(){
        ps.println("Ingrese 2 nombres y apellidos para indicar cual es mas largo:");
        String[] apellido1 = entrada2().split(" ");
        String[] apellido2 = entrada2().split(" ");

        if(apellido1[1].length() > apellido2[1].length()){
            ps.println(apellido1[0] + " Tiene un apellido mas largo que " + apellido2[0]);
        }else if(apellido1[1].length() < apellido2[1].length()){
            ps.println(apellido2[0] + " Tiene un apellido mas largo que " + apellido1[0]);
        }else{
            ps.println("Ambos tienen un apellido igual de largo");
        }
    }

    public void ejercicio2g(){
        ps.println("Ingrese un numero para mostrar su tabla de multiplicar:");
        int n = Integer.parseInt(entrada2());
        if( n >= 1){
            for (int i = 1; i <= 10; i++) {
                ps.println( n + " * " + i + " = " + n*i);
            }
        }else{
            ps.println("Ingrese un numero natural!");
        }
    }

    public void ejercicio2h(){
        ps.println("Ingrese un numero para determinar si es primo o no:");

        int n = Integer.parseInt(entrada2());

        for(int i = 2; i < n; i++) {
            if(n%i==0)
                ps.println(n + " no es un numero primo");
                break;
        }
        ps.println(n + " es un numero primo");
    }

    /*-PUNTO 3-*/

    public void ejercicio3a(){
        ps.println("Ingrese datos hasta no escribir nada (espacio en blanco y enter 2 veces):");

        archivo = new File("Archivo.txt");
        try {
            if(!archivo.exists()){
                archivo.createNewFile();
            }


            fos = new FileOutputStream(archivo);
            fps = new PrintStream(fos);

            ArrayList<String> aux = new ArrayList<String>();

            while(!"".equals(entrada2())){
                aux.add(entrada2());
            }

            fps.print(aux.get(aux.size()-1));

        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ejercicio3b(){
        ps.println("Ingrese datos hasta no escribir nada (espacio en blanco y enter 2 veces):");

        archivo = new File("Archivo.txt");
        try {
            if(!archivo.exists()){
                archivo.createNewFile();
            }


            fos = new FileOutputStream(archivo,true);
            fps = new PrintStream(fos);


            String texto = entrada2();

            char[] vectorChar = texto.toCharArray();
            for (int i = 0; i < vectorChar.length; i++) {
                    fps.println(vectorChar[i]);

            }
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public void ejercicio3c(){ 
        archivo = new File(System.getProperty("user.home") + "/Desktop/numeros.txt"); 
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            fos = new FileOutputStream(archivo,true);
            fps = new PrintStream(fos);

            for (int i = 0; i <= 1000; i++) {
                if (i % 2 == 0) {
                    fps.println(i);
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void ejercicio3d(){
        archivo = new File(System.getProperty("user.home") + "/Desktop/numeros.txt");
        try{
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                ps.println(br.readLine());
            }

        }catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(fr != null){
                    fr.close();
                }
                if(br != null){
                    br.close();
                }
            }catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ejercicio3e(){
        archivo = new File(System.getProperty("user.home") + "/Desktop/numeros.txt");
        if(!archivo.exists()){
            ejercicio3c();
        }

        try{
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            fos = new FileOutputStream(archivo,true);
            fps = new PrintStream(fos);


            String linea = "";

            ArrayList<String> aux = new ArrayList<String>();
            while ((linea = br.readLine()) != null) {
                if(Integer.parseInt(linea) % 2 == 0){
                    aux.add(linea);
                }
            }

            archivo.delete();
            archivo.createNewFile();

            for (String i : aux) {
                fps.println(i);
            }
        }catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if (fos != null) {
                    fos.close();
                }
                if(fr != null){
                    fr.close();
                }
                if(br != null){
                    br.close();
                }
            }catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public void ejercicio3f(){
        archivo = new File(System.getProperty("user.home") + "/Desktop/numeros.txt");
        File primosF = new File(System.getProperty("user.home") + "/Desktop/primos.dat");

        try{

            if(!archivo.exists()){
                ejercicio3c();
            }

            if(!primosF.exists()){
                primosF.createNewFile();
            }

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            fos = new FileOutputStream(archivo,true);
            fps = new PrintStream(fos);

            FileOutputStream primoFos = new FileOutputStream(primosF,true);
            PrintStream primoFps = new PrintStream(primoFos);

            String linea = "";

            ArrayList<Integer> aux = new ArrayList<Integer>();
            while ((linea = br.readLine()) != null) {
                aux.add(Integer.parseInt(linea));
            }


            archivo.delete();
            archivo.createNewFile();

            for (Integer i : aux) {
                if(isPrime(i)){
                    primoFps.println(i);
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if (fos != null) {
                    fos.close();
                }
                if(fr != null){
                    fr.close();
                }
                if(br != null){
                    br.close();
                }
            }catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ejercicio3g(){

        archivo = new File(System.getProperty("user.home") + "/Desktop/caracteres.dat");
        if (!archivo.exists()) {
            try{
                archivo.createNewFile();
            }catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }




        ps.println("Ingrese 10 palabras que contengan ñ");
        String[] palabras = new String[10];
        String[] palabrasA = new String[10];

        for (int i = 0; i < 10; i++) {
            palabras[i] = entrada2();
            palabrasA[i] = palabras[i].replace("ñ", "ni");
        }

        ps.println("Fichero original:");
        for (String i: palabras) {
            ps.println(i);
        }

        try {
            fos = new FileOutputStream(archivo,true);
            fps = new PrintStream(fos);


            ps.println("\nFichero arreglado:");
            for (String i: palabrasA) {
                ps.println(i);
                fps.println(i);
            }



        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

}
