/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.Controller;

/**
 *
 * @author Marcelo
 */

import com.mycompany.Biblioteca.Model.Usuario;
import com.mycompany.Biblioteca.Model.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorUsuario {
    
    public boolean registrarUsuario(Usuario usuario) {
        try {
            Connection conexion = BaseDeDatos.conectar();
            String query = "INSERT INTO usuarios (nombre, correo, contrasena) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getCorreo());
            statement.setString(3, usuario.getContrasena());
            int filasInsertadas = statement.executeUpdate();
            conexion.close();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
   public boolean iniciarSesion(String correo, String contrasena) {
        try {
         
            Connection conexion = BaseDeDatos.conectar();
            
   
            String query = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, correo);
            statement.setString(2, contrasena);
            
            // Ejecutar consulta
            ResultSet resultSet = statement.executeQuery();
            
            // Verificar si se encontró un usuario con las credenciales proporcionadas
            boolean usuarioValido = resultSet.next();
            
            // Cerrar conexión a la base de datos
            conexion.close();
            
            return usuarioValido;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}