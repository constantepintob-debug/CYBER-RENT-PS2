
# Casos de prueba - Cyber-Rent PS2

Estas son las pruebas que vamos a hacer cuando el programa esté terminado. Probamos casos que deberían andar bien y casos con datos mal cargados, para ver que salten nuestras excepciones.

| N° | Qué pruebo | Datos de entrada | Resultado esperado | Resultado obtenido | ¿Pasó? |
|---|---|---|---|---|---|
| 1 | Una reserva bien hecha | DNI 35123456, GTA, 2 días, fecha de mañana | Se guarda la reserva y el total es $6.000 | | |
| 2 | DNI con letras | "35abc456" | Avisa "DNI inválido" | | |
| 3 | DNI muy corto | "123" | Avisa "DNI inválido" | | |
| 4 | Juego ya alquilado | Reservar GTA dos veces | Avisa "El juego no está disponible" | | |
| 5 | Fecha que ya pasó | 01/01/2020 | Avisa "La fecha no puede ser anterior a hoy" | | |
| 6 | Días que no existen | 5 días | Avisa "La duración debe ser 1, 2 o 3 días" | | |
| 7 | Letras en el menú | Escribir "abc" | Avisa "Ingresá un número" y el programa sigue | | |
| 8 | Que el finally siempre aparezca | Cualquier reserva, salga bien o mal | Siempre se muestra "Operación finalizada" | | |

Las columnas "Resultado obtenido" y "¿Pasó?" las completamos cuando probemos el programa.
