/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Form;

import App.Proyecto.Controlador.Interface.InterfacePersonaDAO;
import App.Proyecto.DAO.CellRenderer;
import App.Proyecto.DAO.PersonaDAO;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Funciones;
import App.Proyecto.Modelo.Modelo_Excel;
import App.Proyecto.Modelo.Persona;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Barrantes Tapia
 */
public final class RegistroAlumnos extends javax.swing.JFrame {

    Funciones Fun = new Funciones();
    InterfacePersonaDAO al = new PersonaDAO();
    conexion con;
    DefaultTableModel modelo = new DefaultTableModel();
    Modelo_Excel modeloE = new Modelo_Excel();
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int id_persona = 0;
    String Cod_Estudiante = "";
    String Nombres = "";
    String Ap_Paterno = "";
    String Ap_Materno = "";
    String dni = "";
    String Estado_Persona = "";
    String fecha_nac = null;
    String vive_padre = "";
    String vive_madre = "";
    String pais = "";
    String Escolaridad_madre = "";
    String Nac_Registrado = "";
    String Tipo_Discapacidad = "";
    String Lengua_Materna = "";
    String Segunda_Lengua = "";
    String sexo = "";
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

    public RegistroAlumnos() {
        initComponents();
        pintarLabel("src/App/Proyecto/Imagenes/fondo_celeste.jpg", imgFondo);
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo);
        pintarLabel("src/App/Proyecto/Imagenes/barra.jpg", imgBarraTitulo1);
        pintaratras("src/App/Proyecto/Imagenes/ATRAS.png", btnAtras);
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("DNI");
        modo.addColumn("Id_Persona");
        modo.addColumn("Cod Estudiantes");
        modo.addColumn("Nombres");
        modo.addColumn("Apellido Paterno");
        modo.addColumn("Apellido Materno");
        modo.addColumn("DNI");
        modo.addColumn("Estado Alumno");
        modo.addColumn("Estado Matricula");
        Object[][] row = {};
        modelo.addRow(row);
        dtDatosAlumnos.setModel(modelo);
        jTListaAlumno.setModel(modo);
        ListarAlumno();
        setCellRender(jTListaAlumno);
        setCellRender(dtDatosAlumnos);
        CargarCombo();
        cmbEstado_Alumno.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "ACTIVO":
                        Estado_Persona = "1";
                        break;
                    case "INACTIVO":
                        Estado_Persona = "0";
                        break;
                    case "--":
                        Estado_Persona = "";
                        break;
                }
            }

        });
        cmbVive_Padre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "SI":
                        vive_padre = "1";
                        break;
                    case "NO":
                        vive_padre = "0";
                        break;
                    case "--":
                        vive_padre = "";
                        break;
                }
            }

        });
        cmbVive_Madre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "SI":
                        vive_madre = "1";
                        break;
                    case "NO":
                        vive_madre = "0";
                        break;
                    case "--":
                        vive_madre = "";
                        break;
                }
            }

        });
        cmbPais.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "Perú":
                        pais = "1";
                        break;
                    case "Ecuador":
                        pais = "2";
                        break;
                    case "Colombia":
                        pais = "3";
                        break;
                    case "Brasil":
                        pais = "4";
                        break;
                    case "Bolivia":
                        pais = "5";
                        break;
                    case "Chile":
                        pais = "6";
                        break;
                    case "Otro":
                        pais = "7";
                        break;
                    case "--":
                        pais = "";
                        break;
                }
            }

        });
        cmbEscolaridad_Madre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "Analfabeta":
                        Escolaridad_madre = "A";
                        break;
                    case "Primaria":
                        Escolaridad_madre = "P";
                        break;
                    case "Secundaria":
                        Escolaridad_madre = "S";
                        break;
                    case "Superior":
                        Escolaridad_madre = "U";
                        break;
                    case "--":
                        Escolaridad_madre = "";
                        break;
                }
            }

        });
        cmbLengua_Materna.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "Castellano":
                        Lengua_Materna = "C";
                        break;
                    case "Quechua":
                        Lengua_Materna = "Q";
                        break;
                    case "Aimara":
                        Lengua_Materna = "A";
                        break;
                    case "Otra lengua":
                        Lengua_Materna = "O";
                        break;
                    case "Lengua extranjera":
                        Lengua_Materna = "E";
                        break;
                    case "--":
                        Lengua_Materna = "";
                        break;
                }
            }

        });
        cmbSegunda_Lengua.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "Castellano":
                        Segunda_Lengua = "C";
                        break;
                    case "Quechua":
                        Segunda_Lengua = "Q";
                        break;
                    case "Aimara":
                        Segunda_Lengua = "A";
                        break;
                    case "Otra lengua":
                        Segunda_Lengua = "O";
                        break;
                    case "Lengua extranjera":
                        Segunda_Lengua = "E";
                        break;
                    case "--":
                        Segunda_Lengua = "";
                        break;
                }
            }

        });
        cmbNac_Reg.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "SI":
                        Nac_Registrado = "1";
                        break;
                    case "NO":
                        Nac_Registrado = "0";
                        break;
                    case "--":
                        Nac_Registrado = "";
                        break;
                }
            }

        });
        cmbTipo_Discapacidad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "Intelectual":
                        Tipo_Discapacidad = "I";
                        break;
                    case "Auditiva":
                        Tipo_Discapacidad = "A";
                        break;
                    case "Visual":
                        Tipo_Discapacidad = "V";
                        break;
                    case "Motora":
                        Tipo_Discapacidad = "M";
                        break;
                    case "Otra":
                        Tipo_Discapacidad = "O";
                        break;
                    case "--":
                        Tipo_Discapacidad = null;
                        break;
                }
            }

        });
        cmbSexo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String valor = (String) comboBox.getSelectedItem();
                switch (valor) {
                    case "Hombre":
                        sexo = "H";
                        break;
                    case "Mujer":
                        sexo = "M";
                        break;
                    case "--":
                        sexo = "";
                        break;
                }
            }

        });

    }

    public void LimpiarFrame() {
        Cod_Estudiante = "";
        Nombres = "";
        Ap_Paterno = "";
        Ap_Materno = "";
        dni = "";
        Estado_Persona = "";
        fecha_nac = null;
        vive_padre = "";
        vive_madre = "";
        pais = "";
        Escolaridad_madre = "";
        Nac_Registrado = "";
        Tipo_Discapacidad = "";
        Lengua_Materna = "";
        Segunda_Lengua = "";
        sexo = "";
        cmbEstado_Alumno.setSelectedIndex(0);
        cmbEscolaridad_Madre.setSelectedIndex(0);
        cmbLengua_Materna.setSelectedIndex(0);
        cmbNac_Reg.setSelectedIndex(0);
        cmbSegunda_Lengua.setSelectedIndex(0);
        cmbPais.setSelectedIndex(0);
        cmbTipo_Discapacidad.setSelectedIndex(0);
        cmbVive_Madre.setSelectedIndex(0);
        cmbVive_Padre.setSelectedIndex(0);
        cmbSexo.setSelectedIndex(0);
        dateFecha_nac.setDate(null);
        txtCod_Alumno.setText("");
        txtDni.setText("");
        txtNombres.setText("");
        txtMaterno.setText("");
        txtPaterno.setText("");
    }

    public void pintaratras(String url, JButton obj) {
        ImageIcon imagen = new ImageIcon(url);
        Icon Icono = new ImageIcon(imagen.getImage().getScaledInstance(obj.getWidth() - 10, obj.getHeight() - 10, Image.SCALE_DEFAULT));
        obj.setIcon(Icono);
        this.repaint();
    }

    public void AgregarFiltro() {
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }

    public void CargarCombo() {
        DefaultComboBoxModel modelito = new DefaultComboBoxModel();
        modelito.addElement("--");
        modelito.addElement("ACTIVO");
        modelito.addElement("INACTIVO");
        cmbEstado_Alumno.setModel(modelito);
        DefaultComboBoxModel modelito2 = new DefaultComboBoxModel();
        cmbVive_Padre.setModel(modelito2);
        modelito2.addElement("--");
        modelito2.addElement("SI");
        modelito2.addElement("NO");
        DefaultComboBoxModel modelito3 = new DefaultComboBoxModel();
        cmbVive_Madre.setModel(modelito3);
        modelito3.addElement("--");
        modelito3.addElement("SI");
        modelito3.addElement("NO");
        DefaultComboBoxModel modelito4 = new DefaultComboBoxModel();
        cmbPais.setModel(modelito4);
        modelito4.addElement("--");
        modelito4.addElement("Perú");
        modelito4.addElement("Ecuador");
        modelito4.addElement("Colombia");
        modelito4.addElement("Brasil");
        modelito4.addElement("Bolivia");
        modelito4.addElement("Chile");
        modelito4.addElement("Otro");
        DefaultComboBoxModel modelito5 = new DefaultComboBoxModel();
        cmbLengua_Materna.setModel(modelito5);
        modelito5.addElement("--");
        modelito5.addElement("Castellano");
        modelito5.addElement("Quechua");
        modelito5.addElement("Aimara");
        modelito5.addElement("Otra lengua");
        modelito5.addElement("Lengua extranjera");
        DefaultComboBoxModel modelito6 = new DefaultComboBoxModel();
        cmbSegunda_Lengua.setModel(modelito6);
        modelito6.addElement("--");
        modelito6.addElement("Castellano");
        modelito6.addElement("Quechua");
        modelito6.addElement("Aimara");
        modelito6.addElement("Otra lengua");
        modelito6.addElement("Lengua extranjera");
        DefaultComboBoxModel modelito7 = new DefaultComboBoxModel();
        cmbEscolaridad_Madre.setModel(modelito7);
        modelito7.addElement("--");
        modelito7.addElement("Analfabeta");
        modelito7.addElement("Primaria");
        modelito7.addElement("Secundaria");
        modelito7.addElement("Superior");
        DefaultComboBoxModel modelito8 = new DefaultComboBoxModel();
        cmbTipo_Discapacidad.setModel(modelito8);
        modelito8.addElement("--");
        modelito8.addElement("Intelectual");
        modelito8.addElement("Auditiva");
        modelito8.addElement("Visual");
        modelito8.addElement("Motora");
        modelito8.addElement("Otra");
        DefaultComboBoxModel modelito9 = new DefaultComboBoxModel();
        cmbNac_Reg.setModel(modelito9);
        modelito9.addElement("--");
        modelito9.addElement("SI");
        modelito9.addElement("NO");
        DefaultComboBoxModel modelito10 = new DefaultComboBoxModel();
        cmbSexo.setModel(modelito10);
        modelito10.addElement("--");
        modelito10.addElement("Hombre");
        modelito10.addElement("Mujer");

    }

    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }

    public RegistroAlumnos(JLabel imgBarraTitulo, JLabel imgFondo) {
        this.imgBarraTitulo = imgBarraTitulo;
        this.imgFondo = imgFondo;
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

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public void ListarAlumno() {
        DefaultTableModel model = (DefaultTableModel) jTListaAlumno.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        List<Persona> p = al.ListarAlumno();
        for (int i = 0; i < p.size(); i++) {
            String Est_Persona = null;
            String Estado_Aumno = null;
            Persona per = new Persona();
            per = (Persona) p.get(i);
            String cod_es = null;
            if (per.getCod_Estudiante() != null) {
                cod_es = per.getCod_Estudiante();
            } else {
                cod_es = "No ingresado";
            }
            if (per.getEstado_Persona()== null) {
                Est_Persona = "Desactivo";
            } else if (per.getEstado_Persona().trim().equals("1")) {
                Est_Persona = "Activo";
            } else if (per.getEstado_Persona().trim().equals("0")) {
                Est_Persona = "Desactivo";
            }
            if (per.getEstado_Alumno() == null) {
                Estado_Aumno = "No Matriculado";
            } else if (per.getEstado_Alumno().equals("1")) {
                Estado_Aumno = "No Matriculado";
            } else if (per.getEstado_Alumno().equals("2")) {
                Estado_Aumno = "Matriculado";
            }
            model.addRow(new Object[]{per.getId_Persona(), cod_es, per.getNombre_Persona(), per.getApellido_Paterno(), per.getApellido_Materno(), per.getDni(), Est_Persona, Estado_Aumno});
        }
        jTListaAlumno.setModel(model);
    }

    public void Listar_AlumnosBuscar(List<Persona> Lista) {
        DefaultTableModel model = (DefaultTableModel) jTListaAlumno.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (int i = 0; i < Lista.size(); i++) {
            String Est_Persona = null;
            String Estado_Aumno = null;
            Persona per = new Persona();
            per = (Persona) Lista.get(i);
            String cod_es = null;
            if (per.getCod_Estudiante() != null) {
                cod_es = per.getCod_Estudiante();
            } else {
                cod_es = "No ingresado";
            }
            if (per.getEstado_Persona()== null) {
                Est_Persona = "Desactivo";
            } else if (per.getEstado_Persona().trim().equals("1")) {
                Est_Persona = "Activo";
            } else if (per.getEstado_Persona().trim().equals("0")) {
                Est_Persona = "Desactivo";
            }
            if (per.getEstado_Alumno() == null) {
                Estado_Aumno = "No Matriculado";
            } else if (per.getEstado_Alumno().equals("1")) {
                Estado_Aumno = "No Matriculado";
            } else if (per.getEstado_Alumno().equals("2")) {
                Estado_Aumno = "Matriculado";
            }
            model.addRow(new Object[]{per.getId_Persona(), cod_es, per.getNombre_Persona(), per.getApellido_Paterno(), per.getApellido_Materno(), per.getDni(), Est_Persona, Estado_Aumno});
        }
        jTListaAlumno.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuOpcion = new javax.swing.JPopupMenu();
        MenActivar = new javax.swing.JMenuItem();
        MenDesactivar = new javax.swing.JMenuItem();
        MenModificar = new javax.swing.JMenuItem();
        IngresarDatos = new javax.swing.JLabel();
        btnIngresarAlumno = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaAlumno = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        imgBarraTitulo = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IngresarDatos1 = new javax.swing.JLabel();
        txtCod_Alumno = new javax.swing.JTextField();
        imgBarraTitulo1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_Registrar = new javax.swing.JButton();
        dateFecha_nac = new com.toedter.calendar.JDateChooser();
        txtDni = new javax.swing.JTextField();
        cmbVive_Madre = new javax.swing.JComboBox();
        cmbVive_Padre = new javax.swing.JComboBox();
        cmbEstado_Alumno = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbPais = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cmbLengua_Materna = new javax.swing.JComboBox();
        cmbSegunda_Lengua = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbEscolaridad_Madre = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        cmbNac_Reg = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        cmbTipo_Discapacidad = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        btnImportar = new javax.swing.JButton();
        jpane = new javax.swing.JScrollPane();
        dtDatosAlumnos = new javax.swing.JTable();
        txtCod_AlumnoBuscar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNombre_PersonaBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDniBuscar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        cmbSexo = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        btnListarAlumnos = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        imgFondo = new javax.swing.JLabel();

        MenActivar.setText("Activar");
        MenuOpcion.add(MenActivar);

        MenDesactivar.setText("Desactivar");
        MenuOpcion.add(MenDesactivar);

        MenModificar.setText("Modificar");
        MenModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenModificarActionPerformed(evt);
            }
        });
        MenuOpcion.add(MenModificar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(239, 239, 239));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1300, 701));
        setResizable(false);
        getContentPane().setLayout(null);

        IngresarDatos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IngresarDatos.setForeground(new java.awt.Color(255, 255, 255));
        IngresarDatos.setText("Lista Alumnos");
        getContentPane().add(IngresarDatos);
        IngresarDatos.setBounds(900, 20, 120, 22);

        btnIngresarAlumno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngresarAlumno.setForeground(new java.awt.Color(102, 153, 255));
        btnIngresarAlumno.setText("Ingresar");
        btnIngresarAlumno.setBorder(null);
        btnIngresarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresarAlumno);
        btnIngresarAlumno.setBounds(170, 620, 130, 40);

        jTListaAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jTListaAlumno.setComponentPopupMenu(MenuOpcion);
        jTListaAlumno.setSelectionBackground(new java.awt.Color(70, 129, 188));
        jScrollPane2.setViewportView(jTListaAlumno);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(640, 70, 620, 530);

        btnExportar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(102, 153, 255));
        btnExportar.setText("Exportar Alumno");
        btnExportar.setBorder(null);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        getContentPane().add(btnExportar);
        btnExportar.setBounds(740, 620, 210, 40);

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(102, 153, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(370, 620, 130, 40);

        imgBarraTitulo.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo);
        imgBarraTitulo.setBounds(625, 10, 670, 40);

        txtNombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombres);
        txtNombres.setBounds(160, 180, 150, 30);

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nombres:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 160, 80, 20);

        txtPaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });
        getContentPane().add(txtPaterno);
        txtPaterno.setBounds(320, 180, 130, 30);

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Apellido Paterno:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(320, 160, 120, 20);

        txtMaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
        });
        getContentPane().add(txtMaterno);
        txtMaterno.setBounds(460, 180, 140, 30);

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Apellido Materno:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(460, 160, 110, 20);

        IngresarDatos1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IngresarDatos1.setForeground(new java.awt.Color(255, 255, 255));
        IngresarDatos1.setText("Ingresar Datos Alumnos");
        getContentPane().add(IngresarDatos1);
        IngresarDatos1.setBounds(210, 20, 190, 22);

        txtCod_Alumno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCod_Alumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_AlumnoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCod_Alumno);
        txtCod_Alumno.setBounds(40, 180, 100, 30);

        imgBarraTitulo1.setBackground(new java.awt.Color(0, 0, 0));
        imgBarraTitulo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imgBarraTitulo1.setName(""); // NOI18N
        getContentPane().add(imgBarraTitulo1);
        imgBarraTitulo1.setBounds(10, 10, 610, 40);

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Cod Alumno");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 160, 90, 20);

        btn_Registrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Registrar.setForeground(new java.awt.Color(102, 153, 255));
        btn_Registrar.setText("Registrar");
        btn_Registrar.setBorder(null);
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Registrar);
        btn_Registrar.setBounds(250, 340, 140, 40);

        dateFecha_nac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateFecha_nac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateFecha_nacKeyTyped(evt);
            }
        });
        getContentPane().add(dateFecha_nac);
        dateFecha_nac.setBounds(240, 240, 120, 30);

        txtDni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        getContentPane().add(txtDni);
        txtDni.setBounds(40, 240, 90, 30);

        cmbVive_Madre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbVive_Madre);
        cmbVive_Madre.setBounds(450, 240, 70, 30);

        cmbVive_Padre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbVive_Padre);
        cmbVive_Padre.setBounds(370, 240, 70, 30);

        cmbEstado_Alumno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbEstado_Alumno);
        cmbEstado_Alumno.setBounds(150, 240, 80, 30);

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Dni");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 220, 30, 20);

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Estado Alumno");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(150, 220, 80, 20);

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Vive Padre?");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(370, 220, 60, 20);

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Sexo");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(530, 220, 60, 20);

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Fecha Nacimiento");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(240, 220, 120, 20);

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbPais);
        cmbPais.setBounds(40, 300, 70, 30);

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Pais:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 280, 30, 20);

        cmbLengua_Materna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbLengua_Materna);
        cmbLengua_Materna.setBounds(130, 300, 70, 30);

        cmbSegunda_Lengua.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbSegunda_Lengua);
        cmbSegunda_Lengua.setBounds(230, 300, 80, 30);

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Lengua Materna");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(130, 280, 90, 20);

        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Segunda Lengua");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(230, 280, 90, 20);

        cmbEscolaridad_Madre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbEscolaridad_Madre);
        cmbEscolaridad_Madre.setBounds(340, 300, 80, 30);

        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Escolaridad Madre");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(340, 280, 100, 20);

        cmbNac_Reg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbNac_Reg);
        cmbNac_Reg.setBounds(440, 300, 60, 30);

        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Nac Reg?");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(440, 280, 60, 20);

        cmbTipo_Discapacidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbTipo_Discapacidad);
        cmbTipo_Discapacidad.setBounds(520, 300, 80, 30);

        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Tipo Discapacidad");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(520, 280, 90, 20);

        btnImportar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImportar.setForeground(new java.awt.Color(102, 153, 255));
        btnImportar.setText("Importar Alumno");
        btnImportar.setBorder(null);
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });
        getContentPane().add(btnImportar);
        btnImportar.setBounds(40, 393, 560, 30);

        dtDatosAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos Paternos", "Apellidos Maternos", "Dni"
            }
        ));
        dtDatosAlumnos.getTableHeader().setReorderingAllowed(false);
        dtDatosAlumnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dtDatosAlumnosKeyPressed(evt);
            }
        });
        jpane.setViewportView(dtDatosAlumnos);

        getContentPane().add(jpane);
        jpane.setBounds(40, 430, 560, 170);

        txtCod_AlumnoBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCod_AlumnoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_AlumnoBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtCod_AlumnoBuscar);
        txtCod_AlumnoBuscar.setBounds(100, 90, 120, 30);

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Cod Alumno");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(100, 70, 110, 20);

        txtNombre_PersonaBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre_PersonaBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre_PersonaBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombre_PersonaBuscar);
        txtNombre_PersonaBuscar.setBounds(250, 90, 150, 30);

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Nombres y Apellidos:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(250, 70, 110, 20);

        txtDniBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDniBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtDniBuscar);
        txtDniBuscar.setBounds(430, 90, 110, 30);

        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Dni");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(430, 70, 30, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Buscar Alumno");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(50, 50, 110, 17);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(102, 153, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(270, 130, 100, 30);

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbSexo);
        cmbSexo.setBounds(530, 240, 70, 30);

        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Vive Madre?");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(450, 220, 60, 20);

        btnListarAlumnos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnListarAlumnos.setForeground(new java.awt.Color(102, 153, 255));
        btnListarAlumnos.setText("Listar Todos los alumnos");
        btnListarAlumnos.setBorder(null);
        btnListarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAlumnosActionPerformed(evt);
            }
        });
        getContentPane().add(btnListarAlumnos);
        btnListarAlumnos.setBounds(980, 620, 190, 40);

        btnAtras.setBorder(null);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras);
        btnAtras.setBounds(30, 610, 70, 60);

        imgFondo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(imgFondo);
        imgFondo.setBounds(0, 0, 1300, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarAlumnoActionPerformed
        // TODO add your handling code here:
        Object[][] row = {};
        DefaultTableModel model = (DefaultTableModel) dtDatosAlumnos.getModel();
        for (int i = 0; i < dtDatosAlumnos.getRowCount(); i++) {
            try {
                al.Insertar_Alumno(dtDatosAlumnos.getValueAt(i, 0).toString().trim(), dtDatosAlumnos.getValueAt(i, 1).toString().trim(), dtDatosAlumnos.getValueAt(i, 2).toString().trim(), dtDatosAlumnos.getValueAt(i, 3).toString().trim());
                model.removeRow(i);
                model.addRow(row);
            } catch (java.lang.NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Ingrese datos completos Completos");
            }
        }
        ListarAlumno();

    }//GEN-LAST:event_btnIngresarAlumnoActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        if (selecArchivo.showDialog(null, "Exportar") == JFileChooser.APPROVE_OPTION) {
            archivo = selecArchivo.getSelectedFile();
            if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                JOptionPane.showMessageDialog(null, modeloE.Exportar(archivo, jTListaAlumno) + "\n Formato ." + archivo.getName().substring(archivo.getName().lastIndexOf(".") + 1));
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato valido.");
            }
        }

    }//GEN-LAST:event_btnExportarActionPerformed

    private void dtDatosAlumnosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtDatosAlumnosKeyPressed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) dtDatosAlumnos.getModel();
        if (evt.getKeyCode() == 10) {
            Object[][] row = {};
            model.addRow(row);
        }
    }//GEN-LAST:event_dtDatosAlumnosKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) dtDatosAlumnos.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        TableColumnModel modCol = dtDatosAlumnos.getColumnModel();
        Object[][] row = {};
        model.addRow(row);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        // TODO add your handling code here:
        if (selecArchivo.showDialog(null, "Seleccionar archivo") == JFileChooser.APPROVE_OPTION) {
            archivo = selecArchivo.getSelectedFile();
            if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                dtDatosAlumnos.setSize(jpane.getWidth(), jpane.getHeight());
                JOptionPane.showMessageDialog(null, modeloE.Importar(archivo, dtDatosAlumnos) + "\n Formato ." + archivo.getName().substring(archivo.getName().lastIndexOf(".") + 1), "IMPORTAR EXCEL", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato valido.");
            }
        }
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        // TODO add your handling code here:
        switch (btn_Registrar.getText()) {
            case "Registrar":
                Cod_Estudiante = txtCod_Alumno.getText();
                Nombres = txtNombres.getText();
                Ap_Paterno = txtPaterno.getText();
                Ap_Materno = txtMaterno.getText();
                dni = txtDni.getText();
                fecha_nac = Fun.getFecha(dateFecha_nac);
                JOptionPane.showMessageDialog(null, fecha_nac);
                if (!Nombres.equals("")
                        && !Cod_Estudiante.equals("")
                        && !Ap_Paterno.equals("")
                        && !Ap_Materno.equals("")
                        && !dni.equals("")
                        && !Estado_Persona.equals("")
                        && !vive_padre.equals("")
                        && !vive_madre.equals("")
                        && !pais.equals("")
                        && !Lengua_Materna.equals("")
                        && !Segunda_Lengua.equals("")
                        && !Escolaridad_madre.equals("")
                        && !Nac_Registrado.equals("")
                        && !Tipo_Discapacidad.equals("")) {
                    
                    al.Insertar_Persona_Alumno(Cod_Estudiante, Nombres, Ap_Paterno, Ap_Materno, dni, Estado_Persona, fecha_nac, vive_padre, vive_madre, pais, Escolaridad_madre, Nac_Registrado, Tipo_Discapacidad, Lengua_Materna, Segunda_Lengua, sexo);
                    ListarAlumno();
                    LimpiarFrame();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Insertar DatosCompletos");
                }   break;
            case "Modificar":
                Cod_Estudiante = txtCod_Alumno.getText();
                Nombres = txtNombres.getText();
                Ap_Paterno = txtPaterno.getText();
                Ap_Materno = txtMaterno.getText();
                dni = txtDni.getText();
                fecha_nac = Fun.getFecha(dateFecha_nac);
                if (!Nombres.equals("")
                        && !Cod_Estudiante.equals("")
                        && !Ap_Paterno.equals("")
                        && !Ap_Materno.equals("")
                        && !dni.equals("")
                        && !Estado_Persona.equals("")
                        && !vive_padre.equals("")
                        && !vive_madre.equals("")
                        && !pais.equals("")
                        && !Lengua_Materna.equals("")
                        && !Segunda_Lengua.equals("")
                        && !Escolaridad_madre.equals("")
                        && !Nac_Registrado.equals("")) {
                    
                    al.Modificar_Persona_Alumno(id_persona, Cod_Estudiante, Nombres, Ap_Paterno, Ap_Materno, dni, Estado_Persona, fecha_nac, vive_padre, vive_madre, pais, Escolaridad_madre, Nac_Registrado, Tipo_Discapacidad, Lengua_Materna, Segunda_Lengua, sexo);
                    ListarAlumno();
                    btn_Registrar.setText("Registrar");
                    LimpiarFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresar datos completos");
                }   break;
        }
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void MenModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenModificarActionPerformed
        // TODO add your handling code here:
        int fila = jTListaAlumno.getSelectedRow();
        id_persona = (int) jTListaAlumno.getValueAt(fila, 0);
        List<Persona> p = al.ListarAlumnoxId(id_persona);
        if (p.size() > 0) {
            Persona per = new Persona();
            per = (Persona) p.get(0);
            id_persona = per.getId_Persona();
            txtCod_Alumno.setText(per.getCod_Estudiante());
            txtNombres.setText(per.getNombre_Persona());
            txtPaterno.setText(per.getApellido_Paterno());
            txtMaterno.setText(per.getApellido_Materno());
            txtDni.setText(per.getDni());
            if (per.getEstado_Persona() != null) {
                switch (per.getEstado_Persona()) {
                    case "1":
                        cmbEstado_Alumno.setSelectedItem("ACTIVO");
                        break;
                    case "0":
                        cmbEstado_Alumno.setSelectedItem("INACTIVO");
                        break;
                }
            } else {
                cmbEstado_Alumno.setSelectedItem("--");
            }

            if (per.getSexo() != null) {
                switch (per.getSexo()) {
                    case "H":
                        cmbSexo.setSelectedItem("Hombre");
                        break;
                    case "M":
                        cmbSexo.setSelectedItem("Mujer");
                        break;
                }
            } else {
                cmbSexo.setSelectedItem("--");
            }

            if (per.getFecha_Nacimiento() != null) {
                dateFecha_nac.setDate(Fun.Cambiar_Fecha(per.getFecha_Nacimiento()));
            } else {
            }
            if (per.getEs_Vida_Padre() != null) {
                switch (per.getEs_Vida_Padre()) {
                    case "1":
                        cmbVive_Padre.setSelectedItem("SI");
                        break;
                    case "0":
                        cmbVive_Padre.setSelectedItem("NO");
                        break;
                }
            } else {
                cmbVive_Padre.setSelectedIndex(0);
            }
            if (per.getEs_Vida_Madre() != null) {
                switch (per.getEs_Vida_Madre()) {
                    case "1":
                        cmbVive_Madre.setSelectedItem("SI");
                        break;
                    case "0":
                        cmbVive_Madre.setSelectedItem("NO");
                        break;
                }
            } else {
                cmbVive_Madre.setSelectedIndex(0);
            }
            if (per.getSegunda_Lengua() != null) {
                switch (per.getSegunda_Lengua()) {
                    case "C":
                        cmbSegunda_Lengua.setSelectedItem("Castellano");
                        break;
                    case "Q":
                        cmbSegunda_Lengua.setSelectedItem("Quechua");
                        break;
                    case "A":
                        cmbSegunda_Lengua.setSelectedItem("Aimara");
                        break;
                    case "O":
                        cmbSegunda_Lengua.setSelectedItem("Otra lengua");
                        break;
                    case "E":
                        cmbSegunda_Lengua.setSelectedItem("Lengua extranjera");
                        break;
                }
            } else {
                cmbSegunda_Lengua.setSelectedIndex(0);
            }
            if (per.getLengua_Materna() != null) {
                switch (per.getLengua_Materna()) {
                    case "C":
                        cmbLengua_Materna.setSelectedItem("Castellano");
                        break;
                    case "Q":
                        cmbLengua_Materna.setSelectedItem("Quechua");
                        break;
                    case "A":
                        cmbLengua_Materna.setSelectedItem("Aimara");
                        break;
                    case "O":
                        cmbLengua_Materna.setSelectedItem("Otra lengua");
                        break;
                    case "E":
                        cmbLengua_Materna.setSelectedItem("Lengua extranjera");
                        break;
                }
            } else {
                cmbLengua_Materna.setSelectedIndex(0);
            }
            if (per.getPais() != null) {
                switch (per.getPais()) {
                    case "1":
                        cmbPais.setSelectedItem("Perú");
                        break;
                    case "2":
                        cmbPais.setSelectedItem("Ecuador");
                        break;
                    case "3":
                        cmbPais.setSelectedItem("Colombia");
                        break;
                    case "4":
                        cmbPais.setSelectedItem("Brasil");
                        break;
                    case "5":
                        cmbPais.setSelectedItem("Bolivia");
                        break;
                    case "6":
                        cmbPais.setSelectedItem("Chile");
                        break;
                    case "7":
                        cmbPais.setSelectedItem("Otro");
                        break;
                }
            } else {
                cmbPais.setSelectedIndex(0);
            }
            if (per.getEscolaridad_Madre() != null) {
                switch (per.getEscolaridad_Madre()) {
                    case "A":
                        cmbEscolaridad_Madre.setSelectedItem("Analfabeta");
                        break;
                    case "P":
                        cmbEscolaridad_Madre.setSelectedItem("Primaria");
                        break;
                    case "S":
                        cmbEscolaridad_Madre.setSelectedItem("Secundaria");
                        break;
                    case "U":
                        cmbEscolaridad_Madre.setSelectedItem("Superior");
                        break;
                }
            } else {
                cmbEscolaridad_Madre.setSelectedIndex(0);
            }
            if (per.getNacimiento_Registrado() != null) {
                switch (per.getNacimiento_Registrado()) {
                    case "1":
                        cmbNac_Reg.setSelectedItem("SI");
                        break;
                    case "0":
                        cmbNac_Reg.setSelectedItem("NO");
                        break;
                }
            } else {
                cmbNac_Reg.setSelectedIndex(0);
            }
            if (per.getTipo_Discapacidad() != null) {
                switch (per.getTipo_Discapacidad()) {
                    case "I":
                        cmbTipo_Discapacidad.setSelectedItem("Intelectual");
                        break;
                    case "A":
                        cmbTipo_Discapacidad.setSelectedItem("Auditiva");
                        break;
                    case "V":
                        cmbTipo_Discapacidad.setSelectedItem("Visual");
                        break;
                    case "M":
                        cmbTipo_Discapacidad.setSelectedItem("Motora");
                        break;
                    case "O":
                        cmbTipo_Discapacidad.setSelectedItem("Otra");
                        break;
                    case "":
                        cmbTipo_Discapacidad.setSelectedIndex(0);
                        break;
                }
            } else {
                cmbTipo_Discapacidad.setSelectedIndex(0);
            }
            Listar_AlumnosBuscar(p);
            btn_Registrar.setText("Modificar");
        }

    }//GEN-LAST:event_MenModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String cod_Alumno = txtCod_AlumnoBuscar.getText();
        String Nombre_al = txtNombre_PersonaBuscar.getText();
        String Dni_Al = txtDniBuscar.getText();
        if (!cod_Alumno.equals("") || !Nombre_al.equals("") || !Dni_Al.equals("")) {
            List<Persona> lis = al.Buscar_Persona(cod_Alumno, Nombre_al, Dni_Al);
            if (lis.size() > 0) {
                if (lis.size() == 1) {
                    Persona per = new Persona();
                    per = (Persona) lis.get(0);
                    id_persona = per.getId_Persona();
                    txtCod_Alumno.setText(per.getCod_Estudiante());
                    txtNombres.setText(per.getNombre_Persona());
                    txtPaterno.setText(per.getApellido_Paterno());
                    txtMaterno.setText(per.getApellido_Materno());
                    txtDni.setText(per.getDni());
                    if (per.getEstado_Persona() != null) {
                        switch (per.getEstado_Persona()) {
                            case "1":
                                cmbEstado_Alumno.setSelectedItem("ACTIVO");
                                break;
                            case "0":
                                cmbEstado_Alumno.setSelectedItem("INACTIVO");
                                break;
                        }
                    } else {
                        cmbEstado_Alumno.setSelectedItem("--");
                    }

                    if (per.getSexo() != null) {
                        switch (per.getSexo()) {
                            case "H":
                                cmbSexo.setSelectedItem("Hombre");
                                break;
                            case "M":
                                cmbSexo.setSelectedItem("Mujer");
                                break;
                        }
                    } else {
                        cmbSexo.setSelectedItem("--");
                    }

                    if (per.getFecha_Nacimiento() != null) {
                        dateFecha_nac.setDate(Fun.Cambiar_Fecha(per.getFecha_Nacimiento()));
                    } else {
                    }
                    if (per.getEs_Vida_Padre() != null) {
                        switch (per.getEs_Vida_Padre()) {
                            case "1":
                                cmbVive_Padre.setSelectedItem("SI");
                                break;
                            case "0":
                                cmbVive_Padre.setSelectedItem("NO");
                                break;
                        }
                    } else {
                        cmbVive_Padre.setSelectedIndex(0);
                    }
                    if (per.getEs_Vida_Madre() != null) {
                        switch (per.getEs_Vida_Madre()) {
                            case "1":
                                cmbVive_Madre.setSelectedItem("SI");
                                break;
                            case "0":
                                cmbVive_Madre.setSelectedItem("NO");
                                break;
                        }
                    } else {
                        cmbVive_Madre.setSelectedIndex(0);
                    }
                    if (per.getSegunda_Lengua() != null) {
                        switch (per.getSegunda_Lengua()) {
                            case "C":
                                cmbSegunda_Lengua.setSelectedItem("Castellano");
                                break;
                            case "Q":
                                cmbSegunda_Lengua.setSelectedItem("Quechua");
                                break;
                            case "A":
                                cmbSegunda_Lengua.setSelectedItem("Aimara");
                                break;
                            case "O":
                                cmbSegunda_Lengua.setSelectedItem("Otra lengua");
                                break;
                            case "E":
                                cmbSegunda_Lengua.setSelectedItem("Lengua extranjera");
                                break;
                        }
                    } else {
                        cmbSegunda_Lengua.setSelectedIndex(0);
                    }
                    if (per.getLengua_Materna() != null) {
                        switch (per.getLengua_Materna()) {
                            case "C":
                                cmbLengua_Materna.setSelectedItem("Castellano");
                                break;
                            case "Q":
                                cmbLengua_Materna.setSelectedItem("Quechua");
                                break;
                            case "A":
                                cmbLengua_Materna.setSelectedItem("Aimara");
                                break;
                            case "O":
                                cmbLengua_Materna.setSelectedItem("Otra lengua");
                                break;
                            case "E":
                                cmbLengua_Materna.setSelectedItem("Lengua extranjera");
                                break;
                        }
                    } else {
                        cmbLengua_Materna.setSelectedIndex(0);
                    }
                    if (per.getPais() != null) {
                        switch (per.getPais()) {
                            case "1":
                                cmbPais.setSelectedItem("Perú");
                                break;
                            case "2":
                                cmbPais.setSelectedItem("Ecuador");
                                break;
                            case "3":
                                cmbPais.setSelectedItem("Colombia");
                                break;
                            case "4":
                                cmbPais.setSelectedItem("Brasil");
                                break;
                            case "5":
                                cmbPais.setSelectedItem("Bolivia");
                                break;
                            case "6":
                                cmbPais.setSelectedItem("Chile");
                                break;
                            case "7":
                                cmbPais.setSelectedItem("Otro");
                                break;
                        }
                    } else {
                        cmbPais.setSelectedIndex(0);
                    }
                    if (per.getEscolaridad_Madre() != null) {
                        switch (per.getEscolaridad_Madre()) {
                            case "A":
                                cmbEscolaridad_Madre.setSelectedItem("Analfabeta");
                                break;
                            case "P":
                                cmbEscolaridad_Madre.setSelectedItem("Primaria");
                                break;
                            case "S":
                                cmbEscolaridad_Madre.setSelectedItem("Secundaria");
                                break;
                            case "U":
                                cmbEscolaridad_Madre.setSelectedItem("Superior");
                                break;
                        }
                    } else {
                        cmbEscolaridad_Madre.setSelectedIndex(0);
                    }
                    if (per.getNacimiento_Registrado() != null) {
                        switch (per.getNacimiento_Registrado()) {
                            case "1":
                                cmbNac_Reg.setSelectedItem("SI");
                                break;
                            case "0":
                                cmbNac_Reg.setSelectedItem("NO");
                                break;
                        }
                    } else {
                        cmbNac_Reg.setSelectedIndex(0);
                    }
                    if (per.getTipo_Discapacidad() != null) {
                        switch (per.getTipo_Discapacidad()) {
                            case "I":
                                cmbTipo_Discapacidad.setSelectedItem("Intelectual");
                                break;
                            case "A":
                                cmbTipo_Discapacidad.setSelectedItem("Auditiva");
                                break;
                            case "V":
                                cmbTipo_Discapacidad.setSelectedItem("Visual");
                                break;
                            case "M":
                                cmbTipo_Discapacidad.setSelectedItem("Motora");
                                break;
                            case "O":
                                cmbTipo_Discapacidad.setSelectedItem("Otra");
                                break;
                            case "":
                                cmbTipo_Discapacidad.setSelectedIndex(0);
                                break;
                        }
                    } else {
                        cmbTipo_Discapacidad.setSelectedIndex(0);
                    }
                    Listar_AlumnosBuscar(lis);
                    btn_Registrar.setText("Modificar");
                } else if (lis.size() > 1) {
                    LimpiarFrame();
                    Listar_AlumnosBuscar(lis);
                    btn_Registrar.setText("Registrar");
                }
            } else {
                DefaultTableModel model = (DefaultTableModel) jTListaAlumno.getModel();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                model.addRow(new Object[]{"No hay registro", "No hay registro", "No hay registro", "No hay registro", "No hay registro", "No hay registro", "No hay registro"});
                jTListaAlumno.setModel(model);
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnListarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAlumnosActionPerformed
        // TODO add your handling code here:
        ListarAlumno();
    }//GEN-LAST:event_btnListarAlumnosActionPerformed

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

    private void txtCod_AlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_AlumnoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtCod_Alumno.getText().length() == 14) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCod_AlumnoKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtNombres.getText().length() == 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtPaterno.getText().length() == 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPaternoKeyTyped

    private void txtMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtMaterno.getText().length() == 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMaternoKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtDni.getText().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void dateFecha_nacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateFecha_nacKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_dateFecha_nacKeyTyped

    private void txtCod_AlumnoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_AlumnoBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtCod_AlumnoBuscar.getText().length() == 14) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCod_AlumnoBuscarKeyTyped

    private void txtNombre_PersonaBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_PersonaBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtNombre_PersonaBuscar.getText().length() == 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombre_PersonaBuscarKeyTyped

    private void txtDniBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtDniBuscar.getText().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniBuscarKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IngresarDatos;
    private javax.swing.JLabel IngresarDatos1;
    private javax.swing.JMenuItem MenActivar;
    private javax.swing.JMenuItem MenDesactivar;
    private javax.swing.JMenuItem MenModificar;
    private javax.swing.JPopupMenu MenuOpcion;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnExportar;
    public javax.swing.JButton btnImportar;
    private javax.swing.JButton btnIngresarAlumno;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListarAlumnos;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JComboBox cmbEscolaridad_Madre;
    private javax.swing.JComboBox cmbEstado_Alumno;
    private javax.swing.JComboBox cmbLengua_Materna;
    private javax.swing.JComboBox cmbNac_Reg;
    private javax.swing.JComboBox cmbPais;
    private javax.swing.JComboBox cmbSegunda_Lengua;
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JComboBox cmbTipo_Discapacidad;
    private javax.swing.JComboBox cmbVive_Madre;
    private javax.swing.JComboBox cmbVive_Padre;
    private com.toedter.calendar.JDateChooser dateFecha_nac;
    public javax.swing.JTable dtDatosAlumnos;
    private javax.swing.JLabel imgBarraTitulo;
    private javax.swing.JLabel imgBarraTitulo1;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTListaAlumno;
    private javax.swing.JScrollPane jpane;
    private javax.swing.JTextField txtCod_Alumno;
    private javax.swing.JTextField txtCod_AlumnoBuscar;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDniBuscar;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre_PersonaBuscar;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}
