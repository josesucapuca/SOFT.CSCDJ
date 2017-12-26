/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package App.Proyecto.Controlador.Interface;

import App.Proyecto.Modelo.Matricula;
import java.util.List;

/**
 *
 * @author Admin-ronald.arrieta
 */
public interface InterfaceMatriculaDAO {
    public List<Matricula> Listar_Matricula();
    public List<Matricula> Listar_Matriculaxid(int id_Matricula);
    public List<Matricula> Buscar_Matriculaxidgradoxidano(int id_grado,int id_periodo);
    void Insertar_Matricula(int id_persona,int id_grado,int id_año,String Es_Trabajo,String Nro_Ho_Sem,String Li_Ti_Mat);
    void Modificar_Matricula(int id_Matricula,int id_grado,int id_año,String Es_Trabajo,String Nro_Ho_Sem,String Li_Ti_Mat);
}
