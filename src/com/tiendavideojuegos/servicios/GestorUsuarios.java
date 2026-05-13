package com.tiendavideojuegos.servicios;

import com.tiendavideojuegos.modelo.Usuario;

import java.util.ArrayList;

public class GestorUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    // =========================
    // REGISTRAR USUARIO
    // =========================
    public void registrarUsuario(Usuario u) {
        usuarios.add(u);
        System.out.println("✅ Usuario registrado correctamente");
    }

    // =========================
    // INICIAR SESIÓN
    // =========================
    public Usuario iniciarSesion(String email, String contraseña) {

        for (Usuario u : usuarios) {

            if (u.getEmail().equals(email)
                    && u.getContraseña().equals(contraseña)) {

                return u;
            }
        }

        return null;
    }

    // =========================
    // LISTAR USUARIOS (opcional para pruebas)
    // =========================
    public void listarUsuarios() {

        System.out.println("\n👥 USUARIOS REGISTRADOS:");

        for (Usuario u : usuarios) {
            System.out.println("- " + u.getNombre()
                    + " | " + u.getEmail());
        }
    }
}