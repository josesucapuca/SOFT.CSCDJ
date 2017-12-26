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
import App.Proyecto.DAO.CellRenderer;
import App.Proyecto.DAO.ListadosDAO;
import App.Proyecto.DAO.MatriculaDAO;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Ano;
import App.Proyecto.Modelo.Grado_Seccion;
import App.Proyecto.Modelo.Matricula;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Barrantes Tapia
 */
public class FormMatricula extends javax.swing.JFrame {

    /**
     * Creates new form Matricula
     */
    InterfaceMatriculaDAO al = new MatriculaDAO();
    InterfaceListadosDAO lis = new ListadosDAO();
    InterfaceAñoDAO an = new AnoDAO();
    conexion con;
    int id_Grado_Seccion = 0;
    int id_Periodo = 0;
    String Li_Ti_Matricula = "";
    String Es_Trabaja = "";
    String Nro_Horas = "";
    int id_matricula = 0;
    public static String nom_usuario;
    public static String nom_persona;

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

    public FormMatricula() {
        initComponents();
        pintarLabel("src/App/Proyecto/Imagenes/fondo_celeste.jpg", imgFondo);
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo1);
        modo.addColumn("Id_Matriula");
        modo.addColumn("Alumno");
        modo.addColumn("Dni");
        modo.addColumn("Grado Seccion");
        modo.addColumn("Año");
        modo.addColumn("Fecha_Matricula");
        modo.addColumn("Tipo_Matricula");
        jTablaMatricula.setModel(modo);
        ListarMatricula();
        setCellRender(jTablaMatricula);
        Cargar_Grado_Seccion();
        Cargar_Año();
        Cargar_Trabaja();
        Cargar_Tipo_Matricula();
        
