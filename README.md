# CYBER-RENT-PS2

## Integrantes
- Ludmila Castro
- Brisa Constante

## Nombre del programa
CYBER-RENT-PS2

## Descripción del proyecto
  Cyber-Rent PS2 es un local donde se alquilan juegos de PlayStation 2. Tenemos los 5 juegos más jugados de esa época: GTA San Andreas, God of War II, Resident Evil 4, DBZ Budokai Tenkaichi 3 y Shadow of the Colossus. El cliente elige un juego, lo reserva por 1, 2 o 3 días y lo retira en el local mostrando su DNI.
## Problema
Si las reservas se anotan a mano es fácil equivocarse: se puede escribir mal un DNI, reservar un juego que ya está alquilado o dar un turno para un día que ya pasó. Nuestro programa revisa los datos de cada reserva y, si algo está mal, muestra un mensaje explicando el error en vez de cerrarse.
## Solución propuesta
Tema elegido

Clase 9: Excepciones.

Lo elegimos porque en un sistema de reservas el cliente puede cargar muchos datos mal, y justamente las excepciones sirven para manejar esos errores sin que el programa se rompa.

Lo que usamos del tema:

try / catch / finally para atrapar los errores.
Excepciones creadas por nosotras para los errores del negocio: DniInvalidoException, JuegoNoDisponibleException, FechaInvalidaException y DuracionInvalidaException.
throw y throws para lanzar los errores desde los métodos

## Herramientas y tecnologías utilizadas
Java, HTML y CSS, GitHub y Trello


## Enlace del tablero
https://trello.com/b/TyL6jqW1/grupo-3-cyber-rent-ps2

## Instrucciones para ejecutar
(El código todavía está en desarrollo.)

Clonar el repositorio.
Abrir la carpeta src en el IDE.
Ejecutar Main.java.
Funcionalidades
Ver los juegos y si están disponibles.
Reservar un juego.
Calcular el precio según los días: 1 día $4.000, 2 días $6.000, 3 días $9.000.
Avisar cuando un dato está mal

## Estado del proyecto
En desarrollo



