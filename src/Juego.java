public class Juego {
    private String codigo;
    private String nombre;
    private double precioPorDia;
    private boolean disponible;

    public Juego(String codigo, String nombre, double precioPorDia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioPorDia = precioPorDia;
        this.disponible = true;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecioPorDia() { return precioPorDia; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
