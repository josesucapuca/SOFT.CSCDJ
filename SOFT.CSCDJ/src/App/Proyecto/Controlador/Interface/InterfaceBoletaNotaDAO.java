/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Controlador.Interface;

import App.Proyecto.Modelo.V_Boleta_Nota;
import java.util.List;

/**
 *
 * @author user
 */
public interface InterfaceBoletaNotaDAO {

    List<V_Boleta_Nota> Lista_VistaBoletaNota(int id_Detale_dca);

    void Modificar_Nota(int id_Boleta_Nota,Double Nota,String Nota_Letra);
}
