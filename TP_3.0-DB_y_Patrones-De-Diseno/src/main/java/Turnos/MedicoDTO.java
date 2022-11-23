package Turnos;

import java.io.Serializable;
import java.util.Date;

class MedicoDTO extends PersonaDTO implements Serializable {

    private static final long serialVersionUID = -1000L;

    private int matricula;
    private Especialidad especialidad;

    /**
     * Metodo Constructor
     *
     * @param matricula Matricula del Medico
     * @param especialidad Especialidad del Medico
     * @param DNI DNI del Medico
     * @param nombre Nombre del Medico
     * @param apellido Apellido del Medico
     * @param genero Genero del Medico
     * @param email Correo Electronico del Medico
     * @param nacimiento Fecha de Nacimiento del Medico
     * @param direccion Direccion del Medico
     */
    public MedicoDTO(int matricula, Especialidad especialidad, int DNI, String nombre, String apellido, Genero genero, String email, Date nacimiento, String direccion) {
        super(DNI, nombre, apellido, genero, email, nacimiento, direccion);
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    /**
     * Devuelve la matricula del medico
     *
     * @return Matricula del Medico
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Asigna una matricula al Medico
     *
     * @param matricula Matricula del Medico
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * Devuelve la especialidad del medico
     *
     * @return Especialidad del Medico
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     * Asigna una matricula al Medico
     *
     * @param especialidad Matricula del Medico
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Devuelve los datos del medico
     *
     * @return Datos del medico en formato texto
     */
    @Override
    public String toString() {
        return "MedicoDTO{" + "matricula=" + matricula + ", especialidad=" + especialidad + '}';
    }

}
