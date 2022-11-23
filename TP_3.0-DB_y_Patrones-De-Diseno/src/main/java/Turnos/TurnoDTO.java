package Turnos;

import java.io.Serializable;
import java.util.Date;

public class TurnoDTO implements GeneralDTO, Serializable {

    private static final long serialVersionUID = -1000L;

    private Date fecha;
    private Especialidad especialidad;
    private PacienteDTO paciente;
    private MedicoDTO medico;

    /**
     *
     * @param fecha Fecha de realizacion del Turno
     * @param especialidad Especialidad del Turno
     * @param paciente Paciente del Turno
     * @param medico Medico del Turno
     */
    public TurnoDTO(Date fecha, Especialidad especialidad, PacienteDTO paciente, MedicoDTO medico) {
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.paciente = paciente;
        this.medico = medico;
    }

    /**
     * Devuelve la fecha de realizacion del Turno
     *
     * @return Fecha de realizacion del Turno
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Asigna una fecha de realizacion al Turno
     *
     * @param fecha Fecha de realizacion del Turno
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve la especialidad del Turno
     *
     * @return Especialidad del Turno
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     * Asigna una especialidad al Turno
     *
     * @param especialidad Especialidad del Turno
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    /**
     *  Devuelve el paciente del Turno
     * @return Paciente del Turno
     */
    public PacienteDTO getPaciente() {
        return paciente;
    }

    /**
     * Asigna un paciente al Turno
     * @param paciente Paciente al Turno
     */
    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    /**
     * Devuelve el medico del Turno
     * @return Medico del Turno
     */
    public MedicoDTO getMedico() {
        return medico;
    }

    /**
     * Asigna un Medico al Turno
     * @param medico Medico del Turno
     */
    public void setMedico(MedicoDTO medico) {
        this.medico = medico;
    }

    /**
     * Devuelve los datos del Turno
     *
     * @return Datos del turno en formato texto
     */
    @Override
    public String toString() {
        return "TurnoDTO{" + "fecha=" + fecha + ", especialidad=" + especialidad + ", paciente=" + paciente + ", medico=" + medico + '}';
    }

}
