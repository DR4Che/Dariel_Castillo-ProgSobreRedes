package tpfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**

 * Dariel Castillo 
*/
public class ConexionesFactory {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/chatfinal";
    String user = "root";
    String pass = "";

   
    private static ConexionesFactory fabrica = null;


    private ConexionesFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionesFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, pass);

        return conn;
    }

    public static ConexionesFactory getInstance() {
        if (fabrica == null) {
            fabrica = new ConexionesFactory();
        }

        return fabrica;
    }

}
