/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Modelo;

import App.Proyecto.Form.RegistroAlumnos;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Beth
 */
public class Funciones {

    SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");

    public String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    public Date ParseFecha(String fecha) {
        SimpleDateFormat Formato2 = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = null;
        try {
            fechaDate = Formato2.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public Date Cambiar_Fecha(String Fecha) {
        String Convertido=null;
        String[] parts = Fecha.split("-");
        Convertido=parts[2]+"/"+parts[1]+"/"+parts[0]; 
        SimpleDateFormat Formato2 = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = Formato2.parse(Convertido);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
}
