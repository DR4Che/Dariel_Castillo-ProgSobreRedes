package Turnos;

import java.io.Serializable;
import java.util.Date;

/**
 * Estructura de una persona (sea medico o paciente)
 *
 */
abstract class PersonaDTO implements GeneralDTO, Serializable {

    private static final long serialVersionUID = -1000L;

    protected int DNI;
    protected String nombre;
    protected String apellido;
    protected Genero genero;
    protected String email;
    protected Date nacimiento;
    protected String direccion;

    /**
     * Metodo constructor
     *
     * @param DNI DNI de la persona
     * @param nombre Nombre de la persona
     * @param apellido Apellido de la persona
     * @param genero Genero de la persona
     * @param email Correo electronico de la persona
     * @param nacimiento Fecha de nacimiento de la persona
     * @param direccion Direccion de la persona
     */
    public PersonaDTO(int DNI, String nombre, String apellido, Genero genero, String email, Date nacimiento, String direccion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.email = email;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
    }

    /**
     * Devuelve el DNI de la persona
     *
     * @return DNI de la persona
     */
    public int getDNI() {
        return DNI;
    }

    /**
     * Asigna un DNI a la persona
     *
     * @param DNI DNI de la persona
     */
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    /**
     * Devuelve el nombre de la persona
     *
     * @return Nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre a la persona
     *
     * @param nombre Nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido de la persona
     *
     * @return Apellido de la persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Asigna un apellido a la persona
     *
     * @param apellido Apellido de la persona
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Devuelve el genero de la persona
     *
     * @return Genero de la persona
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Asigna un genero a la persona
     *
     * @param genero Genero de la persona
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Devuelve el correo electronico de la persona
     *
     * @return Correo electronico de la persona
     */
    public String getEmail() {
        return email;
    }

    /**
     * Asigna un correo electronico a la persona
     *
     * @param email Correo electronico de la persona
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la fecha de nacimiento de la persona
     *
     * @return Fecha de nacimiento de la persona
     */
    public Date getNacimiento() {
        return nacimiento;
    }

    /**
     * Asigna una fecha de nacimiento a la persona
     *
     * @param nacimiento Fecha de nacimiento de la persona
     */
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * Devuelve la direccion de la persona
     *
     * @return Direccion de la persona
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Asigna una direccion a la persona
     *
     * @param direccion Direccion de la persona
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve los datos de la persona
     *
     * @return Datos de la persona en formato texto
     */
    @Override
    public String toString() {
        return "PersonaDTO{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", email=" + email + ", nacimiento=" + nacimiento + ", direccion=" + direccion + '}';
    }

}
