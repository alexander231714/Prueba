package conf;
import java.sql.*;
/**
 *
 * @author Usuario
 */
public class conexion {

    Connection con;
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bk_aac", "root", "");
        } catch (Exception e) {
            System.err.println("No se pudo establecer conexion con la Base de Datos. Error: "+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
