package main;

import Modelo.ConexionBD;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Intentar obtener una conexión
            connection = ConexionBD.obtenerConexion();

            // Verificar si la conexión fue exitosa
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexión a la base de datos establecida con éxito.");
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerrar la conexión
            ConexionBD.cerrarConexion();
        }
    }
}
