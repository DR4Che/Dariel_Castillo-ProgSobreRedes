package Proyecto_FileBinary;

import java.io.Serializable;
import java.util.Date;

public abstract class Persona implements Serializable {
    private static final long serialVersionUID = -1000L;
    
    protected int DNI;
    protected Date fechaDeIngreso;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected int edad;
    protected Genero genero;
    protected String numContacto; //despues usamos Format para pasarlo a Int      

    /**
     * Metodo Contructor
     * 
     * @param DNI
     * @param fechaDeIngreso
     * @param nombre
     * @param apellido
     * @param direccion
     * @param edad
     * @param genero
     * @param numContacto 
     */
    public Persona(int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        this.DNI = DNI;
        this.fechaDeIngreso = fechaDeIngreso;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.genero = genero;
        this.numContacto = numContacto;
    }
    
    /**
     * Distintas acciones dependiendo que tipo de {@link Persona} sea
     */
    public abstract void proceder();
    
    /**
     * Distintas acciones dependiendo que tipo de {@link Persona} sea
     */
    public abstract void mostrarDatos();
    
    /**
     * Distintas acciones dependiendo que tipo de {@link Persona} sea
     * @return {@link Boolean}
     */
    public abstract boolean mostrarMenu();
    
    /**
     * Distintas acciones dependiendo que tipo de {@link Persona} sea
     */
    public abstract void calcular();
    
}
