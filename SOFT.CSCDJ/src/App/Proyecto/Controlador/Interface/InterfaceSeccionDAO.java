/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Controlador.Interface;

import App.Proyecto.Modelo.Seccion;
import java.util.List;

/**
 *
 * @author user
 */
public interface InterfaceSeccionDAO {

    List<Seccion> Listar_Seccion();

    void Insertar_Seccion(String Nombre_Seccion,String Estado_Seccion);

    void Modificar_Seccion(int id_Seccion,String Nombre_Seccion,String Estado_Seccion);
}
