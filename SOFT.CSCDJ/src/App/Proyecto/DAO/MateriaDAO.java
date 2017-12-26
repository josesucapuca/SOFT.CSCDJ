/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfaceMateriaDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Materia;
import App.Proyecto.Modelo.V_Dca_Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class MateriaDAO implements InterfaceMateriaDAO {

    conexion con;

    @Override
    public List<Materia> ListarMateria() {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "execute ListarMateria";
        List<Materia> lis = new ArrayList<Materia>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Materia ma = new Materia();
                ma.setId_Materia(rs.getInt("id_Materia"));
                ma.setNombre_Materia(rs.getString("Nombre_Materia"));
                ma.setLi_Tipo_Materia(rs.getString("li_Ti_Materia"));
                ma.setEstado_Materia(rs.getString("Estado_Materia"));
                lis.add(ma);
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
        return lis;
    }

    @Override
    public void InsertarMateria(String Nombre_Materia, String Li_Ti_Materia, String Estado_Materia) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute InsertarMateria ?, ?, ?");
            ps.setString(1, Nombre_Materia);
            ps.setString(2, Li_Ti_Materia);
            ps.setString(3, Estado_Materia);
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
    public void ModificarMateria(int id_Materia, String Nombre_Materia, String Li_Ti_Materia, String Estado_Materia) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute ModificarMateria ?, ?, ?, ?");
            ps.setInt(1, id_Materia);
            ps.setString(2, Nombre_Materia);
            ps.setString(3, Li_Ti_Materia);
            ps.setString(4, Estado_Materia);
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
    public int ListarMateriaxNombre(String Materia) {
        int id = 0;
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select * from Materia where Nombre_Materia like '%" + Materia.trim() + "%'";
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                id = rs.getInt("id_Materia");
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
        return id;
    }

    @Override
    public List<V_Dca_Materia> ListarMateriaxid_Matricula(int id) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select dca.id_Detalle_Carga_Academica,m.id_Materia, m.Nombre_Materia,m.li_Ti_Materia from Carga_Academica ca, Detalle_Carga_Academica dca, Materia_Profesor mp, Grado_Materia gm, Materia m \n"
                + "where ca.id_Carga_Academica=dca.id_Carga_Academica and \n"
                + "dca.id_Materia_Profesor=mp.id_Materia_Profesor and \n"
                + "mp.id_Grado_Materia=gm.id_Grado_Materia and\n"
                + "gm.id_Materia=m.id_Materia and ca.id_Matricula=" + id + " order by m.li_Ti_Materia";
        List<V_Dca_Materia> lis = new ArrayList<V_Dca_Materia>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                V_Dca_Materia ma = new V_Dca_Materia();
                ma.setId_Detalle_Carga_Academica(rs.getInt("id_Detalle_Carga_Academica"));
                ma.setId_Materia(rs.getInt("id_Materia"));
                ma.setNombre_Materia(rs.getString("Nombre_Materia"));
                ma.setLi_Ti_Materia(rs.getString("li_Ti_Materia"));
                lis.add(ma);
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
        return lis;
    }

    @Override
    public int ListarIdDcaxNombre(String Materia, int id_Matricula) {
        int id = 0;
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select dca.id_Detalle_Carga_Academica,m.id_Materia, m.Nombre_Materia,m.li_Ti_Materia from Carga_Academica ca, Detalle_Carga_Academica dca, Materia_Profesor mp, Grado_Materia gm, Materia m \n"
                + "where ca.id_Carga_Academica=dca.id_Carga_Academica and \n"
                + "dca.id_Materia_Profesor=mp.id_Materia_Profesor and \n"
                + "mp.id_Grado_Materia=gm.id_Grado_Materia and\n"
                + "gm.id_Materia=m.id_Materia and ca.id_Matricula=" + id_Matricula + " and m.Nombre_Materia like '%" + Materia.trim() + "%' order by m.li_Ti_Materia";
        try {
            ResultSet rs = con.query(sql);
            ResultSetMetaData rd = rs.getMetaData();
            if (rd.getColumnCount() > 0) {
                while (rs.next()) {
                    id = rs.getInt("id_Detalle_Carga_Academica");
                }
            } else {

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
        return id;
    }

}
