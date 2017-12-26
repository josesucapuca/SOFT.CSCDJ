/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfaceAñoDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Ano;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin-ronald.arrieta
 */
public class AnoDAO implements InterfaceAñoDAO{

    conexion con;
    @Override
    public List<Ano> Listar_Ano() {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "execute ListarAno";
        List<Ano> lis = new ArrayList<Ano>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Ano an = new Ano();
                an.setId_año(rs.getInt("id_Periodo"));
                an.setAño(rs.getString("ano"));
                lis.add(an);
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
    public int Anoxnombre(String Ano) {
         int id_año=0;
       this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select * from Periodo where ano='"+Ano+"'";
        try {
            ResultSet rs = this.con.query(sql);
            while (rs.next()) {
                id_año=rs.getInt("id_Periodo");
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
        return id_año;
    }
    
}
