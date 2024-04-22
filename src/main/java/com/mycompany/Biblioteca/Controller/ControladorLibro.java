/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.Controller;

/**
 *
 * @author Marcelo
 */


import com.mycompany.Biblioteca.Model.Libro;
import com.mycompany.Biblioteca.Model.BaseDeDatos;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorLibro {
    
    public Libro buscarLibro(String criterio) {
        try {
            Connection conexion = BaseDeDatos.conectar();
            String query = "SELECT * FROM libros WHERE titulo LIKE ? OR autor LIKE ? OR genero LIKE ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, "%" + criterio + "%");
            statement.setString(2, "%" + criterio + "%");
            statement.setString(3, "%" + criterio + "%");
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                Libro libro = new Libro(
                    //resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getString("autor"),
                    resultSet.getString("genero"),
                    resultSet.getInt("anioPublicacion"),
                    resultSet.getString("disponible")
                );
                conexion.close();
                return libro;
            } else {
                conexion.close();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Libro> obtenerLibros() {
        List<Libro> libros = new ArrayList<>();
        try {
            // Establecer conexión a la base de datos
            Connection conexion = BaseDeDatos.conectar();
            
            // Crear consulta SQL para obtener todos los libros
            String query = "SELECT * FROM libros";
            PreparedStatement statement = conexion.prepareStatement(query);
            
            // Ejecutar consulta
            ResultSet resultSet = statement.executeQuery();
            
            // Recorrer el resultado de la consulta y crear objetos Libro
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                String genero = resultSet.getString("genero");
                int anioPublicacion = resultSet.getInt("anioPublicacion");
                String disponible = resultSet.getString("disponible");
                
                // Crear objeto Libro y añadirlo a la lista
                Libro libro = new Libro(id,titulo,  autor, genero, anioPublicacion, disponible);
                libros.add(libro);
            }
            
            // Cerrar conexión a la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    } 



public List<Libro> buscarLibrosPorTitulo(String titulo) {
    List<Libro> librosEncontrados = new ArrayList<>();
    try {
        // Establecer conexión a la base de datos
        Connection conexion = BaseDeDatos.conectar();
        
        // Crear consulta SQL para buscar libros por título
        String query = "SELECT * FROM libros WHERE titulo LIKE ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, "%" + titulo + "%"); // Utilizamos LIKE para buscar títulos que contengan la cadena proporcionada
        
        // Ejecutar consulta
        ResultSet resultSet = statement.executeQuery();
        
        // Recorrer el resultado de la consulta y crear objetos Libro
        while (resultSet.next()) {
            String tituloLibro = resultSet.getString("titulo");
            String autor = resultSet.getString("autor");
            String genero = resultSet.getString("genero");
            int anioPublicacion = resultSet.getInt("anioPublicacion");
            String disponible = resultSet.getString("disponible");
            
            // Crear objeto Libro y añadirlo a la lista
            Libro libro = new Libro(tituloLibro, autor, genero, anioPublicacion, disponible);
            librosEncontrados.add(libro);
        }
        
        // Cerrar conexión a la base de datos
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return librosEncontrados;
}

public List<String> obtenerTitulosLibros() {
    List<String> titulosLibros = new ArrayList<>();
    try {
        // Establecer conexión a la base de datos
        Connection conexion = BaseDeDatos.conectar();
        
        // Crear consulta SQL para obtener todos los títulos y IDs de libros
        String query = "SELECT id, titulo FROM libros";
        PreparedStatement statement = conexion.prepareStatement(query);
        
        // Ejecutar consulta
        ResultSet resultSet = statement.executeQuery();
        
        // Recorrer el resultado de la consulta y obtener los títulos y IDs de los libros
        while (resultSet.next()) {
            String idLibro = resultSet.getString("id");
            String tituloLibro = resultSet.getString("titulo");
            titulosLibros.add(idLibro + ": " + tituloLibro);
        }
        
        // Cerrar conexión a la base de datos
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return titulosLibros;
    
}
        
   public void editarLibro(int id, String nuevoTitulo, String nuevoAutor, String nuevoGenero, int nuevoAnioPublicacion, String disponible) {
        try {
            Connection conexion = BaseDeDatos.conectar();
            String query = "UPDATE libros SET titulo=?, autor=?, genero=?, anioPublicacion=?, disponible=? WHERE id=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nuevoTitulo);
            statement.setString(2, nuevoAutor);
            statement.setString(3, nuevoGenero);
            statement.setInt(4, nuevoAnioPublicacion);
            statement.setString(5, disponible);
            statement.setInt(6, id);

            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("El libro con ID " + id + " ha sido actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún libro con ID " + id + ".");
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
}}