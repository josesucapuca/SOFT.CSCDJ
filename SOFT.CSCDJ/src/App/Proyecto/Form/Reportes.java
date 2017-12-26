/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Form;

import App.Proyecto.Controlador.Interface.InterfaceAñoDAO;
import App.Proyecto.Controlador.Interface.InterfaceListadosDAO;
import App.Proyecto.Controlador.Interface.InterfaceMatriculaDAO;
import App.Proyecto.DAO.AnoDAO;
import App.Proyecto.DAO.ListadosDAO;
import App.Proyecto.DAO.MatriculaDAO;
import App.Proyecto.Modelo.Ano;
import App.Proyecto.Modelo.Grado_Seccion;
import App.Proyecto.Modelo.Matricula;
import App.Proyecto.Modelo.Modelo_Excel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Reportes extends javax.swing.JFrame {

    InterfaceAñoDAO an = new AnoDAO();
    InterfaceListadosDAO lis = new ListadosDAO();
    InterfaceMatriculaDAO al = new MatriculaDAO();
    int id_Periodo = 0;
    int id_Grado_Seccion = 0;
    Modelo_Excel modeloE = new Modelo_Excel();
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    public static String nom_usuario;
    public static String nom_persona;

    /**
     * Creates new form Reportes
     */
    public class ModeloTabla extends DefaultTableModel {

        public boolean isCellEditable(int row, int col) {
            if (col == 0) {
                return false;
            } else {
                return true;
            }
        }
    }
    ModeloTabla modo = new ModeloTabla();

    public Reportes() {
        initComponents();
        pintarLabel("src/App/Proyecto/Imagenes/fondo_celeste.jpg", imgFondo);
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo1);
        modo.addColumn("Alumno");
        modo.addColumn("Cod Alumno");
        modo.addColumn("Dni");
        modo.addColumn("Grado Seccion");
        modo.addColumn("Año");
        modo.addColumn("Fecha_Matricula");
        modo.addColumn("Tipo_Matricula");
        modo.addColumn("Estado Matricula");
        tblMatriculados.setModel(modo);
        Cargar_Año();
        Cargar_Grado_Seccion();
        ListarMatriculados();
        cmbGradoSeccion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Object selected = comboBox.getSelectedItem();
                id_Grado_Seccion = lis.Validar_Grado((String) selected);
            }
        });
        cmbAño.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Object selected = comboBox.getSelectedItem();
                id_Periodo = an.Anoxnombre((String) selected);
            }
        });
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

    public void pintarLabel(String url, JLabel obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth(), obj.getHeight(), Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
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
        cmbAño.setModel(modelito);
    }

    public void ListarMatriculados() {
        DefaultTableModel modelo = (DefaultTableModel) tblMatriculados.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        List<Matricula> p = al.Listar_Matricula();
        for (int i = 0; i < p.size(); i++) {
            String Situacion_Matricula = null;
            String estado_Matricula = null;
            String cod_estudiante = null;
            Matricula per = new Matricula();
            per = (Matricula) p.get(i);
            if (per.getLi_Estado_Matricula() != null) {
                if (per.getLi_Estado_Matricula().equals("I")) {
                    Situacion_Matricula = "Ingresante";
                } else if (per.getLi_Estado_Matricula().equals("P")) {
                    Situacion_Matricula = "Promovido";
                } else if (per.getLi_Estado_Matricula().equals("R")) {
                    Situacion_Matricula = "Repitente";
                } else if (per.getLi_Estado_Matricula().equals("D")) {
                    Situacion_Matricula = "Reentrante";
                }
            } else {
                Situacion_Matricula = "No Ingresado";
            }
            if (per.getEstado_Matricula() != null) {
                if (per.getEstado_Matricula().equals("1")) {
                    estado_Matricula = "ACTIVO";
                } else if (per.getEstado_Matricula().equals("0")) {
                    estado_Matricula = "Retiado";
                }
            } else {
                estado_Matricula = "No Ingresado";
            }
            if (per.getCod_Estudiante() != null) {
                cod_estudiante = per.getCod_Estudiante();
            } else {
                cod_estudiante = "No Ingresado";
            }

            modelo.addRow(new Object[]{per.getAlumno(), cod_estudiante, per.getDni(), per.getGrado_seccion(), per.getAño(), per.getFe_Matricula(), Situacion_Matricula, estado_Matricula});
        }
        tblMatriculados.setModel(modelo);
    }

    public void ListarMatriculadosBuscado(JTable table, List<Matricula> list) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String Situacion_Matricula = null;
                String estado_Matricula = null;
                String cod_estudiante = null;
                Matricula per = new Matricula();
                per = (Matricula) list.get(i);
                if (per.getLi_Estado_Matricula() != null) {
                    if (per.getLi_Estado_Matricula().equals("I")) {
                        Situacion_Matricula = "Ingresante";
                    } else if (per.getLi_Estado_Matricula().equals("P")) {
                        Situacion_Matricula = "Promovido";
                    } else if (per.getLi_Estado_Matricula().equals("R")) {
                        Situacion_Matricula = "Repitente";
                    } else if (per.getLi_Estado_Matricula().equals("D")) {
                        Situacion_Matricula = "Reentrante";
                    }
                } else {
                    Situacion_Matricula = "No Ingresado";
                }
                if (per.getEstado_Matricula() != null) {
                    if (per.getEstado_Matricula().equals("1")) {
                        estado_Matricula = "ACTIVO";
                    } else if (per.getEstado_Matricula().equals("0")) {
                        estado_Matricula = "Retiado";
                    }
                } else {
                    estado_Matricula = "No Ingresado";
                }
                if (per.getCod_Estudiante() != null) {
                    cod_estudiante = per.getCod_Estudiante();
                } else {
                    cod_estudiante = "No Ingresado";
                }

                modelo.addRow(new Object[]{per.getAlumno(), cod_estudiante, per.getDni(), per.getGrado_seccion(), per.getAño(), per.getFe_Matricula(), Situacion_Matricula, estado_Matricula});
            }

        } else {
            modelo.addRow(new Object[]{"Sin Datos", "Sin Datos", "Sin Datos", "Sin Datos", "Sin Datos", "Sin Datos", "Sin Datos"});
        }
        table.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVisualizar = new javax.swing.JButton();
        cmbAño = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbGradoSeccion = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatriculados = new javax.swing.JTable();
        imgBarraTitulo1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVisualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 150, 30));

        cmbAño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 130, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Año");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 80, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Reportes");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 130, 30));

        cmbGradoSeccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbGradoSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 190, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Grado Seccion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 80, 20));

        btnExportar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        getContentPane().add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 580, 170, 40));

        tblMatriculados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMatriculados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 810, 430));

        imgBarraTitulo1.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo1.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 870, 40));

        btnAtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 170, 40));
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        // TODO add your handling code here:
        ListarMatriculadosBuscado(tblMatriculados, al.Buscar_Matriculaxidgradoxidano(id_Grado_Seccion, id_Periodo));
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        if (selecArchivo.showDialog(null, "Exportar") == JFileChooser.APPROVE_OPTION) {
            archivo = selecArchivo.getSelectedFile();
            if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                JOptionPane.showMessageDialog(null, modeloE.Exportar(archivo, tblMatriculados) + "\n Formato ." + archivo.getName().substring(archivo.getName().lastIndexOf(".") + 1));
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato valido.");
            }
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrame frame = new Principal_Reportes();
        frame.setTitle("Menu Reportes");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Principal_Reportes.lblUsuario.setText(nom_usuario);
        Principal_Reportes.lblPersona.setText(nom_persona);
    }//GEN-LAST:event_btnAtrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox cmbAño;
    private javax.swing.JComboBox cmbGradoSeccion;
    private javax.swing.JLabel imgBarraTitulo1;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMatriculados;
    // End of variables declaration//GEN-END:variables
}
