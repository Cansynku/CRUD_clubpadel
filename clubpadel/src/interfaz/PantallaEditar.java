/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author javier
 */
public class PantallaEditar extends javax.swing.JDialog {

    static Connection conn = iniciarConexion();

    /**
     * Creates new form PantallaEditar
     */
    public PantallaEditar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(new Color(255, 250, 205));
        setIconImage(new ImageIcon(getClass().getResource("/interfaz/img/tenis.png")).getImage());

        // Limpiar el JTextField
        limpiarCamposAlumno(); // Método para limpiar campos de alumno
        limpiarCamposProfesor(); // Método para limpiar campos de profesor

        idAlumnos();
        idProfesores();
        cargarOpiniones();

        // Cargar los niveles de los alumnos al JComboBox
        cargarNivelesAlumno();
        cargarNivelesProfesor();
    }

    private void cargarNivelesAlumno() {
        jComboBoxNivelAlumno.removeAllItems(); // Limpiar el JComboBox

        try {
            Statement st = conn.createStatement();
            String query = "SELECT DISTINCT nivel_id FROM alumnos ORDER BY nivel_id";
            ResultSet rs = st.executeQuery(query);

            // Agregar los niveles obtenidos de la base de datos al JComboBox
            while (rs.next()) {
                // Agregar los niveles al JComboBox sin selección predefinida
                jComboBoxNivelAlumno.addItem(rs.getString("nivel_id"));
            }

            // Deseleccionar cualquier ítem seleccionado
            jComboBoxNivelAlumno.setSelectedIndex(-1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void cargarNivelesProfesor() {
        jComboBoxNivelProfesor.removeAllItems(); // Limpiar el JComboBox

        try {
            Statement st = conn.createStatement();
            String query = "SELECT DISTINCT nivel_id FROM profesores ORDER BY nivel_id";
            ResultSet rs = st.executeQuery(query);

            // Agregar los niveles obtenidos de la base de datos al JComboBox
            while (rs.next()) {
                // Agregar los niveles al JComboBox sin selección predefinida
                jComboBoxNivelProfesor.addItem(rs.getString("nivel_id"));
            }

            // Deseleccionar cualquier ítem seleccionado
            jComboBoxNivelProfesor.setSelectedIndex(-1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para limpiar los campos del alumno
    private void limpiarCamposAlumno() {
        jTextFieldDNIAlumno.setText("");
        jTextFieldNombreAlumno.setText("");
        jTextFieldApellidoAlumno.setText("");
        jTextFieldCorreoAlumno.setText("");
    }

    private void limpiarCamposProfesor() {
        jTextFieldDNIProfesor.setText("");
        jTextFieldNombreProfesor.setText("");
        jTextFieldApellidoProfesor.setText("");
        jTextFieldCorreoProfesor.setText("");

    }

// Método para cargar los IDs de las opiniones en el JComboBox
    private void cargarOpiniones() {
        jComboBoxOPINIONES.removeAllItems(); // Limpiar los items previos

        try {
            // Realizar la consulta para obtener los IDs y nombres de los profesores de las opiniones
            String query = "SELECT o.id, o.dni_alumno, o.comentario, CONCAT(p.nombre, ' ', p.apellido) AS profesor FROM opiniones o JOIN profesores p ON o.profesor_id = p.id";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Agregar los elementos al JComboBox y un mapa para almacenar los comentarios y los nombres de los profesores
            Map<String, String> comentariosMap = new HashMap<>();
            Map<String, String> profesoresMap = new HashMap<>();
            while (resultSet.next()) {
                // Concatenar el ID y el DNI del alumno para mostrar en el JComboBox
                String item = resultSet.getString("id") + " - " + resultSet.getString("dni_alumno") + " - Profesor: " + resultSet.getString("profesor");

                jComboBoxOPINIONES.addItem(item);

                // Almacenar el comentario correspondiente en el mapa
                String comentario = resultSet.getString("comentario");
                comentariosMap.put(item, comentario);

                // Almacenar el nombre del profesor correspondiente en el mapa
                String profesor = resultSet.getString("profesor");
                profesoresMap.put(item, profesor);
            }

            // Llamar a setSelectedIndex(-1) para deseleccionar cualquier elemento del JComboBox
            jComboBoxOPINIONES.setSelectedIndex(-1);

            // Obtener el comentario del elemento seleccionado y mostrarlo en el JTextArea junto con el nombre del profesor
            jComboBoxOPINIONES.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedItem = (String) jComboBoxOPINIONES.getSelectedItem();
                    String comentario = comentariosMap.get(selectedItem);
                    String profesor = profesoresMap.get(selectedItem);
                    String comentarioCompleto = "Comentario para el profesor " + profesor + ":\n" + comentario;
                    jTextFieldComentario.setText(comentarioCompleto);
                }
            });

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Los dos primeros métodos son los mismos que en la pantalla de añadir
    public static Connection iniciarConexion() {

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/clubpadelnuevo?serverTimezone=UTC", "root", "caraculo");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void idProfesores() {
        jComboBoxIDProfesorAlumno.removeAllItems();
        jComboBoxIDProfesores.removeAllItems();
        try {
            Statement st = conn.createStatement();
            String query = ("Select id from profesores");
            ResultSet rs = st.executeQuery(query);

            // Verificar si hay resultados antes de agregar elementos al JComboBox
            if (rs.next()) {
                jComboBoxIDProfesorAlumno.addItem("0");
                jComboBoxIDProfesores.addItem("0");

                // Agregar los IDs obtenidos de la base de datos al JComboBox
                do {
                    jComboBoxIDProfesorAlumno.addItem(rs.getString(1));
                    jComboBoxIDProfesores.addItem(rs.getString(1));
                } while (rs.next());
            } else {
                // Si no hay resultados, mostrar un mensaje o tomar alguna acción adecuada
                System.out.println("No hay profesores disponibles.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//Funciona igual que los profesores pero para alumnos
    public void idAlumnos() {
        jComboBoxIDAlumnos.removeAllItems();
        jComboBoxIDAlumnos.addItem("0");
        try {
            Statement st = conn.createStatement();
            String query = ("Select id from alumnos order by id");
            ResultSet rs = st.executeQuery(query);

            // Verificar si hay resultados antes de agregar elementos al JComboBox
            if (rs.next()) {
                // Agregar los IDs obtenidos de la base de datos al JComboBox
                do {
                    jComboBoxIDAlumnos.addItem(rs.getString(1));
                } while (rs.next());
            } else {
                // Si no hay resultados, mostrar un mensaje o tomar alguna acción adecuada
                System.out.println("No hay alumnos disponibles.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxIDAlumnos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDNIAlumno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNombreAlumno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldApellidoAlumno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCorreoAlumno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxIDProfesorAlumno = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxNivelAlumno = new javax.swing.JComboBox<>();
        jButtonEliminarAlumno = new javax.swing.JButton();
        jButtonModificarAlumno = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxIDProfesores = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDNIProfesor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNombreProfesor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldApellidoProfesor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCorreoProfesor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxNivelProfesor = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jButtonModificarProfesor = new javax.swing.JButton();
        jButtonEliminarProfesor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButtonEliminarComentario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextFieldComentario = new javax.swing.JTextArea();
        jComboBoxOPINIONES = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldFiltrarIDProfesor = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana Editar");

        jPanel1.setBackground(new java.awt.Color(255, 250, 205));
        jPanel1.setLayout(new java.awt.GridLayout(8, 20, 0, 10));

        jLabel1.setText("SELECCIONE UN ID:");
        jPanel1.add(jLabel1);

        jComboBoxIDAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDAlumnosActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxIDAlumnos);

        jLabel2.setText("DNI:");
        jPanel1.add(jLabel2);
        jPanel1.add(jTextFieldDNIAlumno);

        jLabel3.setText("NOMBRE:");
        jPanel1.add(jLabel3);
        jPanel1.add(jTextFieldNombreAlumno);

        jLabel4.setText("APELLIDO:");
        jPanel1.add(jLabel4);
        jPanel1.add(jTextFieldApellidoAlumno);

        jLabel5.setText("CORREO ELECTRÓNICO:");
        jPanel1.add(jLabel5);
        jPanel1.add(jTextFieldCorreoAlumno);

        jLabel6.setText("ID PROFESOR ASIGNADO:");
        jPanel1.add(jLabel6);

        jPanel1.add(jComboBoxIDProfesorAlumno);

        jLabel16.setText("NIVEL PLAYTOMIC:");
        jPanel1.add(jLabel16);

        jPanel1.add(jComboBoxNivelAlumno);

        jButtonEliminarAlumno.setBackground(new java.awt.Color(255, 0, 0));
        jButtonEliminarAlumno.setText("ELIMINAR");
        jButtonEliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminarAlumno);

        jButtonModificarAlumno.setBackground(new java.awt.Color(255, 255, 0));
        jButtonModificarAlumno.setText("MODIFICAR");
        jButtonModificarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificarAlumno);

        jTabbedPane1.addTab("ALUMNO", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 250, 205));
        jPanel2.setLayout(new java.awt.GridLayout(8, 2, 0, 10));

        jLabel7.setText("SELECCION UN ID:");
        jPanel2.add(jLabel7);

        jComboBoxIDProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDProfesoresActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxIDProfesores);

        jLabel8.setText("DNI:");
        jPanel2.add(jLabel8);
        jPanel2.add(jTextFieldDNIProfesor);

        jLabel9.setText("NOMBRE:");
        jPanel2.add(jLabel9);
        jPanel2.add(jTextFieldNombreProfesor);

        jLabel10.setText("APELLIDO:");
        jPanel2.add(jLabel10);
        jPanel2.add(jTextFieldApellidoProfesor);

        jLabel11.setText("CORREO ELECTRÓNICO:");
        jPanel2.add(jLabel11);
        jPanel2.add(jTextFieldCorreoProfesor);

        jLabel12.setText("NIVEL QUE IMPARTE:");
        jPanel2.add(jLabel12);

        jPanel2.add(jComboBoxNivelProfesor);

        jLabel15.setText("DESCRIPCIÓN");
        jPanel2.add(jLabel15);

        jTextFieldDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescripcionActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldDescripcion);

        jButtonModificarProfesor.setBackground(new java.awt.Color(51, 102, 255));
        jButtonModificarProfesor.setText("MODIFICAR");
        jButtonModificarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarProfesorActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonModificarProfesor);

        jButtonEliminarProfesor.setBackground(new java.awt.Color(255, 0, 0));
        jButtonEliminarProfesor.setText("ELIMINAR");
        jButtonEliminarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProfesorActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEliminarProfesor);

        jTabbedPane1.addTab("PROFESOR", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 250, 205));

        jLabel13.setText("SELECCIONE UNA OPINIÓN");

        jButtonEliminarComentario.setText("ELIMINAR COMENTARIO");
        jButtonEliminarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarComentarioActionPerformed(evt);
            }
        });

        jTextFieldComentario.setColumns(20);
        jTextFieldComentario.setRows(5);
        jScrollPane1.setViewportView(jTextFieldComentario);

        jComboBoxOPINIONES.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("FILTRAR POR ID DE PROFESOR");

        jTextFieldFiltrarIDProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFiltrarIDProfesorActionPerformed(evt);
            }
        });

        jButtonFiltrar.setText("FILTRAR");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldFiltrarIDProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jButtonFiltrar))
                            .addComponent(jComboBoxOPINIONES, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButtonEliminarComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxOPINIONES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFiltrarIDProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminarComentario)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("OPINIONES", jPanel3);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButtonLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonLimpiar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxIDAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDAlumnosActionPerformed

        if (jComboBoxIDAlumnos.getItemCount() > 0) {
            if (jComboBoxIDAlumnos.getSelectedIndex() != -1) {
                try {
                    PreparedStatement ps = conn.prepareStatement("SELECT dni, nombre, apellido, email, profesor_id, nivel_id FROM alumnos WHERE id = ?");
                    ps.setInt(1, Integer.parseInt(jComboBoxIDAlumnos.getSelectedItem().toString()));
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        jTextFieldDNIAlumno.setText(rs.getString("dni"));
                        jTextFieldNombreAlumno.setText(rs.getString("nombre"));
                        jTextFieldApellidoAlumno.setText(rs.getString("apellido"));
                        jTextFieldCorreoAlumno.setText(rs.getString("email"));

                        int profesorId = rs.getInt("profesor_id");
                        for (int i = 0; i < jComboBoxIDProfesorAlumno.getItemCount(); i++) {
                            if (jComboBoxIDProfesorAlumno.getItemAt(i).equals(String.valueOf(profesorId))) {
                                jComboBoxIDProfesorAlumno.setSelectedIndex(i);
                                break;
                            }
                        }

                        // Limpiar el JComboBox antes de agregar elementos
                        jComboBoxNivelAlumno.removeAllItems();

                        // Obtener el nivel actual del alumno
                        String nivelActualId = rs.getString("nivel_id");

                        // Obtener todos los niveles disponibles
                        Statement st = conn.createStatement();
                        ResultSet rsNiveles = st.executeQuery("SELECT id FROM nivelplaytomic");
                        while (rsNiveles.next()) {
                            int nivelId = rsNiveles.getInt("id");
                            jComboBoxNivelAlumno.addItem(String.valueOf(nivelId));
                        }

                        // Deseleccionar cualquier ítem seleccionado
                        jComboBoxNivelAlumno.setSelectedIndex(-1);

                        // Seleccionar el nivel actual del alumno en el JComboBox
                        jComboBoxNivelAlumno.setSelectedItem(nivelActualId);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            // El JComboBox está vacío, realiza alguna acción adecuada
        }
    }//GEN-LAST:event_jComboBoxIDAlumnosActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        //Volver al menú 
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonModificarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarAlumnoActionPerformed

        // Comprueba que no hay datos faltantes antes de realizar la modificación
        if (jComboBoxIDAlumnos.getSelectedIndex() != 0
                && !jTextFieldNombreAlumno.getText().equals("")
                && !jTextFieldApellidoAlumno.getText().equals("")
                && !jTextFieldDNIAlumno.getText().equals("")
                && !jTextFieldCorreoAlumno.getText().equals("")) {

            // Modifica los datos del ID seleccionado
            try {
                PreparedStatement ps = conn.prepareStatement("UPDATE alumnos SET dni = ?, nombre = ?, apellido = ?, email = ?, profesor_id = ?, nivel_id = ? WHERE id = ?");
                ps.setString(1, jTextFieldDNIAlumno.getText());
                ps.setString(2, jTextFieldNombreAlumno.getText());
                ps.setString(3, jTextFieldApellidoAlumno.getText());
                ps.setString(4, jTextFieldCorreoAlumno.getText());
                ps.setInt(5, Integer.parseInt(jComboBoxIDProfesorAlumno.getSelectedItem().toString()));
                ps.setString(6, jComboBoxNivelAlumno.getSelectedItem().toString());
                ps.setInt(7, Integer.parseInt(jComboBoxIDAlumnos.getSelectedItem().toString()));

                if (ps.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Información cambiada.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Faltan datos por rellenar.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonModificarAlumnoActionPerformed

    private void jComboBoxIDProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDProfesoresActionPerformed
        // Función igual que el comboBox de alumnos
        if (jComboBoxIDProfesores.getItemCount() > 0) {
            // Verifica si hay elementos en el JComboBox
            if (jComboBoxIDProfesores.getSelectedIndex() != -1) {
                // Verifica si se ha seleccionado un índice válido
                cargarNivelesProfesor(); // Cargar los niveles del profesor seleccionado
                // Tu código para manejar la selección del índice aquí
            } else {
                // No se ha seleccionado ningún índice, realiza alguna acción adecuada
            }
        } else {
            // El JComboBox está vacío, realiza alguna acción adecuada
        }
      try {
    PreparedStatement ps = conn.prepareStatement("SELECT dni, nombre, apellido, email, nivel_id, descripcion FROM profesores WHERE id = ?");
    ps.setInt(1, Integer.parseInt(jComboBoxIDProfesores.getSelectedItem().toString()));
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        jTextFieldDNIProfesor.setText(rs.getString("dni"));
        jTextFieldNombreProfesor.setText(rs.getString("nombre"));
        jTextFieldApellidoProfesor.setText(rs.getString("apellido"));
        jTextFieldCorreoProfesor.setText(rs.getString("email"));
        
        // Aquí es donde se establece la descripción en el JTextField
        String descripcion = rs.getString("descripcion");
        int maxLength = 30; // Longitud máxima permitida
        if (descripcion.length() > maxLength) {
            descripcion = descripcion.substring(0, maxLength) + "....";
        }
        jTextFieldDescripcion.setText(descripcion);
        
        int nivelId = rs.getInt("nivel_id");
        for (int i = 0; i < jComboBoxNivelProfesor.getItemCount(); i++) {
            if (Integer.parseInt(jComboBoxNivelProfesor.getItemAt(i).toString()) == nivelId) {
                jComboBoxNivelProfesor.setSelectedIndex(i);
                break;
            }
        }
    }
} catch (SQLException ex) {
    ex.printStackTrace();
}




    }//GEN-LAST:event_jComboBoxIDProfesoresActionPerformed

    private void jButtonModificarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarProfesorActionPerformed
        // Primero comprueba y luego modifica si están todos los campos rellenados
        if (jComboBoxIDProfesores.getSelectedIndex() != 0
                && !jTextFieldNombreProfesor.getText().equals("")
                && !jTextFieldApellidoProfesor.getText().equals("")
                && !jTextFieldDNIProfesor.getText().equals("")
                && !jTextFieldCorreoProfesor.getText().equals("")
                && !jTextFieldDescripcion.getText().equals("")) { // Verificar si la descripción está llenada

            try {
                PreparedStatement ps = conn.prepareStatement("UPDATE profesores SET dni=?, nombre=?, apellido=?, email=?, nivel_id=?, descripcion=? WHERE id=?");
                ps.setString(1, jTextFieldDNIProfesor.getText());
                ps.setString(2, jTextFieldNombreProfesor.getText());
                ps.setString(3, jTextFieldApellidoProfesor.getText());
                ps.setString(4, jTextFieldCorreoProfesor.getText());
                ps.setInt(5, Integer.parseInt(jComboBoxNivelProfesor.getSelectedItem().toString())); // Obtener el nivel_id del ComboBox
                ps.setString(6, jTextFieldDescripcion.getText()); // Establecer la descripción
                ps.setInt(7, Integer.parseInt(jComboBoxIDProfesores.getSelectedItem().toString()));
                if (ps.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Información cambiada.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException | NumberFormatException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Faltan datos por rellenar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModificarProfesorActionPerformed

    private void jButtonEliminarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProfesorActionPerformed
        // Primera parte igual que para alumnos, solo cambia una cosa
        if (jComboBoxIDProfesores.getSelectedIndex() != 0) {

            if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar el profesor?", "Eliminar profesor", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                String inputIdNuevoProfesor = JOptionPane.showInputDialog(null, "Introduce el ID del profesor nuevo para los alumnos asociados al que se va a eliminar:", "Eliminar profesor", JOptionPane.QUESTION_MESSAGE);

                // Validar si el input es un número válido
                if (inputIdNuevoProfesor != null && inputIdNuevoProfesor.matches("\\d+")) {
                    int idNuevoProfesor = Integer.parseInt(inputIdNuevoProfesor);
                    try {
                        // Actualizar el campo profesor_id de los alumnos asociados al profesor que se eliminará
                        PreparedStatement actualizarAlumnos = conn.prepareStatement("UPDATE alumnos SET profesor_id = ? WHERE profesor_id = ?");
                        actualizarAlumnos.setInt(1, idNuevoProfesor);
                        actualizarAlumnos.setInt(2, Integer.parseInt(jComboBoxIDProfesores.getSelectedItem().toString()));
                        actualizarAlumnos.executeUpdate();

                        // Eliminar al profesor
                        PreparedStatement eliminarProfesor = conn.prepareStatement("DELETE FROM profesores WHERE id = ?");
                        eliminarProfesor.setInt(1, Integer.parseInt(jComboBoxIDProfesores.getSelectedItem().toString()));
                        if (eliminarProfesor.executeUpdate() == 1) {
                            JOptionPane.showMessageDialog(null, "Profesor eliminado correctamente.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            jComboBoxIDProfesores.removeItemAt(jComboBoxIDProfesores.getSelectedIndex());

                        } else {
                            JOptionPane.showMessageDialog(null, "Error al eliminar al profesor.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "El ID del profesor nuevo no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                } else {
                    // El input no es un ID válido
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hace falta seleccionar un ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonEliminarProfesorActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // Devuelve todo a como se encontraba originalmente
        jTextFieldApellidoAlumno.setText("");
        jTextFieldApellidoProfesor.setText("");
        jTextFieldCorreoAlumno.setText("");
        jTextFieldCorreoProfesor.setText("");
        jTextFieldDNIAlumno.setText("");
        jTextFieldDNIProfesor.setText("");

        jTextFieldNombreAlumno.setText("");
        jTextFieldNombreProfesor.setText("");
        jComboBoxIDAlumnos.setSelectedIndex(0);
        jComboBoxIDProfesorAlumno.setSelectedIndex(0);
        jComboBoxIDProfesores.setSelectedIndex(0);
        // Limpiar el JTextArea
        jTextFieldComentario.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed


    private void jButtonEliminarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarComentarioActionPerformed
        // Obtener la selección del JComboBox
        String selectedItem = (String) jComboBoxOPINIONES.getSelectedItem();

        // Verificar que se haya seleccionado un elemento válido
        if (selectedItem != null) {
            // Preguntar al usuario si está seguro de eliminar el comentario
            int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este comentario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                // Extraer el ID del comentario seleccionado
                String[] parts = selectedItem.split(" - ");
                String selectedId = parts[0];

                try {
                    // Realizar la eliminación del comentario de la base de datos
                    String query = "DELETE FROM opiniones WHERE id = ?";
                    PreparedStatement statement = conn.prepareStatement(query);
                    statement.setString(1, selectedId);
                    int rowsDeleted = statement.executeUpdate();

                    // Verificar si se eliminó correctamente el comentario
                    if (rowsDeleted > 0) {
                        // Eliminación exitosa, mostrar mensaje de éxito
                        JOptionPane.showMessageDialog(null, "Comentario eliminado correctamente.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);

                        // Recargar los comentarios en el JComboBox después de eliminar el comentario
                        cargarOpiniones();

                        // Limpiar el JTextArea
                        jTextFieldComentario.setText("");
                    } else {
                        // No se eliminó ningún comentario, mostrar mensaje de error
                        JOptionPane.showMessageDialog(null, "Error al eliminar el comentario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al eliminar el comentario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // No se seleccionó ningún comentario, mostrar mensaje de error
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un comentario único a eliminar sin filtrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarComentarioActionPerformed

    private void jTextFieldFiltrarIDProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFiltrarIDProfesorActionPerformed
        // Obtener el ID del profesor ingresado por el usuario desde el JTextField
        String idProfesorText = jTextFieldFiltrarIDProfesor.getText().trim();

        if (!idProfesorText.isEmpty()) {
            try {
                int idProfesor = Integer.parseInt(idProfesorText);
                // Llamar al método cargarOpinionesFiltradas con el ID del profesor
                cargarOpinionesFiltradas(idProfesor);
            } catch (NumberFormatException ex) {
                // Manejar el caso en que el usuario ingrese un valor no numérico
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico para el ID del profesor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Manejar el caso en que el usuario no ingrese ningún valor
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de profesor para filtrar las opiniones.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldFiltrarIDProfesorActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // Obtener el ID del profesor ingresado por el usuario desde el JTextField
        String idProfesorText = jTextFieldFiltrarIDProfesor.getText().trim();

        if (!idProfesorText.isEmpty()) {
            try {
                int idProfesor = Integer.parseInt(idProfesorText);
                // Llamar al método cargarOpinionesFiltradas con el ID del profesor
                cargarOpinionesFiltradas(idProfesor);
            } catch (NumberFormatException ex) {
                // Manejar el caso en que el usuario ingrese un valor no numérico
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico para el ID del profesor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Manejar el caso en que el usuario no ingrese ningún valor
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de profesor para filtrar las opiniones.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        // Verificar si se han encontrado comentarios, de lo contrario, mostrar un mensaje en el jTextFieldComentario
        if (jTextFieldComentario.getText().isEmpty()) {
            jTextFieldComentario.setText("No se encontraron comentarios para el ID del profesor ingresado.");
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonEliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarAlumnoActionPerformed
        // Comprueba que haya algún ID seleccionado para eliminar
        if (jComboBoxIDAlumnos.getSelectedIndex() != 0) {
            // Ventana de confirmación antes de eliminar
            if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar el alumno?", "Eliminar alumno", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
                // Elimina los datos del ID de alumno seleccionado
                try {
                    PreparedStatement st = conn.prepareStatement("DELETE FROM alumnos WHERE id = ?");
                    st.setInt(1, Integer.parseInt(jComboBoxIDAlumnos.getSelectedItem().toString()));
                    if (st.executeUpdate() == 1) {
                        JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        jComboBoxIDAlumnos.removeItemAt(jComboBoxIDAlumnos.getSelectedIndex());

                        // Limpia los campos de texto y ComboBoxes
                        jTextFieldDNIAlumno.setText("");
                        jTextFieldNombreAlumno.setText("");
                        jTextFieldApellidoAlumno.setText("");
                        jTextFieldCorreoAlumno.setText("");
                        jComboBoxNivelAlumno.setSelectedIndex(0); // Asumiendo que el primer índice es una opción vacía o "seleccione nivel"
                        jComboBoxIDProfesorAlumno.setSelectedIndex(0); // Asumiendo que el primer índice es una opción vacía o "seleccione profesor"
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el alumno.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hace falta seleccionar un ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarAlumnoActionPerformed

    private void jTextFieldDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescripcionActionPerformed
// Método para cargar las opiniones filtradas por el ID del profesor

    private void cargarOpinionesFiltradas(int idProfesor) {
        // Limpiar el campo de comentario antes de cargar las nuevas opiniones
        jTextFieldComentario.setText("");

        try {
            // Realizar la consulta para obtener las opiniones filtradas por el ID del profesor
            String query = "SELECT o.comentario, o.dni_alumno FROM opiniones o JOIN profesores p ON o.profesor_id = p.id WHERE p.id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idProfesor);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder comentarios = new StringBuilder();
            // Recorrer los resultados y construir un StringBuilder con los comentarios y los DNIs de los alumnos
            while (resultSet.next()) {
                String comentario = resultSet.getString("comentario");
                String dniAlumno = resultSet.getString("dni_alumno");
                comentarios.append("DNI del alumno: ").append(dniAlumno).append("\n");
                comentarios.append("Comentario: ").append(comentario).append("\n\n");
            }

            // Mostrar los comentarios en el JTextFieldComentario
            jTextFieldComentario.setText(comentarios.toString());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(PantallaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PantallaEditar dialog = new PantallaEditar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonEliminarAlumno;
    private javax.swing.JButton jButtonEliminarComentario;
    private javax.swing.JButton jButtonEliminarProfesor;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificarAlumno;
    private javax.swing.JButton jButtonModificarProfesor;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxIDAlumnos;
    private javax.swing.JComboBox<String> jComboBoxIDProfesorAlumno;
    private javax.swing.JComboBox<String> jComboBoxIDProfesores;
    private javax.swing.JComboBox<String> jComboBoxNivelAlumno;
    private javax.swing.JComboBox<String> jComboBoxNivelProfesor;
    private javax.swing.JComboBox<String> jComboBoxOPINIONES;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldApellidoAlumno;
    private javax.swing.JTextField jTextFieldApellidoProfesor;
    private javax.swing.JTextArea jTextFieldComentario;
    private javax.swing.JTextField jTextFieldCorreoAlumno;
    private javax.swing.JTextField jTextFieldCorreoProfesor;
    private javax.swing.JTextField jTextFieldDNIAlumno;
    private javax.swing.JTextField jTextFieldDNIProfesor;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldFiltrarIDProfesor;
    private javax.swing.JTextField jTextFieldNombreAlumno;
    private javax.swing.JTextField jTextFieldNombreProfesor;
    // End of variables declaration//GEN-END:variables
}
