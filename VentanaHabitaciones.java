package Hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaHabitaciones extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel[] etiquetasHab = new JLabel[10];
    private JLabel[] etiquetasDisp = new JLabel[10];
    private JLabel habitaciónSeleccionada;
    private JSpinner campoHabitaciónSeleccionada;
    private SpinnerNumberModel modeloSpinner;
    private JButton botónAceptar;
    private Hotel hotel;

    public VentanaHabitaciones(Hotel hotel) {
        this.hotel = hotel;
        inicio();
        setTitle("Habitaciones");
        setSize(760, 260);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        for (int i = 0; i < 10; i++) {
            int col = i % 5;
            int row = i / 5;
            int x = 20 + col * 140;
            int y = 30 + row * 90;

            etiquetasHab[i] = new JLabel("Habitación " + (i + 1));
            etiquetasHab[i].setBounds(x, y, 130, 23);

            etiquetasDisp[i] = new JLabel("Disponible");
            etiquetasDisp[i].setBounds(x, y + 20, 100, 23);

            Habitación habitación = hotel.listaHabitaciones.elementAt(i);
            if (!habitación.getDisponible()) {
                etiquetasDisp[i].setText("No disponible");
            }

            contenedor.add(etiquetasHab[i]);
            contenedor.add(etiquetasDisp[i]);
        }

        habitaciónSeleccionada = new JLabel("Habitación a reservar:");
        habitaciónSeleccionada.setBounds(250, 180, 135, 23);

        campoHabitaciónSeleccionada = new JSpinner();
        modeloSpinner = new SpinnerNumberModel(1, 1, 10, 1);
        campoHabitaciónSeleccionada.setModel(modeloSpinner);
        campoHabitaciónSeleccionada.setBounds(380, 180, 40, 23);

        botónAceptar = new JButton("Aceptar");
        botónAceptar.setBounds(500, 180, 100, 23);
        botónAceptar.addActionListener(this);

        contenedor.add(habitaciónSeleccionada);
        contenedor.add(campoHabitaciónSeleccionada);
        contenedor.add(botónAceptar);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == botónAceptar) {
            int habitación = (int) campoHabitaciónSeleccionada.getValue();
            if (!hotel.buscarHabitaciónOcupada(habitación)) {
                VentanaIngreso ventanaIngreso = new VentanaIngreso(hotel, habitación);
                setVisible(false);
                ventanaIngreso.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "La habitación está ocupada", "Mensaje", JOptionPane.INFORMATION_MESSAGE, null);
            }
        }
    }
}
