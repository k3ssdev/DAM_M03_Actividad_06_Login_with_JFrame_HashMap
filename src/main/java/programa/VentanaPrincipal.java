/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package programa;

import java.io.*;
import java.util.HashMap;

/**
 *
 * @author Alberto Pérez
 */
public class VentanaPrincipal {

    public static void main(String[] args) {

        // Se crea el HashMap
        HashMap<String, Empleado> empleados = new HashMap<String, Empleado>();

        // Se crean los objetos Empleado, dandoles un nombre, apellido y sueldo. Tambien
        // se asigna una clave.
        Empleado empleado1 = new Empleado("Alberto", "Perez", 3000);
        empleado1.setClave("1234");

        Empleado empleado2 = new Empleado("Alejandro", "Sama", 1500);
        empleado2.setClave("5678");

        // Se guardan los objetos Empleado en el HashMap, con la clave y con el objeto
        // empleado
        empleados.put(empleado1.getClave(), empleado1);
        empleados.put(empleado2.getClave(), empleado2);

        // Se genera el fichero
        String rutaCarpeta = System.getProperty("user.dir"); // devuelve la ruta de la carpeta actual de trabajo
        // Se crea el fichero con la ruta de la carpeta actual de trabajo y el nombre
        File fichero = new File(rutaCarpeta + File.separator + "empleados.txt"); 

        // Se crea el flujo de salida
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            // Se crea el flujo de salida
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);

            // Se escribe el HashMap en el fichero
            oos.writeObject(empleados);

            // Se cierra el flujo de salida
            oos.close();

            // Se crea VentaLogin y se hace visible
            VentanaLogin ventanaLogin;
            try {
                ventanaLogin = new VentanaLogin();
                ventanaLogin.setVisible(true);
            } catch (ErrorLeerArchivo e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {

            System.out.println("Error al crear el fichero");
            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Error al escribir en el fichero");
            e.printStackTrace();

        } finally {

            try {
                // Se cierra el flujo de salida
                oos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}