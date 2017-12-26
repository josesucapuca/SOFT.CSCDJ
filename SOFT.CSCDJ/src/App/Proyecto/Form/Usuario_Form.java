/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Form;

import App.Proyecto.Controlador.Interface.InterfacePersonaDAO;
import App.Proyecto.Controlador.Interface.InterfaceUsuarioDAO;
import App.Proyecto.DAO.PersonaDAO;
import App.Proyecto.DAO.UsuarioDAO;
import App.Proyecto.Modelo.Funciones;
import App.Proyecto.Modelo.Persona;
import App.Proyecto.Modelo.Usuario;
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
public class Usuario_Form extends javax.swing.JFrame {

    InterfacePersonaDAO al = new PersonaDAO();
    InterfaceUsuarioDAO usu = new UsuarioDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    Funciones Fun = new Funciones();
    public static int id_Persona = 0;
    public static int id_Usuario = 0;
    String Estado_Usuario = null;

    /**
     *
     * Creates new form Usuario
     */
    public Usuario_Form() {
        initComponents();
        pintarLabel("src/App/Proyecto/Imagenes/fondo_celeste.jpg", imgFondo);
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo);
        modelo.addColumn("Id_Persona");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("DNI");
        modelo.addColumn("Tipo");
        JtPersona.setModel(modelo);
        ListarPersona();
        cagarcombo();
        cmbEstado_Usuario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "ACTIVADO":
                        Estado_Usuario = "1";
                        break;
                    case "DESACTIVADO":
                        Estado_Usuario = "0";
                        break;
                    case "--":
                        Estado_Usuario = "";
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

