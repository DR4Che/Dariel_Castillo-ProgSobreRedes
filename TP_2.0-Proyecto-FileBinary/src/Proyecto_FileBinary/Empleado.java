package Proyecto_FileBinary;

import java.util.Date;
import java.time.LocalDate;
import static Proyecto_FileBinary.Utilidades.mostrarPorPantalla;

public class Empleado extends Persona {

    private int codigo;
    private Puestos puesto;
    private float sueldo;
    private BaseDeUsuario usuarios;

    /**
     * Metodo Contructor
     * 
     * @param lista
     * @param codigo
     * @param puesto
     * @param DNI
     * @param fechaDeIngreso
     * @param nombre
     * @param apellido
     * @param direccion
     * @param edad
     * @param genero
     * @param numContacto 
     */
    public Empleado(BaseDeUsuario lista, int codigo, Puestos puesto, int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        super(DNI, fechaDeIngreso, nombre, apellido, direccion, edad, genero, numContacto);

        this.codigo = codigo;
        this.puesto = puesto;
        this.sueldo = -1;
        this.usuarios = lista;
    }

    /**
     * Calcula el atributo {@link Empleado#sueldo} del {@link Empleado} dependiendo el tipo de {@link Empleado#puesto} y {@link Empleado#fechaDeIngreso}
     */
    @Override
    public void calcular() {
        switch (this.puesto) {
            case Administrativo:
                this.sueldo = 50000;
                break;
            case Caddy:
                this.sueldo = 30000;
                break;
            case Gerente:
                this.sueldo = 100000;
                break;
            case Limpieza:
                this.sueldo = 40000;
                break;
            case RecogedorDePelotas:
                this.sueldo = 5000;
                break;
        }
        
        if ( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) >= 2) {
            this.sueldo += this.sueldo*.5;
        }else if( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) > 2 && (LocalDate.now().getYear() - fechaDeIngreso.getYear()) <= 10 ){
            this.sueldo += this.sueldo*.10;
        }else if( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) > 10 && (LocalDate.now().getYear() - fechaDeIngreso.getYear()) <= 15 ){
            this.sueldo += this.sueldo*.20;
        }else if( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) > 15 ){
            this.sueldo += this.sueldo*.30;
        }
        
    }

    /**
     * Muestra el menu de opciones del objeto {@link Empleado}
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
                    "\tMENÚ EMPLEADO\n"
                    + "\t\t[1] Cargar un Empleado\n"
                    + "\t\t[2] Calcular Sueldos\n"
                    + "\t\t[3] Mostrar Empleados\n"
                    + "\t\t[4] Cambiar Puesto\n"
                    + "\t\t[5] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '5');

            switch (op) {
                case '1':
                    this.cargarNuevoEmpleado();
                    break;
                case '2':
                    usuarios.actualizarSueldosCoutas();
                    break;
                case '3':
                    usuarios.mostrarPersonas(Empleado.class);
                    break;
                case '4':
                    this.cambiarPuesto((Empleado) usuarios.elegirPersona(Empleado.class));
                    break;
                case '5':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }

    /**
     * Muestra los datos del {@link Empleado}
     */
    @Override
    public void mostrarDatos() {
        Utilidades.mostrarPorPantalla("EMPLEADO: \n"
                + "\tNOMBRE Y APELLIDO: " + this.nombre + " " + this.apellido + "\n"
                + "\tEDAD: " + this.edad + "\n"
                + "\t DIRECCION: " + this.direccion + "\n"
                + "\t GENERO: " + this.genero + "\n"
                + "\t TEL: " + this.numContacto + "\n"
                + "\t DNI: " + this.DNI + "\n"
                + "----------------------\n"
                + "\t CODIGO: " + this.codigo + "\n"
                + "\t PUESTO: " + this.puesto + "\n"
                + "\t SUELDO: " + this.sueldo + "\n"
                + "\t==================================\n"
        );
    }

    /**
     * Ejecuta el metodo {@link Empleado#mostrarMenu()}
     */
    @Override
    public void proceder() {
        mostrarMenu();
    }

    /**
     * Añade un nuevo Objeto de la clase {@link Empleado} a {@link BaseDeUsuario#bUsuario}
     */
    public void cargarNuevoEmpleado() {

        //aca deberiamos hacer un Do While para verificar si ingreso datos el usuario 
        Utilidades.mostrarPorPantalla("Ingrese el codigo: ");
        int cod = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el puesto: ");
        Puestos pue = Utilidades.elegirPuesto();
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

        Empleado e = new Empleado(usuarios, cod, pue, dni, fecha, nombre, apellido, direccion, edad, gen, tel);

        usuarios.agregarUsuario(e);

    }

    /**
     * Modifica el atributo {@link Empleado#puesto} del objeto {@link Empleado} dado como parametro de entrada
     * @param e 
     */
    private void cambiarPuesto(Empleado e) {
        boolean continuar = false;
        do {
            Utilidades.mostrarPorPantalla(
                "\t\t\tSeleccione el nuevo puesto:\n"
                +"\t\t\t\t1. Administrativo\n"
                +"\t\t\t\t2. Caddy\n"
                +"\t\t\t\t3. Gerente\n"
                +"\t\t\t\t4. Limpieza\n"
                +"\t\t\t\t5. Recogedor de pelotas\n"
                +"\t\t\t\t6. Volver\n"
            );
            switch(Utilidades.obtenerOpcion()){
                case '1':
                    e.puesto = puesto.Administrativo;
                    continuar = true;
                    break;
                case '2':
                    e.puesto = puesto.Caddy;
                    continuar = true;
                    break;
                case '3':
                    e.puesto = puesto.Gerente;
                    continuar = true;
                    break;
                case '4':
                    e.puesto = puesto.Limpieza;
                    continuar = true;
                    break;
                case '5':
                    e.puesto = puesto.RecogedorDePelotas;
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

}
