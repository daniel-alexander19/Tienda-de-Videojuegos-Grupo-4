package com.tiendavideojuegos.modelo;

import com.tiendavideojuegos.interfaces.Pago;

import java.util.Scanner;

public class Nequi implements Pago {

    @Override
    public void procesarPago(double monto) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n📱 PAGO NEQUI");

        System.out.print("Número celular: ");
        String celular = sc.next();

        System.out.print("Clave Nequi: ");
        String clave = sc.next();

        System.out.println("🔐 Validando cuenta...");
        System.out.println("📲 Celular: " + celular);
        System.out.println("💰 Pago aprobado de $" + monto);
    }
}