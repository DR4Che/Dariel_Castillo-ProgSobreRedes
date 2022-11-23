package Turnos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ignacio Rios Lahore (Pistak41)
 */
public class TurnoDAO implements GeneralDAO<TurnoDTO>, Serializable {

    private static final long serialVersionUID = -1000L;

    /**
     * Agrega un {@link TurnoDTO} a la {@link BaseDatos}
     *
     * @param t {@link TurnoDTO}
     */
    @Override
    public void agregar(TurnoDTO t) {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            String query = "INSERT INTO turno(fecha, especialidad, paciente, medico) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setDate(1, Utilidades.DateToSQL(t.getFecha()));
            pst.setString(2, t.getEspecialidad().toString());

            PreparedStatement paciente = con.prepareStatement("SELECT * FROM paciente WHERE dni = " + t.getPaciente().getDNI());
            ResultSet pacienteRS = paciente.executeQuery();

            while (pacienteRS.next()) {
                System.out.println("Paciente id: " + pacienteRS.getInt("id"));
                pst.setInt(3, pacienteRS.getInt("id"));
            }

            PreparedStatement medico = con.prepareStatement("SELECT * FROM medico WHERE dni = " + t.getMedico().getDNI());
            ResultSet medicoRS = paciente.executeQuery();

            while (medicoRS.next()) {
                pst.setInt(4, medicoRS.getInt("id"));
            }

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Agrega un {@link TurnoDTO} a la {@link BaseDatos}
     *
     */
    public void agregar() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            String query = "INSERT INTO turno(fecha, especialidad, paciente, medico) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            System.out.println("Ingrese la fecha del turno:");
            pst.setDate(1, Utilidades.DateToSQL(Utilidades.leerFecha()));

            System.out.println("Ingrese la especialidad:");
            pst.setString(2, Utilidades.leerEspecialidad().toString());

            System.out.println("Elija el paciente: ");
            pst.setInt(3, Utilidades.elegirPaciente());

            System.out.println("Elija el medico: ");
            pst.setInt(4, Utilidades.elegirMedico());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Elimina un {@link TurnoDTO} de la {@link BaseDatos}
     *
     * @param t id de {@link TurnoDTO} en la base de datos
     */
    @Override
    public void borrar(int t) {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            PreparedStatement pst = con.prepareStatement("DELETE FROM turno WHERE id = ?");

            pst.setInt(1, t);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Muestra el menu de opciones de Turnos
     *
     * @return {@link Boolean#TRUE} o {@link Boolean#FALSE}
     */
    @Override
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;

        while (!cerrar) {
            char op;
            do {
                System.out.println("\t\n--------------Menu de Turnos--------------\n"
                        + "\t\t[1] Cargar un Turno\n"
                        + "\t\t[2] Quitar un Turno\n"
                        + "\t\t[3] Mostrar Datos\n"
                        + "\t\t[4] Atras\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '4');

            switch (op) {
                case '1':
                    Connection con = null;

                    try {
                        con = ConexionesFactory.getInstance().getConection();

                        if (con.prepareStatement("SELECT * FROM paciente").executeQuery().next()) {
                            if (con.prepareStatement("SELECT * FROM medico").executeQuery().next()) {
                                this.agregar();
                            } else {
                                System.out.println("No existen medicos en la base de datos");
                            }
                        } else {
                            System.out.println("No existen pacientes en la base de datos");
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(TurnoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;

                case '2': 
                    try {
                    if (!ConexionesFactory.getInstance().getConection().prepareStatement("SELECT * FROM turno").executeQuery().next()) {
                        System.out.println("No existen turnos creados");
                    } else {
                        this.borrar(Utilidades.elegirTurno());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TurnoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

                case '3':
                   try {
                    if (!ConexionesFactory.getInstance().getConection().prepareStatement("SELECT * FROM turno").executeQuery().next()) {
                        System.out.println("No existen turnos creados");
                    } else {
                        this.mostrarDatos(Utilidades.elegirTurno());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TurnoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                case '4':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }

    /**
     * Muestra los datos de {@link TurnoDTO}
     *
     * @param t id de {@link TurnoDTO} en la base de datos
     */
    @Override
    public void mostrarDatos(int t) {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            PreparedStatement turnoPS = con.prepareStatement("SELECT * FROM turno WHERE id = ?");
            PreparedStatement medicoPS = con.prepareStatement("SELECT * FROM medico WHERE id = ?");
            PreparedStatement pacientePS = con.prepareStatement("SELECT * FROM paciente WHERE id = ?");

            ResultSet turno = turnoPS.executeQuery();

            while (turno.next()) {
                medicoPS.setInt(1, turno.getInt("medico"));
                pacientePS.setInt(1, turno.getInt("paciente"));

                ResultSet medico = medicoPS.executeQuery();
                ResultSet paciente = pacientePS.executeQuery();

                System.out.println("\n---------------------------------------------------------------------------\n"
                        + "\n\tTurno: "
                        + "\n\t\tFecha: " + turno.getDate("fecha")
                        + "\n\t\tEspecialidad" + turno.getString("especialidad")
                        + "\n\t\tPaciente: " + paciente.getString("nombre") + " " + paciente.getString("apellido")
                        + "\n\t\tMedico: " + medico.getString("nombre") + " " + medico.getString("apellido")
                        + "\n---------------------------------------------------------------------------\n"
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(TurnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
