package Turnos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PacienteDAO extends PersonaDAO<PacienteDTO> implements Serializable {

    private static final long serialVersionUID = -1000L;

    /**
     * Agrega un {@link PersonaDTO} a la {@link BaseDatos}
     *
     * @param p {@link PacienteDTO}
     */
    @Override
    public void agregar(PacienteDTO p) {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            String query = "INSERT INTO paciente(nroSocio, cobertura, dni, nombre, apellido, genero, email, nacimiento, direccion) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, p.getNroSocio());
            pst.setString(2, p.getCobertura().toString());
            pst.setInt(3, p.getDNI());
            pst.setString(4, p.getNombre());
            pst.setString(5, p.getApellido());
            pst.setString(6, p.getGenero().toString());
            pst.setString(7, p.getEmail());
            pst.setDate(8, Utilidades.DateToSQL(p.getNacimiento()));
            pst.setString(9, p.getDireccion());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Agrega un {@link PersonaDTO} a la {@link BaseDatos}
     *
     */
    public void agregar() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            String query = "INSERT INTO paciente(nroSocio, cobertura, dni, nombre, apellido, genero, email, nacimiento, direccion) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            System.out.println("Ingrese el nombre del paciente:");
            pst.setString(4, Utilidades.leerTexto());

            System.out.println("Ingrese el Apellido del paciente:");
            pst.setString(5, Utilidades.leerTexto());

            System.out.println("Ingrese su DNI:");
            pst.setInt(3, Utilidades.leerNumero());

            System.out.println("Ingrese su fecha de nacimiento:");
            pst.setDate(8, Utilidades.DateToSQL(Utilidades.leerFecha()));

            System.out.println("Ingrese su genero:");
            pst.setString(6, Utilidades.leerGenero().toString());

            System.out.println("Ingrese su numero de socio:");
            pst.setInt(1, Utilidades.leerNumero());

            System.out.println("Ingrese su cobertura medico:");
            pst.setString(2, Utilidades.leerCobertura().toString());

            System.out.println("Ingrese su correo electronico:");
            pst.setString(7, Utilidades.leerTexto());

            System.out.println("Ingrese su direccion");
            pst.setString(9, Utilidades.leerTexto());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Elimina un {@link PacienteDTO} de la {@link BaseDatos}
     *
     * @param id id de {@link PacienteDTO} en la base de datos
     */
    @Override
    public void borrar(int id) {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            PreparedStatement pacientePS = con.prepareStatement("DELETE FROM turno WHERE paciente = " + id);
            PreparedStatement pst = con.prepareStatement("DELETE FROM paciente WHERE id = " + id);

            pacientePS.executeUpdate();
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Muestra el menu de opciones del paciente
     *
     * @return {@link Boolean#TRUE} o {@link Boolean#FALSE}
     */
    @Override
    public boolean mostrarMenu() {

        boolean cerrar = false, continuar = true;

        while (!cerrar) {
            char op;
            do {
                System.out.println("\t\n--------------Menu de Pacientes--------------\n"
                        + "\t\t[1] Cargar un Paciente\n"
                        + "\t\t[2] Quitar un Paciente\n"
                        + "\t\t[3] Mostrar Datos\n"
                        + "\t\t[4] Atras\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '4');

            switch (op) {
                case '1':
                    this.agregar();
                    break;
                case '2':
                    this.borrar(Utilidades.elegirPaciente());
                    break;
                case '3':
                    this.mostrarDatos(Utilidades.elegirPaciente());
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
     * Muestra los datos de {@link PacienteDTO}
     *
     * @param id id de {@link PacienteDTO} en la base de datos
     */
    @Override
    public void mostrarDatos(int id) {
        Connection con = null;

        try {

            con = ConexionesFactory.getInstance().getConection();

            PreparedStatement pacientePS = con.prepareStatement("SELECT * FROM paciente WHERE id = " + id);
            ResultSet paciente = pacientePS.executeQuery();

            while (paciente.next()) {
                System.out.println("\n---------------------------------------------------------------------------"
                        + "\n\tPaciente: " + paciente.getString("nombre") + " " + paciente.getString("apellido")
                        + "\n\t\tDNI: " + paciente.getInt("dni")
                        + "\n\t\tNumero de Socio: " + paciente.getInt("nroSocio")
                        + "\n\t\tCobertura: " + paciente.getString("cobertura")
                        + "\n\t\tGenero: " + paciente.getString("genero")
                        + "\n\t\tFecha de nacimiento: " + paciente.getDate("nacimiento")
                        + "\n\t\tCorreo Electronico: " + paciente.getString("email")
                        + "\n\t\tDireccion" + paciente.getString("direccion")
                        + "\n---------------------------------------------------------------------------"
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Realiza una accion del paciente
     */
    @Override
    public void proceder() {
        System.out.println("Estoy siendo atendido...");
    }

}
