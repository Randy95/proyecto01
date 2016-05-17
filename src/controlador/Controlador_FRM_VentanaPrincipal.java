/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosUsuario;
import modelo.Verificar;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;
import vista.FRM_SeleccionInicial;
import vista.FRM_VentanaLogin;
import vista.FRM_VentanaPrincipal;
import vista.FRM_VentanaRegistrar;

/**
 *
 * @author tecnologiamultimedia
 */


    
public class Controlador_FRM_VentanaPrincipal implements ActionListener{

    public ConexionBD conexion;
    FRM_SeleccionInicial frm_SeleccionInicial;
    public FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    public FRM_MantenimientoCursos frm_MantenimientoCursos;
    public FRM_Matricula frm_Matricula;
    Verificar verificar;
    FRM_VentanaRegistrar frm_VentanaRegistrar;
    FRM_VentanaLogin frm_VentanaLogin;
    public MetodosUsuario metodos;
    
    public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipal frm_VentanaPrincipal,ConexionBD conexion)
    {
        this.conexion = conexion;
        verificar = new Verificar();
        frm_SeleccionInicial = new FRM_SeleccionInicial(this);
        this.frm_SeleccionInicial.setVisible(true);
        frm_MantenimientoEstudiantes= new FRM_MantenimientoEstudiantes(conexion,frm_SeleccionInicial,verificar);
        frm_MantenimientoCursos= new FRM_MantenimientoCursos(conexion,frm_SeleccionInicial,verificar);
        metodos = new MetodosUsuario(conexion,frm_SeleccionInicial);
        frm_VentanaRegistrar = new FRM_VentanaRegistrar(frm_VentanaPrincipal,metodos,verificar);
        frm_VentanaLogin = new FRM_VentanaLogin(frm_VentanaPrincipal,metodos);
        frm_Matricula = new FRM_Matricula(frm_MantenimientoEstudiantes,frm_MantenimientoCursos,conexion,frm_SeleccionInicial);
         
    }
    public void inicarPrograma()
    {
      if(frm_SeleccionInicial.verificarBD())
        {    
            if(frm_VentanaRegistrar.metodos.getTamanio()==0)
            {
              this.frm_VentanaRegistrar.setVisible(true);
            }
            else
                this.frm_VentanaLogin.setVisible(true);
        }   
      else if(frm_SeleccionInicial.verificarArchivosPlanos())
        {    
            if(frm_VentanaRegistrar.metodos.getTamanio()==0)
            {
              this.frm_VentanaRegistrar.setVisible(true);
            }
            else
                this.frm_VentanaLogin.setVisible(true);
        }
      else if(frm_SeleccionInicial.verificarXML())
        {    
            if(frm_VentanaRegistrar.metodos.getTamanio()==0)
            {
              this.frm_VentanaRegistrar.setVisible(true);
            }
            else
                this.frm_VentanaLogin.setVisible(true);
        }
        else
            System.exit(0);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            frm_MantenimientoEstudiantes.setVisible(true);    
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            frm_MantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            frm_Matricula.setVisible(true);
            frm_Matricula.colocarCodigo();
        }
        if(e.getActionCommand().equals("Registrar"))
        {
            frm_VentanaRegistrar.setVisible(true);
        }
        if(e.getActionCommand().equals("Login"))
        {
            frm_VentanaLogin.setVisible(true);
        }
    }
    
}












