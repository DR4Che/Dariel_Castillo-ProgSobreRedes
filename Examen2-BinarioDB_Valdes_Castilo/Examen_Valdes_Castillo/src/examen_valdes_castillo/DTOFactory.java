/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_valdes_castillo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Software-Notebook
 */
public class DTOFactory {
    
    private static DTOFactory fabrica = null;
    private GeneralDTO dto = null;
    
    private DTOFactory()
    {
        
    }
    
    public static DTOFactory getInstance(){
        if( fabrica == null)
            fabrica = new DTOFactory();
        
        return fabrica;
    }
    
    public GeneralDTO getDTO( String tipo , ResultSet rs ) throws SQLException{
        
        switch(tipo)
        {
            case "cliente":
            break;
            case "stock":
            break;
        }
        
        return dto;
    }

    
}
