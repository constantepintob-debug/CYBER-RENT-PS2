import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CyberRent local = new CyberRent();
        int opcion = 0;

        do {
            System.out.println("\n--- CYBER-RENT PS2 ---");
            System.out.println("1. Mostrar juegos");
            System.out.println("2. Registrar reserva");
            System.out.println("3. Cobrar");
            System.out.println("4. Devolver juego");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                if (opcion == 1) {
                    local.mostrarJuegos();
                } else if (opcion == 2) {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Codigo del juego (G1 a G5): ");
                    String codigo = sc.nextLine();
                    System.out.print("Dias (1, 2 o 3): ");
                    int dias = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha de retiro (aaaa-mm-dd): ");
                    String fecha = sc.nextLine();
                    System.out.print("Hora de retiro: ");
                    String hora = sc.nextLine();
                    Alquiler alquiler = local.registrarReserva(nombre, dni, codigo, dias, fecha, hora);
                    System.out.println("Reserva hecha. Total: $" + alquiler.calcularPrecio());
                } else if (opcion == 3) {
                    System.out.print("Codigo del juego: ");
                    local.cobrar(sc.nextLine());
                } else if (opcion == 4) {
                    System.out.print("Codigo del juego: ");
                    local.devolver(sc.nextLine());
                    System.out.println("Juego devuelto");
                } else if (opcion == 5) {
                    System.out.println("Chau!");
                } else {
                    System.out.println("Esa opcion no existe");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: tenes que escribir un numero");
                sc.nextLine();
            } catch (DniInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (JuegoNoEncontradoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (JuegoOcupadoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (DuracionInvalidaException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (FechaInvalidaException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (JuegoLibreException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (SinJuegosException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (TiempoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Operacion finalizada");
            }
        } while (opcion != 5);

        sc.close();
    }
}
