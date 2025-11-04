package modelo;

public class Cliente {
    private String nombre;
    private double saldo;

    public Cliente(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() { return nombre; }
    public double getSaldo() { return saldo; }

    @Override
    public String toString() {
        return nombre + " - Saldo: " + saldo;
    }
}
