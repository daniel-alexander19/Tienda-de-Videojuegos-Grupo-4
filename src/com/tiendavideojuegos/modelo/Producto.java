package com.tiendavideojuegos.modelo;

public abstract class Producto {

    private int id;
    private String nombre;
    private double precio;
    private String descripcion;
    private Categoria categoria;

    public Producto(int id, String nombre, double precio, String descripcion, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Producto(int id, String nombre, double precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // =========================
    // GETTERS
    // =========================
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // =========================
    // SETTERS
    // =========================
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract void mostrarInfo();

    // =========================
    // MÉTODO ABSTRACTO
    // =========================
    public abstract String mostrarInformacion();
}