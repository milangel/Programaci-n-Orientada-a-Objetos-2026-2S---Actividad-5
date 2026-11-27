package Nómina;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class VentanaNómina extends JFrame {
    private Container contenedor;
    private ListaEmpleados lista;
    private JLabel empleados, nómina;
    private JTable tabla;

    public VentanaNómina(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Nómina de Empleados");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        empleados = new JLabel("Lista de empleados:");
        empleados.setBounds(20, 10, 135, 23);

        String[][] datos = lista.obtenerMatriz();
        String[] titulos = {"NOMBRE", "APELLIDOS", "SUELDO"};
        DefaultTableModel model = new DefaultTableModel(datos, titulos);
        tabla = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 45, 300, 105);

        nómina = new JLabel("Total nómina mensual = $ " + String.format("%.2f", lista.totalNómina));
        nómina.setBounds(20, 165, 280, 23);

        contenedor.add(empleados);
        contenedor.add(scroll);
        contenedor.add(nómina);
    }
}