Diseño de Arquitectura del Menú y Consola - Cyber-Rent PS2

### 1. Estructura de Ejecución (Main.java)

El sistema se ejecuta a través de un bucle interactivo ( do-while ) controlado por una variable numérica de opción. Utiliza la clase `Scanner` para la captura de entradas por consola y se comunica directamente con la clase gestora `CyberRent`.

La validación no se realiza con expresiones lógicas en el `Main`, sino mediante el manejo de excepciones con bloques `try-catch`. Cada operación puede lanzar una excepción personalizada que es capturada en el menú y mostrada por pantalla sin detener el programa.

### 2. Flujo de Opciones del Menú Principal

El menú despliega 7 opciones operativas:

1. Registrar consola: Pide código, nombre, ubicación y estado inicial (LIBRE). Invoca el método `alta()` de la clase `CyberRent`. Si el código ya existe, lanza `ConsolaDuplicadaException`.

2. Iniciar alquiler: Solicita el código de la consola, el cliente y el juego. Invoca el método `iniciarAlquiler()`. Si la consola no existe, lanza `ConsolaNoEncontradaException`. Si está OCUPADA, lanza `ConsolaOcupadaException`.

3. Finalizar alquiler y cobrar: Solicita el código de la consola y los minutos jugados. Invoca el método `cobrar()`. Si la consola está LIBRE, lanza `ConsolaLibreException`. Si los minutos son 0 o negativos, lanza `TiempoInvalidoException`.

4. Consultar consola: Busca la consola por su código en la lista y muestra sus detalles completos por pantalla. Si no se encuentra, lanza `ConsolaNoEncontradaException`.

5. Registrar cliente / juego: Da de alta un cliente o un juego utilizando su código identificador. Si el código ya existe, lanza `CodigoDuplicadoException`.

6. Listar consolas: Despliega por consola el estado completo del ciber organizado por consolas. Si no hay consolas registradas, lanza `SinConsolasException`.

7. Salir: Cierra el flujo de ejecución y finaliza el programa.
