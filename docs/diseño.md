# Diseño - Cyber-Rent PS2

En este archivo está el plano del programa: qué clases tiene, cómo funciona el menú y dónde se usan las excepciones.

## 1. Clases

```mermaid
classDiagram
    class Juego {
        String codigo
        String nombre
        double precioPorDia
        boolean disponible
        setDisponible()
    }
    class Cliente {
        String nombre
        String dni
    }
    class Alquiler {
        Juego juego
        Cliente cliente
        int dias
        LocalDateTime fechaRetiro
        calcularPrecio()
    }
    class CyberRent {
        ArrayList~Juego~ juegos
        ArrayList~Alquiler~ alquileres
        altaJuego()
        altaCliente()
        mostrarJuegos()
        registrarReserva()
        cobrar()
        devolver()
        buscarJuego()
    }
    class Main {
        menú con do-while
        Scanner
        try / catch / finally
    }
    Alquiler --> Juego
    Alquiler --> Cliente
    CyberRent --> Juego
    CyberRent --> Alquiler
    Main --> CyberRent

      
    

       
  
