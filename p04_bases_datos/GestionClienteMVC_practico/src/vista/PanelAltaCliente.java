// Panel Alta Cliente
package vista;

import controlador.Controlador;
import javax.swing.*;
import java.time.LocalDate;

public class PanelAltaCliente extends JPanel {

    private JTextField tNombre = new JTextField(10);
    private JTextField tPeso = new JTextField(5);
    private JTextField tFecha = new JTextField(10);
    private Controlador controlador;

    public PanelAltaCliente() {
        add(new JLabel("Nombre:"));
        add(tNombre);
        add(new JLabel("Peso:"));
        add(tPeso);
        add(new JLabel("Fecha (YYYY-MM-DD):"));
        add(tFecha);
        JButton btn = new JButton("Agregar");
        btn.addActionListener(e -> agregar());
        add(btn);
    }

    public void setControlador(Controlador c) {
        this.controlador = c;
    }

    private void agregar() {
        controlador.agregarCliente(
                tNombre.getText(),
                Double.parseDouble(tPeso.getText()),
                LocalDate.parse(tFecha.getText())
        );
        JOptionPane.showMessageDialog(this, "Cliente añadido");
    }
}
