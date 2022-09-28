/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valdes_castillo;

/**
 *
 * @author Soft 06
 */
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

}

