/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Form;

import App.Proyecto.Controlador.Interface.InterfaceMateriaDAO;
import App.Proyecto.DAO.MateriaDAO;
import App.Proyecto.Modelo.Materia;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class FormMateria extends javax.swing.JFrame {

    /**
     * Creates new form FormMateria
     */
    InterfaceMateriaDAO mtr = new MateriaDAO();
    public static int id_Materia;
    String ti_Materia;
    String Es_Materia;

    public FormMateria() {
        initComponents();
        pintarLabel("src/App/Proyecto/Imagenes/fondo_celeste.jpg", imgFondo);
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo);
        CargarCombo();
        cmbEstadoMateria.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "ACTIVO":
                        Es_Materia = "1";
                        break;
                    case "INACTIVO":
                        Es_Materia = "0";
                        break;
                    case "--":
                        Es_Materia = "";
                        break;
                }
            }

        });
        cmbTipoMateria.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "MATERIA CURSOS":
                        ti_Materia = "1";
                        break;
                    case "MATERIA CONDUCTUAL":
                        ti_Materia = "2";
                        break;
                    case "MATERIA PARTICIPACIÓN PADRES":
                        ti_Materia = "3";
                        break;
                    case "--":
                        ti_Materia = "";
                        break;
                }
            }

        });
    }

    public void pintarLabel(String url, JLabel obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth(), obj.getHeight(), Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    public void CargarCombo() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        modelito.addElement("--");
        modelito.addElement("ACTIVO");
        modelito.addElement("INACTIVO");
        cmbEstadoMateria.setModel(modelito);
        DefaultComboBoxModel modelito2 = new DefaultComboBoxModel();
        modelito2.addElement("--");
        modelito2.addElement("MATERIA CURSOS");
        modelito2.addElement("MATERIA CONDUCTUAL");
        modelito2.addElement("MATERIA PARTICIPACIÓN PADRES");
        cmbTipoMateria.setModel(modelito2);
    }
public void ListarMateria(JTable Seccion) {
        DefaultTableModel model = (DefaultTableModel) Seccion.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        List<Materia> p = mtr.ListarMateria();
        for (int i = 0; i < p.size(); i++) {
           String Tipo_Materia = null;
            String Estado_Materia = null;
            Materia s = new Materia();
            s = (Materia) p.get(i);
            switch (s.getLi_Tipo_Materia()) {
                case "1":
                    Tipo_Materia = "MATERIA CURSOS";
                    break;
                case "2":
                    Tipo_Materia = "MATERIA CONDUCTUAL";
                    break;
                case "3":
                    Tipo_Materia = "MATERIA PARTICIPACIÓN PADRES";
                    break;
            }
            switch (s.getEstado_Materia()) {
                case "1":
                    Estado_Materia = "ACTIVO";
                    break;
                case "0":
                    Estado_Materia = "INACTIVO";
                    break;
            }

            model.addRow(new Object[]{s.getId_Materia(), s.getNombre_Materia(), Tipo_Materia, Estado_Materia});
        }
        Seccion.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMateria = new javax.swing.JTextField();
        cmbEstadoMateria = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnRegistrarMateria = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        imgBarraTitulo = new javax.swing.JLabel();
        cmbTipoMateria = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMateria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMateriaActionPerformed(evt);
            }
        });
        txtMateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMateriaKeyTyped(evt);
            }
        });
        getContentPane().add(txtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 210, 30));

        cmbEstadoMateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbEstadoMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 160, 30));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Estado Materia");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 80, 20));

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Materia");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 60, 20));

        btnAtras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(102, 153, 255));
        btnAtras.setText("Atras");
        btnAtras.setBorder(null);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 120, 40));

        btnRegistrarMateria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarMateria.setForeground(new java.awt.Color(102, 153, 255));
        btnRegistrarMateria.setText("Registrar");
        btnRegistrarMateria.setBorder(null);
        btnRegistrarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMateriaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 120, 40));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registrar Materia");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        imgBarraTitulo.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 730, 40));

        cmbTipoMateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbTipoMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 240, 30));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Tipo Materia");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 80, 20));

        imgFondo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMateriaActionPerformed

    private void txtMateriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMateriaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtMateria.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMateriaKeyTyped

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnRegistrarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMateriaActionPerformed
        // TODO add your handling code here:
        switch (btnRegistrarMateria.getText()) {
            case "Registrar":
                if (!txtMateria.getText().equals("") && !Es_Materia.equals("") && !ti_Materia.equals("")) {
                    mtr.InsertarMateria(txtMateria.getText(), ti_Materia, Es_Materia);
                    this.dispose();
                    ListarMateria(CRUD_Materia.tblMateria);
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresar datos completos");
                }
                break;
            case "Modificar":
                if (!txtMateria.getText().equals("") && !Es_Materia.equals("") && !ti_Materia.equals("")) {
                    mtr.ModificarMateria(id_Materia,txtMateria.getText(), ti_Materia, Es_Materia);
                    this.dispose();
                    ListarMateria(CRUD_Materia.tblMateria);
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresar datos completos");
                }
                break;
        }
    }//GEN-LAST:event_btnRegistrarMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    public static javax.swing.JButton btnRegistrarMateria;
    public static javax.swing.JComboBox cmbEstadoMateria;
    public static javax.swing.JComboBox cmbTipoMateria;
    private javax.swing.JLabel imgBarraTitulo;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel lblTitulo;
    public static javax.swing.JTextField txtMateria;
    // End of variables declaration//GEN-END:variables
}
