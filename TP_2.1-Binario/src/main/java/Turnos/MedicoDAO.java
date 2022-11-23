package Turnos;

import java.io.Serializable;
import java.util.Date;

/**
 * Interfaz que maneja el CRUD de {@link MedicoDTO}
 *
 */
public class MedicoDAO extends PersonaDAO<MedicoDTO> implements Serializable {

    private static final long serialVersionUID = -1000L;

    /**
     * Agrega un {@link MedicoDTO} a la {@link BaseDatos}
     *
     * @param db Base de datos
     */
    @Override
    public void agregar(BaseDatos db) {
        System.out.println("Ingrese el nombre del medico:");
        String nombre = Utilidades.leerTexto();

        System.out.println("Ingrese el Apellido del medico:");
        String apellido = Utilidades.leerTexto();

        System.out.println("Ingrese su DNI:");
        int dni = Utilidades.leerNumero();

        System.out.println("Ingrese su fecha de nacimiento:");
        Date fecha = Utilidades.leerFecha();

        System.out.println("Ingrese su genero:");
        Genero genero = Utilidades.leerGenero();

        System.out.println("Ingrese su numero de matricula:");
        int matricula = Utilidades.leerNumero();

        System.out.println("Ingrese su especialidad:");
        Especialidad especialidad = Utilidades.leerEspecialidad();

        System.out.println("Ingrese su correo electronico:");
        String email = Utilidades.leerTexto();

        System.out.println("Ingrese su direccion");
        String direccion = Utilidades.leerTexto();

        db.agregar(DTOFactory.getDTO(matricula, especialidad, dni, nombre, apellido, genero, email, fecha, direccion));
    }

    /**
     * Elimina un {@link MedicoDTO} de la {@link BaseDatos}
     *
     * @param medico   Objeto {@link MedicoDTO}
     * @param db Base de datos
     */
    @Override
    public void borrar(MedicoDTO medico, BaseDatos db) {
        db.quitar(medico);
    }

    /**
     * Muestra el menu de opciones del medico
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
                    this.agregar(db);
                    break;
                case '2':
                    this.borrar(db.elegirMedico(), db);
                    break;
                case '3':
                    this.mostrarDatos(db.elegirMedico());
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
     * @param medico {@link MedicoDTO}
     */
    @Override
    public void mostrarDatos(MedicoDTO medico) {
        System.out.println("\n---------------------------------------------------------------------------"
                + "\n\tMedico: " + medico.getNombre() + " " + medico.getApellido()
                + "\n\t\tMatricula: " + medico.getMatricula()
                + "\n\t\tEspecialidad: " + medico.getEspecialidad()
                + "\n\t\tGenero: " + medico.getGenero()
                + "\n\t\tFecha de nacimiento: " + medico.getNacimiento()
                + "\n\t\tCorreo Electronico: " + medico.getEmail()
                + "\n---------------------------------------------------------------------------"
        );
    }

    /**
     * Realiza una accion del Medico
     */
    @Override
    public void proceder() {
        System.out.println("Estoy a tendiendo a un Paciente...");
    }

}
