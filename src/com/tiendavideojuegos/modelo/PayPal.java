package com.tiendavideojuegos.modelo;

import com.tiendavideojuegos.interfaces.Pago;

import java.util.Scanner;

public class PayPal implements Pago {

    @Override
    public void procesarPago(double monto) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n🌐 PAYPAL");

        System.out.print("Correo PayPal: ");
        String correo = sc.next();

        System.out.print("Contraseña: ");
        String pass = sc.next();

        System.out.println("🔐 Autenticando...");
        System.out.println("💰 Pago aprobado de $" + monto);
    }
}