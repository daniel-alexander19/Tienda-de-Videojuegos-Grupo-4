package com.tiendavideojuegos.modelo;

public class Envio implements Entrega {

    @Override
    public void procesarEntrega() {
        System.out.println("🚚 Envío a domicilio en proceso...");
        System.out.println("El pedido será entregado en la dirección registrada.");
    }
}