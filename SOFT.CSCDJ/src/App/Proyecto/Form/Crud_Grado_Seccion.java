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
import static App.Proyecto.Form.CRUD_Materia.nom_persona;
import static App.Proyecto.Form.CRUD_Materia.nom_usuario;
import App.Proyecto.Modelo.Grado_SeccionComp;
import App.Proyecto.Modelo.Seccion;
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
public class Crud_Grado_Seccion extends javax.swing.JFrame {

    InterfaceSeccionDAO sec = new SeccionDAO();
    InterfaceGradoSeccionDAO gs = new GradoSeccionAO();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    public static String nom_usuario;
    public static String nom_persona;

    /**
     * Creates new form Crud_Grado_Seccion
     */
    public Crud_Grado_Seccion() {
        initComponents();
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo);
        pintarLabel("src/App/Proyecto/Imagenes/fondo_celeste.jpg", imgFondo);
        modelo.addColumn("id seccion");
        modelo.addColumn("Seccion");
        modelo.addColumn("Estado_Seccion");
        modelo1.addColumn("id Grado");
        modelo1.addColumn("Nombre Grado");
        modelo1.addColumn("id Seccion");
        modelo1.addColumn("Seccion");
        modelo1.addColumn("Nivel");
        modelo1.addColumn("Estado Grado");
        tblSeccion.setModel(modelo);
        tblGradoSeccion.setModel(modelo1);
        ListarSeccion();
        ListarGrado();
    }

    public void pintarLabel(String url, JLabel obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth(), obj.getHeight(), Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    public void ListarSeccion() {
        DefaultTableModel model = (DefaultTableModel) tblSeccion.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        List<Seccion> p = sec.Listar_Seccion();
        for (int i = 0; i < p.size(); i++) {
            String Est_Seccion = null;
            Seccion s = new Seccion();
            s = (Seccion) p.get(i);
            if (s.getEstado_Seccion().equals("1")) {
                Est_Seccion = "Activado";
            } else if (s.getEstado_Seccion().equals("0")) {
                Est_Seccion = "Desactivado";
            }
            model.addRow(new Object[]{s.getId_seccion(), s.getNombre_Seccion(), Est_Seccion});
        }
        tblSeccion.setModel(model);
    }

    public void ListarGrado() {
        DefaultTableModel model = (DefaultTableModel) tblGradoSeccion.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        List<Grado_SeccionComp> p = gs.Listar_Grado_Seccion();
        for (int i = 0; i < p.size(); i++) {
            String id_Seccion = null;
            String Nombre_Seccion = null;
            String Nivel = null;
            String EstadoGrado = null;
            Grado_SeccionComp s = new Grado_SeccionComp();
            s = (Grado_SeccionComp) p.get(i);
            if (s.getId_Seccion() != null) {
                id_Seccion = "SIN ASIGNAR";
            } else {
                id_Seccion = s.getId_Seccion();
            }
            if (s.getSeccion() != null) {
                Nombre_Seccion = s.getSeccion();
            } else {
                Nombre_Seccion = "SIN ASIGNAR";
            }
            switch (s.getLi_Nivel()) {
                case "1":
                    Nivel = "INICIAL";
                    break;
                case "2":
                    Nivel = "PRIMARIA";
                    break;
                case "3":
                    Nivel = "PRE-SECUNDARIA";
                    break;
            }
            switch (s.getEstado_Grado()) {
                case "1":
                    EstadoGrado = "ACTIVO";
                    break;
                case "0":
                    EstadoGrado = "INACTIVO";
                    break;
            }
            model.addRow(new Object[]{s.getId_Grado(), s.getNombre_Grado(), id_Seccion, Nombre_Seccion, Nivel, EstadoGrado});
        }
        tblGradoSeccion.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuOpciones = new javax.swing.JPopupMenu();
        MenModificar = new javax.swing.JMenuItem();
        MenActivar = new javax.swing.JMenuItem();
        MenDesactivar = new javax.swing.JMenuItem();
        IngresarDatos1 = new javax.swing.JLabel();
        imgBarraTitulo = new javax.swing.JLabel();
        btnRegistrarGrado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSeccion = new javax.swing.JTable();
        btn_RegistrarSeccion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGradoSeccion = new javax.swing.JTable();
        btnRegistrarGrado1 = new javax.swing.JButton();
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
        IngresarDatos1.setText("Formulario Grado Seccion");
        getContentPane().add(IngresarDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        imgBarraTitulo.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, 40));

        btnRegistrarGrado.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarGrado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarGrado.setForeground(new java.awt.Color(102, 153, 255));
        btnRegistrarGrado.setText("<html><p>Registrar Grado</p><p>Seccion</p></html>");
        btnRegistrarGrado.setToolTipText("Registrar Grado Seccion");
        btnRegistrarGrado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrarGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarGradoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 130, -1));

        tblSeccion.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSeccion.setComponentPopupMenu(MenuOpciones);
        jScrollPane1.setViewportView(tblSeccion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 510, 190));

        btn_RegistrarSeccion.setBackground(new java.awt.Color(255, 255, 255));
        btn_RegistrarSeccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_RegistrarSeccion.setForeground(new java.awt.Color(102, 153, 255));
        btn_RegistrarSeccion.setText("<html><p>Registrar</p><p>Seccion</p></html>"); // NOI18N
        btn_RegistrarSeccion.setToolTipText("Registrar Seccion");
        btn_RegistrarSeccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_RegistrarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarSeccionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RegistrarSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 130, 50));

        tblGradoSeccion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblGradoSeccion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 510, 190));

        btnRegistrarGrado1.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarGrado1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarGrado1.setForeground(new java.awt.Color(102, 153, 255));
        btnRegistrarGrado1.setText("ATRAS");
        btnRegistrarGrado1.setToolTipText("Registrar Grado Seccion");
        btnRegistrarGrado1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrarGrado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarGrado1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarGrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 130, 40));
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarGradoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnRegistrarGradoActionPerformed

    private void btn_RegistrarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarSeccionActionPerformed
        // TODO add your handling code here:
        JFrame frame = new Form_Seccion();
        frame.setTitle("Registrar Seccion");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Form_Seccion.lblTitulo.setText("Modificar Seccion");
    }//GEN-LAST:event_btn_RegistrarSeccionActionPerformed

    private void MenModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenModificarActionPerformed
        // TODO add your handling code here:

        String nombre_seccion;
        int nrofilas = tblSeccion.getSelectedRowCount();
        int fila = tblSeccion.getSelectedRow();
        if (nrofilas > 0) {
            nombre_seccion = (String) tblSeccion.getValueAt(fila, 1);
            JFrame frame = new Form_Seccion();
            frame.setTitle("Modificar Seccion");
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            Form_Seccion.lblTitulo.setText("Modificar Seccion");
            Form_Seccion.btnRegistrarSeccion.setText("Modificar");
            Form_Seccion.txtSeccion.setText((String) tblSeccion.getValueAt(fila, 1));
            Form_Seccion.id_seccion = (int) tblSeccion.getValueAt(fila, 0);
            if (tblSeccion.getValueAt(fila, 2).equals("Activado")) {
                Form_Seccion.cmbEstadoSeccion.setSelectedItem("ACTIVO");
            } else if (tblSeccion.getValueAt(fila, 2).equals("Desactivado")) {
                Form_Seccion.cmbEstadoSeccion.setSelectedItem("INACTIVO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar Seccion");
        }
    }//GEN-LAST:event_MenModificarActionPerformed

    private void MenActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenActivarActionPerformed
        // TODO add your handling code here:
        int id_seccion;
        String nombre_seccion;
        int nrofilas = tblSeccion.getSelectedRowCount();
        int fila = tblSeccion.getSelectedRow();
        if (nrofilas > 0) {
            id_seccion = (int) tblSeccion.getValueAt(fila, 0);
            nombre_seccion = (String) tblSeccion.getValueAt(fila, 1);
            if (tblSeccion.getValueAt(fila, 2).equals("Activado")) {
                JOptionPane.showMessageDialog(null, "Ya esta activado");
            } else if (tblSeccion.getValueAt(fila, 2).equals("Desactivado")) {
                sec.Modificar_Seccion(id_seccion, nombre_seccion, "1");
                ListarSeccion();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar Seccion");
        }
    }//GEN-LAST:event_MenActivarActionPerformed

    private void MenDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenDesactivarActionPerformed
        // TODO add your handling code here:
        int id_seccion;
        String nombre_seccion;
        int nrofilas = tblSeccion.getSelectedRowCount();
        int fila = tblSeccion.getSelectedRow();
        if (nrofilas > 0) {
            id_seccion = (int) tblSeccion.getValueAt(fila, 0);
            nombre_seccion = (String) tblSeccion.getValueAt(fila, 1);
            if (tblSeccion.getValueAt(fila, 2).equals("Activado")) {
                sec.Modificar_Seccion(id_seccion, nombre_seccion, "0");
                ListarSeccion();
            } else if (tblSeccion.getValueAt(fila, 2).equals("Desactivado")) {
                JOptionPane.showMessageDialog(null, "Ya esta Desactivado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar Seccion");
        }
    }//GEN-LAST:event_MenDesactivarActionPerformed

    private void btnRegistrarGrado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarGrado1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrame frame = new Principal_Administrador();
        frame.setTitle("MENU");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Principal_Administrador.lblUsuario.setText(nom_usuario);
        Principal_Administrador.lblPersona.setText(nom_persona);
    }//GEN-LAST:event_btnRegistrarGrado1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IngresarDatos1;
    private javax.swing.JMenuItem MenActivar;
    private javax.swing.JMenuItem MenDesactivar;
    private javax.swing.JMenuItem MenModificar;
    private javax.swing.JPopupMenu MenuOpciones;
    private javax.swing.JButton btnRegistrarGrado;
    private javax.swing.JButton btnRegistrarGrado1;
    private javax.swing.JButton btn_RegistrarSeccion;
    private javax.swing.JLabel imgBarraTitulo;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblGradoSeccion;
    public static javax.swing.JTable tblSeccion;
    // End of variables declaration//GEN-END:variables
}
