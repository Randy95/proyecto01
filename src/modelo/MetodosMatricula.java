/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Controlador_FRM_Matricula;
import java.util.ArrayList;
import vista.FRM_Matricula;
import vista.FRM_SeleccionInicial;

/**
 *
 * @author RandyGUTI
 */
public class MetodosMatricula {

    private ArrayList <Matricula> arrayMatricula;
    String arregloInformacionConsultada[]=new String[4];
    Controlador_FRM_Matricula controlador;
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    public ConexionBD conexion;
    ArchivosMatricula archivos;
    public XML_Matricula archivoXML;
    public FRM_SeleccionInicial frm_SeleccionInicial;
    
    public MetodosMatricula(MetodosCursos metodosCursos,MetodosEstudiantes metodosEstudiantes
    ,Controlador_FRM_Matricula controlador,ConexionBD conexion,FRM_SeleccionInicial frm_SeleccionInicial) {
        
       this.controlador=controlador;
       this.metodosCursos=metodosCursos;
       this.metodosEstudiantes=metodosEstudiantes;
       arrayMatricula=new ArrayList <Matricula>();
       this.frm_SeleccionInicial=frm_SeleccionInicial;
       this.conexion=conexion;
       archivoXML = new XML_Matricula(); 
       archivos = new ArchivosMatricula();
    }
    public void igualArrayXML()
    {
      arrayMatricula=archivoXML.crearArrayMatricula();
    }
    public void igualarArrayBD()
    {
       arrayMatricula=conexion.crearArrayMatricula();
    }
    public void igualarArrayArchivos()
    {
      arrayMatricula=archivos.leerInformacionCompleta();
    }
    public void agregarMatricula(String informacion[])
    {
        int posicion=0;
        boolean localizado=false;
        Matricula objeto=new Matricula(informacion[0], informacion[1], informacion[2], true);
        for (int i = 0; i < arrayMatricula.size(); i++) 
        {
            if(arrayMatricula.get(i).getCodigo().equalsIgnoreCase(informacion[0]) )
            {
                if(arrayMatricula.get(i).getSigla().equalsIgnoreCase(informacion[2]))
                {
                    localizado=true;
                    break;
                }
                posicion=i+1;
            }
        }
        if(arrayMatricula.size()!=0)
        {
            if(!localizado)
            {
                if(posicion==0)
                {    
                    arrayMatricula.add(objeto);
                    if(frm_SeleccionInicial.verificarBD())
                    {    
                        if(conexion.registrarMatricula(informacion))
                            System.out.println("Se registro la matricula en la BD");
                    } 
                    if(frm_SeleccionInicial.verificarXML())
                       archivoXML.guardarEnXML(informacion);
                }
                else
                {    
                    arrayMatricula.add(posicion,objeto);
                    if(frm_SeleccionInicial.verificarBD())
                    {    
                        if(conexion.registrarMatricula(informacion))
                            System.out.println("Se registro la matricula en la BD");
                    }  
                    if(frm_SeleccionInicial.verificarXML())
                       archivoXML.guardarEnXML(informacion);
                }
            }
        }
        else
        {
            arrayMatricula.add(objeto);
            if(frm_SeleccionInicial.verificarBD())
                    {    
                        if(conexion.registrarMatricula(informacion))
                            System.out.println("Se registro la matricula en la BD");
                    }  
            if(frm_SeleccionInicial.verificarXML())
                       archivoXML.guardarEnXML(informacion);
        }
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            System.out.println(arrayMatricula.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarMatricula(String codigo)
    {
        boolean existe=false;
        controlador.frm_Matricula.limpiarTabla();
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(codigo))
            {
                if(arrayMatricula.get(contador).getEstado())
                {
                   arregloInformacionConsultada[0]=arrayMatricula.get(contador).getCodigo();
                   arregloInformacionConsultada[1]=arrayMatricula.get(contador).getCedula();
                   metodosEstudiantes.consultarEstudiante(arrayMatricula.get(contador).getCedula());
                   arregloInformacionConsultada[2]=metodosEstudiantes.getArregloInformacion()[0];
                   arregloInformacionConsultada[3]=arrayMatricula.get(contador).getSigla();
                   controlador.frm_Matricula.agregarInformacionTabla(arregloInformacionConsultada);
                
                   existe=true;
                }
                
                
            }
        
        }
        return existe;
    
    }
    public void modificarMatricula(String arreglo[])
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(arreglo[0]))
            {
                arrayMatricula.get(contador).setCedula(arreglo[1]);
                arrayMatricula.get(contador).setSigla(arreglo[2]);
                if(frm_SeleccionInicial.verificarBD())
                   conexion.modificarMatricula(arreglo);
                if(frm_SeleccionInicial.verificarXML())
                       archivoXML.modificarInformacionDelXml(arreglo);
            }
        }
    }
    public void eliminarMatricula(String codigo, String sigla)
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(codigo))
            {
                if(arrayMatricula.get(contador).getSigla().equals(sigla))
                {
                    arrayMatricula.get(contador).setEstado(false);
                    if(frm_SeleccionInicial.verificarBD())
                        conexion.eliminarMatricula(codigo,sigla);
                    if(frm_SeleccionInicial.verificarXML())
                       archivoXML.eliminarInformacionDelXml(codigo, sigla);
                }
            }
        }
    }
    public void escribirEnArchivo()
    {
      archivos.crearArchivo();
      
      for(int contador=0;contador<arrayMatricula.size();contador++)
      {
        archivos.escribirInformacionEnElArchivo(arrayMatricula.get(contador));
        
      }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    public String devolverCodigo()
    {
      String codigo= "0000";
      //+this.arrayMatricula.size()+1
      if(arrayMatricula.size()==0)
      {
        codigo+=1;
      }
      else
      {
        int numero=Integer.parseInt(arrayMatricula.get(arrayMatricula.size()-1).getCodigo());
        numero++;
        codigo="0000"+numero;
      }
      codigo=codigo.substring(codigo.length()-5,codigo.length());
      return codigo;
    }
}
