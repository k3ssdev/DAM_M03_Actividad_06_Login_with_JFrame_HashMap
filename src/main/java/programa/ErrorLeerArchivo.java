package programa;

public class ErrorLeerArchivo extends Exception {
    
        public ErrorLeerArchivo() {
            super("Error al leer el archivo");
        }
    
        public ErrorLeerArchivo(String mensaje) {
            super(mensaje);
        }
    }
