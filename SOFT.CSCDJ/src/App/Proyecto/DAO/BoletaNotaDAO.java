/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfaceBoletaNotaDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.V_Boleta_Nota;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class BoletaNotaDAO implements InterfaceBoletaNotaDAO {

    conexion con;

    @Override
    public List<V_Boleta_Nota> Lista_VistaBoletaNota(int id_Detale_dca) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select bn.id_boleta_Nota,ca.id_Matricula,bn.id_calificacion,dca.id_Detalle_Carga_Academica,\n"
                + "dca.id_Materia_Profesor,bn.Nota,bn.Nota_Letra,bn.Estado_Boleta_Nota, \n"
                + "gm.id_Materia,c.Nombre_Calificacion,bn.id_Bimestre,c.li_Tipo_Calificacion\n"
                + "from Boleta_Nota bn, Detalle_Carga_Academica dca, Carga_Academica ca,Materia_Profesor mp,Grado_Materia gm,Calificacion c \n"
                + "where c.id_Calificacion=bn.id_calificacion \n"
                + "and ca.id_Carga_Academica=dca.id_Carga_Academica \n"
                + "and bn.id_Detalle_Carga_Academica=dca.id_Detalle_Carga_Academica \n"
                + "and dca.id_Materia_Profesor=mp.id_Materia_Profesor \n"
                + "and mp.id_Grado_Materia=gm.id_Grado_Materia \n"
                + "and dca.id_Detalle_Carga_Academica=" + id_Detale_dca + " order by bn.id_Bimestre";
        List<V_Boleta_Nota> List = new ArrayList<V_Boleta_Nota>();
        try {
            ResultSet rs = this.con.query(sql);
            while (rs.next()) {
                V_Boleta_Nota us = new V_Boleta_Nota();
                us.setId_Boleta_Nota(rs.getInt("id_boleta_Nota"));
                us.setId_Matricula(rs.getInt("id_Matricula"));
                us.setId_calificacion(rs.getInt("id_calificacion"));
                us.setId_Detalle_Carga_Academica(rs.getInt("id_Detalle_Carga_Academica"));
                us.setId_Materia_Profesor(rs.getInt("id_Materia_Profesor"));
                us.setNota(rs.getDouble("Nota"));
                us.setNota_Letra(rs.getString("Nota_Letra"));
                us.setEstado_Boleta_Nota(rs.getString("Estado_Boleta_Nota"));
                us.setId_Materia(rs.getInt("id_Materia"));
                us.setNombre_Calificacion(rs.getString("Nombre_Calificacion"));
                us.setId_Bimestre(rs.getInt("id_Bimestre"));
                us.setLi_Tipo_Calificacion(rs.getString("li_Tipo_Calificacion"));
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
    public void Modificar_Nota(int id_Boleta_Nota, Double Nota, String Nota_Letra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
