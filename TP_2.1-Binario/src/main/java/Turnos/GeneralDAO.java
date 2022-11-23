package Turnos;

/**
 * Interfaz DAO que permitira manejar el CRUD de quien la implemente
 *
 * @author Ignacio Rios Lahore (Pistak41)
 * @param <T>
 */
public interface GeneralDAO<T> {

    /**
     * Agrega un {@link GeneralDTO} a la {@link BaseDatos}
     *
     * @param db Base de datos
     */
    public void agregar(BaseDatos db);

    /**
     * Elimina un {@link GeneralDTO} de la {@link BaseDatos}
     *
     * @param t Objeto {@link GeneralDTO}
     * @param db Base de datos
     */
    public void borrar(T t, BaseDatos db);

    /**
     * Muestra el respectivo menu del objeto
     *
     * @param db Base de datos
     * @return {@link Boolean#TRUE} o {@link Boolean#FALSE}
     */
    public boolean mostrarMenu(BaseDatos db);

    /**
     * Muestra los datos de {@link GeneralDTO}
     *
     * @param t Objeto {@link GeneralDTO}
     */
    public void mostrarDatos(T t);

}
