/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import modelo.ConexionBD;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;
import vista.FRM_SeleccionInicial;


/**
 *
 * @author RandyGUTI
 */
public class Controlador_FRM_Matricula implements ActionListener{

    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    public FRM_Matricula frm_Matricula;
    
    public MetodosEstudiantes metodosEstudiantes;
    public MetodosCursos metodosCursos;
    public MetodosMatricula metodosMatricula;
    
    private boolean verificarCurso=false;
    private boolean verificarEstudiante=false;
    
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes, FRM_MantenimientoCursos frm_MantenimientoCursos,
            FRM_Matricula frm_Matricula,ConexionBD conexion,FRM_SeleccionInicial frm_SeleccionInicial) 
    {
      this.metodosEstudiantes=frm_MantenimientoEstudiantes.controlador.metodosEstudiantes;
      this.metodosCursos=frm_MantenimientoCursos.controlador.metodosCursos;
      this.frm_Matricula=frm_Matricula;
      metodosMatricula = new MetodosMatricula(metodosCursos, metodosEstudiantes,this,conexion,frm_SeleccionInicial);
    }
    public void actionPerformed(ActionEvent e)
    {
      if(e.getActionCommand().equals("BuscarEstudiante"))
        {            
            buscarEstudiante();
            
        }
      if(e.getActionCommand().equals("BuscarCurso"))
        {            
            buscarCurso();
            
        }
      if(e.getActionCommand().equals("Agregar"))
        { 
          if(!frm_Matricula.siglaVacia())
          {
            frm_Matricula.agregarInformacionTabla();
            frm_Matricula.habilitarFinalizar();
            frm_Matricula.resetearSigla();
          }
          else
              frm_Matricula.mostrarMensaje("El espacio de la sigla se encuentra vacia");
        }
      if(e.getActionCommand().equals("Finalizar"))
        {        
          String arreglo[]=new String[3];
          for(int contador=0;contador<frm_Matricula.getCantidadFilas();contador++)
          {
             arreglo[0]=frm_Matricula.devolverCodigo();
             arreglo[1]=frm_Matricula.devolverDato(contador,1);
             arreglo[2]=frm_Matricula.devolverDato(contador,3);
             metodosMatricula.agregarMatricula(arreglo);
          }
          limpiar();
          desvalidar();
          frm_Matricula.deshabilitarFinalizar();
          frm_Matricula.colocarCodigo();
        }
      if(e.getActionCommand().equals("Consultar"))
        {            
          if(!metodosMatricula.consultarMatricula(frm_Matricula.devolverCodigo()))
          {   
            frm_Matricula.mostrarMensaje("No se encuentra ese código de matricula registrado");
            frm_Matricula.resetearGUI();
          }
          else
          {
             frm_Matricula.habilitarFinalizar();
             frm_Matricula.deshabilitarCodigo();
          }
          
        }
      if(e.getActionCommand().equals("Eliminar"))
        {           
          String codigo=frm_Matricula.devolverCodigo();
          String sigla=frm_Matricula.devolverSiglaSeleccionada();
          metodosMatricula.eliminarMatricula(codigo, sigla);
          frm_Matricula.eliminarFilaTabla();
          frm_Matricula.deshabilitarEliminar();
          frm_Matricula.resetearSigla();
        }
      
       //habilitarAgregar();
    }
    public void buscarEstudiante()
    {
        if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
            {
                frm_Matricula.mostrarEstudiante(metodosEstudiantes.getArregloInformacion());
                verificarEstudiante=metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula());
                habilitarAgregar();
            }
            else
            {
                frm_Matricula.mostrarMensaje("La cédula digitada no se encuentra.");
                frm_Matricula.resetearCedula();
                verificarEstudiante=false;
            }     
    }
    public void buscarCurso()
    {
        if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
            {
                frm_Matricula.mostrarCurso(metodosCursos.getArregloInformacion());
                verificarCurso=metodosCursos.consultarCurso(frm_Matricula.devolverSigla());
                habilitarAgregar();
            }
            else
            {
                frm_Matricula.mostrarMensaje("La sigla digitada no se encuentra.");
                frm_Matricula.resetearSigla();
                verificarCurso=false;
            }   
    }
    public void habilitarAgregar()
    {
      if(verificarEstudiante && verificarCurso)
      {
         frm_Matricula.habilitarAgregar();
         frm_Matricula.deshabilitarSiglaYCedula();
         frm_Matricula.deshabilitarCodigo();
      }
    }
    public void limpiar()
    {
      frm_Matricula.resetearGUI();
      frm_Matricula.deshabilitarAgregar();
    }
    public void desvalidar()
    {
      verificarCurso=false;
      verificarEstudiante=false;
    }
}
