package Turnos;

/**
 * Interfaz DAO que permitira manejar el CRUD de quien la implemente
 *
 * @author Ignacio Rios Lahore (Pistak41)
 * @param <T> Operador diamante
 */
public interface GeneralDAO<T> {

    /**
     * Agrega un {@link GeneralDTO} a la {@link BaseDatos}
     *
     * @param t Objeto {@link GeneralDTO}
     */
    public void agregar(T t);

    /**
     * Elimina un {@link GeneralDTO} de la {@link BaseDatos}
     *
     * @param id id de {@link GeneralDTO} en la base de datos
     */
    public void borrar(int id);

    /**
     * Muestra el respectivo menu del objeto
     *
     * @return {@link Boolean#TRUE} o {@link Boolean#FALSE}
     */
    public boolean mostrarMenu();

    /**
     * Muestra los datos de {@link GeneralDTO}
     *
     * @param id id de {@link GeneralDTO} en la base de datos
     */
    public void mostrarDatos(int id);

}
