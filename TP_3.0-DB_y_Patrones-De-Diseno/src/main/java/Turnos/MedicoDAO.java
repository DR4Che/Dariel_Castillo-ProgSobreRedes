package Turnos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicoDAO extends PersonaDAO<MedicoDTO> implements Serializable {

    private static final long serialVersionUID = -1000L;

    /**
     * Agrega un {@link MedicoDTO} a la {@link BaseDatos}
     *
     * @param m {@link MedicoDTO}
     */
    @Override
    public void agregar(MedicoDTO m) {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            String query = "INSERT INTO medico(matricula, especialidad, dni, nombre, apellido, genero, email, nacimiento, direccion) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, m.getMatricula());
            pst.setString(2, m.getEspecialidad().toString());
            pst.setInt(3, m.getDNI());
            pst.setString(4, m.getNombre());
            pst.setString(5, m.getApellido());
            pst.setString(6, m.getGenero().toString());
            pst.setString(7, m.getEmail());
            pst.setDate(8, Utilidades.DateToSQL(m.getNacimiento()));
            pst.setString(9, m.getDireccion());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Agrega un {@link MedicoDTO} a la {@link BaseDatos}
     *
     */
    public void agregar() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            String query = "INSERT INTO medico(matricula, especialidad, dni, nombre, apellido, genero, email, nacimiento, direccion) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            System.out.println("Ingrese el nombre del medico:");
            pst.setString(4, Utilidades.leerTexto());

            System.out.println("Ingrese el Apellido del medico:");
            pst.setString(5, Utilidades.leerTexto());

            System.out.println("Ingrese su DNI:");
            pst.setInt(3, Utilidades.leerNumero());

            System.out.println("Ingrese su fecha de nacimiento:");
            pst.setDate(8, Utilidades.DateToSQL(Utilidades.leerFecha()));

            System.out.println("Ingrese su genero:");
            pst.setString(6, Utilidades.leerGenero().toString());

            System.out.println("Ingrese su numero de matricula:");
            pst.setInt(1, Utilidades.leerNumero());

            System.out.println("Ingrese su especialidad:");
            pst.setString(2, Utilidades.leerEspecialidad().toString());

            System.out.println("Ingrese su correo electronico:");
            pst.setString(7, Utilidades.leerTexto());

            System.out.println("Ingrese su direccion");
            pst.setString(9, Utilidades.leerTexto());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Elimina un {@link MedicoDTO} de la {@link BaseDatos}
     *
     * @param id id de {@link MedicoDTO} en la base de datos
     */
    @Override
    public void borrar(int id) {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            PreparedStatement medicoPS = con.prepareStatement("DELETE FROM turno WHERE medico = " + id);
            PreparedStatement pst = con.prepareStatement("DELETE FROM medico WHERE id = " + id);

            medicoPS.executeUpdate();
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Muestra el menu de opciones del medico
     *
     * @return {@link Boolean#TRUE} o {@link Boolean#FALSE}
     */
    @Override
    public boolean mostrarMenu() {

        boolean cerrar = false, continuar = true;

        while (!cerrar) {
            char op;
            do {
                System.out.println("\t\n--------------Menu de Medicos--------------\n"
                        + "\t\t[1] Cargar un Medico\n"
                        + "\t\t[2] Quitar un Medico\n"
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
                    this.borrar(Utilidades.elegirMedico());
                    break;
                case '3':
                    this.mostrarDatos(Utilidades.elegirMedico());
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
     * Muestra los datos de {@link MedicoDTO}
     *
     * @param id id de {@link MedicoDTO} en la base de datos
     */
    @Override
    public void mostrarDatos(int id) {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            PreparedStatement medicoPS = con.prepareStatement("SELECT * FROM medico WHERE id = " + id);
            ResultSet medico = medicoPS.executeQuery();

            while (medico.next()) {
                System.out.println("\n---------------------------------------------------------------------------"
                        + "\n\tMedico: " + medico.getString("nombre") + " " + medico.getString("apellido")
                        + "\n\t\tDNI: " + medico.getInt("dni")
                        + "\n\t\tMatricula: " + medico.getInt("matricula")
                        + "\n\t\tEspecialidad: " + medico.getString("especialidad")
                        + "\n\t\tGenero: " + medico.getString("genero")
                        + "\n\t\tFecha de nacimiento: " + medico.getDate("nacimiento")
                        + "\n\t\tCorreo Electronico: " + medico.getString("email")
                        + "\n\t\tDireccion" + medico.getString("direccion")
                        + "\n---------------------------------------------------------------------------"
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Realiza una accion del Medico
     */
    @Override
    public void proceder() {
        System.out.println("Estoy a tendiendo a un Paciente...");
    }

}
