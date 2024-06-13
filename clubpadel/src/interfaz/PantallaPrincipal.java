/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;



/**
 *
 * @author  javier
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/interfaz/img/tenis.png")).getImage());
        getContentPane().setBackground(new Color(255,250,205));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButtonAñadir = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonClases = new javax.swing.JButton();
        jButtonHTML = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Menú");

        jPanel3.setBackground(new java.awt.Color(255, 250, 205));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 50, 50));

        jButtonAñadir.setBackground(new java.awt.Color(0, 255, 0));
        jButtonAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir64.png"))); // NOI18N
        jButtonAñadir.setText("AÑADIR ALUMNO / PROFESOR");
        jButtonAñadir.setContentAreaFilled(false);
        jButtonAñadir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAñadir.setMargin(new java.awt.Insets(1, 8, 1, 8));
        jButtonAñadir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir96.png"))); // NOI18N
        jButtonAñadir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir96.png"))); // NOI18N
        jButtonAñadir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAñadir);

        jButtonModificar.setBackground(new java.awt.Color(255, 165, 0));
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar64.png"))); // NOI18N
        jButtonModificar.setText("MODIFICAR/ELIMINAR - ALUMNO / PROFESOR / OPINIÓN");
        jButtonModificar.setContentAreaFilled(false);
        jButtonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar96.png"))); // NOI18N
        jButtonModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar96.png"))); // NOI18N
        jButtonModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonModificar);

        jButtonConsultar.setBackground(new java.awt.Color(173, 216, 230));
        jButtonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/consultar64.png"))); // NOI18N
        jButtonConsultar.setText("CONSULTAR ALUMNO - PROFESOR");
        jButtonConsultar.setContentAreaFilled(false);
        jButtonConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConsultar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/consultar96.png"))); // NOI18N
        jButtonConsultar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/consultar96.png"))); // NOI18N
        jButtonConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonConsultar);

        jButtonSalir.setBackground(new java.awt.Color(105, 105, 105));
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir64.png"))); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir96.png"))); // NOI18N
        jButtonSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir96.png"))); // NOI18N
        jButtonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSalir);

        jButtonClases.setBackground(new java.awt.Color(255, 165, 0));
        jButtonClases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clases64.png"))); // NOI18N
        jButtonClases.setText("         REGISTRO Nº ALUMNOS POR PROFESOR");
        jButtonClases.setContentAreaFilled(false);
        jButtonClases.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonClases.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clases96.png"))); // NOI18N
        jButtonClases.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clases96.png"))); // NOI18N
        jButtonClases.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClasesActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonClases);

        jButtonHTML.setBackground(new java.awt.Color(255, 165, 0));
        jButtonHTML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/web64.png"))); // NOI18N
        jButtonHTML.setText("WEB 200X100");
        jButtonHTML.setContentAreaFilled(false);
        jButtonHTML.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonHTML.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/web96.png"))); // NOI18N
        jButtonHTML.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/web96.png"))); // NOI18N
        jButtonHTML.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonHTML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHTMLActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonHTML);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/img/200x100padel.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        //Se cierra el programa
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        //Se abre la pantalla para consultar
        PantallaConsultar pc = new PantallaConsultar(this, true);
        pc.setVisible(true);
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirActionPerformed
        //Se abre la pantalla para añadir
        PantallaAñadir pa = new PantallaAñadir(this, true);
        pa.setVisible(true); 
    }//GEN-LAST:event_jButtonAñadirActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        //Se abre la pantalla para editar o eliminar registros
        PantallaEditar pe = new PantallaEditar(this, true);
        pe.setVisible(true);
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClasesActionPerformed
        //Se abre la pantalla para clases
        PantallaClases pc = new PantallaClases(this, true);
        pc.setVisible(true);
    }//GEN-LAST:event_jButtonClasesActionPerformed

    private void jButtonHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHTMLActionPerformed
   // URL del servidor local donde se está ejecutando tu proyecto
    String urlLocalhost = "http://localhost:3000"; // 

    // Llama al método para abrir la URL del servidor local en el navegador
    abrirURLenNavegador(urlLocalhost);

}

private void abrirURLenNavegador(String url) {
    // Verifica si el Desktop es compatible (disponible en la plataforma actual)
    if (Desktop.isDesktopSupported()) {
        // Obtiene una instancia de Desktop
        Desktop desktop = Desktop.getDesktop();
        try {
            // Abre la URL en el navegador predeterminado
            desktop.browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            // Maneja cualquier excepción (por ejemplo, URL no válida)
            e.printStackTrace();
        }
    } else {
        // Desktop no es compatible, imprime un mensaje de error
        System.out.println("El Desktop no es compatible con esta plataforma");
    }
    }//GEN-LAST:event_jButtonHTMLActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadir;
    private javax.swing.JButton jButtonClases;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonHTML;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
