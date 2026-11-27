package Nómina;

import java.util.*;

public class ListaEmpleados {
    public Vector<Empleado> lista;
    public double totalNómina = 0;

    public ListaEmpleados() {
        lista = new Vector<Empleado>();
    }

    public void agregarEmpleado(Empleado a) {
        lista.add(a);
    }

    public double calcularTotalNómina() {
        totalNómina = 0;
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.elementAt(i);
            totalNómina = totalNómina + e.calcularNómina();
        }
        return totalNómina;
    }

    public String[][] obtenerMatriz() {
        String datos[][] = new String[lista.size()][3];
        totalNómina = 0;
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.elementAt(i);
            datos[i][0] = e.getNombre();
            datos[i][1] = e.getApellidos();
            datos[i][2] = Double.toString(e.calcularNómina());
            totalNómina = totalNómina + e.calcularNómina();
        }
        return datos;
    }

    public String convertirTexto() {
        String texto = "";
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.elementAt(i);
            texto = texto + "Nombre = " + e.getNombre() + "\n"
                    + "Apellidos = " + e.getApellidos() + "\n"
                    + "Cargo = " + e.getCargo() + "\n"
                    + "Género = " + e.getGénero() + "\n"
                    + "Salario = $" + e.getSalarioDía() + "\n"
                    + "Días trabajados = " + e.getDíasTrabajados() + "\n"
                    + "Otros ingresos = $" + e.getOtrosIngresos() + "\n"
                    + "Pagos salud = $" + e.getPagosSalud() + "\n"
                    + "Aportes pensiones = $" + e.getAportePensiones() + "\n---------\n";
        }
        texto = texto + "Total nómina = $" + String.format("%.2f", calcularTotalNómina());
        return texto;
    }
}
