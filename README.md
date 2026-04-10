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
Se recomienda adjuntar la imagen exportada del diagrama para una mejor comprensión visual del sistema.

---

## ⚙️ Tecnologías Utilizadas

- Draw.io (diagrams.net)  
- UML  

---

*Proyecto de Programación y Diseño Orientado a Objetos — Corhuila 2026*
