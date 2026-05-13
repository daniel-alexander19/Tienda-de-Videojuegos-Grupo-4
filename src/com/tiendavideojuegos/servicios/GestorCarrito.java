package com.tiendavideojuegos.servicios;

import com.tiendavideojuegos.modelo.Producto;

import java.util.ArrayList;

public class GestorCarrito {

    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("✔ Agregado al carrito: " + p.getNombre());
    }

    public void mostrarProductos() {
        System.out.println("\n🛒 CARRITO:");

        if (productos.isEmpty()) {
            System.out.println("Vacío");
            return;
        }

        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    public double calcularTotal() {
        double total = 0;

        for (Producto p : productos) {
            total += p.getPrecio();
        }

        return total;
    }

    public void limpiarCarrito() {
        productos.clear();
        System.out.println("🧹 Carrito vaciado");
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}