/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.Model;

/**
 *
 * @author Marcelo
 */
public class EditarLibro {
   private int id; 
   private String titulo; 
   private String autor ;
   private String genero; 
   private String anio; 
   private String disponibilidad; 

    public EditarLibro() {
    }

    public EditarLibro(int id,String titulo, String autor, String genero, String anio, String disponibilidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.disponibilidad = disponibilidad;
    }

   
   
}
