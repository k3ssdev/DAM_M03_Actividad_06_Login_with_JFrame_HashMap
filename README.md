# [DAM][M03]- Actividad 6 - Ventana de Login con Java Swing y HashMap
## Descripción del proyecto
Este proyecto es una actividad de la asignatura de Desarrollo de Aplicaciones Multiplataforma del ciclo formativo de grado superior de Desarrollo de Aplicaciones Web en Linkia FP. Consiste en una aplicación que simula una ventana de login con un panel de control de usuarios.

## Desarrollado con
* [Java] - Lenguaje de programación
* [NetBeans] - Entorno de desarrollo integrado
* [GitHub] - Control de versiones


## Descripción del proyecto
El programa consiste en una aplicación Java que permite almacenar información de empleados y autenticar a los usuarios mediante una ventana de login.

La clase `Empleado` almacena información de cada empleado, como su nombre, apellido y sueldo. El programa permite crear varios empleados y almacenarlos en una HashMap según su nombre, y guardar esta HashMap en un archivo.

La clase `VentanaPrincipal` es la clase principal del programa y contiene el método `main`. Al ejecutarse, crea varios empleados, los almacena en una HashMap según su nombre y los guarda en un archivo. Luego, inicia una ventana de login definida en la clase `VentanaLogin`.

La clase `VentanaLogin` muestra una ventana con una caja de texto para introducir el nombre, otra caja para introducir el password (que será el apellido) y un botón de login. Al abrir la ventana, el programa intenta acceder al archivo con la información de los empleados. Si puede acceder, muestra todos los datos almacenados en el archivo en la consola y los guarda en una variable de la clase `VentanaLogin`. Si no puede acceder, lanza una excepción del tipo `ErrorLeerArchivo` que la clase `VentanaPrincipal` controla mostrando un mensaje al usuario.

El botón de login comprueba que el usuario existe en el archivo con el nombre y mismo apellido (introducido en el password) indicado por el usuario. Si todo es correcto, se abre una nueva ventana dando la bienvenida al usuario con su apellido y un botón para cerrar la aplicación. Si el usuario no rellena algún campo, se muestra un mensaje de error. Si el nombre o password no concuerda, se muestra un mensaje de error.

El programa utiliza la serialización para guardar los datos de los empleados en un archivo, excepto el atributo que guarda la clave.

## Autor
**Alberto Pérez** 

## Licencia
Este proyecto está bajo la Licencia MIT - mira el archivo [LICENSE.md] para más detalles