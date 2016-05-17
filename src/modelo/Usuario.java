/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author RandyGUTI
 */
public class Usuario implements Serializable{
    
    private String nombreUsuario;
    private String password;
    private String tipo;
    private String nombreCompleto;
    private String cedula;

    public Usuario(String nombreUsuario, String password, String tipo, String nombreCompleto, String cedula) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipo = tipo;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getInformacion()
    {
      return "Nombre usuario: "+getNombreUsuario()+"\nPassword: "+getPassword()+"\nTipo usuario: "+getTipo();
    }
    
}
