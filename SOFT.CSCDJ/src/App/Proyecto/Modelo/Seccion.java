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
public class Seccion {
    private int id_seccion;
    private String Nombre_Seccion;
    private String Estado_Seccion;

    public Seccion(int id_seccion, String Nombre_Seccion, String Estado_Seccion) {
        this.id_seccion = id_seccion;
        this.Nombre_Seccion = Nombre_Seccion;
        this.Estado_Seccion = Estado_Seccion;
    }
    public Seccion() {
        this.id_seccion = 0;
        this.Nombre_Seccion = "";
        this.Estado_Seccion = "";
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public String getNombre_Seccion() {
        return Nombre_Seccion;
    }

    public void setNombre_Seccion(String Nombre_Seccion) {
        this.Nombre_Seccion = Nombre_Seccion;
    }

    public String getEstado_Seccion() {
        return Estado_Seccion;
    }

    public void setEstado_Seccion(String Estado_Seccion) {
        this.Estado_Seccion = Estado_Seccion;
    }
    
    
}
