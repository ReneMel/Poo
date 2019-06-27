package ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hugo
 */


public class prueba {
    
    private final String url = "jdbc:postgresql://localhost/poo2019";
    private final String user = "postgres";
    private final String password = "my_postgres_password";
    Connection conn;
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection prueba() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
     }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
}
 
 