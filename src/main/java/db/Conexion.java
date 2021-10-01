package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Contiene el metodo para conectar a la base de datos para realizar consultas mediante los DAO
 * 
 * @author dltun, isra, asael, leslie
 */
public class Conexion {
    public static Connection ConectarBD() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EscuelaMaven?"
                    + "user=postgres"
                    + "&password=");

        } catch (SQLException e) {
            System.out.println("Error de conexión:  " + e.getMessage());
        }

        return conn;
    }
}
