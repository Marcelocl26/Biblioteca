/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.Controller;

/**
 *
 * @author Marcelo
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.mycompany.Biblioteca.Model.BaseDeDatos; 
import com.mycompany.Biblioteca.Model.Estudiante;
import com.mycompany.Biblioteca.Model.Libro;
import com.mycompany.Biblioteca.Model.Prestamo;

public class ControladorPrestamo {
    
    public List<Prestamo> obtenerPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        try {
            Connection conexion = BaseDeDatos.conectar();
            String query = "SELECT id, estudiante, libro, fecha_prestamo, fecha_devolucion, idLibro FROM prestamo";
            PreparedStatement statement = conexion.prepareStatement(query);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String estudiante = resultSet.getString("estudiante");
                String libro = resultSet.getString("libro");
                Date fechaPrestamo = resultSet.getDate("fecha_prestamo");
                Date fechaDevolucion = resultSet.getDate("fecha_devolucion");
                int idLibro = resultSet.getInt("idLibro");
                
                Prestamo prestamo = new Prestamo(id, estudiante, libro, fechaPrestamo, fechaDevolucion, idLibro);
                prestamos.add(prestamo);
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }


public void registrarPrestamo(String nombreEstudiante, String tituloLibro, Date fechaPrestamo, Date fechaDevolucion, int idLibro) {
    try {
        
        Connection conexion = BaseDeDatos.conectar();

        // Consulta SQL para insertar un nuevo préstamo
        String query = "INSERT INTO prestamo (estudiante, libro, fecha_prestamo, fecha_devolucion, idLibro) VALUES (?, ?, ?, ?, ?)";

        
        PreparedStatement statement = conexion.prepareStatement(query);

        // Establecer los parámetros de la consulta
        statement.setString(1, nombreEstudiante); // Utilizar el nombre del estudiante en lugar de su ID
        statement.setString(2, tituloLibro);
        statement.setDate(3, new java.sql.Date(fechaPrestamo.getTime()));
        statement.setDate(4, new java.sql.Date(fechaDevolucion.getTime()));
        statement.setInt(5, idLibro); // Asignar el ID del libro

        // Ejecutar la consulta
        int filasInsertadas = statement.executeUpdate();

        
        if (filasInsertadas > 0) {
            System.out.println("El préstamo se registró correctamente.");
        } else {
            System.out.println("Error al registrar el préstamo.");
        }

        // Cerrar la conexión
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }}
        
         public void eliminarPrestamo(int prestamoId, int prestamoidLibro) throws SQLException {
        try {
       
            Connection conexion = BaseDeDatos.conectar();

            // Consulta SQL para eliminar el préstamo con el ID 
            String query = "DELETE FROM prestamo WHERE id = ?";

          
            PreparedStatement statement = conexion.prepareStatement(query);

        
            statement.setInt(1, prestamoId);

            // Ejecutar la consulta para eliminar el préstamo
            int filasEliminadas = statement.executeUpdate();

           
            if (filasEliminadas > 0) {
                System.out.println("El préstamo se eliminó correctamente.");
            } else {
                System.out.println("No se encontró ningún préstamo con el ID proporcionado.");
            }

     
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }
    }
         
         public void actualizarDisponibilidadLibro(int idLibro) {
    try {
       
        Connection conexion = BaseDeDatos.conectar();

        // Consulta SQL para actualizar la columna 'disponible' 
        String query = "UPDATE libros SET disponible = no disponible WHERE id = ?";

        // Crear un objeto PreparedStatement con la consulta SQL
        PreparedStatement statement = conexion.prepareStatement(query);

       
        statement.setInt(1, idLibro);

        
        int filasActualizadas = statement.executeUpdate();

      
        if (filasActualizadas > 0) {
            System.out.println("La disponibilidad del libro se actualizó correctamente.");
        } else {
            System.out.println("Error al actualizar la disponibilidad del libro.");
        }

        // Cerrar la conexión
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
         
         public void actualizarDisponibilidadLibroDevuelto(int prestamoIdLibro) {
    try {
        // Establecer la conexión a la base de datos
        Connection conexion = BaseDeDatos.conectar();

        // Consulta SQL para actualizar la columna 'disponible' 
        String query = "UPDATE libros SET disponible = disponible WHERE id = ?";

        
        PreparedStatement statement = conexion.prepareStatement(query);

        // Establecer el parámetro de la consulta con el ID del libro
        statement.setInt(1, prestamoIdLibro);

        // Ejecutar la consulta
        int filasActualizadas = statement.executeUpdate();

        
        if (filasActualizadas > 0) {
            System.out.println("La disponibilidad del libro se actualizó correctamente.");
        } else {
            System.out.println("Error al actualizar la disponibilidad del libro.");
        }

        // Cerrar la conexión
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
         
         public int obtenerIdLibroDelPrestamo(int prestamoIdLibro) throws SQLException {
    try {
        
        Connection conexion = BaseDeDatos.conectar();

        // Consulta SQL para obtener el ID del libro asociado al préstamo
        String query = "SELECT idLibro FROM prestamo WHERE id = ?";
        
       
        PreparedStatement statement = conexion.prepareStatement(query);
        
        
        statement.setInt(1, prestamoIdLibro);
        
        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();
        
        int idLibro = -1; 
        
       
        if (resultSet.next()) {
            idLibro = resultSet.getInt("idLibro");
        }
        
        // Cerrar la conexión
        conexion.close();
        
        return idLibro;
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
}




    }