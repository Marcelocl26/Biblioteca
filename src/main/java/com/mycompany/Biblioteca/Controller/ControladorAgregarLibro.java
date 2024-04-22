/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.Controller;

import com.mycompany.Biblioteca.Model.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Marcelo
 */
public class ControladorAgregarLibro {
    
    public void guardarLibro(
            JTextField txtTitulo, 
            JTextField txtAutor, 
            JTextField txtGenero, 
            JTextField txtAnioPublicacion, 
            JComboBox<String> cboDisponible
    ) {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = BaseDeDatos.conectar();
            
            // Consulta SQL para insertar un nuevo libro
            String query = "INSERT INTO libros (titulo, autor, genero, anioPublicacion, disponible) VALUES (?, ?, ?, ?, ?)";
            
           
            PreparedStatement statement = conexion.prepareStatement(query);
            
            
            statement.setString(1, txtTitulo.getText());
            statement.setString(2, txtAutor.getText());
            statement.setString(3, txtGenero.getText());
            statement.setInt(4, Integer.parseInt(txtAnioPublicacion.getText()));
            
     
            String disponibilidad = cboDisponible.getSelectedItem().toString();
            statement.setString(5, disponibilidad);
            
            // Ejecutar la consulta SQL para insertar el nuevo libro
            int filasInsertadas = statement.executeUpdate();
            
           
            if (filasInsertadas > 0) {
                System.out.println("Libro insertado correctamente en la base de datos.");
            } else {
                System.out.println("Error al insertar el libro en la base de datos.");
            }
            
     
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar con la base de datos o al ejecutar la consulta SQL.");
        }
    }
}

