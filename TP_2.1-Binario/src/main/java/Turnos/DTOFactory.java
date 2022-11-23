package Turnos;

import java.util.Date;

/**
 * Fabrica de DTOs
 *
 * La fabrica se encarga de devolver una instancia de algun DTO dependiendo los
 * datos dados como parametro de entrada
 *
 */
public class DTOFactory {

    private static DTOFactory fabrica = null;
    private static GeneralDTO dto = null;

    /**
     * Metodo constructor privado
     */
    private DTOFactory() {
    }

    /**
     * Devuelve una instacia del objeto {@link DTOFactory}
     */
    public static DTOFactory getInstance() {
        if (fabrica == null) {
            fabrica = new DTOFactory();
        }

        return fabrica;
    }

    /**
     * Devuelve un {@link PacienteDTO}
     *
     * @param nroSocio Numero de Socio del {@link PacienteDTO}
     * @param cobertura Cobertura del {@link PacienteDTO}
     * @param DNI Dni del {@link PacienteDTO}
     * @param nombre Nombre del {@link PacienteDTO}
     * @param apellido Apellido del {@link PacienteDTO}
     * @param genero Genero del {@link PacienteDTO}
     * @param email Correo electronico del {@link PacienteDTO}
     * @param nacimiento Fecha de nacimiento del {@link PacienteDTO}
     * @param direccion Direccion del {@link PacienteDTO}
     * @return {@link PacienteDTO}
     */
    public static PacienteDTO getDTO(int nroSocio, Cobertura cobertura, int DNI, String nombre, String apellido, Genero genero, String email, Date nacimiento, String direccion) {
        dto = new PacienteDTO(nroSocio, cobertura, DNI, nombre, apellido, genero, email, nacimiento, direccion);

        return (PacienteDTO) dto;
    }

    /**
     * Devuelve un {@link MedicoDTO}
     *
     * @param matricula Numero de matricula del {@link MedicoDTO}
     * @param especialidad Especialidad de Trabajo del {@link MedicoDTO}
     * @param DNI Dni del {@link MedicoDTO}
     * @param nombre Nombre del {@link MedicoDTO}
     * @param apellido Apellido del {@link MedicoDTO}
     * @param genero Genero del {@link MedicoDTO}
     * @param email Correo electronico del {@link MedicoDTO}
     * @param nacimiento Fecha de nacimiento del {@link MedicoDTO}
     * @param direccion Direccion del {@link MedicoDTO}
     * @return {@link MedicoDTO}
     */
    public static MedicoDTO getDTO(int matricula, Especialidad especialidad, int DNI, String nombre, String apellido, Genero genero, String email, Date nacimiento, String direccion) {
        dto = new MedicoDTO(matricula, especialidad, DNI, nombre, apellido, genero, email, nacimiento, direccion);

        return (MedicoDTO) dto;
    }

    /**
     * Devuelve un {@link TurnoDTO}
     *
     * @param fecha Fecha del {@link TurnoDTO}
     * @param especialidad Especialidad del {@link TurnoDTO}
     * @param paciente Paciente del {@link TurnoDTO}
     * @param medico Medico del {@link TurnoDTO}
     *
     * @return {@link TurnoDTO}
     */
    public static TurnoDTO getDTO(Date fecha, Especialidad especialidad, PacienteDTO paciente, MedicoDTO medico) {
        dto = new TurnoDTO(fecha, especialidad, paciente, medico);

        return (TurnoDTO) dto;
    }

}
