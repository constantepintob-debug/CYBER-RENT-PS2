Diseño de Arquitectura del Menú y Consola - Cyber-Rent PS2

### 1. Estructura de Ejecución (Main.java)

El sistema se ejecuta a través de un bucle interactivo ( do-while ) controlado por una variable numérica de opción. Utiliza la clase `Scanner` para la captura de entradas por consola y se comunica directamente con la clase gestora `CyberRent`.

La validación no se realiza con expresiones lógicas en el `Main`, sino mediante el manejo de excepciones con bloques `try-catch`. Cada operación puede lanzar una excepción personalizada que es capturada en el menú y mostrada por pantalla sin detener el programa.

### 2. Opciones del Menú Principal

El menú despliega 7 opciones operativas:

1. Registrar consola: Pide código, nombre, ubicación y estado inicial (LIBRE). Invoca el método `alta()` de la clase `CyberRent`. Si el código ya existe, lanza `ConsolaDuplicadaException`.

2. Iniciar alquiler: Solicita el código de la consola, DNI del cliente, nombre y apellido del cliente, el juego, el día y la hora de retiro y la cantidad de días de alquiler. Valida que el cliente exista (buscado por DNI). Invoca el método iniciarAlquiler(). Si la consola no existe, lanza ConsolaNoEncontradaException. Si está OCUPADA, lanza ConsolaOcupadaException. Si el DNI no existe, lanza ClienteNoEncontradoException.

3. Finalizar alquiler y cobrar: Solicita el código de la consola y verifica la fecha de devolución. Calcula el costo total en base a la cantidad de días alquilados (costo por día). Invoca el método cobrar(). Si está LIBRE, lanza ConsolaLibreException. Si los días son 0 o negativos, lanza TiempoInvalidoException. Muestra ticket con DNI, nombre del cliente, día/hora de retiro y total a cobrar.

4. Consultar consola: Busca la consola por su código en la lista y muestra sus detalles completos por pantalla, incluyendo si está alquilada y a qué cliente (DNI y nombre) y día/hora de retiro. Si no se encuentra, lanza ConsolaNoEncontradaException.

5. Registrar cliente / juego: Da de alta un cliente solicitando DNI, nombre y apellido o un juego utilizando su código identificador. Si el código o el DNI ya existe, lanza CodigoDuplicadoException.

6. Listar consolas: Despliega por consola el estado completo del ciber organizado por consola, detallando para las ocupadas: DNI, nombre del cliente, día y hora de retiro y días de alquiler. Si no hay consolas registradas, lanza SinConsolasException.

7. Salir: Cierra el flujo de ejecución y finaliza el programa.
