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
//clase objeto
public class Matricula implements Serializable{
    
    private String codigo;
    private String cedula;
    private String sigla;
    private boolean estado;

    public Matricula(String codigo, String cedula, String sigla,boolean estado) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.sigla = sigla;
        this.estado= estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public String getInformacion()
    {
      return this.cedula+this.sigla+this.sigla;
    }
}
