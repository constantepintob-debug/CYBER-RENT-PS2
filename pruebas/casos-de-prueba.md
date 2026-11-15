# Casos de prueba - Cyber-Rent PS2

Estas son las pruebas que hicimos ejecutando el programa en Eclipse. Probamos casos que tienen que andar bien y casos con datos mal cargados, para ver que salten nuestras excepciones. Las capturas están en esta misma carpeta.

| N° | Qué pruebo | Datos de entrada | Resultado esperado | Resultado obtenido | ¿Pasó? |
|---|---|---|---|---|---|
| 1 | Una reserva bien hecha | DNI 35123456, G1, 2 días, 2026-11-20 | Se guarda la reserva y el total es $6.000 | Reserva hecha. Total: $6000.0 | Sí |
| 2 | DNI con letras | 35abc456 | Salta DniInvalidoException | Error: El DNI no puede tener letras | Sí |
| 3 | DNI muy corto | 123 | Salta DniInvalidoException | Error: El DNI tiene que tener 7 u 8 numeros | Sí |
| 4 | Juego ya alquilado | Reservar G1 dos veces | Salta JuegoOcupadoException | Error: El juego ya esta alquilado | Sí |
| 5 | Fecha que ya pasó | 2020-01-01 | Salta FechaInvalidaException | Error: La fecha ya paso | Sí |
| 6 | Fecha mal escrita | 15/11/26 | Salta FechaInvalidaException | Error: La fecha tiene que ser asi: aaaa-mm-dd | Sí |
| 7 | Días que no existen | 5 días | Salta DuracionInvalidaException | Error: Solo se puede alquilar por 1, 2 o 3 dias | Sí |
| 8 | Juego que no existe | G9 | Salta JuegoNoEncontradoException | Error: No existe el juego G9 | Sí |
| 9 | Letras en el menú | abc | Avisa y el programa sigue | Error: tenes que escribir un numero | Sí |
| 10 | Cobrar un juego alquilado | Opción 3, G3 | Muestra el ticket con el total | Ticket con cliente, juego, días y Total: $6000.0 | Sí |
| 11 | Cobrar un juego libre | Opción 3, G2 | Salta JuegoLibreException | Error: Ese juego no esta alquilado | Sí |
| 12 | Devolver un juego | Opción 4, G3 | El juego vuelve a estar libre | Juego devuelto | Sí |
| 13 | Devolver un juego que ya estaba libre | Opción 4, G2 | Salta JuegoLibreException | Error: Ese juego ya estaba libre | Sí |
| 14 | Que el finally siempre aparezca | Todas las pruebas anteriores | Siempre se muestra el mensaje final | Operacion finalizada, en todos los casos | Sí |

Dos excepciones no se pudieron provocar desde el menú: SinJuegosException (el local siempre arranca con 5 juegos cargados) y TiempoInvalidoException (los días ya se revisan al reservar, así que nunca llegan a ser 0). Las dejamos igual porque protegen al programa si más adelante se cambia el código.
