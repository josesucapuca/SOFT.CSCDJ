/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package App.Proyecto.Controlador.Interface;

import App.Proyecto.Modelo.Materia;
import App.Proyecto.Modelo.V_Dca_Materia;
import java.util.List;

/**
 *
 * @author user
 */
public interface InterfaceMateriaDAO {
    List<Materia> ListarMateria();
    List<V_Dca_Materia> ListarMateriaxid_Matricula(int id);
    int ListarMateriaxNombre(String Materia);
    int ListarIdDcaxNombre(String Materia, int id_Matricula);
    void InsertarMateria(String Nombre_Materia,String Li_Ti_Materia,String Estado_Materia);
    void ModificarMateria(int id_Materia,String Nombre_Materia,String Li_Ti_Materia,String Estado_Materia);
}
