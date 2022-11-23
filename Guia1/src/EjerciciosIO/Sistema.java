package EjerciciosIO;

public class Sistema {

    public Sistema() {
    }
    
    public void menu(){
        ClaseEjerciciosIO io = new ClaseEjerciciosIO();
        
        io.ps.println("-----------------------------------------\n           Guia de Ejercicios\n-----------------------------------------\n"
                + "Ingrese una opción:"
                + "\n   1. Ejercicio N°1"
                + "\n   2. Ejercicio N°2"
                + "\n   3. Ejercicio N°2"
                + "\n   0. Salir."
        );
    
        switch(Integer.parseInt(io.entrada2())){
            case 1:
                io.ps.println("Ejercicio N°1:"
                        + "\n   1. Dados el valor de una hora de trabajo y la cantidad de horas trabajadas, la computadora muestra el valor del sueldo bruto."
                        + "\n   2. Dados los valores de dos de los ángulos interiores de un triángulo, la computadora muestra el valor del restante."
                        + "\n   3. Dada la superficie de un cuadrado (en m2), la computadora muestra su perímetro."
                        + "\n   4. Dada una temperatura en grados Fahrenheit, la computadora la muestra en grados centígrados."
                        + "\n   5. Dado un tiempo en segundos, la computadora lo muestra expresado en días, horas, minutos y segundos."
                        + "\n   6. Dado el precio de un artículo, la computadora muestra los valores a pagar según cada plan. Una casa de artículos para el hogar ofrece a sus clientes los siguientes planes de pago:"
                        + "\n       -Plan 1: 100% al contado. Se hace el 10% de descuento sobre el precio publicado."
                        + "\n       -Plan 2: 50% al contado y el resto en 2 cuotas iguales. El precio publicado se incrementa en un 10%."
                        + "\n       -Plan 3: 25% al contado y el resto en 5 cuotas iguales. El precio publicado se incrementa en un 15%."
                        + "\n       -Plan 4: Totalmente financiado en 8 cuotas. El 60% se reparte en partes iguales en las primeras 4 cuotas y el resto se reparte en partes iguales en las últimas 4 cuotas. El precio publicado se incrementa en un 25%."
                        + "\n   7. Dado el signo zodiacal del usuario, la computadora muestra su mes de nacimiento aproximado."
                );                
                switch(Integer.parseInt(io.entrada2())){
                    case 1:
                        io.ejercicio1a();
                        menu();
                    case 2:
                        io.ejercicio1b();
                        menu();
                    case 3:
                        io.ejercicio1c();
                        menu();
                    case 4:
                        io.ejercicio1d();
                        menu();
                    case 5:    
                        io.ejercicio1e();
                        menu();
                    case 6:    
                        io.ejercicio1f();
                        menu();
                    case 7:
                        io.ejercicio1g();
                        menu();
                    default:
                        io.ps.println("Error");
                }      
            case 2:
                io.ps.println("Ejercicio N°2:"                                             
                        + "\n   1. Dados tres apellidos, la computadora los muestra ordenados alfabéticamente."    
                        + "\n   2. Dados cuatro números reales, la computadora indica cuál es el menor."
                        + "\n   3. Dado un número, la computadora indica si es par o impar."
                        + "\n   4. Dados dos números reales, la computadora indica si el mayor es divisible por el menor."
                        + "\n   5. Dada la fecha de nacimiento de una persona, la computadora muestra su signo del zodíaco."
                        + "\n   6. Dado el nombre y apellido de 2 personas, la computadora muestra cuál de los 2 tiene el apellido más largo."
                        + "\n   7. Dado un entero N natural, la computadora muestra su tabla de multiplicar."
                        + "\n   8. Dado un número natural, la computadora indica si es primo o no."
                );
                switch(Integer.parseInt(io.entrada2())){
                    case 1:
                        io.ejercicio2a();
                        menu();
                    case 2:
                        io.ejercicio2b();
                        menu();
                    case 3:
                        io.ejercicio2c();
                        menu();
                    case 4:
                        io.ejercicio2d();
                        menu();
                    case 5:    
                        io.ejercicio2e();
                        menu();
                    case 6:    
                        io.ejercicio2f();
                        menu();
                    case 7:
                        io.ejercicio2g();
                        menu();
                    case 8:
                        io.ejercicio2h();
                        menu();
                    default:
                        io.ps.println("Error");
                }
            case 3:
                io.ps.println("Ejercicio N°3:"
                        + "\n    1. Crear un archivo de texto (en la carpeta del proyecto) que guarde solo el último dato que el usuario escribe por consola."
                        + "\n    2. Crear un archivo de texto (en la carpeta del proyecto) que guarde TODOS los valores NUMERICOS que ingrese el usuario por consola, cada uno en un renglón (puede ingresar otros datos que no sean numero OJO)."
                        + "\n    3. Crear un archivo de texto (fuera de la carpeta del proyecto) que se llame “números.txt” que guarde los números pares desde el 0 al 1000."
                        + "\n    4. Utilizar el archivo creado anteriormente “números.txt” y leer los valores para mostrarlos por la consola."
                        + "\n    5. Utilizar el archivo creado anteriormente “números.txt” y borrarle todos los renglones que contengas números impares."
                        + "\n    6. Utilizar el archivo creado anteriormente “números.txt” (con los números impares eliminados) y colocar en otro archivos de texto “primos.dat” (fuera de la carpeta del proyecto y de la carpeta que tiene el archivo “números.txt”) todos los números de ”números.txt” que sean primos."
                        + "\n    7. Crear un archivo de texto plano (fuera de la carpeta del proyecto) que se llame “caracteres.dat”, cargarle 10 palabras que contengan la letra ‘ñ’ mediante consola. Luego mostrar las 10 palabras por consola con la leyenda “Fichero original: ” y luego editar el fichero para que cambie todas las apariciones de la letra ‘ñ’ por su fonético ‘nie-nio’ y mostrar de nuevo las palabras con la leyenda “Fichero arreglado:”."
                );
                switch(Integer.parseInt(io.entrada2())){
                    case 1:
                        io.ejercicio3a();
                        menu();
                    case 2:
                        io.ejercicio3b();
                        menu();
                    case 3:
                        io.ejercicio3c();
                        menu();
                    case 4:
                        io.ejercicio3d();
                        menu();
                    case 5:    
                        io.ejercicio3e();
                        menu();
                    case 6:    
                        io.ejercicio3f();
                        menu();
                    case 7:
                        io.ejercicio3g();
                        menu();
                    default:
                        io.ps.println("Error");
                }                
            case 0:
                break;
            default:
                io.ps.println("Error");
        }
    }
}
