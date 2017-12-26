/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfaceSeccionDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Seccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class SeccionDAO implements InterfaceSeccionDAO {

    conexion con;

    @Override
    public List<Seccion> Listar_Seccion() {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "execute ListarSeccion";
        List<Seccion> list = new ArrayList<Seccion>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Seccion sec = new Seccion();
                sec.setId_seccion(rs.getInt("id_Seccion"));
                sec.setNombre_Seccion(rs.getString("Nombre_Seccion"));
                sec.setEstado_Seccion(rs.getString("Estado_Seccion"));
                list.add(sec);
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
    public void Insertar_Seccion(String Nombre_Seccion, String Estado_Seccion) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute InsertarSeccion ?, ?");
            ps.setString(1, Nombre_Seccion);
            ps.setString(2, Estado_Seccion);
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
    public void Modificar_Seccion(int id_Seccion, String Nombre_Seccion, String Estado_Seccion) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute ModificarSeccion ?, ?, ?");
            ps.setInt(1, id_Seccion);
            ps.setString(2, Nombre_Seccion);
            ps.setString(3, Estado_Seccion);
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
