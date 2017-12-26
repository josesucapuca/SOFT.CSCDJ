/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfaceListadosDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Grado_Seccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author admin-ronald.arrieta
 */
public class ListadosDAO implements InterfaceListadosDAO{

     conexion con;

    @Override
    public List<Grado_Seccion> ListarGradoSeccion() {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "execute ListarGradoSeccion";
        List<Grado_Seccion> list = new ArrayList<Grado_Seccion>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Grado_Seccion gr = new Grado_Seccion();
                gr.setId_Grado(rs.getInt("id_Grado"));
                gr.setGrado_seccion(rs.getString("grado_seccion"));
                list.add(gr);
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
    public int Validar_Grado(String Nombre_Grado) {
        int id_grado = 0;
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select * from(select gr.id_Grado,gr.nombre_Grado+'  '+ case when sc.Nombre_Seccion IS NULL THEN '' WHEN sc.Nombre_Seccion IS NOT NULL THEN '\"'+RTRIM( sc.Nombre_Seccion)+'\"' END as grado_seccion\n FROM Grado gr left outer join Seccion sc on gr.id_seccion=sc.id_Seccion)as a where a.grado_seccion='" + Nombre_Grado + "'";
        try {
            ResultSet rs = this.con.query(sql);
            while (rs.next()) {
                id_grado = rs.getInt("id_Grado");
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
