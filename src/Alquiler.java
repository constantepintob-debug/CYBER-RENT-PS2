public class Alquiler {
    private Juego juego;
    private Cliente cliente;
    private int dias;
    private String fechaHoraRetiro;

    public Alquiler(Juego juego, Cliente cliente, int dias, String fechaHoraRetiro) {
        this.juego = juego;
        this.cliente = cliente;
        this.dias = dias;
        this.fechaHoraRetiro = fechaHoraRetiro;
    }

    public double calcularPrecio() {
        if (dias == 1) return 4000;
        if (dias == 2) return 6000;
        if (dias == 3) return 9000;
        return 0;
    }

    public Juego getJuego() { return juego; }
    public Cliente getCliente() { return cliente; }
    public int getDias() { return dias; }
    public String getFechaHoraRetiro() { return fechaHoraRetiro; }
}
