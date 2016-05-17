/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosEstudiantes;
import modelo.Verificar;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_SeleccionInicial;


public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    public MetodosEstudiantes metodosEstudiantes;
    Verificar verificar;
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes,ConexionBD conexion,FRM_SeleccionInicial frm_SeleccionInicial
    ,Verificar verificar)
    {
        this.verificar=verificar;
        metodosEstudiantes= new MetodosEstudiantes(conexion,frm_SeleccionInicial);
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
            if(!frm_MantenimientoEstudiantes.espaciosVacios())
            {
                if(verificar.verificarLetras(frm_MantenimientoEstudiantes.devolverInformacion()[1]))
                {
                    metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                    frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
                    frm_MantenimientoEstudiantes.resetearGUI();
                }
                else
                    frm_MantenimientoEstudiantes.mostrarMensaje("El nombre completo solo puede contener letras");
            }
            else
                frm_MantenimientoEstudiantes.mostrarMensaje("Faltan espacios por rellenar");
            
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
           if(!frm_MantenimientoEstudiantes.espaciosVacios())
            {
                if(verificar.verificarLetras(frm_MantenimientoEstudiantes.devolverInformacion()[1]))
                {
                    metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                    frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta");
                    frm_MantenimientoEstudiantes.resetearGUI();
                }
                else
                    frm_MantenimientoEstudiantes.mostrarMensaje("El nombre completo solo puede contener letras");
            }
            else
                frm_MantenimientoEstudiantes.mostrarMensaje("Faltan espacios por rellenar");
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void buscar()
    {
        if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                if(verificar.verificarNumeros(frm_MantenimientoEstudiantes.devolverInformacion()[0]))
                {   
                    frm_MantenimientoEstudiantes.mostrarMensaje("La cédula buscada no se encuentra.");
                    frm_MantenimientoEstudiantes.habilitarAgregar();
                }
                else
                    frm_MantenimientoEstudiantes.mostrarMensaje("La cedula solo debe contener números");
            }
    }
    
    
    
    
    
    
    
    
    
    
    
}
