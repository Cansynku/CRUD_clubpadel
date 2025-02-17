/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class PantallaConsultar extends javax.swing.JDialog {

    static Connection conn = iniciarConexion();

    /**
     * Creates new form PantallaConsultar
     */
    public PantallaConsultar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(new Color(255, 250, 205));
        setIconImage(new ImageIcon(getClass().getResource("/interfaz/img/tenis.png")).getImage());

        // Establecer el tipo de fuente y el tamaño para el JTextArea
        jTextAreaResultado.setFont(new Font("Arial", Font.PLAIN, 16)); // Cambiar la fuente y el tamaño según tus preferencias

// Cambiar el color de fondo del JTextArea
        jTextAreaResultado.setBackground(new Color(240, 240, 240)); // Un color ligeramente grisáceo para un aspecto moderno

// Cambiar el color del texto del JTextArea
        jTextAreaResultado.setForeground(new Color(50, 50, 50)); // Un tono oscuro para una mejor legibilidad

// Cambiar el estilo del borde del JTextArea
        jTextAreaResultado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1), // Borde sólido delgado de color gris claro
                BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Agregar un espacio interno alrededor del JTextArea

// Agregar espaciado entre líneas al JTextArea
        jTextAreaResultado.setLineWrap(true); // Activar el ajuste de línea
        jTextAreaResultado.setWrapStyleWord(true); // Ajustar las palabras al ancho del JTextArea

    }

    //Igual que en el resto de pantallas
    public static Connection iniciarConexion() {

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/clubpadelnuevo?serverTimezone=UTC", "root", "caraculo");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonTodosAlumnos = new javax.swing.JButton();
        jButtonTodosProfesores = new javax.swing.JButton();
        jTextFieldDNIAlumnos = new javax.swing.JTextField();
        jButtonMostrarAlumno = new javax.swing.JButton();
        jTextFieldDNIProfesor = new javax.swing.JTextField();
        jButtonMostarProfesor = new javax.swing.JButton();
        jTextFieldNivel = new javax.swing.JTextField();
        jButtonNivel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaResultado = new javax.swing.JTextArea();
        jButtonSalir = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana Consultar");

        jPanel1.setBackground(new java.awt.Color(255, 250, 205));
        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 15, 10));

        jButtonTodosAlumnos.setBackground(new java.awt.Color(0, 153, 255));
        jButtonTodosAlumnos.setText("MOSTRAR TODOS  LOS ALUMNOS");
        jButtonTodosAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTodosAlumnosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTodosAlumnos);

        jButtonTodosProfesores.setBackground(new java.awt.Color(51, 255, 51));
        jButtonTodosProfesores.setText("MOSTRAR TODOS LOS PROFESORES");
        jButtonTodosProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTodosProfesoresActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTodosProfesores);

        jTextFieldDNIAlumnos.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldDNIAlumnos.setText("Introduce el DNI del alumno...");
        jTextFieldDNIAlumnos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDNIAlumnosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDNIAlumnosFocusLost(evt);
            }
        });
        jPanel1.add(jTextFieldDNIAlumnos);

        jButtonMostrarAlumno.setText("MOSTRAR ALUMNO FILTRADO POR DNI");
        jButtonMostrarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonMostrarAlumno);

        jTextFieldDNIProfesor.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldDNIProfesor.setText("Introduce el DNI del profesor...");
        jTextFieldDNIProfesor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDNIProfesorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDNIProfesorFocusLost(evt);
            }
        });
        jPanel1.add(jTextFieldDNIProfesor);

        jButtonMostarProfesor.setText("MOSTRAR PROFESOR FILTRADO POR DNI");
        jButtonMostarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostarProfesorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonMostarProfesor);

        jTextFieldNivel.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldNivel.setText("Introduce el nivel del alumno...");
        jTextFieldNivel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNivelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNivelFocusLost(evt);
            }
        });
        jPanel1.add(jTextFieldNivel);

        jButtonNivel.setText("MOSTRAR LOS ALUMNOS DEL NIVEL");
        jButtonNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNivelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNivel);

        jTextAreaResultado.setColumns(20);
        jTextAreaResultado.setRows(5);
        jScrollPane1.setViewportView(jTextAreaResultado);

        jButtonSalir.setText("VOLVER AL MENÚ");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("LIMPIAR");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButtonLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonLimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTodosAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTodosAlumnosActionPerformed
        boolean registros = false;
    jTextAreaResultado.setText("");

    String query = "SELECT a.id, a.dni, a.nombre, a.apellido, a.email, n.nombre AS nombre_nivel, p.nombre AS nombre_profesor "
            + "FROM alumnos a "
            + "LEFT JOIN profesores p ON a.profesor_id = p.id "
            + "LEFT JOIN nivelplaytomic n ON a.nivel_id = n.id";

    try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        jTextAreaResultado.append("ID - DNI - Nombre - Apellido - Email - Nivel - Nombre del Profesor\n");
        while (rs.next()) {
            registros = true;
            jTextAreaResultado.append("ID: " + rs.getString("id") + "\n");
            jTextAreaResultado.append("DNI: " + rs.getString("dni") + "\n");
            jTextAreaResultado.append("NOMBRE: " + rs.getString("nombre") + "\n");
            jTextAreaResultado.append("APELLIDO: " + rs.getString("apellido") + "\n");
            jTextAreaResultado.append("EMAIL: " + rs.getString("email") + "\n");
            jTextAreaResultado.append("NIVEL: " + rs.getString("nombre_nivel") + "\n");
            jTextAreaResultado.append("NOMBRE DEL PROFESOR: " + rs.getString("nombre_profesor") + "\n\n");

            // Agregar un borde alrededor del conjunto de información
            jTextAreaResultado.append("----------------------------------------------------\n\n");
        }
        if (!registros) {
            jTextAreaResultado.setText("No hay registros.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    }//GEN-LAST:event_jButtonTodosAlumnosActionPerformed

    private void jButtonTodosProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTodosProfesoresActionPerformed
boolean registros = false;
    jTextAreaResultado.setText("");

    String query = "SELECT p.id, p.nombre, p.apellido, p.dni, p.email, n.nombre AS nivel, p.descripcion "
            + "FROM profesores p "
            + "INNER JOIN nivelplaytomic n ON p.nivel_id = n.id";

    try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            registros = true;
            jTextAreaResultado.append("ID: " + rs.getString("id") + "\n");
            jTextAreaResultado.append("DNI: " + rs.getString("dni") + "\n");
            jTextAreaResultado.append("NOMBRE: " + rs.getString("nombre") + "\n");
            jTextAreaResultado.append("APELLIDO: " + rs.getString("apellido") + "\n");
            jTextAreaResultado.append("EMAIL: " + rs.getString("email") + "\n");
            jTextAreaResultado.append("NIVEL: " + rs.getString("nivel") + "\n");
            jTextAreaResultado.append("DESCRIPCIÓN: " + rs.getString("descripcion") + "\n\n");

            // Agregar un borde alrededor del conjunto de información
            jTextAreaResultado.append("----------------------------------------------------\n\n");
        }

        if (!registros) {
            jTextAreaResultado.setText("No hay registros.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }//GEN-LAST:event_jButtonTodosProfesoresActionPerformed

    //Métodos para el placeholder de los textField
    private void jTextFieldDNIAlumnosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDNIAlumnosFocusGained

        if (jTextFieldDNIAlumnos.getText().equals("Introduce el DNI del alumno...")) {
            jTextFieldDNIAlumnos.setForeground(Color.BLACK);
            jTextFieldDNIAlumnos.setText("");
        }
    }//GEN-LAST:event_jTextFieldDNIAlumnosFocusGained

    private void jTextFieldDNIAlumnosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDNIAlumnosFocusLost
        if (jTextFieldDNIAlumnos.getText().equals("")) {
            jTextFieldDNIAlumnos.setForeground(new Color(204, 204, 204));
            jTextFieldDNIAlumnos.setText("Introduce el DNI del alumno...");
        }
    }//GEN-LAST:event_jTextFieldDNIAlumnosFocusLost

    private void jTextFieldDNIProfesorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDNIProfesorFocusGained
        if (jTextFieldDNIProfesor.getText().equals("Introduce el DNI del profesor...")) {
            jTextFieldDNIProfesor.setForeground(Color.BLACK);
            jTextFieldDNIProfesor.setText("");
        }
    }//GEN-LAST:event_jTextFieldDNIProfesorFocusGained

    private void jTextFieldDNIProfesorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDNIProfesorFocusLost
        if (jTextFieldDNIProfesor.getText().equals("")) {
            jTextFieldDNIProfesor.setForeground(new Color(204, 204, 204));
            jTextFieldDNIProfesor.setText("Introduce el DNI del profesor...");
        }
    }//GEN-LAST:event_jTextFieldDNIProfesorFocusLost


    private void jButtonMostrarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarAlumnoActionPerformed
        //Consulta con statement en vez de PreparedStatement por no hacer todas iguales
        jTextAreaResultado.setText("");
        Boolean informacion = false;
        String query = "SELECT a.id, a.dni, a.nombre, a.apellido, a.email, p.nombre AS nombre_profesor, n.nombre AS nombre_nivel "
                + "FROM alumnos a "
                + "LEFT JOIN profesores p ON a.profesor_id = p.id "
                + "LEFT JOIN nivelplaytomic n ON a.nivel_id = n.id "
                + "WHERE a.dni = '" + jTextFieldDNIAlumnos.getText() + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                informacion = true;
                jTextAreaResultado.append("ID: " + rs.getString("id") + "\nDNI: " + rs.getString("dni")
                        + "\nNOMBRE: " + rs.getString("nombre") + "\nAPELLIDO: " + rs.getString("apellido")
                        + "\nEMAIL: " + rs.getString("email") + "\nID PROFESOR: " + rs.getString("nombre_profesor")
                        + "\nNIVEL: " + rs.getString("nombre_nivel") + "\n");
            }

            if (!informacion) {
                jTextAreaResultado.setText("No hay registros.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Verificar formato del DNI
        String dni = jTextFieldDNIAlumnos.getText();
        if (!dni.matches("\\d{8}[A-Za-z]")) {
            JOptionPane.showMessageDialog(this, "El DNI debe tener ocho números seguidos de una letra.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonMostrarAlumnoActionPerformed

    private void jButtonMostarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostarProfesorActionPerformed
                                                     
                                                           
                                                         
    jTextAreaResultado.setText("");
    Boolean informacion = false;
    String query = "SELECT p.id, p.dni, p.nombre, p.apellido, p.email, p.descripcion, n.nombre AS nombre_nivel " +
                   "FROM profesores p " +
                   "LEFT JOIN nivelplaytomic n ON p.nivel_id = n.id " +
                   "WHERE p.dni = '" + jTextFieldDNIProfesor.getText() + "'";
    try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            informacion = true;
            jTextAreaResultado.append("ID: " + rs.getString("id") + "\nDNI: " + rs.getString("dni")
                    + "\nNOMBRE: " + rs.getString("nombre") + "\nAPELLIDO: " + rs.getString("apellido")
                    + "\nEMAIL: " + rs.getString("email") + "\nNIVEL: " + rs.getString("nombre_nivel")
                    + "\nDESCRIPCIÓN: " + rs.getString("descripcion") + "\n");
        }

        if (!informacion) {
            jTextAreaResultado.setText("No hay registros.");
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    // Verificar formato del DNI
    String dni = jTextFieldDNIProfesor.getText();
    if (!dni.matches("\\d{8}[A-Za-z]")) {
        JOptionPane.showMessageDialog(this, "El DNI debe tener ocho números seguidos de una letra.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonMostarProfesorActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        //Volver al menú 
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    //Mismo métodos para los placeholder del jTextField de materia
    private void jTextFieldNivelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNivelFocusGained
        if (jTextFieldNivel.getText().equals("Introduce el nivel del alumno...")) {
            jTextFieldNivel.setForeground(Color.BLACK);
            jTextFieldNivel.setText("");
        }
    }//GEN-LAST:event_jTextFieldNivelFocusGained

    private void jTextFieldNivelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNivelFocusLost
        if (jTextFieldNivel.getText().equals("")) {
            jTextFieldNivel.setForeground(new Color(204, 204, 204));
            jTextFieldNivel.setText("Introduce el nombre de la materia...");
        }
    }//GEN-LAST:event_jTextFieldNivelFocusLost

    private void jButtonNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNivelActionPerformed
        //Consulta a la base de datos con un JOIN
        Boolean informacion = false;

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT a.dni, a.nombre, a.apellido, p.nombre AS nombre_profesor "
                    + "FROM alumnos a "
                    + "JOIN profesores p ON p.id = a.profesor_id "
                    + "WHERE a.nivel_id = ?");
            int nivelId = Integer.parseInt(jTextFieldNivel.getText());
            ps.setInt(1, nivelId);
            ResultSet rs = ps.executeQuery();

            jTextAreaResultado.setText("Los alumnos que tienen el nivel ID " + nivelId + " son: \n");
            while (rs.next()) {
                informacion = true;
                jTextAreaResultado.append("DNI: " + rs.getString("dni")
                        + " NOMBRE: " + rs.getString("nombre")
                        + " " + rs.getString("apellido")
                        + " PROFESOR: " + rs.getString("nombre_profesor") + "\n");
            }
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
        }

        if (!informacion) {
            jTextAreaResultado.setText("No hay registros.");
        }
    }//GEN-LAST:event_jButtonNivelActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        //Devuelve todo a como estaba al principio
        jTextAreaResultado.setText("");
        jTextFieldDNIAlumnos.setForeground(new Color(204, 204, 204));
        jTextFieldDNIAlumnos.setText("Introduce el DNI del alumno...");
        jTextFieldDNIProfesor.setForeground(new Color(204, 204, 204));
        jTextFieldDNIProfesor.setText("Introduce el DNI del profesor...");
        jTextFieldNivel.setForeground(new Color(204, 204, 204));
        jTextFieldNivel.setText("Introduce el nivel Playtomic del alumno...");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PantallaConsultar dialog = new PantallaConsultar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonMostarProfesor;
    private javax.swing.JButton jButtonMostrarAlumno;
    private javax.swing.JButton jButtonNivel;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonTodosAlumnos;
    private javax.swing.JButton jButtonTodosProfesores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaResultado;
    private javax.swing.JTextField jTextFieldDNIAlumnos;
    private javax.swing.JTextField jTextFieldDNIProfesor;
    private javax.swing.JTextField jTextFieldNivel;
    // End of variables declaration//GEN-END:variables
}
