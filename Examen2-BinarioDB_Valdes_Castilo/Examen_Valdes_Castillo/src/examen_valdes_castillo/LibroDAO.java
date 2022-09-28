/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_valdes_castillo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En las Class con patron de diseño DAO vamos a implemetar la capa de negocios
 * especifica (la logica) para cada tabla de datos (o DTO) en este caso lo
 * aplicamos con el CRUD de cada tabla en particular.
 *
 * @author conso
 */
public class LibroDAO implements GeneralDAO<Libro>{

    public void agregar( Libro registro ) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = ConexionesFactory.getInstance().getConection();
            String consulta = "INSERT INTO articulos(codigo,nombre,genero) VALUES (?,?,?)";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setInt(1, registro.getCodigo() );
            ps.setString(2, registro.getNombre());
            ps.setString(3, registro.getGenero());
            
            ps.executeUpdate();
            /**
             * Esto es una API que implementa una tecnica llama REFLEXION que
             * nos permite a grandes rasgos obtener datos de lo declarado en una
             * de nuestras Class mediente metados, en este caso lo usaremos para
             * saber los campos que sean necesarios para la consulta. Field[]
             * atributos = GeneralDAO.class.getDeclaredFields();
             */            
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            
    }

    public void borrar( Libro registro) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            String consulta = "DELETE FROM articulos WHERE id = ? ";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setInt(1, registro.getId() );
            
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }              
    }

    
    public void actualizar( Libro registro) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            String consulta = "UPDATE articulos SET codigo=? , nombre=? , genero=? WHERE id=?";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setString(1, registro.getNombre() );
            ps.setString(2, registro.getDni());
            ps.setDate(3, registro.getFecha());
            ps.setInt(4, registro.getId());
            
            ps.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }

    public ArrayList<Libro> obtenerTodo() {      
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Libro> listAux = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM articulos";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement( sql );
            
            rs = ps.executeQuery();
            
            while( rs.next() )
            {             
                listAux.add( (Libro)Libro.getInstance().getDTO("cliente", rs) );
            }
            
        }catch(SQLException ex){
            
        }finally{
            try {
            if( rs != null)
                rs.close();
                    
            if( ps != null )
                ps.close();
            
            if( con != null)
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        return listAux;
    }

    public Libro obtener(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            String sql = "SELECT * FROM articulos WHERE id=?";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement( sql );
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            while( rs.next() )
            {             
                return (Libro)Libro.getInstance().get( "cliente" , rs ) ;
            }   
        }catch(SQLException ex){
            
        }finally{
            try {
            if( rs != null)
                rs.close();
                    
            if( ps != null )
                ps.close();
            
            if( con != null)
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        return null;        
    }
     
}
