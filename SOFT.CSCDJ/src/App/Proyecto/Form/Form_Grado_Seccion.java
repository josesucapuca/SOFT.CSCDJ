/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Form;

import App.Proyecto.Controlador.Interface.InterfaceGradoSeccionDAO;
import App.Proyecto.Controlador.Interface.InterfaceSeccionDAO;
import App.Proyecto.DAO.GradoSeccionAO;
import App.Proyecto.DAO.SeccionDAO;
import App.Proyecto.Modelo.Seccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author user
 */
public class Form_Grado_Seccion extends javax.swing.JFrame {

    /**
     * Creates new form Form_Grado_Seccion
     */
    String Li_Nivel;
    int id_seccion;
    InterfaceGradoSeccionDAO igs = new GradoSeccionAO();
    InterfaceSeccionDAO sec = new SeccionDAO();

    public Form_Grado_Seccion() {
        initComponents();

        cmbNivelGrado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "SIN SECCION":
                        Li_Nivel = null;
                        break;
                    case "INICIAL":
                        Li_Nivel = "1";
                        break;
                    case "PRIMARIA":
                        Li_Nivel = "2";
                        break;
                    case "PRE-SECUNDARIA":
                        Li_Nivel = "3";
                        break;
                }
            }

        });
        cmbEstadoGrado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "--":
                        Li_Nivel = null;
                        break;
                    case "ACTIVO":
                        Li_Nivel = "1";
                        break;
                    case "INACTIVO":
                        Li_Nivel = "2";
                        break;
                }
            }

        });
        cmbSeccion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                if (valor.equals("SIN ASIGNAR")) {
                    id_seccion = 0;
                } else {
                    id_seccion = igs.LIstar_SeccionxNombre(valor);
                }
            }

        });
    }

    public void CargarCombo() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        modelito.addElement("--");
        modelito.addElement("ACTIVO");
        modelito.addElement("INACTIVO");
        cmbEstadoGrado.setModel(modelito);
        DefaultComboBoxModel modelito2 = new DefaultComboBoxModel();
        modelito2.addElement("--");
        modelito2.addElement("INICIAL");
        modelito2.addElement("PRIMARIA");
        modelito2.addElement("PRE-SECUNDARIA");
        cmbNivelGrado.setModel(modelito2);
    }

    public void CargarSeccion() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        modelito.addElement("SIN ASIGNAR");
        List<Seccion> p = sec.Listar_Seccion();
        for (int i = 0; i < p.size(); i++) {
            Seccion s = new Seccion();
            s = (Seccion) p.get(i);
            modelito.addElement(s.getNombre_Seccion());
        }
        cmbSeccion.setModel(modelito);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        imgBarraTitulo = new javax.swing.JLabel();
        txtNombreGrado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnRegistrarGrado = new javax.swing.JButton();
        cmbSeccion = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmbNivelGrado = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cmbEstadoGrado = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registrar Grado");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        imgBarraTitulo.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 630, 40));

        txtNombreGrado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombreGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreGradoActionPerformed(evt);
            }
        });
        txtNombreGrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreGradoKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombreGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 120, 30));

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Grado");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 60, 20));

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(102, 153, 255));
        btnAtras.setText("Atras");
        btnAtras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 120, 40));

        btnRegistrarGrado.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarGrado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarGrado.setForeground(new java.awt.Color(102, 153, 255));
        btnRegistrarGrado.setText("Registrar");
        btnRegistrarGrado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrarGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarGradoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 120, 40));

        cmbSeccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 100, 30));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Nivel");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 80, 20));

        cmbNivelGrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbNivelGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 100, 30));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Seccion");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 80, 20));

        cmbEstadoGrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbEstadoGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 100, 30));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Estado Grado");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 80, 20));

        imgFondo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreGradoActionPerformed

    private void txtNombreGradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreGradoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtNombreGrado.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreGradoKeyTyped

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnRegistrarGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarGradoActionPerformed
        // TODO add your handling code here:
        switch (btnRegistrarGrado.getText()) {
            case "Registrar":

                break;
            case "Modificar":

                break;
        }
    }//GEN-LAST:event_btnRegistrarGradoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    public static javax.swing.JButton btnRegistrarGrado;
    private javax.swing.JComboBox cmbEstadoGrado;
    private javax.swing.JComboBox cmbNivelGrado;
    private javax.swing.JComboBox cmbSeccion;
    private javax.swing.JLabel imgBarraTitulo;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel lblTitulo;
    public static javax.swing.JTextField txtNombreGrado;
    // End of variables declaration//GEN-END:variables
}
