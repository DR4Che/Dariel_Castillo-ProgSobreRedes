package Turnos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Base de datos de Turnos, Pacientes y Medicos
 *
 */
public class BaseDatos implements Serializable {

    private static final long serialVersionUID = -1000L;

    protected LinkedList<PersonaDTO> BasePersonas;
    protected LinkedList<TurnoDTO> BaseTurnos;

    private MedicoDAO medicoUI = new MedicoDAO();
    private PacienteDAO pacienteUI = new PacienteDAO();
    private TurnoDAO turnoUI = new TurnoDAO();

    /**
     * Metodo Contructor
     */
    public BaseDatos() {
        BasePersonas = new LinkedList<>();
        BaseTurnos = new LinkedList<>();
    }

    /**
     * Agrega las Personas de la lista {@link BaseDatos#BasePersonas} a la Base de datos
     */
    public void agregarPersonasDB() {
        for (PersonaDTO p : BasePersonas) {
            if (p instanceof MedicoDTO) {
                medicoUI.agregar((MedicoDTO) p);
            }
            if (p instanceof PacienteDTO) {
                pacienteUI.agregar((PacienteDTO) p);
            }
        }
    }
    
    /**
     * Agrega los turnos de la lista {@link BaseDatos#BaseTurnos} a la Base de datos
     */
    public void agregarTurnosDB() {
        for (TurnoDTO t : BaseTurnos) {
            turnoUI.agregar(t);
        }
    }

    /**
     * Muestra los datos de todos los {@link PacienteDTO} en la base de datos
     */
    public void mostrarPacientes() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            PreparedStatement pst = con.prepareStatement("SELECT * FROM paciente");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                pacienteUI.mostrarDatos(rs.getInt("id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Muestra los datos de todos los {@link MedicoDTO} de las base de datos
     */
    public void mostrarMedicos() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            PreparedStatement pst = con.prepareStatement("SELECT * FROM medico");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                medicoUI.mostrarDatos(rs.getInt("id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Muestra todos los {@link TurnoDTO} de la base de datos
     */
    public void mostrarTurnos() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            PreparedStatement pst = con.prepareStatement("SELECT * FROM turno");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                turnoUI.mostrarDatos(rs.getInt("id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
