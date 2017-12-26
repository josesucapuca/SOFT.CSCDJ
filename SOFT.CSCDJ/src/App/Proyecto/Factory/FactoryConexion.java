/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Factory;

import App.Proyecto.Factory.conexion;
import App.Proyecto.Factory.SQLSERVER;

/**
 *
 * @author Barrantes Tapia
 */
public class FactoryConexion {

    public static final int SQLSERVER = 3;
    public static String[] configSQLServer = {"sa", "sys"};

    public static conexion open(int typeDB) {
        switch (typeDB) {
            case FactoryConexion.SQLSERVER:
                return new SQLSERVER(configSQLServer);
            default:
                return null;
        }
    }
}
