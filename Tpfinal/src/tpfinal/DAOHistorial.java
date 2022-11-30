/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOHistorial implements DAOGeneral<DTOHistorial> {

    public DAOHistorial(int id, String usuario, String mensaje, String receptor, Date fecha) {
        DTOHistorial dto = new DTOHistorial(id, usuario, mensaje, receptor, fecha);
        agregar(dto);
    }

    @Override
    public void agregar(DTOHistorial registro) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            String consulta = "INSERT INTO historial(usuario,mensaje, receptor,fecha) VALUES (?,?,?,?)";

            con = ConexionesFactory.getInstance().getConection();

            ps = con.prepareStatement(consulta);


            ps.setString(1, registro.getMensaje());
            ps.setString(2, registro.getUsuario());
            ps.setString(3, registro.getReceptor());
            ps.setDate(4, (Date) registro.getFecha());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOHistorial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOHistorial.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public void borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(DTOHistorial registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOHistorial> obtenerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DTOHistorial obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
