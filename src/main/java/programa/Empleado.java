/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programa;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Alberto Pérez del Río
 */
class Empleado implements Serializable {

    // Variables del objeto empleado
    private String nombre;
    private String apellido;
    private double sueldo;

    // Variable string que no se va a serializar usando la palabra reservada
    // transient
    private transient String clave = "patata";

    // Contructores de la clase Empleado
    public Empleado(String nombre, String apellido, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
    }

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String getClave() {
        return clave;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    // Override del metodo String
    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", sueldo=" + sueldo + '}';
    }

    @Override
    public int hashCode() {
        int result = this.nombre.hashCode() + this.apellido.hashCode();
        return result;
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
    }

   

    

}
