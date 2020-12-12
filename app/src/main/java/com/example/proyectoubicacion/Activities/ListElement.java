package com.example.proyectoubicacion.Activities;

public class ListElement {
    public String titulo;
    public String Descripcion;
    public int imagen;

    public ListElement(String titulo, String descripcion, int imagen) {
        this.titulo = titulo;
        Descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
