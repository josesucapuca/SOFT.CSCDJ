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
public class Ano {
    private int id_año;
    private String Año;

    public Ano(int id_año, String Año) {
        this.id_año = id_año;
        this.Año = Año;
    }
    public Ano() {
        this.id_año = 0;
        this.Año = "";
    }

    public int getId_año() {
        return id_año;
    }

    public void setId_año(int id_año) {
        this.id_año = id_año;
    }

    public String getAño() {
        return Año;
    }

    public void setAño(String Año) {
        this.Año = Año;
    }
    
}
