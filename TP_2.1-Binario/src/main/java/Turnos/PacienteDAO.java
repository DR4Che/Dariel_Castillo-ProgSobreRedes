package Turnos;

import java.io.Serializable;
import java.util.Date;

/**
 * Interfaz que maneja el CRUD de {@link PacienteDTO}
 *
 */
public class PacienteDAO extends PersonaDAO<PacienteDTO> implements Serializable {

    private static final long serialVersionUID = -1000L;

    /**
     * Agrega un {@link PersonaDTO} a la {@link BaseDatos}
     *
     * @param db Base de datos
     */
    @Override
    public void agregar(BaseDatos db) {
        System.out.println("Ingrese el nombre del paciente:");
        String nombre = Utilidades.leerTexto();

        System.out.println("Ingrese el Apellido del paciente:");
        String apellido = Utilidades.leerTexto();

        System.out.println("Ingrese su DNI:");
        int dni = Utilidades.leerNumero();

        System.out.println("Ingrese su fecha de nacimiento:");
        Date fecha = Utilidades.leerFecha();

        System.out.println("Ingrese su genero:");
        Genero genero = Utilidades.leerGenero();

        System.out.println("Ingrese su numero de socio:");
        int nroSocio = Utilidades.leerNumero();

        System.out.println("Ingrese su cobertura medica:");
        Cobertura cobertura = Utilidades.leerCobertura();

        System.out.println("Ingrese su correo electronico:");
        String email = Utilidades.leerTexto();

        System.out.println("Ingrese su direccion");
        String direccion = Utilidades.leerTexto();

        PacienteDTO paciente = DTOFactory.getDTO(nroSocio, cobertura, dni, nombre, apellido, genero, email, fecha, direccion);

        db.agregar(paciente);
    }

    /**
     * Elimina un {@link PacienteDTO} de la {@link BaseDatos}
     *
     * @param paciente Objeto {@link PacienteDTO}
     * @param db Base de datos
     */
    @Override
    public void borrar(PacienteDTO paciente, BaseDatos db) {
        db.quitar(paciente);
    }

    /**
     * Muestra el menu de opciones del paciente
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
                    this.agregar(db);
                    break;
                case '2':
                    this.borrar(db.elegirPaciente(), db);
                    break;
                case '3':
                    this.mostrarDatos(db.elegirPaciente());
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
     * @param paciente {@link PacienteDTO}
     */
    @Override
    public void mostrarDatos(PacienteDTO paciente) {
        System.out.println("\n---------------------------------------------------------------------------\n"
                + "\n\tPaciente: " + paciente.getNombre() + " " + paciente.getApellido()
                + "\n\t\tNumero de Socio: " + paciente.getNroSocio()
                + "\n\t\tPlan medico: " + paciente.getCobertura()
                + "\n\t\tGenero: " + paciente.getGenero()
                + "\n\t\tFecha de nacimiento: " + paciente.getNacimiento()
                + "\n\t\tCorreo Electronico: " + paciente.getEmail()
                + "\n---------------------------------------------------------------------------\n"
        );
    }

    /**
     * Realiza una accion del paciente
     */
    @Override
    public void proceder() {
        System.out.println("Estoy siendo atendido...");
    }

}
