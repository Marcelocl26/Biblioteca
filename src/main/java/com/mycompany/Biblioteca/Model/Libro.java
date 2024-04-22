/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.Model;

/**
 *
 * @author Marcelo
 */


public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;
    private String disponible;

    // Constructor
    public Libro(int id, String titulo, String autor, String genero, int anioPublicacion, String disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    
       public Libro( String titulo, String autor, String genero, int anioPublicacion, String disponible) {
        
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }
       
           public Libro( String titulo) {
        
        this.titulo = titulo;
        
    }
           
       public Libro( int id,String titulo ) {
        
        this.titulo = titulo;
        this.id = id;
    }






    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getDisponible() {
        return disponible;
    }

    
    

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

  

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
