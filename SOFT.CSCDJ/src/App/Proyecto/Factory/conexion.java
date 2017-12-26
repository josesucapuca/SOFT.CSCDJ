/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Barrantes Tapia
 */
public abstract class conexion {

    public Connection conex;

    abstract Connection open();

    public ResultSet query(String sql) {
        System.out.println("query  :" + sql);
        Statement st;
        ResultSet rs = null;
        try {
            st = conex.createStatement();
            rs = st.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
    
    public boolean close() {
        boolean ok = true;
        try {
            conex.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok;
    }

}
