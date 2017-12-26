/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfaceBimestreDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class BimestreDAO implements InterfaceBimestreDAO {

    conexion con;

    @Override
    public String BimestrexId(int id) {
        String Nombre = "";
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select * from Bimestre where id_bimestre=" + id;
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Nombre = rs.getString("bimestre");
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
        return Nombre;
    }

}
