/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Controlador.Interface;

import App.Proyecto.Modelo.Usuario;
import java.util.List;

/**
 *
 * @author Barrantes Tapia
 */
public interface InterfaceUsuarioDAO {

    public List<Usuario> logueo(String Usuario, String Contraseña);

    public List<Usuario> Listar_Usuarios();

    public void Insertar_Usuarios(int id_Persona, String Usuario, String Contraseña, String Fe_Vencimiento, String Estado_Usuario);

    public void Modificar_Usuario(int id_usuario, int id_Persona, String Usuario, String Contraseña, String Fe_Vencimiento, String Estado_Usuario);
}
