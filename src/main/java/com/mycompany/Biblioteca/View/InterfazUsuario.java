/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.View;

/**
 *
 * @author Marcelo
 */


import javax.swing.*;

public class InterfazUsuario {
    private JFrame frame;
    private JTextField txtNombre;
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    private JButton btnRegistrar;
    private JButton btnIniciarSesion;
    
    public InterfazUsuario() {
        initialize();
    }
      // Método para obtener la ventana principal (JFrame)
    public JFrame getFrame() {
        return frame;
    }

    private void initialize() {
        frame = new JFrame("Interfaz de Usuario");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 50, 100, 20);
        frame.getContentPane().add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 50, 200, 20);
        frame.getContentPane().add(txtNombre);
        txtNombre.setColumns(10);
        
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(50, 100, 100, 20);
        frame.getContentPane().add(lblCorreo);
        
        txtCorreo = new JTextField();
        txtCorreo.setBounds(150, 100, 200, 20);
        frame.getContentPane().add(txtCorreo);
        txtCorreo.setColumns(10);
        
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(50, 150, 100, 20);
        frame.getContentPane().add(lblContrasena);
        
        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(150, 150, 200, 20);
        frame.getContentPane().add(txtContrasena);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(100, 200, 100, 30);
        frame.getContentPane().add(btnRegistrar);
        
        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setBounds(250, 200, 150, 30);
        frame.getContentPane().add(btnIniciarSesion);
        
        
    }
}
