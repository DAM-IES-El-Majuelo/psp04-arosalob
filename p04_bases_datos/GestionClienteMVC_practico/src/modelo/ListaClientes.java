// ListaClientes
package modelo;

import java.util.ArrayList;

public class ListaClientes {

    private ArrayList<Cliente> lista = new ArrayList<>();
    private int actual = 0;

    public void add(Cliente c) {
        lista.add(c);
    }

    public Cliente getActual() {
        return lista.isEmpty() ? null : lista.get(actual);
    }

    public Cliente siguiente() {
        if (!lista.isEmpty() && actual < lista.size() - 1) {
            actual++;
        }
        return getActual();
    }

    public Cliente anterior() {
        if (!lista.isEmpty() && actual > 0) {
            actual--;
        }
        return getActual();
    }
}
