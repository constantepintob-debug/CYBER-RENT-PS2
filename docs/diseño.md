Diseño - Cyber-Rent PS2
En este archivo está el plano del programa: qué clases tiene, cómo funciona el menú y dónde se usan las excepciones.
1. ClasesmermaidclassDiagram
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
        mostrarJuegos()
        registrarReserva()
        cobrar()
        devolver()
        altaJuego()
        altaCliente()
    }
    class Main {
        menu()
    }
    Alquiler --> Juego
    Alquiler --> Cliente
    CyberRent --> Juego
    CyberRent --> Alquiler
    Main --> CyberRent
   Juego: cada juego del local. Tiene codigo, nombre, precio por dia y sabe si esta LIBRE o ALQUILADO con el atributo disponible.Cliente: la persona que alquila, con su nombre y DNI. El DNI lo guardamos como String porque no hacemos cuentas con el y necesitamos revisar si tiene letras.Alquiler: una reserva. Une un juego con un cliente, guarda los dias y la fecha y hora de retiro, y calcula el precio (1 dia $4.000, 2 dias $6.000, 3 dias $9.000).CyberRent: es la clase que maneja el local. Tiene todos los juegos y los alquileres. Revisa los datos de cada reserva y, si algo esta mal, arroja una de nuestras excepciones con throw.Main: el menu que usa el empleado.2. Como funciona el menu (Main.java)
El menu se repite con un do-while hasta que el empleado elige salir. Para leer lo que escribe usamos Scanner.
En el Main no revisamos los datos con if: cada opcion llama a un metodo de CyberRent dentro de un try. Si ese metodo arroja una excepcion, la atendemos en el catch, mostramos el mensaje y el menu sigue funcionando. En el finally mostramos "Operacion finalizada", haya salido bien o mal.
1. Estructura de Ejecucion (Main.java)
El sistema se ejecuta a traves de un bucle interactivo ( do-while ) controlado por una variable numerica de opcion. Utiliza la clase Scanner para la captura de entradas por consola y se comunica directamente con la clase gestora CyberRent.
La validacion no se realiza con expresiones logicas en el Main, sino mediante el manejo de excepciones con bloques try-catch. Cada operacion puede lanzar una excepcion personalizada que es capturada en el menu y mostrada por pantalla sin detener el programa.
2. Opciones del Menu Principal
El menu desplegable tiene 5 opciones operativas:
Mostrar juegos (R1): Despliega por pantalla todos los juegos registrados indicando si estan LIBRES o ALQUILADOS. Muestra codigo, nombre y si esta alquilado, DNI, nombre del cliente y fecha de retiro. Si no hay juegos, lanza SinJuegosException.Registrar reserva (R2 y R4): Solicita nombre del cliente, DNI, codigo del juego, cantidad de dias y fecha y hora de retiro. Valida que el DNI tenga 7 u 8 numeros sin letras. Invoca registrarReserva() / iniciarAlquiler(). Si el DNI es invalido lanza DniInvalidoException. Si el juego no existe JuegoNoEncontradoException. Si ya esta alquilado JuegoOcupadoException. Si los dias no son 1, 2 o 3 lanza DuracionInvalidaException. Si la fecha ya paso lanza FechaInvalidaException. Si es valido, marca el juego como ALQUILADO.Calcular precio y cobrar (R3): Solicita el codigo del juego. Calcula precio total = dias * precioPorDia, con la promo de la clase Alquiler (1 dia $4.000, 2 dias $6.000, 3 dias $9.000). Invoca cobrar(). Muestra ticket con DNI, nombre, juego, dias, fecha de retiro y total a pagar. Si los dias son 0 o negativos, lanza TiempoInvalidoException.Devolver juego / Finalizar alquiler (R4): Solicita el codigo del juego para liberarlo y marcarlo como LIBRE. Si ya estaba LIBRE, lanza JuegoLibreException. Incluye tambien el alta de juegos y clientes para no perder la funcion. Los 5 juegos iniciales ya vienen cargados en el constructor de CyberRent con altaJuego().Salir (R5): Cierra el flujo de ejecucion y finaliza el programa. Todas las excepciones anteriores se capturan con try/catch, se muestra mensaje claro sin que el programa se cierre y vuelve al menu.Si el empleado escribe letras cuando el menu pide un numero, Java arroja InputMismatchException. Tambien la atendemos en un catch para que el programa no se corte.
3. Donde se arrojan y donde se atienden las excepciones
Como vimos en clase, una excepcion se puede atender en el mismo metodo o arrojarla "hacia arriba" con throws para que la atienda el que llamo al metodo. Nosotras elegimos arrojarlas hacia arriba:
Los metodos de CyberRent tienen throws en su firma, por ejemplo:
registrarReserva(...) throws DniInvalidoException, JuegoNoEncontradoException, JuegoOcupadoException, DuracionInvalidaException, FechaInvalidaExceptionEl Main los llama dentro de un try y tiene un catch distinto para cada excepcion, asi cada error muestra su propio mensaje.Lo elegimos asi para que la clase del local se ocupe de las reglas del negocio y el menu se ocupe de hablar con el empleado.
3.1 Excepciones personalizadas
Todas heredan de Exception:
SinJuegosException: Cuando se intenta mostrar juegos y no hay ninguno.
DniInvalidoException: Cuando el DNI no tiene 7 u 8 numeros o tiene letras.
JuegoNoEncontradoException: Cuando se busca un juego con un codigo que no existe.
JuegoOcupadoException: Cuando se intenta reservar un juego que ya esta ALQUILADO.
JuegoLibreException: Cuando se intenta devolver un juego que ya estaba LIBRE.
DuracionInvalidaException: Cuando los dias no son 1, 2 o 3.
FechaInvalidaException: Cuando la fecha de retiro ya paso.T
iempoInvalidoException: Cuando los dias a cobrar son 0 o negativos.
