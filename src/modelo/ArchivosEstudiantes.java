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
//clase que crea el archivo plano con el objeto estudiante
public class ArchivosEstudiantes {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public ArchivosEstudiantes() 
    {
        
    }
    //metodos que crean el archivo, escriben informacion en este
    public void crearArchivo()
    {
      try
      {
       archivoSalida = new ObjectOutputStream(new FileOutputStream("estudiantes.dat"));
       System.out.println("Archivo creado");
      }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }  
    public void escribirInformacionEnElArchivo(Estudiante estudiante)
    {
      try
      {
        archivoSalida.writeObject(estudiante);
          System.out.println("Se escribió la informacion de forma correcta");
      }
      catch(Exception e)
      {
        System.out.println("Error al escribir en el archivo: "+e);
      }
    }
    public String leerInformacion()
    {
      Estudiante estudiante=null;
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("estudiantes.dat"));
        estudiante=(Estudiante)archivoEntrada.readObject();
      }
      catch(Exception e)
      {
        System.out.println("Error al leer informacion del archivo: "+e);
      }
      return estudiante.getInformacion();
    }
    //metodo que genera un arrayList con los objetos guardados en el archivos
    public ArrayList<Estudiante> leerInformacionCompleta()
    {
      ArrayList<Estudiante> arrayEstudiantes = new ArrayList <Estudiante>();
      
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("estudiantes.dat"));
        while(true)
        {
          arrayEstudiantes.add((Estudiante)archivoEntrada.readObject());
        }
      }
      catch(Exception e)
      {
        System.out.println("Fin del archivo "+e);
      }
      
      return arrayEstudiantes;
    }
    
    
    
}