        cmbGrado_Seccion.addActionListener(new ActionListener() {

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
        cmbTrabaja.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "SI":
                        Es_Trabaja = "1";
                        spNroHoras.setEnabled(true);
                        break;
                    case "NO":
                        Es_Trabaja = "0";
                        spNroHoras.setEnabled(false);
                        Nro_Horas = "0";
                        spNroHoras.setValue(0);
                        break;
                    case "-SELECCIONAR-":
                        Es_Trabaja = "";
                        spNroHoras.setEnabled(false);
                        Nro_Horas = "";
                        break;
                }
            }
        });
        cmbLi_Tipo_Mat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "Ingresante":
                        Li_Ti_Matricula = "I";
                        break;
                    case "Promovido":
                        Li_Ti_Matricula = "P";
                        break;
                    case "Repitente":
                        Li_Ti_Matricula = "R";
                        break;
                    case "Reentrante":
                        Li_Ti_Matricula = "D";
                        break;
                    case "-SELECCIONAR-":
                        Li_Ti_Matricula = "";
                        break;
                }
            }
        });
    }
    public static int id_persona;

    public void Limpiar() {
        id_Grado_Seccion = 0;
        id_Periodo = 0;
        id_matricula = 0;
        id_persona = 0;
        txtAlumno.setText("");
        cmbLi_Tipo_Mat.setSelectedIndex(0);
        cmbGrado_Seccion.setSelectedIndex(0);
        cmbAño.setSelectedIndex(0);
        cmbTrabaja.setSelectedIndex(0);
    }

    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
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
        cmbGrado_Seccion.setModel(modelito);
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

    public void Cargar_Trabaja() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        modelito.addElement("-SELECCIONAR-");
        modelito.addElement("SI");
        modelito.addElement("NO");
        cmbTrabaja.setModel(modelito);
        spNroHoras.setEnabled(false);
    }

    public void Cargar_Tipo_Matricula() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        modelito.addElement("-SELECCIONAR-");
        modelito.addElement("Ingresante");
        modelito.addElement("Promovido");
        modelito.addElement("Repitente");
        modelito.addElement("Reentrante");
        cmbLi_Tipo_Mat.setModel(modelito);
    }

    public void pintarLabel(String url, JLabel obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth(), obj.getHeight(), Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    public void pintar(String url, JButton obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth() - 30, obj.getHeight() - 40, Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    public void ListarMatricula() {
        DefaultTableModel modelo = (DefaultTableModel) jTablaMatricula.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        List<Matricula> p = al.Listar_Matricula();
        for (int i = 0; i < p.size(); i++) {
            String Situacion_Matricula = null;
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
            modelo.addRow(new Object[]{per.getId_Matricula(), per.getAlumno(), per.getDni(), per.getGrado_seccion(), per.getAño(), per.getFe_Matricula(), Situacion_Matricula});
        }
        jTablaMatricula.setModel(modelo);
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
        jMenuItem1 = new javax.swing.JMenuItem();
        txtAlumno = new javax.swing.JTextField();
        cmbGrado_Seccion = new javax.swing.JComboBox();
        cmbAño = new javax.swing.JComboBox();
        cmbTrabaja = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaMatricula = new javax.swing.JTable();
        btn_Matricular = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        IngresarDatos1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        imgBarraTitulo1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnSeleccionarAlumno = new javax.swing.JButton();
        spNroHoras = new javax.swing.JSpinner();
        cmbLi_Tipo_Mat = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        imgFondo = new javax.swing.JLabel();

        jMenuItem1.setText("Modificar");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAlumno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 320, 30));

        cmbGrado_Seccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbGrado_Seccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbGrado_Seccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbGrado_SeccionMouseClicked(evt);
            }
        });
        cmbGrado_Seccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGrado_SeccionActionPerformed(evt);
            }
        });
        getContentPane().add(cmbGrado_Seccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, 30));

        cmbAño.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbAño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 30));

        cmbTrabaja.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbTrabaja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbTrabaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 140, 30));

        jTablaMatricula.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaMatricula.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTablaMatricula);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 670, 190));

        btn_Matricular.setBackground(new java.awt.Color(255, 255, 255));
        btn_Matricular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Matricular.setForeground(new java.awt.Color(102, 153, 255));
        btn_Matricular.setText("Matricular");
        btn_Matricular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Matricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MatricularActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Matricular, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 170, 30));

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
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 120, 30));

        IngresarDatos1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IngresarDatos1.setForeground(new java.awt.Color(255, 255, 255));
        IngresarDatos1.setText("Matricular Alumno");
        getContentPane().add(IngresarDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Alumno");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Grado Seccion");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Año");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 60, -1));

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Trabaja?");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 90, -1));

        imgBarraTitulo1.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo1.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 720, 40));

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Nro Horas Sem");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 90, -1));

        btnSeleccionarAlumno.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionarAlumno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeleccionarAlumno.setForeground(new java.awt.Color(102, 153, 255));
        btnSeleccionarAlumno.setText("Seleccionar Alumno");
        btnSeleccionarAlumno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeleccionarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 170, 30));

        spNroHoras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(spNroHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 90, 30));

        cmbLi_Tipo_Mat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbLi_Tipo_Mat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLi_Tipo_Mat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbLi_Tipo_MatMouseClicked(evt);
            }
        });
        getContentPane().add(cmbLi_Tipo_Mat, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 90, 30));

        jLabel2.setText("Tipo Matricula");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarAlumnoActionPerformed
        // TODO add your handling code here:
        JFrame frame = new Selec_Alumno();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarAlumnoActionPerformed

    private void cmbGrado_SeccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbGrado_SeccionMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbGrado_SeccionMouseClicked

    private void btn_MatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MatricularActionPerformed
        // TODO add your handling code here:
        if (btn_Matricular.getText().equals("Matricular")) {
            if (id_Grado_Seccion != 0 && id_Periodo != 0 && !Es_Trabaja.equals("") && !txtAlumno.getText().equals("") && !Li_Ti_Matricula.equals("")) {
                switch (Es_Trabaja) {
                    case "1":
                        if (spNroHoras.getValue().toString().equals("0")) {
                            JOptionPane.showMessageDialog(null, "Ingrsar canntidad de horas semanales");
                        } else {
                            Nro_Horas = spNroHoras.getValue().toString();
                            al.Insertar_Matricula(id_persona, id_Grado_Seccion, id_Periodo, Es_Trabaja, Nro_Horas, Li_Ti_Matricula);
                            ListarMatricula();
                            Limpiar();
                        }   break;
                    case "0":
                        al.Insertar_Matricula(id_persona, id_Grado_Seccion, id_Periodo, Es_Trabaja, Nro_Horas, Li_Ti_Matricula);
                        ListarMatricula();
                        Limpiar();
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Grado, Año, Estado Trabaja completo");
            }
        } else if (btn_Matricular.getText().equals("Modificar")) {
            if (id_Grado_Seccion != 0 && id_Periodo != 0 && !Es_Trabaja.equals("") && !txtAlumno.getText().equals("") && !Li_Ti_Matricula.equals("")) {
                switch (Es_Trabaja) {
                    case "1":
                        if (spNroHoras.getValue().toString().equals("0")) {
                            JOptionPane.showMessageDialog(null, "Ingrsar canntidad de horas semanales");
                        } else {
                            Nro_Horas = spNroHoras.getValue().toString();
                            al.Modificar_Matricula(id_matricula, id_Grado_Seccion, id_Periodo, Es_Trabaja, Nro_Horas, Li_Ti_Matricula);
                            ListarMatricula();
                            Limpiar();
                            btn_Matricular.setText("Matricular");
                        }   break;
                    case "0":
                        al.Modificar_Matricula(id_matricula, id_Grado_Seccion, id_Periodo, Es_Trabaja, Nro_Horas, Li_Ti_Matricula);
                        ListarMatricula();
                        Limpiar();
                        btn_Matricular.setText("Matricular");
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Grado, Año, Estado Trabaja completo");
            }
        }
    }//GEN-LAST:event_btn_MatricularActionPerformed

    private void cmbLi_Tipo_MatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbLi_Tipo_MatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLi_Tipo_MatMouseClicked

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila = jTablaMatricula.getSelectedRow();
        id_matricula = (int) jTablaMatricula.getValueAt(fila, 0);
        List<Matricula> list = al.Listar_Matriculaxid(id_matricula);
        if (list.size() > 0) {
            Matricula m = new Matricula();
            m = (Matricula) list.get(0);
            txtAlumno.setText(m.getAlumno());
            cmbGrado_Seccion.setSelectedItem(m.getGrado_seccion());
            cmbAño.setSelectedItem(m.getAño());
            if (m.getEstado_Trabajo() != null) {
                switch (m.getEstado_Trabajo()) {
                    case "1":
                        cmbTrabaja.setSelectedItem("SI");
                        spNroHoras.setEnabled(true);
                        spNroHoras.setValue(Integer.parseInt(m.getHoras_Sem_Labora()));
                        break;
                    case "0":
                        cmbTrabaja.setSelectedItem("NO");
                        spNroHoras.setValue(0);
                        spNroHoras.setEnabled(false);
                        break;
                }
            } else {
                cmbTrabaja.setSelectedIndex(0);
            }
            if (m.getLi_Estado_Matricula() != null) {
                switch (m.getLi_Estado_Matricula()) {
                    case "I":
                        cmbLi_Tipo_Mat.setSelectedItem("Ingresante");
                        break;
                    case "P":
                        cmbLi_Tipo_Mat.setSelectedItem("Promovido");
                        break;
                    case "R":
                        cmbLi_Tipo_Mat.setSelectedItem("Repitente");
                        break;
                    case "D":
                        cmbLi_Tipo_Mat.setSelectedItem("Reentrante");
                        break;
                }
            } else {
                cmbLi_Tipo_Mat.setSelectedIndex(0);
            }

        }
        btn_Matricular.setText("Modificar");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cmbGrado_SeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGrado_SeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGrado_SeccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IngresarDatos1;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSeleccionarAlumno;
    private javax.swing.JButton btn_Matricular;
    private javax.swing.JComboBox cmbAño;
    private javax.swing.JComboBox cmbGrado_Seccion;
    private javax.swing.JComboBox cmbLi_Tipo_Mat;
    private javax.swing.JComboBox cmbTrabaja;
    private javax.swing.JLabel imgBarraTitulo1;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaMatricula;
    private javax.swing.JSpinner spNroHoras;
    public static javax.swing.JTextField txtAlumno;
    // End of variables declaration//GEN-END:variables
}