    public void cagarcombo() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        modelito.addElement("--");
        modelito.addElement("ACTIVADO");
        modelito.addElement("DESACTIVADO");
        cmbEstado_Usuario.setModel(modelito);
    }

    public void ListarPersona() {
        DefaultTableModel model = (DefaultTableModel) JtPersona.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        List<Persona> p = al.ListarPersona();
        for (int i = 0; i < p.size(); i++) {
            String tipo_Persona = null;
            Persona per = new Persona();
            per = (Persona) p.get(i);
            if (per.getLi_Tipo_Persona() != null) {
                switch (per.getLi_Tipo_Persona()) {
                    case "1":
                        tipo_Persona = "Alumno";
                        break;
                    case "2":
                        tipo_Persona = "Profesor";
                        break;
                    case "3":
                        tipo_Persona = "Director";
                        break;
                }
            } else {

            }
            model.addRow(new Object[]{per.getId_Persona(), per.getNombre_Persona(), per.getApellido_Paterno(), per.getApellido_Materno(), per.getDni(), tipo_Persona});
        }
        JtPersona.setModel(model);
    }

    public void ListarUsuario(JTable usuarios) {
        DefaultTableModel model = (DefaultTableModel) usuarios.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        List<Usuario> p = usu.Listar_Usuarios();
        for (int i = 0; i < p.size(); i++) {
            String Estado_Usuario = null;
            String Fecha_Vencimiento = null;
            String Li_tipo_Persona = null;
            Usuario us = new Usuario();
            us = (Usuario) p.get(i);
            if (us.getEstado_Usuario() != null) {
                switch (us.getEstado_Usuario()) {
                    case "1":
                        Estado_Usuario = "ACTIVADO";
                        break;
                    case "0":
                        Estado_Usuario = "DESACTIVADO";
                        break;
                }
            } else {
                Estado_Usuario = "No registrado";
            }
            if (us.getFe_Vencimiento() != null) {
                Fecha_Vencimiento = us.getFe_Vencimiento();
            } else {
                Fecha_Vencimiento = "Sin Limite";
            }
            if (us.getLi_tipo_persona() != null) {
                switch (us.getLi_tipo_persona()) {
                    case "1":
                        Li_tipo_Persona = "Alumno";
                        break;
                    case "2":
                        Li_tipo_Persona = "Docente";
                        break;
                    case "3":
                        Li_tipo_Persona = "Director";
                        break;
                }
            } else {
                Fecha_Vencimiento = "No registrado";
            }
            model.addRow(new Object[]{us.getId_persona(), us.getPersona(), us.getId_Usuario(), us.getNombre_Usuario(), us.getPassword(), Estado_Usuario, Fecha_Vencimiento, Li_tipo_Persona});
        }
        usuarios.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        MenSeleccionar = new javax.swing.JMenuItem();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtPersona = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPersona = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnRegistrarUsuario = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordRe = new javax.swing.JPasswordField();
        txtFecha_Vencimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        cmbEstado_Usuario = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        imgBarraTitulo = new javax.swing.JLabel();
        imgFondo = new javax.swing.JLabel();

        MenSeleccionar.setText("Seleccionar");
        MenSeleccionar.setToolTipText("");
        MenSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenSeleccionarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MenSeleccionar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 104, 179));
        jLabel3.setText("PERSONAS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 80, 20));

        JtPersona.setModel(new javax.swing.table.DefaultTableModel(
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
        JtPersona.setComponentPopupMenu(jPopupMenu1);
        JtPersona.setGridColor(new java.awt.Color(0, 0, 0));
        JtPersona.setSelectionBackground(new java.awt.Color(154, 211, 243));
        jScrollPane1.setViewportView(JtPersona);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 740, 270));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Persona:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lbltitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(204, 255, 255));
        lbltitle.setText("Registrar Usuario");
        getContentPane().add(lbltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Repetir Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 210, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));
        getContentPane().add(txtPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 210, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fecha Vencimiento:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 130, -1));

        btnAtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 140, 40));

        btnRegistrarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarUsuario.setText("Registrar");
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 150, 40));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 210, 30));

        txtPasswordRe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtPasswordRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 210, 30));
        getContentPane().add(txtFecha_Vencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 190, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Estado Usaurio:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        cmbEstado_Usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbEstado_Usuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbEstado_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Password:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        imgBarraTitulo.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 730, 40));
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenSeleccionarActionPerformed
        // TODO add your handling code here:
        int fila = JtPersona.getSelectedRow();
        id_Persona = (int) JtPersona.getValueAt(fila, 0);
        List<Persona> list = al.ListarPersona_id(id_Persona);
        if (list.size() > 0) {
            Persona per = new Persona();
            per = (Persona) list.get(0);
            txtPersona.setText(per.getNombre_Persona() + " " + per.getApellido_Paterno() + " " + per.getApellido_Materno());

        }

    }//GEN-LAST:event_MenSeleccionarActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        if (txtUsuario.getText().length() == 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        // TODO add your handling code here:
        if (btnRegistrarUsuario.getText().equals("Registrar")) {
            String Contraseña = txtPassword.getText();
            String Contraseña2 = txtPasswordRe.getText();
            String fecha_venc;
            if (txtFecha_Vencimiento.getDate() != null) {
                fecha_venc = Fun.getFecha(txtFecha_Vencimiento);
            } else {
                fecha_venc = "";
            }
            if (!txtPersona.getText().equals("") && !txtPassword.getText().equals("") && !txtPasswordRe.getText().equals("") && !fecha_venc.equals("") && Estado_Usuario != null) {
                if (Contraseña == null ? Contraseña2 == null : Contraseña.equals(Contraseña2)) {
                    if (!Estado_Usuario.equals("")) {
                        usu.Insertar_Usuarios(id_Persona, txtUsuario.getText(), txtPassword.getText(), Fun.getFecha(txtFecha_Vencimiento), Estado_Usuario);
                        this.dispose();
                        ListarUsuario(CRUD_Usuario.tblUsuarios);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingresar datos completos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Las Contraseñas no coinciden");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresar datos completos");
            }
        } else if (btnRegistrarUsuario.getText().equals("Modificar")) {
            btnRegistrarUsuario.setText("Registrar");
            lbltitle.setText("Registrar Usuario");
            String Contraseña = txtPassword.getText();
            String Contraseña2 = txtPasswordRe.getText();
            String fecha_venc;
            if (txtFecha_Vencimiento.getDate() != null) {
                fecha_venc = Fun.getFecha(txtFecha_Vencimiento);
            } else {
                fecha_venc = "";
            }
            if (!txtPersona.getText().equals("") && !txtPassword.getText().equals("") && !txtPasswordRe.getText().equals("") && !fecha_venc.equals("") && Estado_Usuario != null) {
                if (Contraseña == null ? Contraseña2 == null : Contraseña.equals(Contraseña2)) {
                    if (!Estado_Usuario.equals("")) {
                        JOptionPane.showMessageDialog(null, Integer.toString(id_Persona) + " " + Integer.toString(id_Usuario));
                        usu.Modificar_Usuario(id_Usuario, id_Persona, txtUsuario.getText(), txtPassword.getText(), Fun.getFecha(txtFecha_Vencimiento), Estado_Usuario);
                        this.dispose();
                        ListarUsuario(CRUD_Usuario.tblUsuarios);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingresar datos completos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Las Contraseñas no coinciden");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresar datos completos");
            }
            MenSeleccionar.setEnabled(true);
        }

    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtPersona;
    public static javax.swing.JMenuItem MenSeleccionar;
    private javax.swing.JButton btnAtras;
    public static javax.swing.JButton btnRegistrarUsuario;
    public static javax.swing.JComboBox cmbEstado_Usuario;
    private javax.swing.JLabel imgBarraTitulo;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbltitle;
    public static com.toedter.calendar.JDateChooser txtFecha_Vencimiento;
    public static javax.swing.JPasswordField txtPassword;
    public static javax.swing.JPasswordField txtPasswordRe;
    public static javax.swing.JTextField txtPersona;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
