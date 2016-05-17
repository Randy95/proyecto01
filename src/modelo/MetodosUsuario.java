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
public class MetodosUsuario {
    
    private ArrayList <Usuario> arrayUsuarios;
    String arregloInformacionConsultada[]=new String[4];
    public ConexionBD conexion;
    ArchivosUsuario archivos;
    public XML_Usuario archivoXML;
    public FRM_SeleccionInicial frm_SeleccionInicial;
    
    public MetodosUsuario(ConexionBD conexion,FRM_SeleccionInicial frm_SeleccionInicial)
    {
        arrayUsuarios=new ArrayList <Usuario>();
        this.frm_SeleccionInicial=frm_SeleccionInicial;
        this.conexion=conexion;
        archivos = new ArchivosUsuario();
        archivoXML = new XML_Usuario();
    }
    public void igualArrayXML()
    {
      arrayUsuarios=archivoXML.crearArrayUsuario();
    }
    public void igualarArrayBD()
    {
       arrayUsuarios=conexion.crearArrayUsuario();
    }
    public void igualarArrayArchivos()
    {
      arrayUsuarios=archivos.leerInformacionCompleta();
    }
    public void agregarUsuario(String informacion[])
    {
        Usuario temporal=new Usuario(informacion[0], informacion[1], informacion[2], informacion[3], informacion[4]);
        arrayUsuarios.add(temporal);
        if(frm_SeleccionInicial.verificarBD())
        {
            if(conexion.registrarUsuario(informacion))
                System.out.println("Se registro el usuario en la BD");
        }
        if(frm_SeleccionInicial.verificarXML())
                   archivoXML.guardarEnXML(informacion);
        
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            System.out.println(arrayUsuarios.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarUsuario(String nombre,String password)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equalsIgnoreCase(nombre) && 
                    arrayUsuarios.get(contador).getPassword().equals(password))
            {
                arregloInformacionConsultada[0]=arrayUsuarios.get(contador).getPassword();
                arregloInformacionConsultada[1]=arrayUsuarios.get(contador).getTipo();
                arregloInformacionConsultada[2]=arrayUsuarios.get(contador).getNombreCompleto();
                arregloInformacionConsultada[3]=arrayUsuarios.get(contador).getCedula();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public boolean consultarUsuario(String nombre)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equalsIgnoreCase(nombre))
            {
                arregloInformacionConsultada[0]=arrayUsuarios.get(contador).getPassword();
                arregloInformacionConsultada[1]=arrayUsuarios.get(contador).getTipo();
                arregloInformacionConsultada[2]=arrayUsuarios.get(contador).getNombreCompleto();
                arregloInformacionConsultada[3]=arrayUsuarios.get(contador).getCedula();
                
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificar(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(arreglo[0]))
            {
                arrayUsuarios.get(contador).setPassword(arreglo[1]);
                arrayUsuarios.get(contador).setTipo(arreglo[2]);
                arrayUsuarios.get(contador).setNombreCompleto(arreglo[3]);
                if(frm_SeleccionInicial.verificarBD())
                   conexion.modificarUsuario(arreglo);
                if(frm_SeleccionInicial.verificarXML())
                   archivoXML.modificarInformacionDelXml(arreglo);
            }
        }
    }
    public void eliminar(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(arreglo[0]))
            {
                arrayUsuarios.remove(contador);
                if(frm_SeleccionInicial.verificarBD())
                    conexion.eliminarUsuario(arreglo);
                if(frm_SeleccionInicial.verificarXML())
                   archivoXML.eliminarInformacionDelXml(arreglo[0]);
            }
        }
    }
    public void escribirEnArchivo()
    {
      archivos.crearArchivo();
      
      for(int contador=0;contador<arrayUsuarios.size();contador++)
      {
        archivos.escribirInformacionEnElArchivo(arrayUsuarios.get(contador));
        
      }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    public int getTamanio()
    {
       return arrayUsuarios.size();
    }
    public String devolverTipo(String usuario)
    {
      String tipo="";
      for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(usuario))
            {
                tipo=arrayUsuarios.get(contador).getTipo();
            }
        }
      return tipo;
    }

}
