package com.example.proyectoubicacion.Activities;

public class ListElement {
    public String titulo;
    public String Descripcion;
    public int imagen;
    public int imagen2;
    public int imagen3;

    public ListElement(String titulo, String descripcion, int imagen, int imagen2, int imagen3) {
        this.titulo = titulo;
        Descripcion = descripcion;
        this.imagen = imagen;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
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

    public int getImagen2() {
        return imagen2;
    }

    public void setImagen2(int imagen2) {
        this.imagen2 = imagen2;
    }

    public int getImagen3() {
        return imagen3;
    }

    public void setImagen3(int imagen3) {
        this.imagen3 = imagen3;
    }
}
