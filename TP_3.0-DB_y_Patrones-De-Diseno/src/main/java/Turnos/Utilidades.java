package Turnos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Utilidades {

    private static InputStreamReader isr = null;
    private static BufferedReader br = null;

    /**
     * Devuelve la opcion ingresada por pantalla
     *
     * @return {@link Character}
     */
    static char obtenerOpcion() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        char opt = 0;
        try {
            opt = br.readLine().charAt(0);
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        return opt;
    }

    /**
     * Devuelve el numero ingresado por pantalla
     *
     * @return {@link Integer}
     */
    static int leerNumero() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        try {
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            return 0;
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Devuelve el texto ingresado por pantalla
     *
     * @return {@link Puestos}
     */
    static String leerTexto() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        String texto = "";
        try {
            texto = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        return texto;
    }

    /**
     * Devuelve la fecha ingresada por pantalla
     *
     * @return {@link Date}
     */
    static Date leerFecha() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            return df.parse(br.readLine());
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            return (new Date("00/00/0000"));
        }
    }

    /**
     * Devuelve el genero seleccionado por pantalla
     *
     * @return {@link Genero}
     */
    static Genero leerGenero() {
        int op;
        do {
            String opciones = "\n\tMENU DE OPCIONES\n";
            for (Genero g : Genero.values()) {
                opciones += "\t\t[" + (g.ordinal() + 1) + "] " + g.name() + "\n";
            }
            System.out.println(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < 1 || Character.getNumericValue(op) > Genero.values().length);

        return Genero.values()[Character.getNumericValue(op) - 1];
    }

    /**
     * Devuelve la cobertura seleccionada por pantalla
     *
     * @return {@link Cobertura}
     */
    static Cobertura leerCobertura() {
        int op;
        do {
            String opciones = "\n\tMENU DE OPCIONES\n";
            for (Cobertura c : Cobertura.values()) {
                opciones += "\t\t[" + (c.ordinal() + 1) + "] " + c.name() + "\n";
            }
            System.out.println(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < 1 || Character.getNumericValue(op) > Cobertura.values().length);

        return Cobertura.values()[Character.getNumericValue(op) - 1];
    }

    /**
     * Devuelve la especialidad seleccionada por pantalla
     *
     * @return {@link Especialidad}
     */
    static Especialidad leerEspecialidad() {
        int op;
        do {
            String opciones = "\n\tMENU DE OPCIONES\n";
            for (Especialidad e : Especialidad.values()) {
                opciones += "\t\t[" + (e.ordinal() + 1) + "] " + e.name() + "\n";
            }
            System.out.println(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < 1 || Character.getNumericValue(op) > Especialidad.values().length);

        return Especialidad.values()[Character.getNumericValue(op) - 1];
    }

    static java.sql.Date DateToSQL(Date d) {
        return new java.sql.Date(d.getYear(), d.getMonth(), d.getDay());
    }

    /**
     * Selecciona un {@link MedicoDTO} de la base de datos
     *
     * @return id de {@link MedicoDTO} en la base de datos
     */
    static int elegirMedico() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            String query = "SELECT * FROM medico";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            char op;
            ArrayList<Integer> ids = new ArrayList<>();
            do {
                while (rs.next()) {
                    ids.add(rs.getInt("id"));
                    System.out.println("[" + rs.getInt("id") + "]" + rs.getString("nombre") + " " + rs.getString("apellido"));
                }

                op = Utilidades.obtenerOpcion();

            } while (op < (char) (ids.get(0) + '0') || op > (char) (ids.size() - 1 + '0'));
            int id = 0;

            PreparedStatement medicoPS = con.prepareStatement("SELECT * FROM medico where id = " + op);
            ResultSet medico = medicoPS.executeQuery();

            while (medico.next()) {
                id = medico.getInt("id");
            }

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    /**
     * Selecciona un {@link PacienteDTO} de la base de datos
     *
     * @return id de {@link PacienteDTO} en la base de datos
     */
    static int elegirPaciente() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            String query = "SELECT * FROM paciente";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            char op;
            ArrayList<Integer> ids = new ArrayList<>();
            do {
                while (rs.next()) {
                    ids.add(rs.getInt("id"));
                    System.out.println("[" + rs.getInt("id") + "]" + rs.getString("nombre") + " " + rs.getString("apellido"));
                }

                op = Utilidades.obtenerOpcion();
            } while (op < (char) (ids.get(0) + '0') || op > (char) (ids.size() - 1 + '0'));
            int id = 0;
            PreparedStatement pacientePS = con.prepareStatement("SELECT * FROM paciente where id = " + op);
            ResultSet paciente = pacientePS.executeQuery();

            while (paciente.next()) {
                id = paciente.getInt("id");
            }

            return id;
        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    /**
     * Selecciona un {@link TurnoDTO} de la base de datos
     *
     * @return id de {@link TurnoDTO} en la base de datos
     */
    static int elegirTurno() {
        Connection con = null;

        try {
            con = ConexionesFactory.getInstance().getConection();

            String query = "SELECT * FROM turno";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            int op;
            ArrayList<Integer> ids = new ArrayList<>();
            do {
                while (rs.next()) {
                    ids.add(rs.getInt("id"));
                    System.out.println("[" + rs.getInt("id") + "] Fecha: " + rs.getString("fecha") + "| Especialidad: " + rs.getString("especialidad"));
                }

                op = Utilidades.obtenerOpcion();

            } while (op < (char) (ids.get(0) + '0') || op > (char) (ids.size() - 1 + '0'));
            int id = 0;

            PreparedStatement turnoPS = con.prepareStatement("SELECT * FROM turno where id = " + op);

            ResultSet turno = turnoPS.executeQuery();
            while (turno.next()) {
                id = turno.getInt("id");
            }

            return id;
        } catch (SQLException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

}
