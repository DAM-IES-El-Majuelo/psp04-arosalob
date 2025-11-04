package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JFramePrincipal extends JFrame {
    private JTextField txtNombre = new JTextField(10);
    private JTextField txtSaldo = new JTextField(10);
    private JButton btnAgregar = new JButton("Agregar");
    private JTextArea areaClientes = new JTextArea(10, 30);

    public JFramePrincipal() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Saldo:"));
        panel.add(txtSaldo);
        panel.add(btnAgregar);
        panel.add(new JScrollPane(areaClientes));

        add(panel);
        setTitle("Gestión Clientes - MVC Puro");
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getNombre() { return txtNombre.getText(); }
    public String getSaldo() { return txtSaldo.getText(); }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtSaldo.setText("");
    }

    public void mostrarClientes(String texto) {
        areaClientes.setText(texto);
    }

    public void addAgregarListener(ActionListener listener) {
        btnAgregar.addActionListener(listener);
    }
}
