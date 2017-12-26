/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package App.Proyecto.Modelo;

import java.sql.Date;

/**
 *
 * @author Admin-ronald.arrieta
 */
public class Matricula {
    private String Alumno;
    private String año;
    private int id_Matricula;
    private int id_Persona;
    private int id_Grado;
    private int id_Periodo;
    private Date fe_Matricula ;
    private String li_Estado_Matricula;
    private String Estado_Trabajo;
    private String Horas_Sem_Labora; 
    private String Estado_Matricula;
    private String dni;
    private String Grado_seccion;
    private String Cod_Estudiante;

    public Matricula(String Alumno, String año, int id_Matricula, int id_Persona, int id_Grado, int id_Periodo, Date fe_Matricula, String li_Estado_Matricula, String Estado_Trabajo, String Horas_Sem_Labora, String Estado_Matricula, String dni, String Grado_seccion,String Cod_Estudiante ) {
        this.Alumno = Alumno;
        this.año = año;
        this.id_Matricula = id_Matricula;
        this.id_Persona = id_Persona;
        this.id_Grado = id_Grado;
        this.id_Periodo = id_Periodo;
        this.fe_Matricula = fe_Matricula;
        this.li_Estado_Matricula = li_Estado_Matricula;
        this.Estado_Trabajo = Estado_Trabajo;
        this.Horas_Sem_Labora = Horas_Sem_Labora;
        this.Estado_Matricula = Estado_Matricula;
        this.dni = dni;
        this.Grado_seccion = Grado_seccion;
        this.Cod_Estudiante = Cod_Estudiante;
    }
    
    
    
    public Matricula() {
        this.Alumno = "";
        this.año = "";
        this.id_Matricula = 0;
        this.id_Persona = 0;
        this.id_Grado = 0;
        this.id_Periodo = 0;
        this.fe_Matricula = null;
        this.li_Estado_Matricula = "";
        this.Estado_Trabajo = "";
        this.Horas_Sem_Labora = "";
        this.Estado_Matricula = "";
        this.dni = "";
        this.Grado_seccion = "";
        this.Cod_Estudiante = "";
    }

    public String getAlumno() {
        return Alumno;
    }

    public void setAlumno(String Alumno) {
        this.Alumno = Alumno;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getId_Matricula() {
        return id_Matricula;
    }

    public void setId_Matricula(int id_Matricula) {
        this.id_Matricula = id_Matricula;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

    public int getId_Grado() {
        return id_Grado;
    }

    public void setId_Grado(int id_Grado) {
        this.id_Grado = id_Grado;
    }

    public int getId_Periodo() {
        return id_Periodo;
    }

    public void setId_Periodo(int id_Periodo) {
        this.id_Periodo = id_Periodo;
    }

    public Date getFe_Matricula() {
        return fe_Matricula;
    }

    public void setFe_Matricula(Date fe_Matricula) {
        this.fe_Matricula = fe_Matricula;
    }

    public String getLi_Estado_Matricula() {
        return li_Estado_Matricula;
    }

    public void setLi_Estado_Matricula(String li_Estado_Matricula) {
        this.li_Estado_Matricula = li_Estado_Matricula;
    }

    public String getEstado_Trabajo() {
        return Estado_Trabajo;
    }

    public void setEstado_Trabajo(String Estado_Trabajo) {
        this.Estado_Trabajo = Estado_Trabajo;
    }

    public String getHoras_Sem_Labora() {
        return Horas_Sem_Labora;
    }

    public void setHoras_Sem_Labora(String Horas_Sem_Labora) {
        this.Horas_Sem_Labora = Horas_Sem_Labora;
    }

    public String getEstado_Matricula() {
        return Estado_Matricula;
    }

    public void setEstado_Matricula(String Estado_Matricula) {
        this.Estado_Matricula = Estado_Matricula;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGrado_seccion() {
        return Grado_seccion;
    }

    public void setGrado_seccion(String Grado_seccion) {
        this.Grado_seccion = Grado_seccion;
    }

    public String getCod_Estudiante() {
        return Cod_Estudiante;
    }

    public void setCod_Estudiante(String Cod_Estudiante) {
        this.Cod_Estudiante = Cod_Estudiante;
    }

    
}
