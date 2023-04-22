package programa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControlEmpleado {

    public static void main(String[] args) {
        List<Empleado> empleados = leerEmpleados();
        System.out.println(empleados);
    }

    private static List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();

        // Se lee el fichero con clase ObjectInputStream
        try (BufferedReader br = new BufferedReader(new FileReader("empleados.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Empleado empleado = new Empleado(datos[0], datos[1], Double.parseDouble(datos[2]));
                empleados.add(empleado);
            }
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }

        return empleados;

    }

}
