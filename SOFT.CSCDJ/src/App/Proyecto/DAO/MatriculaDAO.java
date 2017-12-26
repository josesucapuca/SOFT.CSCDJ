/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfaceMatriculaDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Matricula;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin-ronald.arrieta
 */
public class MatriculaDAO implements InterfaceMatriculaDAO {

    conexion con;

    @Override
    public List<Matricula> Listar_Matricula() {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "execute ListaTableMatricula";
        List<Matricula> list = new ArrayList<Matricula>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Matricula per = new Matricula();
                per.setAlumno(rs.getString("Alumno"));
                per.setAño(rs.getString("ano"));
                per.setId_Matricula(rs.getInt("id_Matricula"));
                per.setId_Persona(rs.getInt("id_persona"));
                per.setId_Grado(rs.getInt("id_grado"));
                per.setId_Periodo(rs.getInt("id_Periodo"));
                per.setFe_Matricula(rs.getDate("Fecha_Matricula"));
                per.setLi_Estado_Matricula(rs.getString("li_estado_Matricula"));
                per.setEstado_Trabajo(rs.getString("Estado_Trabaja"));
                per.setHoras_Sem_Labora(rs.getString("Horas_Sem_Labora"));
                per.setEstado_Matricula(rs.getString("Estado_Matricula"));
                per.setDni(rs.getString("dni"));
                per.setCod_Estudiante(rs.getString("Cod_Estudiante"));
                per.setGrado_seccion(rs.getString("grado_seccion"));
                list.add(per);
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
    public void Insertar_Matricula(int id_persona, int id_grado, int id_año, String Es_Trabajo, String Nro_Ho_Sem, String Li_Tipo_Mat) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute InsertarMatricula ?, ?, ?, ?, ?, ?");
            ps.setInt(1, id_persona);
            ps.setInt(2, id_grado);
            ps.setInt(3, id_año);
            ps.setString(4, Es_Trabajo);
            ps.setString(5, Nro_Ho_Sem);
            ps.setString(6, Li_Tipo_Mat);
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
    public List<Matricula> Listar_Matriculaxid(int id_Matricula) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select mat.*, gs.grado_seccion from (select CONVERT(nvarchar(100), ltrim(Rtrim(p.Nombre_Persona))+' '+ltrim(Rtrim(p.Apellido_Paterno))+' '+ltrim(Rtrim(Apellido_Materno)))as Alumno ,a.ano as ano,m.*,p.dni from Matricula m,Persona p, Grado g,Periodo a where  p.id_Persona=m.id_persona  and m.id_grado=g.id_Grado and m.id_Periodo=a.id_Periodo) as mat left outer join (select gr.id_Grado,gr.nombre_Grado+'  '+ case when sc.Nombre_Seccion IS NULL THEN '' WHEN sc.Nombre_Seccion IS NOT NULL THEN '\\\"'+sc.Nombre_Seccion+'\\\"' END as grado_seccion FROM Grado gr left outer join Seccion sc on gr.id_seccion=sc.id_Seccion) as gs on gs.id_Grado=mat.id_Grado WHERE mat.id_Matricula=" + id_Matricula;
        List<Matricula> list = new ArrayList<Matricula>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Matricula per = new Matricula();
                per.setAlumno(rs.getString("Alumno"));
                per.setAño(rs.getString("ano"));
                per.setId_Matricula(rs.getInt("id_Matricula"));
                per.setId_Persona(rs.getInt("id_persona"));
                per.setId_Grado(rs.getInt("id_grado"));
                per.setId_Periodo(rs.getInt("id_Periodo"));
                per.setFe_Matricula(rs.getDate("Fecha_Matricula"));
                per.setLi_Estado_Matricula(rs.getString("li_estado_Matricula"));
                per.setEstado_Trabajo(rs.getString("Estado_Trabaja"));
                per.setHoras_Sem_Labora(rs.getString("Horas_Sem_Labora"));
                per.setEstado_Matricula(rs.getString("Estado_Matricula"));
                per.setDni(rs.getString("dni"));
                per.setGrado_seccion(rs.getString("grado_seccion"));
                list.add(per);
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
    public void Modificar_Matricula(int id_Matricula, int id_grado, int id_año, String Es_Trabajo, String Nro_Ho_Sem, String Li_Ti_Mat) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute ModificarMatricula ?, ?, ?, ?, ?, ?");
            ps.setInt(1, id_Matricula);
            ps.setInt(2, id_grado);
            ps.setInt(3, id_año);
            ps.setString(4, Es_Trabajo);
            ps.setString(5, Nro_Ho_Sem);
            ps.setString(6, Li_Ti_Mat);
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
    public List<Matricula> Buscar_Matriculaxidgradoxidano(int id_grado, int id_periodo) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select mat.*, gs.grado_seccion from (select ltrim(Rtrim(p.Nombre_Persona))+' '+ltrim(Rtrim(p.Apellido_Paterno))+' '+ltrim(Rtrim(Apellido_Materno))as Alumno\n"
                + "	,a.ano as ano,m.*,p.dni\n"
                + "	from Matricula m,Persona p, Grado g,Periodo a where  p.id_Persona=m.id_persona  and m.id_grado=g.id_Grado and m.id_Periodo=a.id_Periodo) as mat left outer join \n"
                + "	(select gr.id_Grado,gr.nombre_Grado+'  '+ case when sc.Nombre_Seccion IS NULL THEN '' WHEN sc.Nombre_Seccion IS NOT NULL THEN '\"'+RTRIM(sc.Nombre_Seccion)+'\"' END as grado_seccion\n"
                + "	FROM Grado gr left outer join Seccion sc on gr.id_seccion=sc.id_Seccion) as gs on gs.id_Grado=mat.id_Grado ";
        if (id_grado != 0) {
            if (id_periodo != 0) {
                sql = sql + "where mat.id_grado=" + id_grado + " and mat.id_Periodo=" + id_periodo + " order by id_Periodo,Alumno";
            } else {
                sql = sql + "where mat.id_grado=" + id_grado + " order by id_Periodo,Alumno";
            }
        } else {
            if (id_periodo != 0) {
                sql = sql + "where mat.id_Periodo=" + id_periodo + " order by id_Periodo,Alumno";
            } else {
            }
        }
        List<Matricula> list = new ArrayList<Matricula>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Matricula per = new Matricula();
                per.setAlumno(rs.getString("Alumno"));
                per.setAño(rs.getString("ano"));
                per.setId_Matricula(rs.getInt("id_Matricula"));
                per.setId_Persona(rs.getInt("id_persona"));
                per.setId_Grado(rs.getInt("id_grado"));
                per.setId_Periodo(rs.getInt("id_Periodo"));
                per.setFe_Matricula(rs.getDate("Fecha_Matricula"));
                per.setLi_Estado_Matricula(rs.getString("li_estado_Matricula"));
                per.setEstado_Trabajo(rs.getString("Estado_Trabaja"));
                per.setHoras_Sem_Labora(rs.getString("Horas_Sem_Labora"));
                per.setEstado_Matricula(rs.getString("Estado_Matricula"));
                per.setDni(rs.getString("dni"));
                per.setGrado_seccion(rs.getString("grado_seccion"));
                list.add(per);
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

}
