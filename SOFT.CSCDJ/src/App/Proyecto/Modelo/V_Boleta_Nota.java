/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package App.Proyecto.Modelo;

/**
 *
 * @author user
 */
public class V_Boleta_Nota {
    private int id_Boleta_Nota;
    private int id_Matricula;
    private int id_calificacion;
    private int id_Detalle_Carga_Academica;
    private int id_Materia_Profesor;
    private Double Nota;
    private String Nota_Letra;
    private String Estado_Boleta_Nota;
    private int id_Materia;
    private String Nombre_Calificacion;
    private int id_Bimestre;
    private String li_Tipo_Calificacion;

    public V_Boleta_Nota(int id_Boleta_Nota, int id_Matricula, int id_calificacion, int id_Detalle_Carga_Academica, int id_Materia_Profesor, Double Nota, String Nota_Letra, String Estado_Boleta_Nota, int id_Materia, String Nombre_Calificacion, int id_Bimestre, String li_Tipo_Calificacion) {
        this.id_Boleta_Nota = id_Boleta_Nota;
        this.id_Matricula = id_Matricula;
        this.id_calificacion = id_calificacion;
        this.id_Detalle_Carga_Academica = id_Detalle_Carga_Academica;
        this.id_Materia_Profesor = id_Materia_Profesor;
        this.Nota = Nota;
        this.Nota_Letra = Nota_Letra;
        this.Estado_Boleta_Nota = Estado_Boleta_Nota;
        this.id_Materia = id_Materia;
        this.Nombre_Calificacion = Nombre_Calificacion;
        this.id_Bimestre = id_Bimestre;
        this.li_Tipo_Calificacion = li_Tipo_Calificacion;
    }
    public V_Boleta_Nota() {
        this.id_Boleta_Nota = 0;
        this.id_Matricula = 0;
        this.id_calificacion = 0;
        this.id_Detalle_Carga_Academica = 0;
        this.id_Materia_Profesor = 0;
        this.Nota = 0.0;
        this.Nota_Letra = "";
        this.Estado_Boleta_Nota = "";
        this.id_Materia = 0;
        this.Nombre_Calificacion = "";
        this.id_Bimestre = 0;
        this.li_Tipo_Calificacion = "";
    }

    public int getId_Matricula() {
        return id_Matricula;
    }

    public void setId_Matricula(int id_Matricula) {
        this.id_Matricula = id_Matricula;
    }

    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public int getId_Detalle_Carga_Academica() {
        return id_Detalle_Carga_Academica;
    }

    public void setId_Detalle_Carga_Academica(int id_Detalle_Carga_Academica) {
        this.id_Detalle_Carga_Academica = id_Detalle_Carga_Academica;
    }

    public int getId_Materia_Profesor() {
        return id_Materia_Profesor;
    }

    public void setId_Materia_Profesor(int id_Materia_Profesor) {
        this.id_Materia_Profesor = id_Materia_Profesor;
    }

    public Double getNota() {
        return Nota;
    }

    public void setNota(Double Nota) {
        this.Nota = Nota;
    }

    public String getNota_Letra() {
        return Nota_Letra;
    }

    public void setNota_Letra(String Nota_Letra) {
        this.Nota_Letra = Nota_Letra;
    }

    public String getEstado_Boleta_Nota() {
        return Estado_Boleta_Nota;
    }

    public void setEstado_Boleta_Nota(String Estado_Boleta_Nota) {
        this.Estado_Boleta_Nota = Estado_Boleta_Nota;
    }

    public int getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(int id_Materia) {
        this.id_Materia = id_Materia;
    }

    public String getNombre_Calificacion() {
        return Nombre_Calificacion;
    }

    public void setNombre_Calificacion(String Nombre_Calificacion) {
        this.Nombre_Calificacion = Nombre_Calificacion;
    }

    public int getId_Bimestre() {
        return id_Bimestre;
    }

    public void setId_Bimestre(int id_Bimestre) {
        this.id_Bimestre = id_Bimestre;
    }

    public String getLi_Tipo_Calificacion() {
        return li_Tipo_Calificacion;
    }

    public void setLi_Tipo_Calificacion(String li_Tipo_Calificacion) {
        this.li_Tipo_Calificacion = li_Tipo_Calificacion;
    }

    public int getId_Boleta_Nota() {
        return id_Boleta_Nota;
    }

    public void setId_Boleta_Nota(int id_Boleta_Nota) {
        this.id_Boleta_Nota = id_Boleta_Nota;
    }
    
}
