/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosCursos;
import modelo.Verificar;
import vista.FRM_MantenimientoCursos;
import vista.FRM_SeleccionInicial;

/**
 *
 * @author RandyGUTI
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{
   
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    public MetodosCursos metodosCursos;
    Verificar verificar;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos,ConexionBD conexion,FRM_SeleccionInicial frm_SeleccionInicial
    ,Verificar verificar)
    {
      this.frm_MantenimientoCursos=frm_MantenimientoCursos;
      this.verificar=verificar;
      metodosCursos=new MetodosCursos(conexion,frm_SeleccionInicial);
    }
    public void actionPerformed(ActionEvent evento)
    {
       if(evento.getActionCommand().equals("Agregar"))
       {
           if(!frm_MantenimientoCursos.espaciosVacios())
           {
             if(verificar.verificarLetras(frm_MantenimientoCursos.devolverInformacion()[1]))
             {
                metodosCursos.agregarCurso(frm_MantenimientoCursos.devolverInformacion());
                frm_MantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
                frm_MantenimientoCursos.resetearGUI();
             }
             else
                 frm_MantenimientoCursos.mostrarMensaje("El nombre del curso no puede tener números");
           }
           else
               frm_MantenimientoCursos.mostrarMensaje("Faltan espacios por rellenar");
       }
       if(evento.getActionCommand().equals("Consultar")||evento.getActionCommand().equals("ConsultaRapida"))
       {
           buscar();
       }
       if(evento.getActionCommand().equals("Modificar"))
       {
          if(!frm_MantenimientoCursos.espaciosVacios())
           {
             if(verificar.verificarLetras(frm_MantenimientoCursos.devolverInformacion()[1]))
             {
                metodosCursos.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
                frm_MantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta");
                frm_MantenimientoCursos.resetearGUI();
             }
             else
                 frm_MantenimientoCursos.mostrarMensaje("El nombre del curso no puede tener números");
           }
           else
               frm_MantenimientoCursos.mostrarMensaje("Faltan espacios por rellenar");
       }
       if(evento.getActionCommand().equals("Eliminar"))
       {
          metodosCursos.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
          frm_MantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
          frm_MantenimientoCursos.resetearGUI();  
       }
    }
    public void buscar()
    {
      if(metodosCursos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodosCursos.getArregloInformacion());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_MantenimientoCursos.habilitarAgregar();
            }
    }
    
}
