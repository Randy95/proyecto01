/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author RandyGUTI
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.JSType;


//clase que interactua con la base de datos de SQL SERVER
public class ConexionBD {
    
    Connection con = null;
    public ConexionBD()
    {
      
    }
    //METODO para conectarse a la base de datos
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada\n");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    
    //Metodos de estudiantes
    //  |
    //  |
    //  |
    //  V
    public boolean registrarEstudiante(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public void consultarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `estudiantes` WHERE cedula="+cedula);
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");
                    System.out.println("Información de la BD:\n\nNombre: "+nombre+"\nCedula: "+cedula+"\nDireccion: "+direccion); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
    }
    public boolean modificarEstudiante(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `estudiantes` SET `cedula`='"+arreglo[0]+"',`nombre`='"+arreglo[1]+"',`direccion`='"+arreglo[2]+"' WHERE cedula='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    public boolean eliminarEstudiante(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `estudiantes` WHERE cedula='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<Estudiante> crearArrayEstudiantes()
    {
        ResultSet rs = null;
        Statement cmd = null;
        ArrayList<Estudiante> arrayEstudiantes = new ArrayList <Estudiante>();
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `estudiantes` ");
                
                while (rs.next()) 
                {
                    String cedula = rs.getString("cedula");
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");
                    
                    Estudiante temporal = new Estudiante(cedula,nombre,direccion);
                    arrayEstudiantes.add(temporal);
                }
                
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return arrayEstudiantes;
    }
    
    //Metodos de cursos
    //  |
    //  |
    //  |
    //  V
    public boolean registrarCurso(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO `cursos`(`sigla`, `nombre`, `creditos`, `horario`) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+Integer.parseInt(arreglo[2])+"','"+arreglo[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public void consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `cursos` WHERE sigla="+sigla);
                
                while (rs.next()) 
                {
                    
                    String nombre = rs.getString("nombre");
                    int creditos = rs.getInt("creditos");
                    String horario = rs.getString("horario");
                    System.out.println("Información de la BD:\n\nNombre: "+nombre+"\nSigla: "+sigla+"\nCreditos: "+creditos+"\nHorario: "+horario); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
    }
    public boolean modificarCurso(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `cursos` SET `sigla`='"+arreglo[0]+"',`nombre`='"+arreglo[1]+"',`creditos`='"+Integer.parseInt(arreglo[2])+"',`horario`='"+arreglo[3]+"' WHERE sigla='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    public boolean eliminarCurso(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `cursos` WHERE sigla='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<Cursos> crearArrayCursos()
    {
        ResultSet rs = null;
        Statement cmd = null;
        ArrayList<Cursos> arrayCursos = new ArrayList <Cursos>();
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `cursos`");
                
                while (rs.next()) 
                {
                    String sigla = rs.getString("sigla");
                    String nombre = rs.getString("nombre");
                    int creditos = rs.getInt("creditos");
                    String horario = rs.getString("horario");
                    Cursos temporal = new Cursos(sigla,nombre,creditos,horario);
                    arrayCursos.add(temporal);
                }
                
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return arrayCursos;
    }
    
    //Metodos de matricula
    //  |
    //  |
    //  |
    //  V
    public boolean registrarMatricula(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO `detalle_matricula`(`codigo`, `cedula`, `sigla`) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public void consultarMatricula(String codigo)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `detalle_matricula` WHERE codigo="+codigo);
                
                while (rs.next()) 
                {
                    
                    String cedula = rs.getString("cedula");
                    String sigla = rs.getString("sigla");
                    
                    //System.out.println("Información de la BD:\n\Codigo: "+codigo);
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
    }
    public boolean modificarMatricula(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `detalle_matricula` SET `codigo`='"+arreglo[0]+"',`cedula`='"+arreglo[1]+"',`sigla`='"+arreglo[2]+"' WHERE codigo='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    public boolean eliminarMatricula(String codigo,String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `detalle_matricula` WHERE codigo='"+codigo+"' and sigla='"+sigla+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<Matricula> crearArrayMatricula()
    {
        ResultSet rs = null;
        Statement cmd = null;
        ArrayList<Matricula> arrayMatricula= new ArrayList <Matricula>();
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `detalle_matricula`");
                
                while (rs.next()) 
                {
                    String sigla = rs.getString("sigla");
                    String codigo = rs.getString("codigo");
                    String cedula = rs.getString("cedula");
                    Matricula temporal = new Matricula(codigo,cedula,sigla,true);
                    arrayMatricula.add(temporal);
                }
                
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return arrayMatricula;
    }
    //Metodos de usuario
    //  |
    //  |
    //  |
    //  V
    public boolean registrarUsuario(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO `usuario`(`nombreUsuario`, `password`, `tipo`, `nombreCompleto`, `cedula`) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"','"+arreglo[3]+"','"+arreglo[4]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public void consultarUsuario(String nombreUsuario)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `usuario` WHERE nombreUsuario="+nombreUsuario);
                
                while (rs.next()) 
                {
                    
                    String cedula = rs.getString("cedula");
                    String tipo = rs.getString("tipo");
                    String password = rs.getString("password");
                    String nombreCompleto = rs.getString("nombreCompleto");
                    
                    //System.out.println("Información de la BD:\n\Nombre Usuario: "+nombreUsuario+"\nCedula: "+cedula+"\nNombre Completo: "+nombreCompleto+"\nPassword: "+password+"\nTipo: "+tipo);
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
    }
    public boolean modificarUsuario(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `usuario` SET `nombreUsuario`='"+arreglo[0]+"',`password`='"+arreglo[1]+"',`tipo`='"+arreglo[2]+"',`nombreCompleto`='"+arreglo[3]+"',`cedula`='"+arreglo[4]+"' WHERE nombreUsuario='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    public boolean eliminarUsuario(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `usuario` WHERE nombreUsuario='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<Usuario> crearArrayUsuario()
    {
        ResultSet rs = null;
        Statement cmd = null;
        ArrayList<Usuario> arrayUsuario= new ArrayList <Usuario>();
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `usuario`");
                
                while (rs.next()) 
                {
                    String nombreUsuario = rs.getString("nombreUsuario");
                    String password = rs.getString("password");
                    String cedula = rs.getString("cedula");
                    String nombreCompleto = rs.getString("nombreCompleto");
                    String tipo = rs.getString("tipo");
                    Usuario temporal = new Usuario(nombreUsuario,password,tipo,nombreCompleto,cedula);
                    arrayUsuario.add(temporal);
                }
                
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return arrayUsuario;
    }
    
}
