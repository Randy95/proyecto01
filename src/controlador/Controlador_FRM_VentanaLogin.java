/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.MetodosUsuario;
import vista.FRM_VentanaLogin;

/**
 *
 * @author RandyGUTI
 */
public class Controlador_FRM_VentanaLogin implements ActionListener{

    FRM_VentanaLogin frm_VentanaLogin;
    
    
    public Controlador_FRM_VentanaLogin(FRM_VentanaLogin frm_VentanaLogin) 
    {
        this.frm_VentanaLogin=frm_VentanaLogin;
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Ingresar"))
        {
          if(!frm_VentanaLogin.espaciosVacio())
          {
            if(!frm_VentanaLogin.metodos.consultarUsuario(frm_VentanaLogin.devolverNombreUsuario(),frm_VentanaLogin.devolverPassword()))
              {
                 frm_VentanaLogin.mostrarMensaje("El nombre de usuario no se encuentra registrado o la contraseña es incorrecta");
              }
            else
            {
                frm_VentanaLogin.mostrarMensaje("Se ha iniciado sesión");
                frm_VentanaLogin.setVisible(false);
                frm_VentanaLogin.frm_VentanaPrincipal.setVisible(true);
                verificarTipo(frm_VentanaLogin.metodos.devolverTipo(frm_VentanaLogin.devolverNombreUsuario()));
            }
          }
          else
              frm_VentanaLogin.mostrarMensaje("Se encuentran espacios sin llenar");
        }
        if(e.getActionCommand().equals("Salir"))
        {
            frm_VentanaLogin.setVisible(false);
            frm_VentanaLogin.frm_VentanaPrincipal.setVisible(true);
        }
    }
    public void verificarTipo(String tipo)
    {
       if(tipo.equals("Administrador"))
       {
         this.frm_VentanaLogin.frm_VentanaPrincipal.habilitarCursos();
         this.frm_VentanaLogin.frm_VentanaPrincipal.habilitarEstudiantes();
         this.frm_VentanaLogin.frm_VentanaPrincipal.habilitarMatricula();
         this.frm_VentanaLogin.frm_VentanaPrincipal.habilitarRegistrar();
       }
       if(tipo.equals("Docente"))
       {
         this.frm_VentanaLogin.frm_VentanaPrincipal.habilitarCursos();
         this.frm_VentanaLogin.frm_VentanaPrincipal.deshabilitarEstudiantes();
         this.frm_VentanaLogin.frm_VentanaPrincipal.deshabilitarMatricula();
         this.frm_VentanaLogin.frm_VentanaPrincipal.deshabilitarRegistrar();
       }
       if(tipo.equals("Estudiante"))
       {
         this.frm_VentanaLogin.frm_VentanaPrincipal.deshabilitarCursos();
         this.frm_VentanaLogin.frm_VentanaPrincipal.habilitarEstudiantes();
         this.frm_VentanaLogin.frm_VentanaPrincipal.habilitarMatricula();
         this.frm_VentanaLogin.frm_VentanaPrincipal.deshabilitarRegistrar();
       }
    }
    
}
