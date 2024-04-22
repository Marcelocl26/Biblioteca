/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.Model;

/**
 *
 * @author Marcelo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
    private static final String URL = "jdbc:mysql://localhost:4563/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
