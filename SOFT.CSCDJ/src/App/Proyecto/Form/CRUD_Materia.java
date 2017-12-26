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
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class CRUD_Materia extends javax.swing.JFrame {

    InterfaceMateriaDAO mtr = new MateriaDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    public static String nom_usuario;
    public static String nom_persona;

    /**
     * Creates new form CRUD_Materia
     */
    public CRUD_Materia() {
        initComponents();
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo);
        pintarLabel("src/App/Proyecto/Imagenes/fondo_celeste.jpg", imgFondo);
        modelo.addColumn("id Materia");
        modelo.addColumn("Nombre Materia");
        modelo.addColumn("Tipo Materia");
        modelo.addColumn("Estado Materia");
        tblMateria.setModel(modelo);
        ListarMateria();
    }

    public void pintarLabel(String url, JLabel obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth(), obj.getHeight(), Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    public void ListarMateria() {
        DefaultTableModel model = (DefaultTableModel) tblMateria.getModel();
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
        tblMateria.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuOpciones = new javax.swing.JPopupMenu();
        MenModificar = new javax.swing.JMenuItem();
        MenActivar = new javax.swing.JMenuItem();
        MenDesactivar = new javax.swing.JMenuItem();
        IngresarDatos1 = new javax.swing.JLabel();
        imgBarraTitulo = new javax.swing.JLabel();
        btn_RegistrarSeccion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateria = new javax.swing.JTable();
        btnAtras = new javax.swing.JToggleButton();
        IngresarDatos2 = new javax.swing.JLabel();
        imgFondo = new javax.swing.JLabel();

        MenModificar.setText("Modificar Seccion");
        MenModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenModificarActionPerformed(evt);
            }
        });
        MenuOpciones.add(MenModificar);

        MenActivar.setText("Activar Seccion");
        MenActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenActivarActionPerformed(evt);
            }
        });
        MenuOpciones.add(MenActivar);

        MenDesactivar.setText("Desactivar Seccion");
        MenDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenDesactivarActionPerformed(evt);
            }
        });
        MenuOpciones.add(MenDesactivar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IngresarDatos1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IngresarDatos1.setForeground(new java.awt.Color(255, 255, 255));
        IngresarDatos1.setText("Formulario Materia");
        getContentPane().add(IngresarDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        imgBarraTitulo.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 830, 40));

        btn_RegistrarSeccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_RegistrarSeccion.setForeground(new java.awt.Color(102, 153, 255));
        btn_RegistrarSeccion.setText("<html><p>Registrar</p><p>Materia</p></html>"); // NOI18N
        btn_RegistrarSeccion.setToolTipText("Registrar Seccion");
        btn_RegistrarSeccion.setBorder(null);
        btn_RegistrarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarSeccionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RegistrarSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 130, 50));

        tblMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMateria.setComponentPopupMenu(MenuOpciones);
        jScrollPane1.setViewportView(tblMateria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 650, 190));

        btnAtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.setBorder(null);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 120, 40));

        IngresarDatos2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IngresarDatos2.setForeground(new java.awt.Color(255, 255, 255));
        IngresarDatos2.setText("GRADO SECCION");
        getContentPane().add(IngresarDatos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegistrarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarSeccionActionPerformed
        // TODO add your handling code here:
        JFrame frame = new FormMateria();
        frame.setTitle("Registrar Materia");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        FormMateria.lblTitulo.setText("Registrar Materia");
    }//GEN-LAST:event_btn_RegistrarSeccionActionPerformed

    private void MenModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenModificarActionPerformed
        // TODO add your handling code here:
        int fila = tblMateria.getSelectedRow();
        int nro = tblMateria.getSelectedRowCount();
        if (nro > 0) {
            JFrame frame = new FormMateria();
            frame.setTitle("Modificar Materia");
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            FormMateria.lblTitulo.setText("Modificar Materia");
            FormMateria.id_Materia = (int) tblMateria.getValueAt(fila, 0);
            FormMateria.cmbEstadoMateria.setSelectedItem((String) tblMateria.getValueAt(fila, 3));
            FormMateria.cmbTipoMateria.setSelectedItem((String) tblMateria.getValueAt(fila, 2));
            FormMateria.txtMateria.setText((String) tblMateria.getValueAt(fila, 1));
            FormMateria.btnRegistrarMateria.setText("Modificar");
        }
    }//GEN-LAST:event_MenModificarActionPerformed

    private void MenActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenActivarActionPerformed
        // TODO add your handling code here:
        int fila = tblMateria.getSelectedRow();
        int nro = tblMateria.getSelectedRowCount();
        if (nro > 0) {
            String Tipo_Materia = null;
            switch (tblMateria.getValueAt(fila, 2).toString().trim()) {
                case "MATERIA CURSOS":
                    Tipo_Materia = "1";
                    break;
                case "MATERIA CONDUCTUAL":
                    Tipo_Materia = "2";
                    break;
                case "MATERIA PARTICIPACIÓN PADRES":
                    Tipo_Materia = "3";
                    break;
            }
            switch (tblMateria.getValueAt(fila, 3).toString().trim()) {
                case "ACTIVO":
                    JOptionPane.showMessageDialog(null, "YA ESTA ACTIVO");
                    break;
                case "INACTIVO":
                    mtr.ModificarMateria((int) tblMateria.getValueAt(fila, 0), (String) tblMateria.getValueAt(fila, 1), Tipo_Materia, "1");
                    ListarMateria();
                    break;
            }
        }
    }//GEN-LAST:event_MenActivarActionPerformed

    private void MenDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenDesactivarActionPerformed
        // TODO add your handling code here:
        int fila = tblMateria.getSelectedRow();
        int nro = tblMateria.getSelectedRowCount();
        if (nro > 0) {
            String Tipo_Materia = null;
            switch (tblMateria.getValueAt(fila, 2).toString().trim()) {
                case "MATERIA CURSOS":
                    Tipo_Materia = "1";
                    break;
                case "MATERIA CONDUCTUAL":
                    Tipo_Materia = "2";
                    break;
                case "MATERIA PARTICIPACIÓN PADRES":
                    Tipo_Materia = "3";
                    break;
            }
            switch (tblMateria.getValueAt(fila, 3).toString().trim()) {
                case "ACTIVO":
                    mtr.ModificarMateria((int) tblMateria.getValueAt(fila, 0), (String) tblMateria.getValueAt(fila, 1), Tipo_Materia, "0");
                    ListarMateria();
                    break;
                case "INACTIVO":
                    JOptionPane.showMessageDialog(null, "YA ESTA DESACTIVO");
                    break;
            }
        }
    }//GEN-LAST:event_MenDesactivarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrame frame = new Principal_Administrador();
        frame.setTitle("MENU");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Principal_Administrador.lblUsuario.setText(nom_usuario);
        Principal_Administrador.lblPersona.setText(nom_persona);
    }//GEN-LAST:event_btnAtrasActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IngresarDatos1;
    private javax.swing.JLabel IngresarDatos2;
    private javax.swing.JMenuItem MenActivar;
    private javax.swing.JMenuItem MenDesactivar;
    private javax.swing.JMenuItem MenModificar;
    private javax.swing.JPopupMenu MenuOpciones;
    private javax.swing.JToggleButton btnAtras;
    private javax.swing.JButton btn_RegistrarSeccion;
    private javax.swing.JLabel imgBarraTitulo;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblMateria;
    // End of variables declaration//GEN-END:variables
}