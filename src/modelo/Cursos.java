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
public class Cursos implements Serializable {
    
    private String sigla;
    private String nombre;
    private int creditos;
    private String horario;

    public Cursos(String sigla, String nombre, int creditos, String horario) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horario = horario;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public String getInformacion()
    {
      return "Sigla: "+sigla+"\nNombre: "+nombre+"\nCreditos: "+creditos+"\nHorario: "+horario+"\n\n";
    }
}
