/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Biblioteca.Model;

/**
 *
 * @author Marcelo
 */
import java.util.Date;

public class Prestamo {
    private int id;
    private String estudiante;
    private String libro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private int idLibro;

    // Constructor
    public Prestamo(int id, String estudiante, String libro, Date fechaPrestamo, Date fechaDevolucion, int idLibro) {
        this.id = id;
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.idLibro= idLibro;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
        public int getidLibro() {
        return idLibro;
    }

    public void setidLibro(int idLibro) {
        this.idLibro = idLibro;
    }


    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", estudiante='" + estudiante + '\'' +
                ", libro='" + libro + '\'' +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
