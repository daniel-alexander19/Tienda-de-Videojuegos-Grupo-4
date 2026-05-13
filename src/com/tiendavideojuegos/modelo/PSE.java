package com.tiendavideojuegos.modelo;

import com.tiendavideojuegos.interfaces.Pago;

import java.util.Scanner;

public class PSE implements Pago {

    @Override
    public void procesarPago(double monto) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n🏦 PSE");

        System.out.print("Banco: ");
        String banco = sc.next();

        System.out.print("Documento: ");
        String doc = sc.next();

        System.out.println("🔐 Conectando con banco...");
        System.out.println("🏦 Banco: " + banco);
        System.out.println("💰 Pago aprobado de $" + monto);
    }
}