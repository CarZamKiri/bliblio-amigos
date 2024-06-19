package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
    //Estos valores se cambian
    private static final String URL = "jdbc:postgresql://localhost:5434/BiblioAmigos";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Safr1du0";
    private static Connection connection;

    public static Connection obtenerConexion() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
        return connection;
    }

    public static void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}
