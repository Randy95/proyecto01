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
 * @author RandyGUTI
 */
//clase con metodos de agregar, consultar, modificar, eliminar del objeto cursos
public class MetodosCursos {
    
    private ArrayList <Cursos> arrayCursos;
    String arregloInformacionConsultada[]=new String[3];
    public ConexionBD conexion;
    ArchivosCursos archivos;
    public XML_Cursos archivoXML;
    public FRM_SeleccionInicial frm_SeleccionInicial;

    public MetodosCursos(ConexionBD conexion,FRM_SeleccionInicial frm_SeleccionInicial) 
    {
        arrayCursos=new ArrayList <Cursos>();
        this.frm_SeleccionInicial=frm_SeleccionInicial;
        this.conexion=conexion;
        archivoXML = new XML_Cursos();
        archivos = new ArchivosCursos();
        
    }
    //metodo para igualar el arraylist de esta clase con el arraylist creado en conexionBD
    public void igualarArrayBD()
    {
       arrayCursos=conexion.crearArrayCursos();
    }
    //metodo para igualar el arraylist de esta clase con el arraylist creado en Archivos del objeto
    public void igualarArrayArchivos()
    {
      arrayCursos=archivos.leerInformacionCompleta();
    }
    //metodo para igualar el arraylist de esta clase con el arraylist creado en Archivos XML del objeto
    public void igualarArrayXML()
    {
      arrayCursos=archivoXML.crearArrayCurso();
    }
    public void agregarCurso(String informacion[])
    {
        Cursos temporal=new Cursos(informacion[0], informacion[1], Integer.parseInt(informacion[2]), informacion[3]);
        arrayCursos.add(temporal);
        if(frm_SeleccionInicial.verificarBD())
        {    
            if(conexion.registrarCurso(informacion))
                System.out.println("Se registro el curso en la BD\n");
        }
        if(frm_SeleccionInicial.verificarXML())
        {
          archivoXML.guardarEnXML(informacion);
        }
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            System.out.println(arrayCursos.get(contador).getInformacion());
        
        }
    
    }
    public void escribirEnArchivo()
    {
      archivos.crearArchivo();
      
      for(int contador=0;contador<arrayCursos.size();contador++)
      {
        archivos.escribirInformacionEnElArchivo(arrayCursos.get(contador));
        
      }
    }
    public boolean consultarCurso(String sigla)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(sigla))
            {
                arregloInformacionConsultada[0]=arrayCursos.get(contador).getNombre();
                arregloInformacionConsultada[1]=Integer.toString(arrayCursos.get(contador).getCreditos());
                arregloInformacionConsultada[2]=arrayCursos.get(contador).getHorario();
                
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.get(contador).setNombre(arreglo[1]);
                arrayCursos.get(contador).setCreditos(Integer.parseInt(arreglo[2]));
                arrayCursos.get(contador).setHorario(arreglo[3]);
                if(frm_SeleccionInicial.verificarBD())
                   conexion.modificarCurso(arreglo);
                if(frm_SeleccionInicial.verificarXML())
                   archivoXML.modificarInformacionDelXml(arreglo);
            }
        }
    }
    public void eliminarCurso(String arreglo[])
    { 
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.remove(contador);
                if(frm_SeleccionInicial.verificarBD()) 
                   conexion.eliminarCurso(arreglo);
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
