/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.DAO;

import App.Proyecto.Controlador.Interface.InterfacePersonaDAO;
import App.Proyecto.Factory.FactoryConexion;
import App.Proyecto.Factory.conexion;
import App.Proyecto.Modelo.Persona;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Barrantes Tapia
 */
public class PersonaDAO implements InterfacePersonaDAO {

    conexion con;

    @Override
    public List<Persona> ListarAlumno() {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "execute ListaTableAlumno";
        List<Persona> list = new ArrayList<Persona>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Persona per = new Persona();
                per.setId_Persona(rs.getInt("id_Persona"));
                per.setCod_Estudiante(rs.getString("Cod_Estudiante"));
                per.setNombre_Persona(rs.getString("Nombre_Persona"));
                per.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                per.setApellido_Materno(rs.getString("Apellido_Materno"));
                per.setLi_Tipo_Persona(rs.getString("li_tipo_persona"));
                per.setDni(rs.getString("dni"));
                per.setEstado_Persona(rs.getString("Estado_Persona"));
                per.setSexo(rs.getString("Sexo"));
                per.setEstado_Alumno(rs.getString("Estado_Alumno"));
                per.setFecha_Nacimiento(rs.getString("Fecha_Nacimiento"));
                per.setEs_Vida_Padre(rs.getString("Es_Vida_Padre"));
                per.setEs_Vida_Madre(rs.getString("Es_Vida_Madre"));
                per.setSegunda_Lengua(rs.getString("Segunda_Lengua"));
                per.setLengua_Materna(rs.getString("Lengua_Materna"));
                per.setPais(rs.getString("Pais"));
                per.setEscolaridad_Madre(rs.getString("Escolaridad_Madre"));
                per.setNacimiento_Registrado(rs.getString("Nacimiento_Registrado"));
                per.setTipo_Discapacidad(rs.getString("Tipo_Discapacidad"));
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
    public void Insertar_Alumno(String Nombre, String Ap_Paterno, String Ap_Materno, String Dni) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute InsertarAlumno ?, ?, ?, ?");
            ps.setString(1, Nombre);
            ps.setString(2, Ap_Paterno);
            ps.setString(3, Ap_Materno);
            ps.setString(4, Dni);
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
    public void Modificar_Alumno(String id_Alumno, String Nombre, String Ap_Paterno, String Ap_Materno, String Dni, String Estado_Alumno) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute Modificar_Alumno ?, ?, ?, ?, ?, ?");
            ps.setString(1, id_Alumno);
            ps.setString(2, Nombre);
            ps.setString(3, Ap_Paterno);
            ps.setString(4, Ap_Materno);
            ps.setString(5, Dni);
            ps.setString(6, Estado_Alumno);
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
    public List<Persona> ListarAlumnoxId(int id) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select * from Persona where id_Persona=" + id;
        List<Persona> List = new ArrayList<Persona>();
        try {
            ResultSet rs = this.con.query(sql);
            while (rs.next()) {
                Persona per = new Persona();
                per.setId_Persona(rs.getInt("id_Persona"));
                per.setCod_Estudiante(rs.getString("Cod_Estudiante"));
                per.setNombre_Persona(rs.getString("Nombre_Persona"));
                per.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                per.setApellido_Materno(rs.getString("Apellido_Materno"));
                per.setLi_Tipo_Persona(rs.getString("li_tipo_persona"));
                per.setDni(rs.getString("dni"));
                per.setEstado_Persona(rs.getString("Estado_Persona"));
                per.setSexo(rs.getString("Sexo"));
                per.setEstado_Alumno(rs.getString("Estado_Alumno"));
                per.setFecha_Nacimiento(rs.getString("Fecha_Nacimiento"));
                per.setEs_Vida_Padre(rs.getString("Es_Vida_Padre"));
                per.setEs_Vida_Madre(rs.getString("Es_Vida_Madre"));
                per.setSegunda_Lengua(rs.getString("Segunda_Lengua"));
                per.setLengua_Materna(rs.getString("Lengua_Materna"));
                per.setPais(rs.getString("Pais"));
                per.setEscolaridad_Madre(rs.getString("Escolaridad_Madre"));
                per.setNacimiento_Registrado(rs.getString("Nacimiento_Registrado"));
                per.setTipo_Discapacidad(rs.getString("Tipo_Discapacidad"));
                List.add(per);
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
    public void Insertar_Persona_Alumno(String Cod_Alumno, String Nombre, String Ap_Paterno, String Ap_Materno, String Dni, String Estado_Persona, String Fecha_nac, String Vive_Padre, String Vive_Madre, String Pais, String Escolaridad_Madre, String Nac_Registrado, String Tipo_Discapacidad, String Leng_Materna, String Seg_Lengua, String sexo) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute InsertarPersonaAlumno ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            ps.setString(1, Cod_Alumno);
            ps.setString(2, Nombre);
            ps.setString(3, Ap_Paterno);
            ps.setString(4, Ap_Materno);
            ps.setString(5, Dni);
            ps.setString(6, Estado_Persona);
            ps.setString(7, Fecha_nac);
            ps.setString(8, Vive_Padre);
            ps.setString(9, Vive_Madre);
            ps.setString(10, Pais);
            ps.setString(11, Escolaridad_Madre);
            ps.setString(12, Nac_Registrado);
            ps.setString(13, Tipo_Discapacidad);
            ps.setString(14, Leng_Materna);
            ps.setString(15, Seg_Lengua);
            ps.setString(16, sexo);
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
    public List<Persona> Buscar_Persona(String Cod_Alumno, String Nombre_Persona, String dni) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        List<Persona> List = new ArrayList<Persona>();
        String sql = "SELECT * FROM Persona where ";

        if (!Nombre_Persona.equals("")) {
            sql = sql + "(Nombre_Persona+' '+Apellido_Paterno+' '+Apellido_Materno)like '%" + Nombre_Persona + "%'";
        } else {
            sql = sql + "(Nombre_Persona+' '+Apellido_Paterno+' '+Apellido_Materno)like '%%'";
        }
        if (!Cod_Alumno.equals("")) {
            sql = sql + " and Cod_Estudiante like '%" + Cod_Alumno + "%'";
        } else {
        }
        if (!dni.equals("")) {
            sql = sql + " and dni like '%" + dni + "%'";
        } else {
        }
        try {
            ResultSet rs = this.con.query(sql);
            while (rs.next()) {
                Persona per = new Persona();
                per.setId_Persona(rs.getInt("id_Persona"));
                per.setCod_Estudiante(rs.getString("Cod_Estudiante"));
                per.setNombre_Persona(rs.getString("Nombre_Persona"));
                per.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                per.setApellido_Materno(rs.getString("Apellido_Materno"));
                per.setLi_Tipo_Persona(rs.getString("li_tipo_persona"));
                per.setDni(rs.getString("dni"));
                per.setEstado_Persona(rs.getString("Estado_Persona"));
                per.setSexo(rs.getString("Sexo"));
                per.setEstado_Alumno(rs.getString("Estado_Alumno"));
                per.setFecha_Nacimiento(rs.getString("Fecha_Nacimiento"));
                per.setEs_Vida_Padre(rs.getString("Es_Vida_Padre"));
                per.setEs_Vida_Madre(rs.getString("Es_Vida_Madre"));
                per.setSegunda_Lengua(rs.getString("Segunda_Lengua"));
                per.setLengua_Materna(rs.getString("Lengua_Materna"));
                per.setPais(rs.getString("Pais"));
                per.setEscolaridad_Madre(rs.getString("Escolaridad_Madre"));
                per.setNacimiento_Registrado(rs.getString("Nacimiento_Registrado"));
                per.setTipo_Discapacidad(rs.getString("Tipo_Discapacidad"));
                List.add(per);
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
    public void Modificar_Persona_Alumno(int Alumno, String Cod_Alumno, String Nombre, String Ap_Paterno, String Ap_Materno, String Dni, String Estado_Persona, String Fecha_nac, String Vive_Padre, String Vive_Madre, String Pais, String Escolaridad_Madre, String Nac_Registrado, String Tipo_Discapacidad, String Leng_Materna, String Seg_Lengua, String sexo) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        try {
            PreparedStatement ps = con.conex.prepareStatement("execute ModificarPersonaAlumno ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            ps.setInt(1, Alumno);
            ps.setString(2, Cod_Alumno);
            ps.setString(3, Nombre);
            ps.setString(4, Ap_Paterno);
            ps.setString(5, Ap_Materno);
            ps.setString(6, Dni);
            ps.setString(7, Estado_Persona);
            ps.setString(8, Fecha_nac);
            ps.setString(9, Vive_Padre);
            ps.setString(10, Vive_Madre);
            ps.setString(11, Pais);
            ps.setString(12, Escolaridad_Madre);
            ps.setString(13, Nac_Registrado);
            ps.setString(14, Tipo_Discapacidad);
            ps.setString(15, Leng_Materna);
            ps.setString(16, Seg_Lengua);
            ps.setString(17, sexo);
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
    public List<Persona> ListarPersona() {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "execute ListaTablePersona";
        List<Persona> list = new ArrayList<Persona>();
        try {
            ResultSet rs = con.query(sql);
            while (rs.next()) {
                Persona per = new Persona();
                per.setId_Persona(rs.getInt("id_Persona"));
                per.setCod_Estudiante(rs.getString("Cod_Estudiante"));
                per.setNombre_Persona(rs.getString("Nombre_Persona"));
                per.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                per.setApellido_Materno(rs.getString("Apellido_Materno"));
                per.setLi_Tipo_Persona(rs.getString("li_tipo_persona"));
                per.setDni(rs.getString("dni"));
                per.setEstado_Persona(rs.getString("Estado_Persona"));
                per.setSexo(rs.getString("Sexo"));
                per.setEstado_Alumno(rs.getString("Estado_Alumno"));
                per.setFecha_Nacimiento(rs.getString("Fecha_Nacimiento"));
                per.setEs_Vida_Padre(rs.getString("Es_Vida_Padre"));
                per.setEs_Vida_Madre(rs.getString("Es_Vida_Madre"));
                per.setSegunda_Lengua(rs.getString("Segunda_Lengua"));
                per.setLengua_Materna(rs.getString("Lengua_Materna"));
                per.setPais(rs.getString("Pais"));
                per.setEscolaridad_Madre(rs.getString("Escolaridad_Madre"));
                per.setNacimiento_Registrado(rs.getString("Nacimiento_Registrado"));
                per.setTipo_Discapacidad(rs.getString("Tipo_Discapacidad"));
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
    public List<Persona> ListarPersona_id(int id) {
        this.con = FactoryConexion.open(FactoryConexion.SQLSERVER);
        String sql = "select * from Persona where id_Persona=" + id;
        List<Persona> List = new ArrayList<Persona>();
        try {
            ResultSet rs = this.con.query(sql);
            while (rs.next()) {
                Persona per = new Persona();
                per.setId_Persona(rs.getInt("id_Persona"));
                per.setCod_Estudiante(rs.getString("Cod_Estudiante"));
                per.setNombre_Persona(rs.getString("Nombre_Persona"));
                per.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                per.setApellido_Materno(rs.getString("Apellido_Materno"));
                per.setLi_Tipo_Persona(rs.getString("li_tipo_persona"));
                per.setDni(rs.getString("dni"));
                per.setEstado_Persona(rs.getString("Estado_Persona"));
                per.setSexo(rs.getString("Sexo"));
                per.setEstado_Alumno(rs.getString("Estado_Alumno"));
                per.setFecha_Nacimiento(rs.getString("Fecha_Nacimiento"));
                per.setEs_Vida_Padre(rs.getString("Es_Vida_Padre"));
                per.setEs_Vida_Madre(rs.getString("Es_Vida_Madre"));
                per.setSegunda_Lengua(rs.getString("Segunda_Lengua"));
                per.setLengua_Materna(rs.getString("Lengua_Materna"));
                per.setPais(rs.getString("Pais"));
                per.setEscolaridad_Madre(rs.getString("Escolaridad_Madre"));
                per.setNacimiento_Registrado(rs.getString("Nacimiento_Registrado"));
                per.setTipo_Discapacidad(rs.getString("Tipo_Discapacidad"));
                List.add(per);
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

}
