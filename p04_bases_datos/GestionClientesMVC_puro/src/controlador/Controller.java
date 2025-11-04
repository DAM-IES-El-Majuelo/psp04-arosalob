package controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private modelo.ListaCliente model;
    private vista.JFramePrincipal view;

    public Controller(modelo.ListaCliente model, vista.JFramePrincipal view) {
        this.model = model;
        this.view = view;

        this.view.addAgregarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = view.getNombre();
                    double saldo = Double.parseDouble(view.getSaldo());
                    model.agregarCliente(nombre, saldo);
                    actualizarVista();
                    view.limpiarCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }

    private void actualizarVista() {
        StringBuilder sb = new StringBuilder();
        for (modelo.Cliente c : model.getClientes()) {
            sb.append(c.toString()).append("\n");
        }
        view.mostrarClientes(sb.toString());
    }
}
