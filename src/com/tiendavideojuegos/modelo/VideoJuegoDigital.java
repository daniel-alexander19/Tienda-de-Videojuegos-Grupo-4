package com.tiendavideojuegos.modelo;

public class VideoJuegoDigital extends Producto {

    private int tamanoMB;

    public VideoJuegoDigital(int id, String nombre, double precio,
                             int tamanoMB, Categoria categoria) {

        super(id, nombre, precio, categoria);
        this.tamanoMB = tamanoMB;
    }

    public int getTamanoMB() {
        return tamanoMB;
    }

    @Override
    public void mostrarInfo() {

        System.out.println("\n🎮 VIDEOJUEGO DIGITAL");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Categoría: " + getCategoria());
        System.out.println("Tamaño: " + tamanoMB + " MB");
    }

    @Override
    public String mostrarInformacion() {
        return "";
    }
}