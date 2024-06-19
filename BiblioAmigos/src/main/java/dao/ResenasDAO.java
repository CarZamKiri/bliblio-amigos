package dao;

import util.ConexionBD;
import model.resenas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResenasDAO {

    // Create
    public boolean insertResena(resenas resena) throws SQLException {
        String sql = "INSERT INTO resenas (idUsuario, idLibro, resena, calificacion, fecha) VALUES (?, ?, ?, ?, ?)";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, resena.getIdUsuario());
        statement.setInt(2, resena.getIdLibro());
        statement.setString(3, resena.getResena());
        statement.setInt(4, resena.getCalificacion());
        statement.setDate(5, Date.valueOf(resena.getFecha()));

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowInserted;
    }

    // Read
    public List<resenas> listAllResenas() throws SQLException {
        List<resenas> listResenas = new ArrayList<>();
        String sql = "SELECT * FROM resenas";

        Connection connection = ConexionBD.obtenerConexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idUsuario = resultSet.getInt("idUsuario");
            int idLibro = resultSet.getInt("idLibro");
            String resena = resultSet.getString("resena");
            int calificacion = resultSet.getInt("calificacion");
            String fecha = resultSet.getDate("fecha").toString();

            resenas resenaObj = new resenas(idUsuario, idLibro, resena, calificacion, fecha);
            listResenas.add(resenaObj);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return listResenas;
    }

    // Update
    public boolean updateResena(resenas resena) throws SQLException {
        String sql = "UPDATE resenas SET resena = ?, calificacion = ?, fecha = ? WHERE idUsuario = ? AND idLibro = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, resena.getResena());
        statement.setInt(2, resena.getCalificacion());
        statement.setDate(3, Date.valueOf(resena.getFecha()));
        statement.setInt(4, resena.getIdUsuario());
        statement.setInt(5, resena.getIdLibro());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowUpdated;
    }

    // Delete
    public boolean deleteResena(int idUsuario, int idLibro) throws SQLException {
        String sql = "DELETE FROM resenas WHERE idUsuario = ? AND idLibro = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idUsuario);
        statement.setInt(2, idLibro);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowDeleted;
    }

    // Get by ID
    public resenas getResena(int idUsuario, int idLibro) throws SQLException {
        resenas resena = null;
        String sql = "SELECT * FROM resenas WHERE idUsuario = ? AND idLibro = ?";

        Connection connection = ConexionBD.obtenerConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idUsuario);
        statement.setInt(2, idLibro);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String resenaText = resultSet.getString("resena");
            int calificacion = resultSet.getInt("calificacion");
            String fecha = resultSet.getDate("fecha").toString();

            resena = new resenas(idUsuario, idLibro, resenaText, calificacion, fecha);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return resena;
    }
}
