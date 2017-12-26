/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfaceUsuarioDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Barrantes Tapia
 */
public class UsuarioDAO implements InterfaceUsuarioDAO {

    conexion con;

    @Override
    public List<Usuario> logueo(String Usuario, String Contraseña) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select u.*,UPPER(case when p.Apellido_Paterno IS NULL then '' when p.Apellido_Paterno IS NOT NULL THEN p.Apellido_Paterno END+' '+case when p.Apellido_Materno IS NULL then '' when p.Apellido_Materno IS NOT NULL THEN p.Apellido_Materno END)+' '+STUFF(LOWER(p.Nombre_Persona),1,1,UPPER(LEFT(p.Nombre_Persona,1))) as Persona,p.li_tipo_persona,\n" +
"case when u.Fe_Vencimiento>GETDATE()then '1' when u.Fe_Vencimiento<GETDATE() then '0' end as Estado_Abierto\n" +
" from dbo.Usuario u,Persona p where u.id_Persona=p.id_Persona and u.Nombre_Usuario='"+Usuario.trim() +"' and u.TPassword='"+Contraseña.trim()+"'";
        List<Usuario> List = new ArrayList<Usuario>();
        try {
            ResultSet rs = this.con.query(sql);
            while (rs.next()) { 
                Usuario us = new Usuario();
                us.setId_Usuario(rs.getString("id_Usuario"));
                us.setId_persona(rs.getString("id_Persona"));
                us.setNombre_Usuario(rs.getString("Nombre_Usuario"));
                us.setPassword(rs.getString("TPassword"));
                us.setEstado_Usuario(rs.getString("Estado_Usuario"));
                us.setPersona(rs.getString("Persona"));
                us.setLi_tipo_persona(rs.getString("li_tipo_persona"));
                us.setEstado_Abierto(rs.getString("Estado_Abierto"));
                List.add(us);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error: " + ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        } finally {
            try {
                this.con.close();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return List;
    }

    @Override
    public List<Usuario> Listar_Usuarios() {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "execute ListarUsuario";
        List<Usuario> list = new ArrayList<Usuario>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId_Usuario(rs.getString("id_Usuario"));
                us.setId_persona(rs.getString("id_Persona"));
                us.setNombre_Usuario(rs.getString("Nombre_Usuario"));
                us.setPassword(rs.getString("TPassword"));
                us.setFe_Vencimiento(rs.getString("Fe_Vencimiento"));
                us.setEstado_Usuario(rs.getString("Estado_Usuario"));
                us.setPersona(rs.getString("Persona"));
                us.setLi_tipo_persona(rs.getString("li_tipo_persona"));
                list.add(us);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error: " + ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        } finally {
            try {
                this.con.close();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return list;
    }

    @Override
    public void Insertar_Usuarios(int id_Persona, String Usuario, String Contraseña, String Fe_Vencimiento, String Estado_Usuario) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute InsertarUsuario ?, ?, ?, ?, ?");
            ps.setInt(1, id_Persona);
            ps.setString(2, Usuario);
            ps.setString(3, Contraseña);
            ps.setString(4, Fe_Vencimiento);
            ps.setString(5, Estado_Usuario);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Error: " + ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        } finally {
            try {
                this.con.close();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    @Override
    public void Modificar_Usuario(int id_usuario, int id_Persona, String Usuario, String Contraseña, String Fe_Vencimiento, String Estado_Usuario) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute Modificar_Usuario ?, ?, ?, ?, ?, ?");
            ps.setInt(1, id_usuario);
            ps.setInt(2, id_Persona);
            ps.setString(3, Usuario);
            ps.setString(4, Contraseña);
            ps.setString(5, Fe_Vencimiento);
            ps.setString(6, Estado_Usuario);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Error: " + ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        } finally {
            try {
                this.con.close();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}
