package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gir15
 * 
 */
public class Conexion {
    
    public Connection obtenerConexion(){
        
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entradacine","root","");
            System.out.println("Conexión exitosa");
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return connection;
    }
    
}
