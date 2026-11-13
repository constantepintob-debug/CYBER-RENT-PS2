# Diseño - Cyber-Rent PS2

En este archivo está el plano del programa: qué clases tiene, cómo funciona el menú y dónde se usan las excepciones.

## 1. Estructura de Ejecución (Main.java)
 El sistema se ejecuta a través de un bucle interactivo ( do-while ) controlado por una variable numérica de opción. Utiliza la clase Scanner para la captura de entradas por consola y se comunica directamente con la clase gestora CyberRent.
La validación no se realiza con expresiones lógicas en el Main, sino mediante el manejo de excepciones con bloques try-catch. Cada operación puede lanzar una excepción personalizada que es capturada en el menú y mostrada por pantalla sin detener el programa.

## 2. Cómo funciona el menú (Main.java)
El menú se repite con un do-while hasta que el empleado elige salir. Para leer lo que escribe usamos Scanner.En el Main no revisamos los datos con if: cada opción llama a un método de CyberRent dentro de un try. Si ese método arroja una excepción, la atendemos en el catch, mostramos el mensaje y el menú sigue funcionando. En el finally mostramos "Operación finalizada", haya salido bien o mal.

## 3. Opciones del Menú 
El menú desplegable tiene 5 opciones operativas:

*Mostrar juegos (R1): Despliega por pantalla todos los juegos registrados indicando si están LIBRES o ALQUILADOS. Muestra código, nombre y si está alquilado, DNI, nombre del cliente y fecha de retiro. Si no hay juegos, lanza SinJuegosException.

*Registrar reserva (R2 y R4): Solicita nombre del cliente, DNI, código del juego, cantidad de días y fecha y hora de retiro. Valida que el DNI tenga 7 u 8 números sin letras. Invoca registrarReserva() / iniciarAlquiler(). Si el DNI es inválido lanza DniInvalidoException. Si el juego no existe JuegoNoEncontradoException. Si ya está alquilado JuegoOcupadoException. Si los días no son 1, 2 o 3 lanza DuracionInvalidaException. Si la fecha ya pasó lanza FechaInvalidaException. Si es válido, marca el juego como ALQUILADO.

*Calcular precio y cobrar (R3): Solicita el código del juego. Calcula precio total = días * precioPorDia, con la promo de la clase Alquiler (1 día $4.000, 2 días $6.000, 3 días $9.000). Invoca cobrar(). Muestra ticket con DNI, nombre, juego, días, fecha de retiro y total a pagar. Si los días son 0 o negativos, lanza TiempoInvalidoException.

*Devolver juego / Finalizar alquiler (R4): Solicita el código del juego para liberarlo y marcarlo como LIBRE. Si ya estaba LIBRE, lanza JuegoLibreException. Incluye también el alta de juegos y clientes para no perder la función. Los 5 juegos iniciales ya vienen cargados en el constructor de CyberRent con altaJuego().

*Salir (R5): Cierra el flujo de ejecución y finaliza el programa. Todas las excepciones anteriores se capturan con try/catch, se muestra mensaje claro sin que el programa se cierre y vuelve al menú.Si el empleado escribe letras cuando el menú pide un número, Java arroja InputMismatchException. También la atendemos en un catch para que el programa no se corte.

## 4. Dónde se arrojan y dónde se atienden las excepciones.
Como vimos en clase, una excepción se puede atender en el mismo método o arrojarla "hacia arriba" con throws para que la atienda el que llamó al método. Nosotras elegimos arrojarlas hacia arriba:

Los métodos de CyberRent tienen throws en su firma, por ejemplo:
registrarReserva(...) throws DniInvalidoException, JuegoNoEncontradoException, JuegoOcupadoException, DuracionInvalidaException, FechaInvalidaException.

El Main los llama dentro de un try y tiene un catch distinto para cada excepción, así cada error muestra su propio mensaje.Lo elegimos así para que la clase del local se ocupe de las reglas del negocio y el menú se ocupe de hablar con el empleado.

## 5. Excepciones personalizadas
Todas heredan de Exception:

SinJuegosException: Cuando se intenta mostrar juegos y no hay ninguno.

DniInvalidoException: Cuando el DNI no tiene 7 u 8 números o tiene letras.

JuegoNoEncontradoException: Cuando se busca un juego con un código que no existe.

JuegoOcupadoException: Cuando se intenta reservar un juego que ya está ALQUILADO.

JuegoLibreException: Cuando se intenta devolver un juego que ya estaba LIBRE.

DuracionInvalidaException: Cuando los días no son 1, 2 o 3.

FechaInvalidaException: Cuando la fecha de retiro ya pasó.

TiempoInvalidoException: Cuando los días a cobrar son 0 o negativos. 


## 6. Clases
Juego: cada juego del local tiene código, nombre, precio por día y sabe si está LIBRE o ALQUILADO con el atributo disponible.

Cliente: la persona que alquila, con su nombre y DNI. El DNI lo guardamos como String porque no hacemos cuentas con él y necesitamos revisar si tiene letras.

Alquiler: una reserva. Une un juego con un cliente, guarda los días y la fecha y hora de retiro, y calcula el precio (1 día $4.000, 2 días $6.000, 3 días $9.000).

CyberRent: es la clase que maneja el local. Tiene todos los juegos y los alquileres. Revisa los datos de cada reserva y, si algo está mal, arroja una de nuestras excepciones con throw.

Main: el menú que usa el empleado.2. Cómo funciona el menú (Main.java)El menú se repite con un do-while hasta que el empleado elige salir. Para leer lo que escribe usamos Scanner.

En el Main no revisamos los datos con if: cada opción llama a un método de CyberRent dentro de un try. Si ese método arroja una excepción, la atendemos en el catch, mostramos el mensaje y el menú sigue funcionando. En el finally mostramos "Operación finalizada", haya salido bien o mal.
    



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



















      
  
