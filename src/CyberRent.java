import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CyberRent {
    private ArrayList<Juego> juegos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Alquiler> alquileres = new ArrayList<>();

   
    public CyberRent() {
        altaJuego("G1", "GTA San Andreas", 4000);
        altaJuego("G2", "God of War II", 4000);
        altaJuego("G3", "Resident Evil 4", 4000);
        altaJuego("G4", "DBZ Budokai Tenkaichi 3", 4000);
        altaJuego("G5", "Shadow of the Colossus", 4000);
    }

    public void altaJuego(String codigo, String nombre, double precio) {
        juegos.add(new Juego(codigo, nombre, precio));
    }

    public Cliente altaCliente(String nombre, String dni) {
        Cliente cliente = new Cliente(nombre, dni);
        clientes.add(cliente);
        return cliente;
    }

    public Juego buscarJuego(String codigo) throws JuegoNoEncontradoException {
        for (Juego juego : juegos) {
            if (juego.getCodigo().equals(codigo)) {
                return juego;
            }
        }
        throw new JuegoNoEncontradoException("No existe el juego " + codigo);
    }

    public void mostrarJuegos() throws SinJuegosException {
        if (juegos.size() == 0) {
            throw new SinJuegosException("No hay juegos cargados");
        }
        for (Juego juego : juegos) {
            if (juego.isDisponible()) {
                System.out.println(juego.getCodigo() + " " + juego.getNombre() + " - LIBRE");
            } else {
                System.out.println(juego.getCodigo() + " " + juego.getNombre() + " - ALQUILADO");
            }
        }
    }

    public Alquiler registrarReserva(String nombre, String dni, String codigo, int dias, String fecha, String hora)
            throws DniInvalidoException, JuegoNoEncontradoException, JuegoOcupadoException,
            DuracionInvalidaException, FechaInvalidaException {

      
        validarDni(dni);
        Juego juego = buscarJuego(codigo);
        if (!juego.isDisponible()) {
            throw new JuegoOcupadoException("El juego ya esta alquilado");
        }
        if (dias < 1 || dias > 3) {
            throw new DuracionInvalidaException("Solo se puede alquilar por 1, 2 o 3 dias");
        }
        validarFecha(fecha);

        // si llego hasta aca esta todo bien
        Cliente cliente = altaCliente(nombre, dni);
        Alquiler alquiler = new Alquiler(juego, cliente, dias, fecha + " " + hora);
        alquileres.add(alquiler);
        juego.setDisponible(false);
        return alquiler;
    }

    public void cobrar(String codigo) throws JuegoNoEncontradoException, JuegoLibreException, TiempoInvalidoException {
        Juego juego = buscarJuego(codigo);
        Alquiler alquiler = buscarAlquiler(juego);
        if (alquiler == null) {
            throw new JuegoLibreException("Ese juego no esta alquilado");
        }
        if (alquiler.getDias() <= 0) {
            throw new TiempoInvalidoException("Los dias no pueden ser 0 o negativos");
        }
        System.out.println("TICKET");
        System.out.println("Cliente: " + alquiler.getCliente().getNombre() + " DNI: " + alquiler.getCliente().getDni());
        System.out.println("Juego: " + juego.getNombre() + " por " + alquiler.getDias() + " dias");
        System.out.println("Retira: " + alquiler.getFechaHoraRetiro());
        System.out.println("Total: $" + alquiler.calcularPrecio());
    }

    public void devolver(String codigo) throws JuegoNoEncontradoException, JuegoLibreException {
        Juego juego = buscarJuego(codigo);
        if (juego.isDisponible()) {
            throw new JuegoLibreException("Ese juego ya estaba libre");
        }
        alquileres.remove(buscarAlquiler(juego));
        juego.setDisponible(true);
    }

    private Alquiler buscarAlquiler(Juego juego) {
        for (Alquiler alquiler : alquileres) {
            if (alquiler.getJuego() == juego) {
                return alquiler;
            }
        }
        return null;
    }

    private void validarDni(String dni) throws DniInvalidoException {
        if (dni.length() < 7 || dni.length() > 8) {
            throw new DniInvalidoException("El DNI tiene que tener 7 u 8 numeros");
        }
        for (int i = 0; i < dni.length(); i++) {
            if (!Character.isDigit(dni.charAt(i))) {
                throw new DniInvalidoException("El DNI no puede tener letras");
            }
        }
    }

    private void validarFecha(String fecha) throws FechaInvalidaException {
        LocalDate dia;
        try {
            dia = LocalDate.parse(fecha);
        } catch (DateTimeParseException e) {
            throw new FechaInvalidaException("La fecha tiene que ser asi: aaaa-mm-dd");
        }
        if (dia.isBefore(LocalDate.now())) {
            throw new FechaInvalidaException("La fecha ya paso");
        }
    }
}
