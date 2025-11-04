// Panel Ver Clientes
package vista;
import controlador.Controlador;
import java.awt.GridLayout;
import modelo.Cliente;
import javax.swing.*;


public class PanelVerClientes extends JPanel {
    private JLabel lbl = new JLabel("Sin clientes");
    private Controlador controlador;


    public PanelVerClientes() {
        JButton prev = new JButton("<<");
        JButton next = new JButton(">>");
        prev.addActionListener(e -> mostrar(controlador.anteriorCliente()));
        next.addActionListener(e -> mostrar(controlador.siguienteCliente()));
        
        JPanel paneBotones = new JPanel();
        paneBotones.setLayout(new GridLayout(1, 0));
        paneBotones.add(prev);
        paneBotones.add(next);
        
        JPanel paneFinal = new JPanel();
        paneFinal.setLayout(new GridLayout(0, 1));
        paneFinal.add(lbl);
        paneFinal.add(paneBotones);
        this.add(paneFinal);
        
    }


    public void setControlador(Controlador c) {
        this.controlador = c;
    }


    private void mostrar(Cliente c) { 
        lbl.setText(c == null ? "Sin clientes" : c.toString());
    }
}