/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Form;

import App.Proyecto.Controlador.Interface.InterfaceAñoDAO;
import App.Proyecto.Controlador.Interface.InterfaceMateriaDAO;
import App.Proyecto.Controlador.Interface.InterfaceMatriculaDAO;
import App.Proyecto.Controlador.Interface.InterfacePersonaDAO;
import App.Proyecto.DAO.AnoDAO;
import App.Proyecto.DAO.CellRenderer;
import App.Proyecto.DAO.MateriaDAO;
import App.Proyecto.DAO.MatriculaDAO;
import App.Proyecto.DAO.PersonaDAO;
import App.Proyecto.Factory.conexion;
import static App.Proyecto.Form.Registro_Notas.cmbMateria;
import App.Proyecto.Modelo.Ano;
import App.Proyecto.Modelo.Materia;
import App.Proyecto.Modelo.Matricula;
import App.Proyecto.Modelo.Persona;
import App.Proyecto.Modelo.V_Dca_Materia;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author user
 */
public class SeleccionarAlumno extends javax.swing.JFrame {

    InterfacePersonaDAO al = new PersonaDAO();
    InterfaceMatriculaDAO m = new MatriculaDAO();
    InterfaceMateriaDAO mtr = new MateriaDAO();
    conexion con;
    InterfaceAñoDAO an = new AnoDAO();
    int id_periodo;

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

    /**
     * Creates new form SeleccionarAlumno
     */
    public SeleccionarAlumno() {
        initComponents();
        pintarLabel("src/App/Proyecto/Imagenes/fondo_celeste.jpg", imgFondo);
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo1);
        modo.addColumn("Id_Persona");
        modo.addColumn("Alumno");
        modo.addColumn("DNI");
        modo.addColumn("Año");
        modo.addColumn("Id Matricula");
        modo.addColumn("Grado Seccion");
        tbAlumno.setModel(modo);
        setCellRender(tbAlumno);

    }

    public void Cargar_Materia(int id,JComboBox Combo) {
        Combo.removeAllItems();
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        List<V_Dca_Materia> list = mtr.ListarMateriaxid_Matricula(id);
        modelito.addElement("-SELECCIONAR-");
        for (int i = 0; i < list.size(); i++) {
            V_Dca_Materia mtr = new V_Dca_Materia();
            mtr = (V_Dca_Materia) list.get(i);
            modelito.addElement(mtr.getNombre_Materia());
        }
        Combo.setModel(modelito);
    }

    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }

    public void pintarLabel(String url, JLabel obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth(), obj.getHeight(), Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    public void pintar(String url, JButton obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth() - 30, obj.getHeight() - 80, Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSeleccionar = new javax.swing.JButton();
        btnATRAS = new javax.swing.JButton();
        IngresarDatos1 = new javax.swing.JLabel();
        imgBarraTitulo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlumno = new javax.swing.JTable();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(102, 153, 255));
        btnSeleccionar.setText("Enviar");
        btnSeleccionar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 120, 30));

        btnATRAS.setBackground(new java.awt.Color(255, 255, 255));
        btnATRAS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnATRAS.setForeground(new java.awt.Color(102, 153, 255));
        btnATRAS.setText("ATRAS");
        btnATRAS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnATRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATRASActionPerformed(evt);
            }
        });
        getContentPane().add(btnATRAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 120, 30));

        IngresarDatos1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IngresarDatos1.setForeground(new java.awt.Color(255, 255, 255));
        IngresarDatos1.setText("Seleccionar Alumno");
        getContentPane().add(IngresarDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        imgBarraTitulo1.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo1.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 660, 40));

        tbAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbAlumno);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 620, 340));

        imgFondo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        int count = tbAlumno.getSelectedRowCount();
        if (count > 0) {
            int fila;
            fila = tbAlumno.getSelectedRow();
            int id_persona;
            id_persona = (int) tbAlumno.getValueAt(fila, 0);
            List<Persona> list = al.ListarAlumnoxId(id_persona);
            if (list.size() > 0) {
                Persona per = new Persona();
                per = (Persona) list.get(0);
                Registro_Notas.lblAlumno.setText(per.getNombre_Persona() + " " + per.getApellido_Paterno() + " " + per.getApellido_Materno());
                Registro_Notas.lblAño.setText((String) tbAlumno.getValueAt(fila, 3));
                Registro_Notas.id_matricula = (int) tbAlumno.getValueAt(fila, 4);
                Registro_Notas.cmbGradoSeccion.setSelectedItem((String) tbAlumno.getValueAt(fila, 5));
                Registro_Notas.cmbGradoSeccion.setEnabled(false);
                Registro_Notas.cmbAno.setEnabled(false);
                Cargar_Materia((int) tbAlumno.getValueAt(fila, 4), Registro_Notas.cmbMateria);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccinar una fila de la tabla");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnATRASActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnATRASActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IngresarDatos1;
    public javax.swing.JButton btnATRAS;
    public javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel imgBarraTitulo1;
    private javax.swing.JLabel imgFondo;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbAlumno;
    // End of variables declaration//GEN-END:variables
}
