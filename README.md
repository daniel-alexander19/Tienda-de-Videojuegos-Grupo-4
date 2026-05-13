# 🎮 Sistema de Tienda de Videojuegos

## 👥 Integrantes
Nombres: - Daniel Alexander Pareja Montero - dapareja-2025a@corhuila.edu.co
         - Alex Stiven Uribe Rey - asuribe-2025a@corhuila.edu.co

## 📖 Descripción
Este proyecto representa el diseño de un sistema de tienda de videojuegos mediante un diagrama de clases UML. El modelo permite gestionar usuarios, productos, plataformas, carrito de compras y métodos de pago, aplicando principios de programación orientada a objetos.

---

## 🎯 Objetivo
Diseñar un modelo estructurado que permita organizar y gestionar la información de una tienda de videojuegos, facilitando la representación de productos, usuarios y procesos de compra.

---

## 🧱 Estructura del Sistema
src/
└── com/
    └── tiendavideojuegos/
        ├── interfaces/
        │   ├── Mostrable.java
        │   ├── Pago.java
        │   └── Validable.java
        ├── modelo/
        │   ├── Producto.java  (Clase abstracta)
        │   ├── Carrito.java
        │   ├── Categoria.java
        │   ├── Entrega.java
        │   ├── Envio.java
        │   ├── Membresia.java
        │   ├── Nequi.java
        │   ├── Paypal.java
        │   ├── Plataforma.java
        │   ├── PlataformaJuegos.java
        │   ├── PSE.java
        │   ├── RecogeEnTienda.java
        │   ├── Tarjeta.java
        │   ├── Usuario.java
        │   ├── VideoJuegoDigital.java
        │   └── VideoJuegoFisico.java
        ├── servicio/
        │   ├── GeneradorFactura.java
        │   ├── GestorCarrito.java
        │   ├── GestorEntregas.java
        │   ├── GestorPagos.java
        │   ├── GestorProductos.java
        │   └── GestorUsuarios.java
        └── Main.java

### 🔹 Usuario
Representa al cliente del sistema.

Atributos:
- id: int  
- nombre: String  

Métodos:
- getContraseña(): int  

---

### 🔹 Carrito
Representa el conjunto de productos que el usuario desea comprar.

Atributos:
- idJuegos: int  
- fecha: Date  
- nombre: String  
- cantidadJuegos: int  
- valorUnitario: double  
- subtotal: double  

---

### 🔹 Producto
Clase base del sistema que representa los productos disponibles.

---

### 🔹 Plataforma
Representa el tipo de plataforma donde se puede jugar un videojuego (PC, consola, etc.).

---

### 🔹 Pago
Gestiona la información del pago.

Atributos:
- idPago: int  
- valorTotal: double  
- estadoPago: String  

---

### 🔹 PayPal
Clase que representa un método de pago específico.

Atributos:
- correo: String  
- idTransaccion: int  

Métodos:
- getCorreo(): String  

---

## 🔗 Relaciones y Justificación

- Usuario → Carrito (1:1)  
  Cada usuario tiene un carrito asociado para gestionar sus compras.

- Carrito → Producto (1:N)  
  Un carrito puede contener varios productos.

- Producto → Plataforma (1:N desde Producto, 0:N desde Plataforma)  
  Un producto pertenece a una sola plataforma, mientras que una plataforma puede tener cero o muchos productos.  
  Esto permite que existan plataformas registradas aunque no tengan productos asociados aún.

- Carrito → Pago (1:1)  
  Cada carrito genera un único proceso de pago.

- Pago → PayPal (Herencia o relación específica)  
  Se modela PayPal como una especialización del pago o método adicional, permitiendo representar distintos métodos de transacción.

---
## 🔗 Tipos de Relaciones Utilizadas

### 🔹 Asociación
La asociación se utiliza cuando dos clases se relacionan sin depender completamente una de la otra. En el modelo se presenta en las relaciones entre Usuario y Carrito, ya que un usuario tiene un carrito asociado; entre Carrito y Producto, debido a que un carrito puede contener varios productos; y entre Producto y Plataforma, donde cada producto pertenece a una plataforma y una plataforma puede tener varios productos.

---

### 🔹 Composición
La composición se presenta cuando una clase depende totalmente de otra para existir. En este caso se evidencia en la relación entre Carrito y Pago, ya que el pago se genera a partir del carrito y no tiene sentido sin este. También puede interpretarse en la relación entre Carrito y sus elementos internos, ya que los productos dentro del carrito dependen de este contexto de compra.

---

### 🔹 Herencia
La herencia se utiliza para representar especialización entre clases. En el modelo se aplica entre Producto y sus subclases VideoJuegoDigital y VideoJuegoFisico, permitiendo reutilizar atributos comunes. También se presenta en la clase Pago, la cual tiene como subclases a PayPal, Tarjeta, PSE y Nequi, representando diferentes métodos de pago. Finalmente, se observa en la clase Entrega, que se especializa en Envio y RecogeEnTienda, permitiendo diferenciar los tipos de entrega disponibles en el sistema.

---

## 🧠 Conceptos Aplicados

- Programación Orientada a Objetos (POO)  
- Relaciones 1 a 1 y 1 a muchos  
- Abstracción  
- Modelado UML  

---

## 🖼️ Diagrama del Sistema

El diagrama fue elaborado en draw.io (diagrams.net).  
<img width="1300" height="1400" alt="Tienda de VideoJuegos drawio (2)" src="https://github.com/user-attachments/assets/9387fb8a-a1dc-49d1-be45-018fe4479627" />

---

## ⚙️ Aplicación de Principios SOLID

### 🔴 S — Single Responsibility Principle
**¿Dónde se aplica?
En el paquete servicio, donde cada clase cumple una función específica dentro del sistema.
- 'GestorProductos': administra el catálogo de videojuegos.
- 'GestorUsuarios': gestiona el registro e inicio de sesión.
- 'GestorPagos': procesa los métodos de pago.
- 'GestorCarrito': administra los productos agregados al carrito.
- 'GestorEntregas': procesa las entregas.

**Código:**
```java
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
    public Usuario iniciarSesion(String email, String contraseña) {...}
```
### 🟠 O — Open/Closed Principle

***¿Dónde se aplica?
En el sistema de pagos, ya que el sistema está abierto para agregar nuevos métodos de pago sin modificar el código existente.
- Pago actúa como abstracción.
- Nequi, PayPal, Tarjeta y PSE extienden el comportamiento.

**Código:**
````
public class Nequi implements Pago {

    @Override
    public void procesarPago(double monto) {...}
}
````

### 🟡 L — Liskov Substitution Principle

***¿Dónde se aplica?
Las clases hijas pueden reemplazar a su clase padre sin afectar el funcionamiento del sistema.
- VideoJuegoDigital
- VideoJuegoFisico

**Código:**
````

````
## ⚙️ Tecnologías Utilizadas

- Draw.io (diagrams.net)  
- UML  

---

*Proyecto de Programación y Diseño Orientado a Objetos — Corhuila 2026*
