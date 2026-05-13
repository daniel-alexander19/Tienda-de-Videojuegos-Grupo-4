package com.tiendavideojuegos.servicios;

import com.tiendavideojuegos.modelo.Producto;
import com.tiendavideojuegos.modelo.Categoria;

import java.util.ArrayList;

public class GestorProductos {

    private ArrayList<Producto> productos = new ArrayList<>();

    // =========================
    // AGREGAR PRODUCTO
    // =========================
    public void agregar(Producto p) {
        productos.add(p);
    }

    // =========================
    // LISTAR TODOS
    // =========================
    public void listar() {

        System.out.println("\n🎮 LISTA DE PRODUCTOS:");

        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public Producto buscarPorId(int id) {

        for (Producto p : productos) {

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    // =========================
    // LISTAR POR CATEGORÍA
    // =========================
    public void listarPorCategoria(Categoria categoria) {

        System.out.println("\n🎮 JUEGOS DE CATEGORÍA: " + categoria);

        boolean encontrado = false;

        for (Producto p : productos) {

            if (p.getCategoria() == categoria) {
                p.mostrarInfo();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("⚠ No hay juegos en esta categoría.");
        }
    }
    public void buscarPorNombre(String nombre) {

        boolean encontrado = false;

        System.out.println("\n🔎 RESULTADOS DE BÚSQUEDA: " + nombre);

        for (Producto p : productos) {

            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {

                p.mostrarInfo();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("❌ No se encontraron productos con ese nombre.");
        }
    }

    // =========================
    // OBTENER TODOS (opcional)
    // =========================
    public ArrayList<Producto> obtenerTodos() {
        return productos;
    }
}