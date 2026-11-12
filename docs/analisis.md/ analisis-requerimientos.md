# Análisis - Cyber-Rent PS2

## El negocio
Cyber-Rent PS2 es un local que alquila juegos de PlayStation 2. No vendemos
juegos: los prestamos por 1, 2 o 3 días y después el cliente los devuelve.
Por eso lo más importante para nosotras es saber quién tiene cada juego y
hasta cuándo.

Juegos que tenemos: GTA San Andreas, God of War II, Resident Evil 4,
DBZ Budokai Tenkaichi 3 y Shadow of the Colossus (una copia de cada uno).

## Quiénes usan el sistema
- Cliente: elige el juego y pide la reserva.
- Empleado del local: carga la reserva en el sistema y entrega el juego.

## Cómo es una reserva, paso a paso
1. El cliente dice qué juego quiere.
2. El empleado se fija si ese juego está libre.
3. Se cargan nombre y DNI del cliente.
4. Se elige cuántos días (1, 2 o 3).
5. Se elige el día y la hora para retirarlo.
6. El sistema calcula el precio y guarda la reserva.
7. El juego queda marcado como alquilado hasta que se devuelve.

Si en cualquiera de estos pasos hay un dato mal, el sistema avisa qué pasó
y deja corregirlo, sin cerrarse.

## Reglas del local
- Precios: 1 día $4.000, 2 días $6.000, 3 días $9.000.
- Solo se puede alquilar por 1, 2 o 3 días.
- El DNI tiene que tener 7 u 8 números, sin letras ni puntos.
- No se puede reservar para una fecha que ya pasó.
- Un juego alquilado no se puede volver a reservar hasta que lo devuelvan.

## Historias de usuario
- Como cliente, quiero ver qué juegos están libres, para no pedir uno que ya está alquilado.
- Como empleado, quiero que el sistema me avise si escribo mal un DNI, para no guardar reservas con datos falsos.
- Como empleado, quiero que el sistema calcule solo el precio, para no equivocarme al cobrar.
- Como empleado, quiero que no me deje reservar un juego ocupado, para no prometerle a dos clientes el mismo juego.
- Como dueño del local, quiero que el programa no se cierre cuando alguien carga un dato mal, para no perder las reservas ya hechas.

## Requerimientos
| N° | El sistema tiene que... |
|---|---|
| R1 | Mostrar los juegos y si están libres o alquilados. |
| R2 | Registrar una reserva con nombre, DNI, juego, días y fecha de retiro. |
| R3 | Calcular el precio según los días. |
| R4 | Marcar el juego como alquilado y liberarlo cuando se devuelve. |
| R5 | Avisar con un mensaje claro cuando un dato está mal, sin cerrarse. |

## Errores que puede haber y cómo los manejamos
| Qué pasa | Ejemplo | Excepción |
|---|---|---|
| El DNI tiene letras o no tiene 7 u 8 números | "35abc" o "123" | DniInvalidoException (nuestra) |
| El juego ya está alquilado | Reservar GTA dos veces | JuegoNoDisponibleException (nuestra) |
| La fecha de retiro ya pasó | 01/01/2020 | FechaInvalidaException (nuestra) |
| Los días no son 1, 2 o 3 | 5 días | DuracionInvalidaException (nuestra) |
| Se escribe una letra donde va un número en el menú | "abc" | InputMismatchException (de Java) |

## Por qué usamos excepciones propias
Podríamos controlar todo con if, pero el código queda lleno de condiciones y
mensajes mezclados. Con una excepción para cada error del local, el nombre ya
dice qué salió mal (por ejemplo JuegoNoDisponibleException) y el menú las
atrapa todas con try/catch en un solo lugar. El finally lo usamos para que
siempre se muestre que la operación terminó, haya habido error o no.
