/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import vista.FRM_SeleccionInicial;

/**
 *
 * @author tecnologiamultimedia
 */
public class MetodosEstudiantes {
    
    private ArrayList <Estudiante> arrayEstudiantes;
    String arregloInformacionConsultada[]=new String[2];
    public ConexionBD conexion;
    public XML_Estudiantes archivoXML;
    ArchivosEstudiantes archivos;
    public FRM_SeleccionInicial frm_SeleccionInicial;
    
    public MetodosEstudiantes(ConexionBD conexion,FRM_SeleccionInicial frm_SeleccionInicial)
    {
        arrayEstudiantes=new ArrayList <Estudiante>();
        this.frm_SeleccionInicial=frm_SeleccionInicial;
        this.conexion=conexion;
        archivos = new ArchivosEstudiantes();
        archivoXML=new XML_Estudiantes();
        
    }
    public void igualArrayXML()
    {
      arrayEstudiantes=archivoXML.crearArrayEstudiante();
    }
    public void igualarArrayBD()
    {
       arrayEstudiantes=conexion.crearArrayEstudiantes();
    }
    public void igualarArrayArchivos()
    {
      arrayEstudiantes=archivos.leerInformacionCompleta();
    }
    public void agregarEstudiante(String informacion[])
    {
        Estudiante temporal=new Estudiante(informacion[0], informacion[1], informacion[2]);
        arrayEstudiantes.add(temporal);
        if(frm_SeleccionInicial.verificarBD())
        {    
            if(conexion.registrarEstudiante(informacion))
                System.out.println("Estudiante registrado en la BD");
        }
        if(frm_SeleccionInicial.verificarXML())
        {
          archivoXML.guardarEnXML(informacion);
        }
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            System.out.println(arrayEstudiantes.get(contador).getInformacion());
        
        }
    
    }
    public void escribirEnArchivo()
    {
      archivos.crearArchivo();
      
      for(int contador=0;contador<arrayEstudiantes.size();contador++)
      {
        archivos.escribirInformacionEnElArchivo(arrayEstudiantes.get(contador));
        
      }
    }
    public boolean consultarEstudiante(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayEstudiantes.get(contador).getNombrecompleto();
                arregloInformacionConsultada[1]=arrayEstudiantes.get(contador).getDireccion();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.get(contador).setNombrecompleto(arreglo[1]);
                arrayEstudiantes.get(contador).setDireccion(arreglo[2]);
                if(frm_SeleccionInicial.verificarBD())
                   conexion.modificarEstudiante(arreglo);
                
                if(frm_SeleccionInicial.verificarXML())
                   archivoXML.modificarInformacionDelXml(arreglo);
        
            }
        }
    }
    public void eliminarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.remove(contador);
                if(frm_SeleccionInicial.verificarBD())
                    conexion.eliminarEstudiante(arreglo);
                
                if(frm_SeleccionInicial.verificarXML())
                   archivoXML.eliminarInformacionDelXml(arreglo[0]);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
