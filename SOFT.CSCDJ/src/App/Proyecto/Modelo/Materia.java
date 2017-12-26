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
public class Materia {
    private int id_Materia;
    private String Nombre_Materia;
    private String Li_Tipo_Materia;
    private String Estado_Materia;

    public Materia(int id_Materia, String Nombre_Materia, String Li_Tipo_Materia, String Estado_Materia) {
        this.id_Materia = id_Materia;
        this.Nombre_Materia = Nombre_Materia;
        this.Li_Tipo_Materia = Li_Tipo_Materia;
        this.Estado_Materia = Estado_Materia;
    }
    public Materia() {
        this.id_Materia = 0;
        this.Nombre_Materia = "";
        this.Li_Tipo_Materia = "";
        this.Estado_Materia = "";
    }

    public int getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(int id_Materia) {
        this.id_Materia = id_Materia;
    }

    public String getNombre_Materia() {
        return Nombre_Materia;
    }

    public void setNombre_Materia(String Nombre_Materia) {
        this.Nombre_Materia = Nombre_Materia;
    }

    public String getLi_Tipo_Materia() {
        return Li_Tipo_Materia;
    }

    public void setLi_Tipo_Materia(String Li_Tipo_Materia) {
        this.Li_Tipo_Materia = Li_Tipo_Materia;
    }

    public String getEstado_Materia() {
        return Estado_Materia;
    }

    public void setEstado_Materia(String Estado_Materia) {
        this.Estado_Materia = Estado_Materia;
    }
    
}
