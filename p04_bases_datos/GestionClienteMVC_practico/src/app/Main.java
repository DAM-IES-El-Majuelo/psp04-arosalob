// =====================
// MAIN
// =====================
package app;

import controlador.Controlador;
import modelo.*;
import vista.VentanaPrincipal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ListaClientes lista = new ListaClientes();
        lista.add(new Cliente("Ana", 60, LocalDate.of(1990, 1, 1)));
        lista.add(new Cliente("Luis", 75, LocalDate.of(1985, 6, 15)));

        VentanaPrincipal vista = new VentanaPrincipal();
        Controlador c = new Controlador(lista, vista);
        c.iniciar();
    }
}
