package Turnos;

import java.io.Serializable;
import java.util.Date;

/**
 * Interfaz que maneja el CRUD de {@link TurnoDTO}
 *
 */
public class TurnoDAO implements GeneralDAO<TurnoDTO>, Serializable {

    private static final long serialVersionUID = -1000L;

    /**
     * Agrega un {@link TurnoDTO} a la {@link BaseDatos}
     *
     * @param db Base de datos
     */
    @Override
    public void agregar(BaseDatos db) {
        System.out.println("Ingrese la fecha del turno:");
        Date fecha = Utilidades.leerFecha();

        System.out.println("Ingrese la Especialidad:");
        Especialidad especialidad = Utilidades.leerEspecialidad();

        System.out.println("Ingrese el paciente que va a reservar el turno:");
        PacienteDTO paciente = db.elegirPaciente();

        System.out.println("Ingrese su medico:");
        MedicoDTO medico = db.elegirMedico();

        db.agregar(DTOFactory.getDTO(fecha, especialidad, paciente, medico));
    }

    /**
     * Elimina un {@link TurnoDTO} de la {@link BaseDatos}
     *
     * @param t Objeto {@link TurnoDTO}
     * @param db Base de datos
     */
    @Override
    public void borrar(TurnoDTO t, BaseDatos db) {
        db.quitar(t);
    }

    /**
     * Muestra el menu de opciones de Turnos
     *
     * @param db Base de datos
     * @return {@link Boolean#TRUE} o {@link Boolean#FALSE}
     */
    @Override
    public boolean mostrarMenu(BaseDatos db) {
        boolean cerrar = false, continuar = true;

        while (!cerrar) {
            char op;
            do {
                System.out.println("\t\n--------------Menu de Turnos--------------\n"
                        + "\t\t[1] Cargar un Turnos\n"
                        + "\t\t[2] Quitar un Turnos\n"
                        + "\t\t[3] Mostrar Datos\n"
                        + "\t\t[4] Atras\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '4');

            switch (op) {
                case '1':
                    if (db.BasePersonas.isEmpty()) {
                        System.out.println("No hay personas cargadas a la base de datos");
                    } else {
                        this.agregar(db);
                    }
                    break;
                case '2':
                    if (db.BaseTurnos.isEmpty()) {
                        System.out.println("No existen turnos creados");
                    } else {
                        this.borrar(db.elegirTurno(), db);
                    }
                    break;
                case '3':
                    if (db.BaseTurnos.isEmpty()) {
                        System.out.println("No existen turnos creados");
                    } else {
                        this.mostrarDatos(db.elegirTurno());
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
     * @param turno {@link TurnoDTO}
     */
    @Override
    public void mostrarDatos(TurnoDTO turno) {
        System.out.println("\n---------------------------------------------------------------------------\n"
                + "\n\tTurno: "
                + "\n\t\tFecha: " + turno.getFecha()
                + "\n\t\tEspecialidad: W" + turno.getEspecialidad()
                + "\n\t\tPaciente: " + turno.getPaciente().getNombre() + " " + turno.getPaciente().getApellido()
                + "\n\t\tMedico: " + turno.getMedico().getNombre() + " " + turno.getMedico().getApellido()
                + "\n---------------------------------------------------------------------------\n"
        );
    }

}
