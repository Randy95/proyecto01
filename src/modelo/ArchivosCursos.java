/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author RandyGUTI
 */
public class ArchivosCursos {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public ArchivosCursos() 
    {
        
    }
    public void crearArchivo()
    {
      try
      {
       archivoSalida = new ObjectOutputStream(new FileOutputStream("cursos.dat"));
       System.out.println("Archivo creado");
      }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }  
    public void escribirInformacionEnElArchivo(Cursos curso)
    {
      try
      {
        archivoSalida.writeObject(curso);
          System.out.println("Se escribió la informacion de forma correcta");
      }
      catch(Exception e)
      {
        System.out.println("Error al escribir en el archivo: "+e);
      }
    }
    public String leerInformacion()
    {
      Cursos curso=null;
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("cursos.dat"));
        curso=(Cursos)archivoEntrada.readObject();
      }
      catch(Exception e)
      {
        System.out.println("Error al leer informacion del archivo: "+e);
      }
      return curso.getInformacion();
    }
    public ArrayList<Cursos> leerInformacionCompleta()
    {
      ArrayList<Cursos> arrayCursos = new ArrayList <Cursos>();
      
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("cursos.dat"));
        while(true)
        {
          arrayCursos.add((Cursos)archivoEntrada.readObject());
        }
      }
      catch(Exception e)
      {
        System.out.println("Fin del archivo "+e);
      }
      
      return arrayCursos;
    }
}
