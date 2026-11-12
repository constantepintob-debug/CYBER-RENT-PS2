# Diseño - Cyber-Rent PS2

En este archivo está el plano del programa: qué clases tiene, cómo funciona el menú y dónde se usan las excepciones.

## 1. Clases

mermaid
classDiagram
    class Juego {
        String nombre
        boolean disponible
        alquilar()
        devolver()
    }
    class Cliente {
        String nombre
        String dni
    }
    class Alquiler {
        Juego juego
        Cliente cliente
        int dias
        LocalDate fechaRetiro
        calcularPrecio()
    }
    class CyberRent {
        lista de juegos
        lista de alquileres
        mostrarJuegos()
        reservar()
        devolver()
        buscarPorDni()
    }
    class Main {
        menú con do-while
        try / catch / finally
    }
    Alquiler --> Juego
    Alquiler --> Cliente
    CyberRent --> Juego
    CyberRent --> Alquiler
    Main --> CyberRent
      
    

       
  
