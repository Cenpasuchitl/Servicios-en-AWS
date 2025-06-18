
package edu.utl.aws.modelo;

public class Libro {
    
    private int id;
    private String titulo;
    private Editorial editorial;

    public Libro() {
    }

    public Libro(int id, String titulo, Editorial editorial) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
    }

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

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "M_Libro{" + "id=" + id + ", titulo=" + titulo + ", editorial=" + editorial + '}';
    }
}