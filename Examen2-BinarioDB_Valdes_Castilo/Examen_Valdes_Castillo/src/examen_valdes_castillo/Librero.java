
package examen_valdes_castillo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Librero implements Serializable {

    private static final long serialVersionUID = -1000L;

    private List<Articulos> articulos;

    public Librero() {
        articulos = new LinkedList<>();
    }

    public void agregarArticulo(Articulos p) {
        if (p != null) {
            articulos.add(p);
        }
    }

    public Articulos devolverArticulo(int i) {
        Articulos auxP = articulos.get(i);
        return auxP;
    }

    public List<Articulos> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulos> articulos) {
        this.articulos = articulos;
    }
    
    

}
