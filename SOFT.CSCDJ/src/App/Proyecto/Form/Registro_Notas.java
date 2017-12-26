/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Form;

import App.Proyecto.Controlador.Interface.InterfaceAñoDAO;
import App.Proyecto.Controlador.Interface.InterfaceBimestreDAO;
import App.Proyecto.Controlador.Interface.InterfaceBoletaNotaDAO;
import App.Proyecto.Controlador.Interface.InterfaceListadosDAO;
import App.Proyecto.Controlador.Interface.InterfaceMateriaDAO;
import App.Proyecto.Controlador.Interface.InterfaceMatriculaDAO;
import App.Proyecto.DAO.AnoDAO;
import App.Proyecto.DAO.BimestreDAO;
import App.Proyecto.DAO.BoletaNotaDAO;
import App.Proyecto.DAO.ListadosDAO;
import App.Proyecto.DAO.MateriaDAO;
import App.Proyecto.DAO.MatriculaDAO;
import App.Proyecto.Modelo.Ano;
import App.Proyecto.Modelo.Grado_Seccion;
import App.Proyecto.Modelo.Materia;
import App.Proyecto.Modelo.Matricula;
import App.Proyecto.Modelo.V_Boleta_Nota;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Barrantes Tapia
 */
public class Registro_Notas extends javax.swing.JFrame {

    InterfaceListadosDAO lis = new ListadosDAO();
    InterfaceMateriaDAO m = new MateriaDAO();
    InterfaceMatriculaDAO mat = new MatriculaDAO();
    InterfaceAñoDAO an = new AnoDAO();
    InterfaceBoletaNotaDAO bn = new BoletaNotaDAO();
    InterfaceBimestreDAO bmt = new BimestreDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    public static String nom_usuario;
    public static String nom_persona;
    public static int id_matricula;
    int id_periodo;
    int id_Detalle_Carga_Academica;
    int id_Grado_Seccion;

