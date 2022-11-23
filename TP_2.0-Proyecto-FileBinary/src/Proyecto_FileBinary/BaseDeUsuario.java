package Proyecto_FileBinary;

import static Proyecto_FileBinary.Utilidades.mostrarPorPantalla;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Base de usuarios
 * @author Castillo Dariel
 */
public class BaseDeUsuario implements Serializable {
    
    private static final long serialVersionUID = -1000L;

    protected List<Persona> bUsuario;
    

    public BaseDeUsuario() {
        bUsuario = new LinkedList<>();
    }
    
    /**
     * Agrega un objeto {@link Persona} a la lista {@link #bUsuario}
     * 
     * 
     * @param p Recibe un objeto {@link Persona}
     */
    public void agregarUsuario(Persona p) {
        if (p != null) {
            bUsuario.add(p);
        }
    }

    /**
     * Recibe un numero y devuelve un objeto {@link Persona} en la lista {@link #bUsuario}, 
     * con la posición igual al numero dado como parametro de entrada
     * 
     * @param i Posición de la lista {@link #bUsuario}
     * @return Objeto {@link Persona}
     */
    public Persona devolverUsurio(int i) {
        Persona auxP = bUsuario.get(i);
        return auxP;
    }

    /**
     * Llama a {@link Persona#mostrarDatos() } de todos los objetos {@link Persona} que tengan una instancia del Objeto dado como pametro de entrada de la lista {@link #bUsuario}
     * @param c
     */
    public void mostrarPersonas(Class<?> c) {
        for (Persona p : bUsuario.subList(2, bUsuario.size())) {
            if (p.getClass() == c.asSubclass(c)) {
                p.mostrarDatos();
            }
        }
    }
    
    /**
     * Actualiza los sueldos y las Cuotas de todos los objetos {@link Persona} llamando a su metodo {@link Persona#calcular()}
     */
    public void actualizarSueldosCoutas() {
        for (Persona p : bUsuario) {
            p.calcular();
        }
    }
    
    /**
     * Devuelve un objeto {@link Persona} instancia de la clase dada como pametro de entrada de la lista {@link #bUsuario}
     * 
     * @param c
     * @return Persona {@link Object}
     */        
    public Object elegirPersona(Class<?> c) {
        int cantSocios = 0;
        Iterator iter = bUsuario.subList(2, bUsuario.size()).iterator();
        while(iter.hasNext()){
            if(iter.next().getClass() == c.asSubclass(c)){
                cantSocios++;
            }
        }
        
        int i = -1;
        boolean cerrar = false;
        int op = 0;
        while (!cerrar) {
            String opciones = "\n\tELIJA UN " + c.asSubclass(c).getSimpleName().toUpperCase() + "\n\n";
            i = 1;
            for (Persona p : bUsuario.subList(2, bUsuario.size())) {
                if(p.getClass() == c.asSubclass(c)){
                    opciones += "\t\t[" + i + "] " + ((Socio) p).nombre + " " + ((Socio) p).apellido + "\n";
                    i++;
                }
            }
            mostrarPorPantalla(opciones);
            op = Utilidades.leerNumero();
            
            if (op > 1 && op < cantSocios){
                cerrar = true;
            }
        } 
        
        i = 1;
        for (Persona p : bUsuario.subList(2, bUsuario.size())) {
            if(p.getClass() == c.asSubclass(c)){
                if(op == i){
                    return p;
                }else{
                    i++;
                }
            }
        }
        return null;
    }
}
