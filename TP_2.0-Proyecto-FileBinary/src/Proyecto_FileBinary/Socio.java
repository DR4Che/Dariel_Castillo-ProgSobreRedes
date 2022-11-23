package Proyecto_FileBinary;

import static Proyecto_FileBinary.Utilidades.mostrarPorPantalla;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Socio extends Persona {

    private float cuota;
    private TipoMembrecia membrecia; //Enum    
    // (numero hoyo , puntos)
    private ArrayList< Map<Integer, Integer>> partidasJugadas;
    private BaseDeUsuario usuarios;

    /**
     * Metodo Contructor
     * 
     * @param lista
     * @param membrecia
     * @param DNI
     * @param fechaDeIngreso
     * @param nombre
     * @param apellido
     * @param direccion
     * @param edad
     * @param genero
     * @param numContacto 
     */
    public Socio(BaseDeUsuario lista, TipoMembrecia membrecia, int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        super(DNI, fechaDeIngreso, nombre, apellido, direccion, edad, genero, numContacto);

        this.cuota = -1;
        this.membrecia = membrecia;
        this.partidasJugadas = new ArrayList<>();
        this.usuarios = lista;
    }

    /**
     * Calcula el atributo {@link Socio#cuota} del {@link Socio} dependiendo el tipo de {@link Socio#membrecia} y {@link Socio#fechaDeIngreso}
     */
    @Override
    public void calcular() {
        switch (this.membrecia) {
            case Bronce:
                this.cuota = 5000;
                break;
            case Plata:
                this.cuota = 10000;
                break;
            case Oro:
                this.cuota = 20000;
                break;
            case Black:
                this.cuota = 50000;
                break;
            case Platino:
                this.cuota = 100000;
                break;
        }
        
        if ( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) >= 2) {
            this.cuota -= this.cuota*.5;
        }else if( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) > 2 && (LocalDate.now().getYear() - fechaDeIngreso.getYear()) <= 10 ){
            this.cuota -= this.cuota*.10;
        }else if( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) > 10 && (LocalDate.now().getYear() - fechaDeIngreso.getYear()) <= 15 ){
            this.cuota -= this.cuota*.20;
        }else if( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) > 15 ){
            this.cuota -= this.cuota*.30;
        }
    }
    
    /**
     * Muestra los datos del {@link Socio}
     */
    public void mostrarDatos() {
        Utilidades.mostrarPorPantalla("SOCIO: \n"
                + "\tNOMBRE Y APELLIDO: " + this.nombre + " " + this.apellido + "\n"
                + "\tEDAD: " + this.edad + "\n"
                + "\tDIRECCION: " + this.direccion + "\n"
                + "\tGENERO: " + this.genero + "\n"
                + "\tTEL: " + this.numContacto + "\n"
                + "\tDNI: " + this.DNI + "\n"
                + "\t----------------------\n"
                + "\tCUOTA: " + this.cuota + "\n"
                + "\tMEMBRECIA: " + this.membrecia + "\n"
                + "....................................\n"
        );

        Utilidades.mostrarListaArray(this.partidasJugadas);
        Utilidades.mostrarPorPantalla("========================================");
    }

    /**
     * Muestra el menu de opciones del objeto {@link Socio}
     * 
     * @return {@link Boolean}
     */
    @Override
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                mostrarPorPantalla(
                        "\tMENÚ SOCIO\n\n"
                        + "\t[1] Cargar un Socio\n"
                        + "\t[2] Cargar Partidas de un Socio\n"
                        + "\t[3] Calcular Cuota\n"
                        + "\t[4] Mostrar Socios\n"
                        + "\t[5] Mostrar Partidas por socios\n"
                        + "\t[6] Cambiar Membresia\n"
                        + "\t[7] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '7');

            switch (op) {
                case '1':
                    this.cargarNuevoSocio();
                    break;
                case '2':
                    this.cargarPartida((Socio) usuarios.elegirPersona(Socio.class));
                    break;
                case '3':
                    usuarios.actualizarSueldosCoutas();
                    break;
                case '4':
                    usuarios.mostrarPersonas(Socio.class);
                    break;
                case '5':
                    this.mostrarPartidaxSocio();
                    break;
                case '6':
                    this.cambiarMembresia((Socio) usuarios.elegirPersona(Socio.class));
                    break;
                case '7':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }

    /**
     * Ejecuta el metodo {@link Utilidades#mostrarPorPantalla(java.lang.String)}
     */
    @Override
    public void proceder() {
        Utilidades.mostrarPorPantalla("JUEGA PLACIDAMENTE");
    }

    /**
     * Añade un nuevo Objeto de la clase {@link Socio} a {@link BaseDeUsuario#bUsuario}
     */
    private void cargarNuevoSocio() {  
         
        Utilidades.mostrarPorPantalla("Elegir Membrecia: ");
        TipoMembrecia mem = Utilidades.elegirMembresia();
        Utilidades.mostrarPorPantalla("Ingrese el dni: ");
        int dni = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Fecha de Ingreso: ");
        Date fecha = Utilidades.leerFecha();
        Utilidades.mostrarPorPantalla("Ingrese el Nombre: ");
        String nombre = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Apellido: ");
        String apellido = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Direcion: ");
        String direccion = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Edad: ");
        int edad = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Genero: ");
        Genero gen = Utilidades.leerGenero();
        Utilidades.mostrarPorPantalla("Ingrese el Telefono: ");
        String tel = Utilidades.leerTexto();

        Socio s = new Socio(usuarios, mem, dni, fecha, nombre, apellido, direccion, edad, gen, tel);

        usuarios.agregarUsuario(s);
    }

    /**
     * Agrega una nueva partida a la lista {@link Socio#partidasJugadas} 
     * @param s
     */
    public void cargarPartida(Socio s) {
        Map<Integer,Integer> partida = new HashMap<>();
        
        Utilidades.mostrarPorPantalla("Ingrese la cantidad de hoyos que jugó:");
        int cantHoyos = Utilidades.leerNumero();
        
        
        for (int i = 1; i <= cantHoyos; i++) {
            Utilidades.mostrarPorPantalla("Numero de hoyo: " + i + "\nPuntos: ");
            partida.put(i, Utilidades.leerNumero());
        }
        
        s.partidasJugadas.add(partida);
    }

    /**
     * Modifica el atributo {@link Socio#membrecia} del objeto {@link Socio} dado como parametro de entrada
     * @param s
     */
    private void cambiarMembresia(Socio s) {
        boolean continuar = false;
        do {
            Utilidades.mostrarPorPantalla(
                "\t\t\tSeleccione la nueva membresia:\n"
                +"\t\t\t\t1. Bronce\n"
                +"\t\t\t\t2. Plata\n"
                +"\t\t\t\t3. Oro\n"
                +"\t\t\t\t4. Black\n"
                +"\t\t\t\t5. Platino\n"
                +"\t\t\t\t6. Volver\n"
            );
            switch(Utilidades.obtenerOpcion()){
                case '1':
                    s.membrecia = membrecia.Bronce;
                    continuar = true;
                    break;
                case '2':
                    s.membrecia = membrecia.Plata;
                    continuar = true;
                    break;
                case '3':
                    s.membrecia = membrecia.Oro;
                    continuar = true;
                    break;
                case '4':
                    s.membrecia = membrecia.Black;
                    continuar = true;
                    break;
                case '5':
                    s.membrecia = membrecia.Platino;
                    continuar = true;
                    break;
                case '6':
                    continuar = true;
                    break;
                default:
                    Utilidades.mostrarPorPantalla("Opcion incorrecta!");
                    break;
            }
        } while (!continuar);
    }

    /**
     * Muestra las por pantalla cada partida de cada Objeto {@link Socio} de la lista {@link BaseDeUsuario#bUsuario}
     */
    private void mostrarPartidaxSocio() {
        for (Persona p : usuarios.bUsuario.subList(2, usuarios.bUsuario.size())) {
            if (p instanceof Socio) {
                Utilidades.mostrarPorPantalla("Socio: " + ((Socio) p).nombre);
                Utilidades.mostrarListaArray(((Socio) p).partidasJugadas);
            }
        }
    }
}
