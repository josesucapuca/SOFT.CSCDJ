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
public class Usuario {

    private String id_Usuario;
    private String id_persona;
    private String Nombre_Usuario;
    private String Password;
    private String Persona;
    private String Li_tipo_persona;
    private String Fe_Vencimiento;
    private String Estado_Usuario;
    private String Estado_Abierto;

    public Usuario(String id_Usuario, String id_persona, String Nombre_Usuario, String Password, String Persona, String Li_tipo_persona, String Fe_Vencimiento, String Estado_Usuario, String Estado_Abierto) {
        this.id_Usuario = id_Usuario;
        this.id_persona = id_persona;
        this.Nombre_Usuario = Nombre_Usuario;
        this.Password = Password;
        this.Persona = Persona;
        this.Li_tipo_persona = Li_tipo_persona;
        this.Fe_Vencimiento = Fe_Vencimiento;
        this.Estado_Usuario = Estado_Usuario;
        this.Estado_Abierto = Estado_Abierto;
    }

    public Usuario() {
        this.id_Usuario = "";
        this.id_persona = "";
        this.Nombre_Usuario = "";
        this.Password = "";
        this.Persona = "";
        this.Li_tipo_persona = "";
        this.Fe_Vencimiento = "";
        this.Estado_Usuario = "";
        this.Estado_Abierto = "";
    }

    public String getLi_tipo_persona() {
        return Li_tipo_persona;
    }

    public void setLi_tipo_persona(String Li_tipo_persona) {
        this.Li_tipo_persona = Li_tipo_persona;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPersona() {
        return Persona;
    }

    public void setPersona(String Persona) {
        this.Persona = Persona;
    }

    public String getFe_Vencimiento() {
        return Fe_Vencimiento;
    }

    public void setFe_Vencimiento(String Fe_Vencimiento) {
        this.Fe_Vencimiento = Fe_Vencimiento;
    }

    public String getEstado_Usuario() {
        return Estado_Usuario;
    }

    public void setEstado_Usuario(String Estado_Usuario) {
        this.Estado_Usuario = Estado_Usuario;
    }

    public String getEstado_Abierto() {
        return Estado_Abierto;
    }

    public void setEstado_Abierto(String Estado_Abierto) {
        this.Estado_Abierto = Estado_Abierto;
    }

    
}
