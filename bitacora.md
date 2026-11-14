# Bitácora - CYBER-RENT-PS2

## Día 1 (09/11/2026)
- Qué hicimos: Lautaro anotó en la planilla el tema (Clase 9: Excepciones) y la idea del local de alquiler de juegos de PS2.
- Quién hizo qué: Lautaro Céspedes.
- Qué nos trabó: no hubo comunicación en el grupo para decidir el tema entre todos.
- Qué sigue: organizarnos y armar el tablero.
- Captura del tablero: todavía no había tablero.

## Día 2 (10/11/2026)
- Qué hicimos: Lautaro subió a su repositorio la página HTML del local (catálogo de 5 juegos y formulario de reserva).
- Quién hizo qué: Lautaro Céspedes.
- Qué nos trabó: no nos agregó a su repositorio y no tuvimos respuesta de él ni de Santiago Centeno. Ludmila intentó subir sus avances al repositorio del grupo pero no tenía permiso (hay captura).
- Qué sigue: avisar a la profesora y ver cómo seguir.
- Captura del tablero: todavía no había tablero.

## Día 3 (11/11/2026)
- Qué hicimos: le avisamos a la profesora la situación del grupo. Decidimos seguir con el tema y el negocio que ya estaban anotados (Cyber-Rent PS2). Creamos este repositorio, armamos el tablero en Trello con las columnas Por hacer, En curso y Hecho, y escribimos el README.
- Quién hizo qué:
  - Ludmila Castro: le informó a la profesora la situación del grupo, intentó contactar a los integrantes, armó el tablero de Trello con todas las tarjetas, redactó el README, el análisis de requerimientos, los casos de prueba y ordenó esta bitácora con el formato del Anexo B.
  - Brisa Constante: creó el repositorio en GitHub, subió el README y organizó los archivos.
- Qué nos trabó: no pudimos contactar a Centeno ni a Céspedes, y no teníamos acceso al repositorio de Céspedes.
- Qué sigue (12/11): programar las clases Juego, Cliente y Alquiler, crear las excepciones en Java y sumar la página HTML del local (hecha por Lautaro Céspedes, se cita en el README).

- 
## Día 4 (12/11/2026)
- Qué hicimos: hoy subimos las primeras 4 excepciones en /src, el análisis con las historias de usuario en /docs, los casos de prueba en /pruebas y la carpeta kanban con la captura del día 3. También armamos el diseño del programa: cómo va a funcionar el menú, el diagrama de clases y qué excepciones vamos a usar. Brisa además escribió qué hace cada método. La profe nos respondió que sigamos avanzando mientras intenta hablar con Lautaro y Santiago.
- Quién hizo qué:
  - Ludmila: hice las excepciones DniInvalidoException, JuegoNoDisponibleException, FechaInvalidaException y DuracionInvalidaException, el análisis, los casos de prueba y la carpeta kanban. También revisé el diseño para que coincida con el alquiler de juegos.
  - Brisa: hizo el diseño del menú y de la clase CyberRent, el diagrama de clases, la lista de las 8 excepciones y el archivo de métodos obligatorios.
- Qué nos trabó: me costó subir archivos dentro de carpetas en GitHub porque se me creaba una carpeta de más. Lo resolví armando las carpetas en la compu antes de subirlas. Además, al principio el diseño quedó como si alquiláramos consolas por minutos en vez de juegos por días, y lo fuimos corrigiendo entre las dos hasta que quedó bien.
- Qué sigue: crear las 4 excepciones que faltan (SinJuegosException, JuegoNoEncontradoException, JuegoLibreException y TiempoInvalidoException) y cambiarle el nombre a JuegoNoDisponibleException por JuegoOcupadoException, así coincide con el diseño. Después empezamos a programar las clases.
- Captura del tablero: kanban/dia-4.png


## Día 5 (13/11/2026)
- Qué hicimos: completamos el código del programa. Agregamos las 4 excepciones que faltaban y le cambiamos el nombre a JuegoNoDisponibleException por JuegoOcupadoException, así coincide con el diseño. También hicimos las clases Juego, Cliente y Alquiler, la clase CyberRent (que revisa los datos y lanza las excepciones) y el Main con el menú, el try/catch y el finally.
- Quién hizo qué:
  - Brisa: hizo las excepciones SinJuegosException, JuegoNoEncontradoException, JuegoLibreException y TiempoInvalidoException, el cambio de nombre a JuegoOcupadoException y las clases Juego, Cliente y Alquiler.
  - Ludmila: hice la clase CyberRent con los métodos para mostrar juegos, reservar, cobrar y devolver, y el Main con el menú de 5 opciones y un catch para cada excepción.
- Qué nos trabó: entender por qué se necesitaban más excepciones. Al final nos dimos cuenta de que las primeras 4 eran solo para reservar y que las otras opciones del menú (mostrar, cobrar y devolver) también podían fallar. También nos costó organizarnos con los horarios porque las dos trabajamos.
- Qué sigue: instalar Eclipse, ejecutar el programa y probar todos los casos para completar los resultados en la tabla de pruebas. Después, sacar capturas del programa funcionando y completar el README.
- Captura del tablero: kanban/dia-5.png
