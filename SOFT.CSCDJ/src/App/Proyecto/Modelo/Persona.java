/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Proyecto.Modelo;

/**
 *
 * @author Barrantes Tapia
 */
public class Persona {

    private int id_Persona;
    private String Cod_Estudiante;
    private String Nombre_Persona;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private String Li_Tipo_Persona;
    private String Dni;
    private String Estado_Persona;
    private String Sexo;
    private String Estado_Alumno;
    private String Fecha_Nacimiento;
    private String Es_Vida_Padre;
    private String Es_Vida_Madre;
    private String Segunda_Lengua;
    private String Lengua_Materna;
    private String Pais;
    private String Escolaridad_Madre;
    private String Nacimiento_Registrado;
    private String Tipo_Discapacidad;

    public Persona(int id_Persona, String Cod_Estudiante, String Nombre_Persona, String Apellido_Paterno, String Apellido_Materno, String Li_Tipo_Persona, String Dni, String Estado_Persona, String Sexo, String Estado_Alumno, String Fecha_Nacimiento, String Es_Vida_Padre, String Es_Vida_Madre, String Segunda_Lengua, String Lengua_Materna, String Pais, String Escolaridad_Madre, String Nacimiento_Registrado, String Tipo_Discapacidad) {
        this.id_Persona = id_Persona;
        this.Cod_Estudiante = Cod_Estudiante;
        this.Nombre_Persona = Nombre_Persona;
        this.Apellido_Paterno = Apellido_Paterno;
        this.Apellido_Materno = Apellido_Materno;
        this.Li_Tipo_Persona = Li_Tipo_Persona;
        this.Dni = Dni;
        this.Estado_Persona = Estado_Persona;
        this.Sexo = Sexo;
        this.Estado_Alumno = Estado_Alumno;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Es_Vida_Padre = Es_Vida_Padre;
        this.Es_Vida_Madre = Es_Vida_Madre;
        this.Segunda_Lengua = Segunda_Lengua;
        this.Lengua_Materna = Lengua_Materna;
        this.Pais = Pais;
        this.Escolaridad_Madre = Escolaridad_Madre;
        this.Nacimiento_Registrado = Nacimiento_Registrado;
        this.Tipo_Discapacidad = Tipo_Discapacidad;
    }
    public Persona() {
        this.id_Persona = 0;
        this.Cod_Estudiante = "";
        this.Nombre_Persona = "";
        this.Apellido_Paterno = "";
        this.Apellido_Materno = "";
        this.Li_Tipo_Persona = "";
        this.Dni = "";
        this.Estado_Persona = "";
        this.Sexo = "";
        this.Estado_Alumno = "";
        this.Fecha_Nacimiento = "";
        this.Es_Vida_Padre = "";
        this.Es_Vida_Madre = "";
        this.Segunda_Lengua = "";
        this.Lengua_Materna = "";
        this.Pais = "";
        this.Escolaridad_Madre = "";
        this.Nacimiento_Registrado = "";
        this.Tipo_Discapacidad = "";
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

    public String getCod_Estudiante() {
        return Cod_Estudiante;
    }

    public void setCod_Estudiante(String Cod_Estudiante) {
        this.Cod_Estudiante = Cod_Estudiante;
    }

    public String getNombre_Persona() {
        return Nombre_Persona;
    }

    public void setNombre_Persona(String Nombre_Persona) {
        this.Nombre_Persona = Nombre_Persona;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String Apellido_Paterno) {
        this.Apellido_Paterno = Apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String Apellido_Materno) {
        this.Apellido_Materno = Apellido_Materno;
    }

    public String getLi_Tipo_Persona() {
        return Li_Tipo_Persona;
    }

    public void setLi_Tipo_Persona(String Li_Tipo_Persona) {
        this.Li_Tipo_Persona = Li_Tipo_Persona;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getEstado_Persona() {
        return Estado_Persona;
    }

    public void setEstado_Persona(String Estado_Persona) {
        this.Estado_Persona = Estado_Persona;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEstado_Alumno() {
        return Estado_Alumno;
    }

    public void setEstado_Alumno(String Estado_Alumno) {
        this.Estado_Alumno = Estado_Alumno;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getEs_Vida_Padre() {
        return Es_Vida_Padre;
    }

    public void setEs_Vida_Padre(String Es_Vida_Padre) {
        this.Es_Vida_Padre = Es_Vida_Padre;
    }

    public String getEs_Vida_Madre() {
        return Es_Vida_Madre;
    }

    public void setEs_Vida_Madre(String Es_Vida_Madre) {
        this.Es_Vida_Madre = Es_Vida_Madre;
    }

    public String getSegunda_Lengua() {
        return Segunda_Lengua;
    }

    public void setSegunda_Lengua(String Segunda_Lengua) {
        this.Segunda_Lengua = Segunda_Lengua;
    }

    public String getLengua_Materna() {
        return Lengua_Materna;
    }

    public void setLengua_Materna(String Lengua_Materna) {
        this.Lengua_Materna = Lengua_Materna;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getEscolaridad_Madre() {
        return Escolaridad_Madre;
    }

    public void setEscolaridad_Madre(String Escolaridad_Madre) {
        this.Escolaridad_Madre = Escolaridad_Madre;
    }

    public String getNacimiento_Registrado() {
        return Nacimiento_Registrado;
    }

    public void setNacimiento_Registrado(String Nacimiento_Registrado) {
        this.Nacimiento_Registrado = Nacimiento_Registrado;
    }

    public String getTipo_Discapacidad() {
        return Tipo_Discapacidad;
    }

    public void setTipo_Discapacidad(String Tipo_Discapacidad) {
        this.Tipo_Discapacidad = Tipo_Discapacidad;
    }

   

}
