package com.tiendavideojuegos.modelo;

import java.util.ArrayList;

public class Carrito {

    private ArrayList<Producto> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    // Agregar producto al carrito
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("✔ Producto agregado: " + producto.getNombre());
    }

    // Mostrar carrito
    public void mostrarCarrito() {
        System.out.println("\n🛒 CARRITO DE COMPRAS");

        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    // Calcular total
    public double calcularTotal() {
        double total = 0;

        for (Producto p : productos) {
            total += p.getPrecio();
        }

        return total;
    }
}