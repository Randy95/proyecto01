/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosUsuario;
import modelo.Verificar;
import vista.FRM_VentanaRegistrar;


/**
 *
 * @author RandyGUTI
 */
//clase que controla los eventos de la FRM_VentanaRegistrar
public class Controlador_FRM_VentanaRegistrar implements ActionListener{

    FRM_VentanaRegistrar frm_VentanaRegistrar;
    Verificar verificar;
            
    public Controlador_FRM_VentanaRegistrar(FRM_VentanaRegistrar frm_VentanaRegistrar,Verificar verificar) 
    {
       this.verificar=verificar;
       this.frm_VentanaRegistrar=frm_VentanaRegistrar;
    }
    public void actionPerformed(ActionEvent e)
    {
      if(e.getActionCommand().equals("Agregar"))
      {
        if(!frm_VentanaRegistrar.espaciosVacios()) 
        {   
            if(verificar.verificarNumeros(frm_VentanaRegistrar.devolverInformacion()[4]))
            {
                if(verificar.verificarLetras(frm_VentanaRegistrar.devolverInformacion()[3]))
                {
                    if(frm_VentanaRegistrar.compararPasswords())
                    {
                     frm_VentanaRegistrar.metodos.agregarUsuario(frm_VentanaRegistrar.devolverInformacion());
                     frm_VentanaRegistrar.mostrarMensaje("Usuario agregado con exito");
                     frm_VentanaRegistrar.resetearGUI();
                    }
                    else
                    {
                        frm_VentanaRegistrar.mostrarMensaje("Las contraseñas no son iguales");
                        frm_VentanaRegistrar.limpiarPasswords();
                    }
                }
                else
                    frm_VentanaRegistrar.mostrarMensaje("El nombre completo no puede tener números");
            }
            else
                frm_VentanaRegistrar.mostrarMensaje("La cedula no puede contener letras");
        }
        else
            frm_VentanaRegistrar.mostrarMensaje("Faltan espacios por rellenar");
      }
      if(e.getActionCommand().equals("Consultar"))
      {
         buscar();   
      }
      if(e.getActionCommand().equals("Modificar"))
      {
        if(!frm_VentanaRegistrar.espaciosVacios()) 
        {   
            if(verificar.verificarNumeros(frm_VentanaRegistrar.devolverInformacion()[4]))
            {
                if(verificar.verificarLetras(frm_VentanaRegistrar.devolverInformacion()[3]))
                {
                    if(frm_VentanaRegistrar.compararPasswords())
                    {
                     frm_VentanaRegistrar.metodos.modificar(frm_VentanaRegistrar.devolverInformacion());
                     frm_VentanaRegistrar.mostrarMensaje("Usuario modificado con exito");
                     frm_VentanaRegistrar.resetearGUI();
                    }
                    else
                    {
                        frm_VentanaRegistrar.mostrarMensaje("Las contraseñas no son iguales");
                        frm_VentanaRegistrar.limpiarPasswords();
                    }
                }
                else
                    frm_VentanaRegistrar.mostrarMensaje("El nombre completo no puede tener números");
            }
            else
                frm_VentanaRegistrar.mostrarMensaje("La cedula no puede contener letras");
        }
        else
            frm_VentanaRegistrar.mostrarMensaje("Faltan espacios por rellenar");
      }
      if(e.getActionCommand().equals("Eliminar"))
      {
         frm_VentanaRegistrar.metodos.eliminar(frm_VentanaRegistrar.devolverInformacion());
         frm_VentanaRegistrar.mostrarMensaje("Usuario eliminado con exito");  
         frm_VentanaRegistrar.resetearGUI();
      }
    }
    //metodo que busca un usuario mediante el nombre usuario, muestra la informacion de este o habilita opciones para agregar uno nuevo
    public void buscar()
    {
     
        if(!frm_VentanaRegistrar.metodos.consultarUsuario(frm_VentanaRegistrar.devolverNombreUsuario()))
            {
                if(verificar.verificarLetras(frm_VentanaRegistrar.devolverNombreUsuario()))
                {    
                    frm_VentanaRegistrar.mostrarMensaje("Puede usar este nombre de usuario");
                    frm_VentanaRegistrar.habilitarCampos();
                    frm_VentanaRegistrar.habilitarAgregar();
                    frm_VentanaRegistrar.deshabilitarNombreUsuario();
                }
                else
                    frm_VentanaRegistrar.mostrarMensaje("El nombre de usuario no puede tener numeros");
            }
        else
        {
          frm_VentanaRegistrar.mostrarMensaje("Ese nombre de usuario ya existe, se mostrara la informacion");
          frm_VentanaRegistrar.mostrarInformacion(frm_VentanaRegistrar.metodos.getArregloInformacion());
          frm_VentanaRegistrar.habilitarModificacion();
          frm_VentanaRegistrar.habilitarEdicion();
          frm_VentanaRegistrar.deshabilitarNombreUsuario();
        }
    }
    
}
