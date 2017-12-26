/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Barrantes Tapia
 */
public final class SQLSERVER extends conexion {
String[] parametro;

    public SQLSERVER(String[] parametro) {
        this.parametro = parametro;
        this.open();
    }

    @Override
    Connection open() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                this.conex = DriverManager.getConnection("jdbc:odbc:ProyectoColegio", parametro[0], parametro[1]);
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
        return this.conex;
    }

}
