package com.tiendavideojuegos.modelo;

public class RecogeEnTienda implements Entrega {

    @Override
    public void procesarEntrega() {
        System.out.println("🏬 Recoger en tienda seleccionado...");
        System.out.println("Puedes reclamar tu pedido en el punto físico.");
    }
}