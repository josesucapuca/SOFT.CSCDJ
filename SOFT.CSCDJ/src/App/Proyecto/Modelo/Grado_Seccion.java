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
public class Grado_Seccion {
    private int id_Grado;
    private String grado_seccion;

    public Grado_Seccion(int id_Grado, String grado_seccion) {
        this.id_Grado = id_Grado;
        this.grado_seccion = grado_seccion;
    }
    public Grado_Seccion() {
        this.id_Grado = 0;
        this.grado_seccion = "";
    }

    public int getId_Grado() {
        return id_Grado;
    }

    public void setId_Grado(int id_Grado) {
        this.id_Grado = id_Grado;
    }

    public String getGrado_seccion() {
        return grado_seccion;
    }

    public void setGrado_seccion(String grado_seccion) {
        this.grado_seccion = grado_seccion;
    }
    
            
}
