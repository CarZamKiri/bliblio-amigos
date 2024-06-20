package dao;

import util.ConexionBD;
import model.usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

    // Create
    public boolean insertUsuario(usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, nombreUsuario, email, fechaNacimiento, genero, estado) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNombre());
        statement.setString(2, usuario.getNombreUsuario());
        statement.setString(3, usuario.getEmail());
        statement.setDate(4, usuario.getFechaNacimiento());
        statement.setInt(5, usuario.getGenero());
        statement.setInt(6, usuario.getEstado());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowInserted;
    }

    // Read
    public List<usuario> listAllUsuarios() throws SQLException {
        List<usuario> listUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        Connection connection = ConexionBD.obtenerConexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String nombre = resultSet.getString("nombre");
            String nombreUsuario = resultSet.getString("nombreUsuario");
            String email = resultSet.getString("email");
            Date fechaNacimiento = resultSet.getDate("fechaNacimiento");
            int genero = resultSet.getInt("genero");
            int estado = resultSet.getInt("estado");

            usuario usuario = new usuario(ID, nombre, nombreUsuario, email, fechaNacimiento, genero, estado);
            listUsuarios.add(usuario);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return listUsuarios;
    }

    // Update
    public boolean updateUsuario(usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, nombreUsuario = ?, email = ?, fechaNacimiento = ?, genero = ?, estado = ? WHERE ID = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNombre());
        statement.setString(2, usuario.getNombreUsuario());
        statement.setString(3, usuario.getEmail());
        statement.setDate(4, usuario.getFechaNacimiento());
        statement.setInt(5, usuario.getGenero());
        statement.setInt(6, usuario.getEstado());
        statement.setInt(7, usuario.getID());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowUpdated;
    }

    // Delete
    public boolean deleteUsuario(usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE ID = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getID());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowDeleted;
    }

    // Get by ID
    public usuario getUsuario(int id) throws SQLException {
        usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE ID = ?";

        Connection connection = ConexionBD.obtenerConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String nombreUsuario = resultSet.getString("nombreUsuario");
            String email = resultSet.getString("email");
            Date fechaNacimiento = resultSet.getDate("fechaNacimiento");
            int genero = resultSet.getInt("genero");
            int estado = resultSet.getInt("estado");

            usuario = new usuario(id, nombre, nombreUsuario, email, fechaNacimiento, genero, estado);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return usuario;
    }
}
