package app;

import controlador.Controller;

public class Main {
    public static void main(String[] args) {
        modelo.ListaCliente model = new modelo.ListaCliente();
        vista.JFramePrincipal view = new vista.JFramePrincipal();
        new Controller(model, view);
    }
}
