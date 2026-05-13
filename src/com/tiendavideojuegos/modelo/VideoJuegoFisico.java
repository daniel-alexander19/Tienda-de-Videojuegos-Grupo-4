package com.tiendavideojuegos.modelo;

public class VideoJuegoFisico extends Producto {

    private int stock;

    public VideoJuegoFisico(int id, String nombre, double precio,
                            int stock, Categoria categoria) {

        super(id, nombre, precio, categoria);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void reducirStock() {
        if (stock > 0) {
            stock--;
        }
    }

    @Override
    public void mostrarInfo() {

        System.out.println("\n🎮 VIDEOJUEGO FÍSICO");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Categoría: " + getCategoria());
        System.out.println("Stock: " + stock);
    }

    @Override
    public String mostrarInformacion() {
        return "";
    }
}