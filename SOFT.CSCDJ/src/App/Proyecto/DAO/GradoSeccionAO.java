/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfaceGradoSeccionDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Grado_SeccionComp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class GradoSeccionAO implements InterfaceGradoSeccionDAO {

    conexion con;

    @Override
    public List<Grado_SeccionComp> Listar_Grado_Seccion() {

        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "execute ListarGrado";
        List<Grado_SeccionComp> list = new ArrayList<Grado_SeccionComp>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Grado_SeccionComp gs = new Grado_SeccionComp();
                gs.setId_Grado(rs.getInt("id_Grado"));
                gs.setNombre_Grado(rs.getString("nombre_Grado"));
                gs.setId_Seccion(Integer.toString(rs.getInt("id_Seccion")));
                gs.setSeccion(rs.getString("Seccion"));
                gs.setLi_Nivel(rs.getString("li_Nivel"));
                gs.setEstado_Grado(rs.getString("Estado_Grado"));
                list.add(gs);
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
    public void Insertar_Grado(String Nombre_Grado, String Li_Nivel, int id_Seccion, String Estado_Grado) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute InsertarGrado ?, ?, ?, ?");
            ps.setString(1, Nombre_Grado);
            ps.setString(2, Li_Nivel);
            ps.setInt(3, id_Seccion);
            ps.setString(4, Estado_Grado);
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
    public void Modificar_Grado(int id_Grado, String Nombre_Grado, String Li_Nivel, int id_Seccion, String Estado_Grado) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute ModificarGrado ?, ?, ?, ?, ?");
            ps.setInt(1, id_Grado);
            ps.setString(2, Nombre_Grado);
            ps.setString(3, Li_Nivel);
            ps.setInt(4, id_Seccion);
            ps.setString(5, Estado_Grado);
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
    public int LIstar_SeccionxNombre(String Nombre_Seccion) {
        int id_grado=0;
       this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select * from Seccion where Nombre_Seccion like '%"+Nombre_Seccion+"%'";
        try {
            ResultSet rs = this.con.query(sql);
            while (rs.next()) {
                id_grado=rs.getInt("id_Seccion");
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
        return id_grado;
    }



}
