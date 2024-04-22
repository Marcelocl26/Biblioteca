/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.Controller;

import com.mycompany.Biblioteca.Model.Libro;
import com.mycompany.Biblioteca.Model.BaseDeDatos;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

 /*
 * @author Marcelo
 */
public class ControladorEditarLibro {
    
    
    
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
    }
}