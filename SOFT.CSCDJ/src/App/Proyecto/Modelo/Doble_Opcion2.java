/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package App.Proyecto.Modelo;

/**
 *
 * @author admin-ronald.arrieta
 */
public class Doble_Opcion2 {
     private String id;
    private String Estado_Alumno;

    public Doble_Opcion2(String id, String Estado_Alumno) {
        this.id = id;
        this.Estado_Alumno = Estado_Alumno;
    }
    public Doble_Opcion2() {
        this.id = "";
        this.Estado_Alumno = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado_Alumno() {
        return Estado_Alumno;
    }

    public void setEstado_Alumno(String Estado_Alumno) {
        this.Estado_Alumno = Estado_Alumno;
    }
}
