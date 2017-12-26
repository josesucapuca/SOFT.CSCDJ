/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package App.Proyecto.Controlador.Interface;

import App.Proyecto.Modelo.Grado_Seccion;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author admin-ronald.arrieta
 */
public interface InterfaceListadosDAO {
    List<Grado_Seccion> ListarGradoSeccion();
    int Validar_Grado(String Nombre_Grado);
}
