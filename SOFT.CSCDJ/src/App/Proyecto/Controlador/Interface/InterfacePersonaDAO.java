/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Controlador.Interface;

import App.Proyecto.Modelo.Persona;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Barrantes Tapia
 */
public interface InterfacePersonaDAO {

    List<Persona> ListarAlumno();

    List<Persona> ListarAlumnoxId(int id);

    void Insertar_Alumno(String Nombre, String Ap_Paterno, String Ap_Materno, String Dni);

    void Modificar_Alumno(String id_Alumno, String Nombre, String Ap_Paterno, String Ap_Materno, String Dni, String Estado_Alumno);

    void Insertar_Persona_Alumno(String Cod_Alumno, String Nombre, String Ap_Paterno, String Ap_Materno, String Dni, String Estado_Persona, String Fecha_nac, String Vive_Padre, String Vive_Madre, String Pais, String Escolaridad_Madre, String Nac_Registrado, String Tipo_Discapacidad, String Leng_Materna, String Seg_Lengua, String sexo);

    void Modificar_Persona_Alumno(int Alumno, String Cod_Alumno, String Nombre, String Ap_Paterno, String Ap_Materno, String Dni, String Estado_Persona, String Fecha_nac, String Vive_Padre, String Vive_Madre, String Pais, String Escolaridad_Madre, String Nac_Registrado, String Tipo_Discapacidad, String Leng_Materna, String Seg_Lengua, String sexo);

    List<Persona> Buscar_Persona(String Cod_Alumno, String Nombre_Persona, String dni);

    List<Persona> ListarPersona();

    List<Persona> ListarPersona_id(int id);

}
