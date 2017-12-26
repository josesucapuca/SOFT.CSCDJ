/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package App.Proyecto.Controlador.Interface;

import App.Proyecto.Modelo.Ano;
import java.util.List;

/**
 *
 * @author admin-ronald.arrieta
 */
public interface InterfaceAñoDAO {
    List<Ano> Listar_Ano();
    int Anoxnombre(String Ano);
}
