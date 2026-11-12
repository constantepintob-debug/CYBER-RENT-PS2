# Diseño - Cyber-Rent PS2

En este archivo está el plano del programa: qué clases tiene, cómo funciona el menú y dónde se usan las excepciones.

## 1. Clases

```mermaid
classDiagram
    class Juego {
        String codigo
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
        LocalDateTime fechaRetiro
        calcularPrecio() : int
        cobrar()
    }
    class CyberRent {
        lista de juegos
        lista de alquileres
        lista de clientes
        mostrarJuegos() throws SinJuegosException
        registrarReserva() throws DniInvalidoException, JuegoNoEncontradoException, JuegoOcupadoException
        cobrar() throws TiempoInvalidoException
        devolver() throws JuegoLibreException
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


Juego: cada juego del local. Tiene código, nombre y sabe si está LIBRE o ALQUILADO.
Cliente: la persona que alquila, con su nombre y DNI.
El DNI lo guardamos como String porque no hacemos cuentas con él y necesitamos revisar si tiene letras.
Alquiler: una reserva une un juego con un cliente, guarda los días y la fecha y hora de retiro, y calcula el precio (precio total = días _ precioPorDia).
CyberRent: es la clase que maneja el local. Tiene todos los juegos, clientes y alquileres. Revisa los datos y, si algo está mal, arroja una excepción con throw.
Main: el menú que usa el empleado.

Cómo funciona el menú (Main.java)
El menú se repite con un do-while hasta que el empleado elige salir. Para leer lo que escribe usamos Scanner.
En el Main no revisamos los datos con if: cada opción llama a un método de CyberRent dentro de un try. Si ese método arroja una excepción, la atendemos en el catch, mostramos el mensaje y el menú sigue funcionando. En el finally mostramos "Operación finalizada".
1. Mostrar juegos (R1): Despliega por pantalla todos los juegos registrados indicando si están LIBRES o ALQUILADOS. Muestra código, nombre y si está alquilado, DNI, nombre del cliente y fecha de retiro. Si no hay juegos, lanza SinJuegosException.
2. Registrar reserva (R2 y R4): Solicita nombre del cliente, DNI, código del juego, cantidad de días y fecha y hora de retiro. Valida que el DNI tenga 7 u 8 números sin letras. Invoca registrarReserva() / iniciarAlquiler(). Si el DNI es inválido lanza DniInvalidoException. Si el juego no existe JuegoNoEncontradoException. Si ya está alquilado JuegoOcupadoException. Si es válido, marca el juego como ALQUILADO.
3. Calcular precio y cobrar (R3): Solicita el código del juego. Calcula precio total = días _ precioPorDia. Invoca cobrar(). Muestra ticket con DNI, nombre, juego, días, fecha de retiro y total a pagar. Si los días son 0 o negativos, lanza TiempoInvalidoException.
4. Devolver juego / Finalizar alquiler (R4): Solicita el código del juego para liberarlo y marcarlo como LIBRE. Si ya estaba LIBRE, lanza JuegoLibreException. Incluye también el alta de juegos y clientes para no perder la función.
5. Salir (R5): Cierra el flujo de ejecución y finaliza el programa. Todas las excepciones anteriores se capturan con try/catch, se muestra mensaje claro sin que el programa se cierre y vuelve al menú.Si el empleado escribe letras cuando el menú pide un número, Java arroja InputMismatchException, también la atendemos en un catch para que el programa no se corte.

Dónde se arrojan y dónde se atienden las excepciones
Los métodos de CyberRent tienen throws en su firma, por ejemplo:
registrarReserva(...) throws DniInvalidoException, JuegoNoEncontradoException, JuegoOcupadoException
El Main los llama dentro de un try y tiene un catch distinto para cada excepción, así cada error muestra su propio mensaje.
Lo elegimos así para que la clase del local se ocupe de las reglas del negocio y el menú se ocupe de hablar con el empleado.



