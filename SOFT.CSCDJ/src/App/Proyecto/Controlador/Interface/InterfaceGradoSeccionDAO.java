/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Controlador.Interface;

import App.Proyecto.Modelo.Grado_SeccionComp;
import java.util.List;

/**
 *
 * @author user
 */
public interface InterfaceGradoSeccionDAO {

    List<Grado_SeccionComp> Listar_Grado_Seccion();

    void Insertar_Grado(String Nombre_Grado, String Li_Nivel, int id_Seccion, String Estado_Grado);

    void Modificar_Grado(int id_Grado, String Nombre_Grado, String Li_Nivel, int id_Seccion, String Estado_Grado);
    
    int LIstar_SeccionxNombre(String Nombre_Seccion);
}
