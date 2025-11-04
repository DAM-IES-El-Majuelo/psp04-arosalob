// =====================
// VISTA
// =====================
package vista;

import controlador.Controlador;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private Controlador controlador;
    private PanelBienvenida pBienvenida = new PanelBienvenida();
    private PanelVerClientes pVer = new PanelVerClientes();
    private PanelAltaCliente pAlta = new PanelAltaCliente();

    public VentanaPrincipal() {
        setTitle("MVC Clientes");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem m1 = new JMenuItem("Inicio");
        JMenuItem m2 = new JMenuItem("Ver clientes");
        JMenuItem m3 = new JMenuItem("Alta cliente");

        m1.addActionListener(e -> setContent(pBienvenida));
        m2.addActionListener(e -> setContent(pVer));
        m3.addActionListener(e -> setContent(pAlta));

        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        barra.add(menu);
        setJMenuBar(barra);
        add(pBienvenida);
    }

    public void setControlador(Controlador c) {
        this.controlador = c;
        pVer.setControlador(c);
        pAlta.setControlador(c);
    }

    private void setContent(JPanel p) {
        getContentPane().removeAll();
        add(p);
        revalidate();
        repaint();
    }
}
