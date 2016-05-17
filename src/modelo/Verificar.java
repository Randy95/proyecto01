/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author RandyGUTI
 */
public class Verificar {

    public Verificar() 
    {
        
    }
    public boolean verificarNumeros(String texto)
    {
      boolean esNumero=true;
      for(int contador=0;contador<texto.length();contador++)
      {
        if(Character.isLetter(texto.charAt(contador)))
        {
         esNumero=false;
         break;
        }
      }
      return esNumero;
    }
    public boolean verificarLetras(String texto)
    {
      boolean esLetra=true;
      for(int contador=0;contador<texto.length();contador++)
      {
        if(Character.isDigit(texto.charAt(contador)))
        {
         esLetra=false;
         break;
        }
      }
      return esLetra;
    }
    public String obviarEspacios(String texto)
    {
      return texto.replaceAll(" ", "").trim();
    }
    public boolean verificarSimbolo(String texto,String simbolo)
    {
      if(texto.contains(simbolo) && texto.contains("."))
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    
}
