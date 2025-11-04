// =====================
// MODELO
// =====================
package modelo;

import java.time.LocalDate;

public class Cliente {

    private String nombre;
    private double peso;
    private LocalDate fechaNacimiento;

    public Cliente(String nombre, double peso, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombre + " - Peso: " + peso + " - Fecha Nac: " + fechaNacimiento;
    }
}
