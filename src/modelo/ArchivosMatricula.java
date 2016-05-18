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
//clase que crea el archivo plano con el objeto matricula
public class ArchivosMatricula {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public ArchivosMatricula() 
    {
        
    }
    //metodos que crean el archivo, escriben informacion en este
    public void crearArchivo()
    {
      try
      {
       archivoSalida = new ObjectOutputStream(new FileOutputStream("matriculas.dat"));
       System.out.println("Archivo creado");
      }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }  
    public void escribirInformacionEnElArchivo(Matricula matricula)
    {
      try
      {
        archivoSalida.writeObject(matricula);
          System.out.println("Se escribió la informacion de forma correcta");
      }
      catch(Exception e)
      {
        System.out.println("Error al escribir en el archivo: "+e);
      }
    }
    public String leerInformacion()
    {
      Matricula matricula=null;
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("matriculas.dat"));
        matricula=(Matricula)archivoEntrada.readObject();
      }
      catch(Exception e)
      {
        System.out.println("Error al leer informacion del archivo: "+e);
      }
      return matricula.getInformacion();
    }
    //metodo que genera un arrayList con los objetos guardados en el archivos
    public ArrayList<Matricula> leerInformacionCompleta()
    {
      ArrayList<Matricula> arrayMatriculas = new ArrayList <Matricula>();
      
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("matriculas.dat"));
        while(true)
        {
          arrayMatriculas.add((Matricula)archivoEntrada.readObject());
        }
      }
      catch(Exception e)
      {
        System.out.println("Fin del archivo "+e);
      }
      
      return arrayMatriculas;
    }
    
}
