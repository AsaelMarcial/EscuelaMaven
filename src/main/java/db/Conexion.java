package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
