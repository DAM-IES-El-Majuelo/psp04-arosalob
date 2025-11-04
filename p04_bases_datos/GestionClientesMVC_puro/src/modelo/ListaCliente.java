package modelo;

import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ListaCliente {
    private final List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(String nombre, double saldo) {
        clientes.add(new Cliente(nombre, saldo));
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
