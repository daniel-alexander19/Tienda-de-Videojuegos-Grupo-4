package com.tiendavideojuegos.servicios;

import com.tiendavideojuegos.interfaces.Pago;

public class GestorPagos {

    public void procesarPago(Pago metodo, double monto) {
        metodo.procesarPago(monto);
    }
}