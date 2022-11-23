package Turnos;

import java.io.Serializable;
import java.util.Date;


public class PacienteDTO extends PersonaDTO implements Serializable {

    private static final long serialVersionUID = -1000L;

    private int nroSocio;
    private Cobertura cobertura;

    /**
     *
     * @param nroSocio Numero de socio del Paciente
     * @param cobertura Plan medico del Paciente
     * @param DNI DNI del Paciente
     * @param nombre Nombre del Paciente
     * @param apellido Apellido del Paciente
     * @param genero Genero del Paciente
     * @param email Correo Electronico del Paciente
     * @param nacimiento Fecha de Nacimiento del Paciente
     * @param direccion Direccion del Paciente
     */
    public PacienteDTO(int nroSocio, Cobertura cobertura, int DNI, String nombre, String apellido, Genero genero, String email, Date nacimiento, String direccion) {
        super(DNI, nombre, apellido, genero, email, nacimiento, direccion);
        this.nroSocio = nroSocio;
        this.cobertura = cobertura;
    }

    /**
     * Devuelve el numero de socio del paciente
     *
     * @return Numero de socio del Paciente
     */
    public int getNroSocio() {
        return nroSocio;
    }

    /**
     * Asigna un numero de socio al paciente
     *
     * @param nroSocio Numero de socio del Paciente
     */
    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    /**
     * Devuelve la cobertura medica del paciente
     *
     * @return Cobertura medica del Paciente
     */
    public Cobertura getCobertura() {
        return cobertura;
    }

    /**
     * Asigna una cobertura medica al paciente
     *
     * @param cobertura Cobertura medica del Paciente
     */
    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

    /**
     * Devuelve los datos del paciente
     *
     * @return Datos del paciente en formato texto
     */
    @Override
    public String toString() {
        return "PacienteDTO{" + "nroSocio=" + nroSocio + ", cobertura=" + cobertura + '}';
    }

}
