package com.tiendavideojuegos;

import com.tiendavideojuegos.interfaces.Pago;
import com.tiendavideojuegos.modelo.*;
import com.tiendavideojuegos.servicios.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // =========================
        // SERVICIOS
        // =========================
        GestorProductos gestorProductos = new GestorProductos();
        GestorCarrito gestorCarrito = new GestorCarrito();
        GestorPagos gestorPagos = new GestorPagos();
        GestorEntregas gestorEntregas = new GestorEntregas();
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        GeneradorFactura factura = new GeneradorFactura();

        Usuario usuarioLogueado = null;

        // =========================
        // MEMBRESÍAS
        // =========================
        Membresia basica = new Membresia("Basica", 0.0, 0);
        Membresia clasica = new Membresia("Clasica", 0.05, 5000);
        Membresia premium = new Membresia("Premium", 0.15, 15000);

        // =========================
        // PRODUCTOS
        // =========================
        gestorProductos.agregar(new VideoJuegoDigital(1, "EA FC 26", 250000, 1200, Categoria.DEPORTES));
        gestorProductos.agregar(new VideoJuegoFisico(2, "God of War Ragnarok", 300000, 10, Categoria.ACCION));
        gestorProductos.agregar(new VideoJuegoDigital(3, "Minecraft", 120000, 800, Categoria.AVENTURA));
        gestorProductos.agregar(new VideoJuegoFisico(4, "Elden Ring", 280000, 5, Categoria.RPG));
        gestorProductos.agregar(new VideoJuegoFisico(5, "Call of Duty Modern Warfare", 320000, 8, Categoria.ACCION));
        gestorProductos.agregar(new VideoJuegoFisico(6, "GTA V", 200000, 15, Categoria.ACCION));
        gestorProductos.agregar(new VideoJuegoDigital(7, "Zelda Breath of the Wild", 260000, 15000, Categoria.AVENTURA));
        gestorProductos.agregar(new VideoJuegoDigital(8, "Uncharted 4", 180000, 12000, Categoria.AVENTURA));
        gestorProductos.agregar(new VideoJuegoFisico(9, "The Witcher 3", 220000, 6, Categoria.RPG));
        gestorProductos.agregar(new VideoJuegoFisico(10, "Final Fantasy XVI", 350000, 4, Categoria.RPG));
        gestorProductos.agregar(new VideoJuegoDigital(11, "FIFA 24", 240000, 9000, Categoria.DEPORTES));
        gestorProductos.agregar(new VideoJuegoDigital(12, "NBA 2K24", 230000, 8500, Categoria.DEPORTES));
        gestorProductos.agregar(new VideoJuegoDigital(13, "Age of Empires IV", 190000, 7000, Categoria.ESTRATEGIA));
        gestorProductos.agregar(new VideoJuegoDigital(14, "Civilization VI", 170000, 6500, Categoria.ESTRATEGIA));
        gestorProductos.agregar(new VideoJuegoFisico(15, "Super Mario Odyssey", 210000, 10, Categoria.PLATAFORMAS));
        gestorProductos.agregar(new VideoJuegoFisico(16, "Sonic Frontiers", 160000, 7, Categoria.PLATAFORMAS));

        // =========================
        // MENÚ
        // =========================
        int opcion;

        do {

            System.out.println("\n===== TIENDA VIDEOJUEGOS =====");
            System.out.println("1. Ver productos por categoría");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Agregar al carrito");
            System.out.println("4. Ver carrito");
            System.out.println("5. Comprar");
            System.out.println("6. Cerrar sesión");
            System.out.println("7. Buscar producto por nombre");
            System.out.println("8. Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("\n1.ACCION 2.AVENTURA 3.RPG 4.DEPORTES 5.ESTRATEGIA 6.PLATAFORMAS 7.TODOS");
                    int cat = sc.nextInt();

                    if (cat == 1) gestorProductos.listarPorCategoria(Categoria.ACCION);
                    else if (cat == 2) gestorProductos.listarPorCategoria(Categoria.AVENTURA);
                    else if (cat == 3) gestorProductos.listarPorCategoria(Categoria.RPG);
                    else if (cat == 4) gestorProductos.listarPorCategoria(Categoria.DEPORTES);
                    else if (cat == 5) gestorProductos.listarPorCategoria(Categoria.ESTRATEGIA);
                    else if (cat == 6) gestorProductos.listarPorCategoria(Categoria.PLATAFORMAS);
                    else gestorProductos.listar();

                    break;

                case 2:

                    System.out.print("Nombre: ");
                    String nombre = sc.next();

                    System.out.print("Email: ");
                    String email = sc.next();

                    System.out.print("Password: ");
                    String pass = sc.next();

                    System.out.println("1.Basica 2.Clasica 3.Premium");
                    int tipo = sc.nextInt();

                    Membresia m;

                    if (tipo == 2) m = clasica;
                    else if (tipo == 3) m = premium;
                    else m = basica;

                    Usuario nuevo = new Usuario(0, nombre, email, pass, m);
                    gestorUsuarios.registrarUsuario(nuevo);

                    break;

                case 3:

                    System.out.print("ID producto: ");
                    int id = sc.nextInt();

                    Producto p = gestorProductos.buscarPorId(id);

                    if (p != null) gestorCarrito.agregarProducto(p);
                    else System.out.println("No existe");

                    break;

                case 4:

                    gestorCarrito.mostrarProductos();
                    System.out.println("Total: $" + gestorCarrito.calcularTotal());

                    break;

                case 5:

                    double total = gestorCarrito.calcularTotal();

                    if (total == 0) {
                        System.out.println("Carrito vacío");
                        break;
                    }

                    // LOGIN OBLIGATORIO
                    if (usuarioLogueado == null) {

                        System.out.print("Email: ");
                        String le = sc.next();

                        System.out.print("Pass: ");
                        String lp = sc.next();

                        usuarioLogueado = gestorUsuarios.iniciarSesion(le, lp);

                        if (usuarioLogueado == null) {
                            System.out.println("Login incorrecto");
                            break;
                        }
                    }

                    double desc =
                            total *
                                    usuarioLogueado
                                            .getMembresia()
                                            .getDescuento();

                    double finalTotal = total - desc;

                    System.out.println("Total final: $" + finalTotal);

                    // =========================
                    // MÉTODOS DE PAGO
                    // =========================

                    System.out.println("\nSeleccione método de pago:");
                    System.out.println("1. Nequi");
                    System.out.println("2. Tarjeta");
                    System.out.println("3. PayPal");
                    System.out.println("4. PSE");

                    int opcionPago = sc.nextInt();

                    Pago metodoPago = null;

                    switch (opcionPago) {

                        case 1:
                            metodoPago = new Nequi();
                            break;

                        case 2:
                            metodoPago = new Tarjeta();
                            break;

                        case 3:
                            metodoPago = new PayPal();
                            break;

                        case 4:
                            metodoPago = new PSE();
                            break;

                        default:
                            System.out.println("Método inválido");
                            break;
                    }

                    if (metodoPago != null) {

                        gestorPagos.procesarPago(
                                metodoPago,
                                finalTotal
                        );

                        gestorCarrito.limpiarCarrito();
                    }

                    break;

                case 6:

                    usuarioLogueado = null;
                    System.out.println("Sesión cerrada");

                    break;

                case 7:

                    sc.nextLine(); // limpiar buffer
                    System.out.print("Nombre juego: ");
                    String busqueda = sc.nextLine();

                    gestorProductos.buscarPorNombre(busqueda);

                    break;
                case 8:

                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");

            }


        } while (opcion != 7);
    }
}