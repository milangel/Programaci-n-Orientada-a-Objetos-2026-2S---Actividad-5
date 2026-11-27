package Hotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hotel {
    public static Vector<Habitación> listaHabitaciones;

    public Hotel() {
        listaHabitaciones = new Vector<Habitación>();
        for (int i = 1; i <= 10; i++) {
            double precio = (i <= 5) ? 120000 : 160000;
            listaHabitaciones.add(new Habitación(i, true, precio));
        }
    }

    public String buscarFechaIngresoHabitación(int número) {
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            Habitación habitación = listaHabitaciones.elementAt(i);
            if (habitación.getNúmeroHabitación() == número) {
                Date fecha = habitación.getHuésped().getFechaIngreso();
                DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                return formatoFecha.format(fecha);
            }
        }
        return "";
    }

    public boolean buscarHabitaciónOcupada(int número) {
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            Habitación habitación = listaHabitaciones.elementAt(i);
            if (habitación.getNúmeroHabitación() == número && !habitación.getDisponible()) {
                return true;
            }
        }
        return false;
    }
}