/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Alberto Perez
 */
public class VentanaLogin extends javax.swing.JFrame {

    private HashMap<String, Empleado> empleados = new HashMap<String, Empleado>();

    private String rutaCarpeta = System.getProperty("user.dir"); // devuelve la ruta de la carpeta actual de trabajo
    private String nombreFichero = "empleados.txt";

    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() throws ErrorLeerArchivo {
        initComponents();
        setLocationRelativeTo(null);
        

        // Cambiar el nombre eicono de la ventana
        setTitle("Acceso al sistema");
        ImageIcon icono = new ImageIcon("icon.png");
        setIconImage(icono.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNombre = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtNombre = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbNombre.setText("Nombre");

        lbPassword.setText("Password");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbPassword)
                    .addComponent(lbNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        txtNombre.getAccessibleContext().setAccessibleName("nombre");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoginActionPerformed
        String username = txtNombre.getText();
        String password = String.valueOf(txtPassword.getPassword());

        Empleado empleado = new Empleado(username, password);

        try {
            // Verificar si el usuario y la contraseña son válidos
            boolean validLogin = false;
            try {
                leerArchivo(); // leer el archivo de empleados
                // Si empleado se encuentra en el HashMap con método containsValue
                if (empleados.containsValue(empleado)) {
                    System.out.println("El empleado " + empleado + " se encuentra en el HashMap.");
                    validLogin = true;
                } else {
                    System.out.println("El empleado " + empleado + " no se encuentra en el HashMap.");
                }

            } catch (Exception e) {
                System.err.println("Error al leer el archivo de empleados");
                e.printStackTrace();
            }

            // Si los campos de texto están vacíos, mostrar un mensaje de error
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "DEBES INTRODUCIR LOS DATOS", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (validLogin) {// Si el login es válido, abrir la ventana bienvenida
                // Crear objeto de la clase VentanaBienvenida
                VentanaBienvenida ventanaBienvenida = new VentanaBienvenida(null, true);
                ventanaBienvenida.setLocationRelativeTo(null); // centrar la ventana
                ventanaBienvenida.setDatos(username, password); // pasar los datos de usuario y contraseña
                ventanaBienvenida.setVisible(true); // mostrar la ventana
                ventanaBienvenida.dispose(); // cerrar la ventana de bienvenida
                // Se borran los datos de los campos de texto
                txtNombre.setText("");
                txtPassword.setText("");

            } else {
                // Si el login no es válido, mostrar un mensaje de error en rojo
                JOptionPane.showMessageDialog(this, "CREDENCIALES INCRORRECTAS", "Error",
                        JOptionPane.ERROR_MESSAGE);
                txtPassword.setText("");
            }
        } catch (Exception e) {

        }

    }// GEN-LAST:event_btnLoginActionPerformed

    // Método para leer el archivo de empleados
    public void leerArchivo() throws ErrorLeerArchivo {
        File archivo = new File(nombreFichero); // crear objeto File para leer el archivo
        if (!archivo.exists()) { // si el archivo no existe, se crea
            System.err.println("El archivo de empleados no existe");
            return; // terminar el método
        }
        try (// Crear un flujo de entrada para leer el archivo
                 FileInputStream fis = new FileInputStream(archivo)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Crear un HashMap para almacenar los datos leídos del archivo
            HashMap<String, Empleado> empleados = (HashMap<String, Empleado>) ois.readObject(); // Castea el objeto
            // ObjectInputStream a
            // HashMap
            ois.close(); // cerrar el flujo
            fis.close(); // cerrar el flujo
            System.out.println("Datos de empleados almacenados en el archivo:");
            for (Empleado empleado : empleados.values()) { // recorrer el HashMap
                System.out.println(empleado); // mostrar los datos de cada empleado
            }
            this.empleados = empleados; // asignar el HashMap leído al atributo empleados de la clase
        } catch (ClassNotFoundException | IOException e) {
            new ErrorLeerArchivo();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaLogin().setVisible(true);
                } catch (ErrorLeerArchivo e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

}
