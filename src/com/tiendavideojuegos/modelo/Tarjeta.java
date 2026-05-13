package com.tiendavideojuegos.modelo;

import com.tiendavideojuegos.interfaces.Pago;

import java.util.Scanner;

public class Tarjeta implements Pago {

    @Override
    public void procesarPago(double monto) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n💳 PAGO CON TARJETA");

        System.out.print("Número de tarjeta: ");
        String numero = sc.next();

        System.out.print("CVV: ");
        String cvv = sc.next();

        System.out.print("Nombre del titular: ");
        String titular = sc.next();

        System.out.println("\n🔐 Validando tarjeta...");
        System.out.println("Titular: " + titular);
        System.out.println("Tarjeta: **** **** **** " + numero.substring(numero.length() - 4));

        System.out.println("💰 Pago aprobado de $" + monto);
    }
}