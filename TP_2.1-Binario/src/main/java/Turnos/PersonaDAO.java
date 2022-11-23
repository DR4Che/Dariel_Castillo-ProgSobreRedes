/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Turnos;

/**
 * Interfaz padre de {@link PacienteDAO} y {@link MedicoDAO}
 *
 * @param <T> {@link PacienteDAO} o {@link MedicoDTO}
 */
public class PersonaDAO<T> implements GeneralDAO<T> {

    /**
     * Agrega una {@link PersonaDTO} a la {@link BaseDatos}
     *
     * @param db Base de datos
     */
    @Override
    public void agregar(BaseDatos db) {
    }

    /**
     * Elimina un {@link PersonaDTO} de la {@link BaseDatos}
     *
     * @param persona {@link PersonaDTO}
     * @param db Base de datos
     */
    @Override
    public void borrar(T persona, BaseDatos db) {
    }

    /**
     * Muestra el menu de {@link PersonaDTO}
     *
     * @param db Base de datos
     * @return {@link Boolean#TRUE} o {@link Boolean#FALSE}
     */
    @Override
    public boolean mostrarMenu(BaseDatos db) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Muestra los datos de {@link PersonaDTO}
     *
     * @param persona {@link PersonaDTO}
     */
    @Override
    public void mostrarDatos(T persona) {
    }

    /**
     * Metodo de accion de la persona
     */
    public void proceder() {}

}
