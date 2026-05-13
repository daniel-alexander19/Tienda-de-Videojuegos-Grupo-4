package com.tiendavideojuegos.modelo;

public class Usuario {

    private int id;
    private String nombre;
    private String email;
    private String contraseña;
    private Membresia membresia;

    public Usuario(int id, String nombre, String email,
                   String contraseña, Membresia membresia) {

        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.membresia = membresia;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}