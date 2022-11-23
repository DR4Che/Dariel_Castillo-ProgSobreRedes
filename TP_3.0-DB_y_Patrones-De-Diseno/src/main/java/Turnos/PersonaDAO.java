package Turnos;

/**
 * @param <T> {@link PacienteDAO} o {@link MedicoDTO}
 */
public class PersonaDAO<T> implements GeneralDAO<T> {

    /**
     * Agrega una {@link PersonaDTO} a la {@link BaseDatos}
     *
     * @param p {@link PersonaDTO}
     */
    @Override
    public void agregar(T p) {
    }

    /**
     * Elimina un {@link PersonaDTO} de la {@link BaseDatos}
     *
     * @param id id de {@link PersonaDTO} en la base de datos
     */
    @Override
    public void borrar(int id) {
    }

    /**
     * Muestra el menu de {@link PersonaDTO}
     *
     * @return {@link Boolean#TRUE} o {@link Boolean#FALSE}
     */
    @Override
    public boolean mostrarMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Muestra los datos de {@link PersonaDTO}
     *
     * @param id id de {@link PersonaDTO} en la base de datos
     *
     */
    @Override
    public void mostrarDatos(int id) {
    }

    /**
     * Metodo de accion de la persona
     */
    public void proceder() {
    }

}
