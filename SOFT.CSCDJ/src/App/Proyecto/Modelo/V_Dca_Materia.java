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
public class V_Dca_Materia {
    private int id_Detalle_Carga_Academica;
    private int id_Materia;
    private String Nombre_Materia;
    private String Li_Ti_Materia;

    public V_Dca_Materia(int id_Detalle_Carga_Academica, int id_Materia, String Nombre_Materia,String Li_Ti_Materia) {
        this.id_Detalle_Carga_Academica = id_Detalle_Carga_Academica;
        this.id_Materia = id_Materia;
        this.Nombre_Materia = Nombre_Materia;
        this.Li_Ti_Materia = Li_Ti_Materia;
    }
    public V_Dca_Materia() {
        this.id_Detalle_Carga_Academica = 0;
        this.id_Materia = 0;
        this.Nombre_Materia = "";
        this.Li_Ti_Materia = "";
    }

    public int getId_Detalle_Carga_Academica() {
        return id_Detalle_Carga_Academica;
    }

    public void setId_Detalle_Carga_Academica(int id_Detalle_Carga_Academica) {
        this.id_Detalle_Carga_Academica = id_Detalle_Carga_Academica;
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

    public String getLi_Ti_Materia() {
        return Li_Ti_Materia;
    }

    public void setLi_Ti_Materia(String Li_Ti_Materia) {
        this.Li_Ti_Materia = Li_Ti_Materia;
    }
    
}
