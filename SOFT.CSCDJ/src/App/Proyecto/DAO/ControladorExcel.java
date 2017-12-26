/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.DAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import App.Proyecto.Form.RegistroAlumnos;
import App.Proyecto.Modelo.Modelo_Excel;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Beth
 */
public class ControladorExcel implements ActionListener {

    Modelo_Excel modeloE = new Modelo_Excel();
    RegistroAlumnos vistaE = new RegistroAlumnos();
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int contAccion = 0;

    public ControladorExcel(RegistroAlumnos vistaE, Modelo_Excel modeloE) {
        this.vistaE = vistaE;
        this.modeloE = modeloE;
        this.vistaE.btnImportar.addActionListener(this);
        this.vistaE.btnExportar.addActionListener(this);
    }

    public void AgregarFiltro() {
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contAccion++;
        if (contAccion == 1) {
            AgregarFiltro();
        }

        if (e.getSource() == vistaE.btnImportar) {
            if (selecArchivo.showDialog(null, "Seleccionar archivo") == JFileChooser.APPROVE_OPTION) {
                archivo = selecArchivo.getSelectedFile();
                if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                    JOptionPane.showMessageDialog(null,
                            modeloE.Importar(archivo, vistaE.dtDatosAlumnos) + "\n Formato ." + archivo.getName().substring(archivo.getName().lastIndexOf(".") + 1),
                            "IMPORTAR EXCEL", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Elija un formato valido.");
                }
            }
        }

        if (e.getSource() == vistaE.btnExportar) {
            if (selecArchivo.showDialog(null, "Exportar") == JFileChooser.APPROVE_OPTION) {
                archivo = selecArchivo.getSelectedFile();
                if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                    JOptionPane.showMessageDialog(null, modeloE.Exportar(archivo, vistaE.dtDatosAlumnos) + "\n Formato ." + archivo.getName().substring(archivo.getName().lastIndexOf(".") + 1));
                } else {
                    JOptionPane.showMessageDialog(null, "Elija un formato valido.");
                }
            }
        }
    }

}
