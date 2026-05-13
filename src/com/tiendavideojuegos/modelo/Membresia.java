package com.tiendavideojuegos.modelo;

public class Membresia {

    private String nombre;
    private double descuento; // porcentaje (ej: 0.05 = 5%)
    private double precio;    // costo de la membresía

    public Membresia(String nombre, double descuento, double precio) {
        this.nombre = nombre;
        this.descuento = descuento;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void mostrarInfo() {
        System.out.println("💎 Membresía: " + nombre);
        System.out.println("📉 Descuento: " + (descuento * 100) + "%");
        System.out.println("💰 Precio: $" + precio);
    }

    @Override
    public String toString() {
        return nombre + " (" + (descuento * 100) + "%)";
    }
}