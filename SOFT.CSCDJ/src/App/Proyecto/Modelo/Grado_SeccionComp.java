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
public class Grado_SeccionComp {
    private int id_Grado;
    private String Nombre_Grado;
    private String id_Seccion;
    private String Seccion;
    private String li_Nivel;
    private String Estado_Grado;

    public Grado_SeccionComp(int id_Grado, String Nombre_Grado, String id_Seccion, String Seccion, String li_Nivel, String Estado_Grado) {
        this.id_Grado = id_Grado;
        this.Nombre_Grado = Nombre_Grado;
        this.id_Seccion = id_Seccion;
        this.Seccion = Seccion;
        this.li_Nivel = li_Nivel;
        this.Estado_Grado = Estado_Grado;
    }
    public Grado_SeccionComp() {
        this.id_Grado = 0;
        this.Nombre_Grado = "";
        this.id_Seccion = "";
        this.Seccion = "";
        this.li_Nivel = "";
        this.Estado_Grado = "";
    }

    public int getId_Grado() {
        return id_Grado;
    }

    public void setId_Grado(int id_Grado) {
        this.id_Grado = id_Grado;
    }

    public String getNombre_Grado() {
        return Nombre_Grado;
    }

    public void setNombre_Grado(String Nombre_Grado) {
        this.Nombre_Grado = Nombre_Grado;
    }

    public String getId_Seccion() {
        return id_Seccion;
    }

    public void setId_Seccion(String id_Seccion) {
        this.id_Seccion = id_Seccion;
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }

    public String getLi_Nivel() {
        return li_Nivel;
    }

    public void setLi_Nivel(String li_Nivel) {
        this.li_Nivel = li_Nivel;
    }

    public String getEstado_Grado() {
        return Estado_Grado;
    }

    public void setEstado_Grado(String Estado_Grado) {
        this.Estado_Grado = Estado_Grado;
    }
    
}