    /**
     * Creates new form Registro_Notas
     */
    public Registro_Notas() {
        initComponents();
        pintarLabel("src/App/Proyecto/Imagenes/fondo_celeste.jpg", imgFondo);
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo);
        pintar("src/App/Proyecto/Imagenes/buscar.png", btnBuscar);
        modelo.addColumn("Id Det Car Acad");
        modelo.addColumn("Calificación");
        modelo.addColumn("Bimestre");
        modelo.addColumn("Nota");
        modelo.addColumn("Nota en Letra");
        tblNotas.setModel(modelo);
        Cargar_Grado_Seccion();
        Cargar_Año();
        btnBuscar.setEnabled(false);
        cmbAno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Object selected = comboBox.getSelectedItem();
                id_periodo = an.Anoxnombre((String) selected);
            }
        });
        cmbGradoSeccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Object selected = comboBox.getSelectedItem();
                id_Grado_Seccion = lis.Validar_Grado((String) selected);
            }
        });
        cmbMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Object selected = comboBox.getSelectedItem();
                id_Detalle_Carga_Academica = m.ListarIdDcaxNombre((String) selected,id_matricula);
                btnBuscar.setEnabled(true);
            }
        });
    }

    public void pintar(String url, JButton obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth() - 10, obj.getHeight() - 10, Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    public void pintarLabel(String url, JLabel obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth(), obj.getHeight(), Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    public void Cargar_Grado_Seccion() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        List<Grado_Seccion> list = lis.ListarGradoSeccion();
        modelito.addElement("-SELECCIONAR-");
        for (int i = 0; i < list.size(); i++) {
            Grado_Seccion gs = new Grado_Seccion();
            gs = (Grado_Seccion) list.get(i);
            modelito.addElement(gs.getGrado_seccion());
        }
        cmbGradoSeccion.setModel(modelito);
    }

    public void Cargar_Materia() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        List<Materia> list = m.ListarMateria();
        modelito.addElement("-SELECCIONAR-");
        for (int i = 0; i < list.size(); i++) {
            Materia mtr = new Materia();
            mtr = (Materia) list.get(i);
            modelito.addElement(mtr.getNombre_Materia());
        }
        cmbMateria.setModel(modelito);
    }

    public void Cargar_Año() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        modelito.addElement("-SELECCIONAR-");
        List<Ano> list = an.Listar_Ano();
        for (int i = 0; i < list.size(); i++) {
            Ano gs = new Ano();
            gs = (Ano) list.get(i);
            modelito.addElement(gs.getAño());
        }
        cmbAno.setModel(modelito);
    }

    public void ListarAlumno(int id_grado, int id_ano, JTable table) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        List<Matricula> p = mat.Buscar_Matriculaxidgradoxidano(id_grado, id_ano);
        for (int i = 0; i < p.size(); i++) {
            Matricula mat = new Matricula();
            mat = (Matricula) p.get(i);

            modelo.addRow(new Object[]{mat.getId_Persona(), mat.getAlumno(), mat.getDni(), mat.getAño(), mat.getId_Matricula(), mat.getGrado_seccion()});
        }
        table.setModel(modelo);
    }

    public void ListarNotas(int id_Detalle_Carga_Academica) {
        DefaultTableModel model = (DefaultTableModel) tblNotas.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        List<V_Boleta_Nota> p = bn.Lista_VistaBoletaNota(id_Detalle_Carga_Academica);
        if (p.size() > 0) {
            for (int i = 0; i < p.size(); i++) {
            V_Boleta_Nota vbn = new V_Boleta_Nota();
            vbn = (V_Boleta_Nota) p.get(i);
            String Bimestre = bmt.BimestrexId(vbn.getId_Bimestre());
            model.addRow(new Object[]{vbn.getId_Detalle_Carga_Academica(), vbn.getNombre_Calificacion(), Bimestre, vbn.getNota(), vbn.getNota_Letra()});
        }
        tblNotas.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "No tiene Notas introducir");
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

        lbltitle = new javax.swing.JLabel();
        cmbGradoSeccion = new javax.swing.JComboBox();
        lblGrado_Seccion = new javax.swing.JLabel();
        btnIngresarNotas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        cmbMateria = new javax.swing.JComboBox();
        panel1 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        lblAlumno = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblAño = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSeleccionarAlumno = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        imgBarraTitulo = new javax.swing.JLabel();
        btnBuscarCalificacion = new javax.swing.JButton();
        cmbAtras = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cmbAno = new javax.swing.JComboBox();
        lblGrado_Seccion1 = new javax.swing.JLabel();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(204, 255, 255));
        lbltitle.setText("Registrar Nota");
        getContentPane().add(lbltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        cmbGradoSeccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbGradoSeccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbGradoSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 260, 40));

        lblGrado_Seccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGrado_Seccion.setText("Año");
        getContentPane().add(lblGrado_Seccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btnIngresarNotas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIngresarNotas.setText("Modificar");
        btnIngresarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarNotasActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresarNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 590, 150, 40));

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblNotas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 840, 270));

        cmbMateria.setBackground(new java.awt.Color(0, 51, 102));
        cmbMateria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(cmbMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 370, 40));

        panel1.setBackground(new java.awt.Color(92, 195, 222));
        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel1.setForeground(new java.awt.Color(153, 153, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Alumno:");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        lblAlumno.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblAlumno.setText("-----");
        panel1.add(lblAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 240, -1));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setToolTipText("Buscar Alumno");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 60, 50));

        lblAño.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblAño.setText("-----");
        panel1.add(lblAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 70, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Año:");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 110, 40));

        btnSeleccionarAlumno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSeleccionarAlumno.setText("<html><p>Seleccionar</p><p>Alumno</p></html>");
        btnSeleccionarAlumno.setToolTipText("Seleccionar Alumno");
        btnSeleccionarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarAlumnoActionPerformed(evt);
            }
        });
        panel1.add(btnSeleccionarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 840, 70));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Materia");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 250, -1));

        imgBarraTitulo.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 40));

        btnBuscarCalificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarCalificacion.setText("Buscar Notas");
        btnBuscarCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCalificacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 150, 40));

        cmbAtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbAtras.setText("Atras");
        cmbAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(cmbAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 590, 150, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 840, 10));

        cmbAno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, 40));

        lblGrado_Seccion1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGrado_Seccion1.setText("Grado Seccion");
        getContentPane().add(lblGrado_Seccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 130, -1));
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnIngresarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarNotasActionPerformed
        // TODO add your handling code here:
        if (btnBuscar.getText().equals("Registrar")) {

        } else if (btnBuscar.getText().equals("Modificar")) {

        }
    }//GEN-LAST:event_btnIngresarNotasActionPerformed

    private void btnBuscarCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCalificacionActionPerformed
        // TODO add your handling code here:
        ListarNotas(id_Detalle_Carga_Academica);

    }//GEN-LAST:event_btnBuscarCalificacionActionPerformed

    private void cmbAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAtrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrame frame = new Principal_Administrador();
        frame.setTitle("MENU");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Principal_Administrador.lblPersona.setText(nom_persona);
        Principal_Administrador.lblUsuario.setText(nom_usuario);
    }//GEN-LAST:event_cmbAtrasActionPerformed

    private void btnSeleccionarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarAlumnoActionPerformed
        // TODO add your handling code here:
        if (!cmbAno.getSelectedItem().equals("-SELECCIONAR-") && !cmbGradoSeccion.getSelectedItem().equals("-SELECCIONAR-")) {

        }
        JFrame frame = new SeleccionarAlumno();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        ListarAlumno(id_Grado_Seccion, id_periodo, SeleccionarAlumno.tbAlumno);
    }//GEN-LAST:event_btnSeleccionarAlumnoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        lblAlumno.setText("-----");
        lblAño.setText("-----");
        cmbAno.setEnabled(true);
        cmbGradoSeccion.setEnabled(true);
        cmbAno.setSelectedIndex(0);
        cmbGradoSeccion.setSelectedIndex(0);
        id_matricula = 0;
        cmbMateria.removeAllItems();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnBuscarCalificacion;
    public static javax.swing.JButton btnIngresarNotas;
    public static javax.swing.JButton btnSeleccionarAlumno;
    public static javax.swing.JComboBox cmbAno;
    public static javax.swing.JButton cmbAtras;
    public static javax.swing.JComboBox cmbGradoSeccion;
    public static javax.swing.JComboBox cmbMateria;
    private javax.swing.JLabel imgBarraTitulo;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lblAlumno;
    public static javax.swing.JLabel lblAño;
    public static javax.swing.JLabel lblGrado_Seccion;
    public static javax.swing.JLabel lblGrado_Seccion1;
    public static javax.swing.JLabel lbltitle;
    private java.awt.Panel panel1;
    private javax.swing.JTable tblNotas;
    // End of variables declaration//GEN-END:variables
}
