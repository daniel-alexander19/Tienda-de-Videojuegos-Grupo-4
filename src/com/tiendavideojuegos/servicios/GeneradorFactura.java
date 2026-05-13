package com.tiendavideojuegos.servicios;

public class GeneradorFactura {

    public void generar(double total) {
        System.out.println("\n🧾 ===== FACTURA =====");
        System.out.println("Total compra: $" + total);
        System.out.println("Gracias por tu compra 🎮");
        System.out.println("======================");
    }
}