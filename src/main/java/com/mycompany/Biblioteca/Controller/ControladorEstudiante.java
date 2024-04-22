package com.mycompany.Biblioteca.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.Biblioteca.Model.BaseDeDatos;
import com.mycompany.Biblioteca.Model.Estudiante;

public class ControladorEstudiante {
    
    public List<Estudiante> obtenerEstudiantes() throws SQLException {
        List<Estudiante> estudiantes = new ArrayList<>();
        
        try (Connection conexion = BaseDeDatos.conectar();
             PreparedStatement statement = conexion.prepareStatement("SELECT nombre, apellido FROM estudiantes");
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                Estudiante estudiante = new Estudiante(nombre, apellido);
                estudiantes.add(estudiante);
            }
        }
        
        return estudiantes;
    }
}
