// =====================
// CONTROLADOR
// =====================
package controlador;
import modelo.*;
import vista.*;
import java.time.LocalDate;


public class Controlador {
    private ListaClientes lista;
    private VentanaPrincipal vista;


    public Controlador(ListaClientes lista, VentanaPrincipal vista) {
        this.lista = lista;
        this.vista = vista;
        this.vista.setControlador(this);
    }


    public void iniciar() {
        vista.setVisible(true);
    }


    public Cliente siguienteCliente() { return lista.siguiente(); }
    public Cliente anteriorCliente() { return lista.anterior(); }
    public Cliente getActualCliente() { return lista.getActual(); }


    public void agregarCliente(String nombre, double peso, LocalDate fecha) {
        Cliente c = new Cliente(nombre, peso, fecha);
        lista.add(c);
    }
}