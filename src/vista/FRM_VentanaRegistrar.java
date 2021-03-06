/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_VentanaRegistrar;
import javax.swing.JOptionPane;
import modelo.MetodosUsuario;
import modelo.Verificar;

/**
 *
 * @author RandyGUTI
 */
//clase que interactua con el usuario para darle mantenimiento a los usuarios
public class FRM_VentanaRegistrar extends javax.swing.JFrame {

    /**
     * Creates new form FRM_VentanaRegistrar
     */
    public Controlador_FRM_VentanaRegistrar controlador;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    public MetodosUsuario metodos;
    
    public FRM_VentanaRegistrar(FRM_VentanaPrincipal frm_VentanaPrincipal,MetodosUsuario metodos,Verificar verificar) {
        initComponents();
        this.setLocation(500,200);
        this.setVisible(false);
        this.metodos=metodos;
        controlador= new Controlador_FRM_VentanaRegistrar(this,verificar);
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
        this.panel_Botones1.agregarEventos(controlador);
    }
    //metodo que hablitia los campos de texto de la ventana
    public void habilitarCampos()
    {
      this.jcb_TipoUsuario.setEnabled(true);
      this.jtp_Password.setEnabled(true);
      this.jt_NombreCompleto.setEnabled(true);
      this.jt_Cedula.setEnabled(true);
      this.jtp_RepetirPassword.setEnabled(true);
    }
    //metodo que verifica si los espacios estan vacios en la ventana y devuelve un true o false
    public boolean espaciosVacios()
    {
      if(jt_Cedula.getText().equals("") || jt_NombreCompleto.getText().equals("") || jtp_Password.getText().equals("")
              || jtp_RepetirPassword.getText().equals(""))
      {
        return true;
      }
      else 
          return false;
    }
    //metodo que habilita ciertos campos de texto
    public void habilitarModificacion()
    {
      this.jcb_TipoUsuario.setEnabled(true);
      this.jtp_Password.setEnabled(true);
      this.jtp_RepetirPassword.setEnabled(true);
      this.jt_NombreCompleto.setEnabled(true);
    }
    //metodo que deshabilita todos los campos y habilita solo el de usuario
    public void deshabilitarCampos()
    {
      this.jt_NombreUsuario.setEnabled(true);
      this.jcb_TipoUsuario.setEnabled(false);
      this.jtp_Password.setEnabled(false);
      this.jt_NombreCompleto.setEnabled(false);
      this.jt_Cedula.setEnabled(false);
      this.jtp_RepetirPassword.setEnabled(false);
      this.panel_Botones1.deshabilitarBotones();
    }
    //metodo que deshabilita el campo de nombre usuario 
    public void deshabilitarNombreUsuario()
    {
     this.jt_NombreUsuario.setEnabled(false);
    }
    
    public void habilitarAgregar()
    {
      this.panel_Botones1.habilitarAgregar();
    }
    public void habilitarEdicion()
    {
      this.panel_Botones1.habilitarEdicion();
    }
    //metodo que muestra un mensaje en pantalla
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    //metodo que devuelve el texto en el nombre de usuario
    public String devolverNombreUsuario()
    {
      return this.jt_NombreUsuario.getText();
    }
    //metodo que devuelve la informacion de los campos de texto en un arreglo
    public String[] devolverInformacion()
    {
      String informacion[]=new String[5];
        informacion[0]=this.jt_NombreUsuario.getText();
        informacion[1]=this.jtp_Password.getText();
        informacion[2]=(String)this.jcb_TipoUsuario.getSelectedItem();
        informacion[3]=this.jt_NombreCompleto.getText();
        informacion[4]=this.jt_Cedula.getText();
        
        
        return informacion;
    }
    //metodo que muestra informacion en los campos de texto mediante un arreglo
    public void mostrarInformacion(String arreglo[])
    {
      this.jtp_Password.setText(arreglo[0]);
      this.jcb_TipoUsuario.setSelectedItem(arreglo[1]);
      this.jt_NombreCompleto.setText(arreglo[2]);
      this.jt_Cedula.setText(arreglo[3]);
    }
    //metodo que limpiar los campos de texto y los deshabilita
    public void resetearGUI()
    {
      this.jt_NombreUsuario.setText("");
      this.jtp_Password.setText("");
      this.jcb_TipoUsuario.setSelectedIndex(0);
      this.jt_NombreCompleto.setText("");
      this.jtp_RepetirPassword.setText("");
      this.jt_Cedula.setText("");
      deshabilitarCampos();
      
    }
    //metodo para comparar que los dos espacios de las passwords sean iguales y devuelven un true o false
    public boolean compararPasswords()
    {
       boolean verdad=false;
       
       if(this.jtp_Password.getText().equals(this.jtp_RepetirPassword.getText()))
       {
         verdad=true;
       }
       
       return verdad;
    }
    //metodo que limpia los campos de password y repetir password
    public void limpiarPasswords()
    {
      this.jtp_Password.setText("");
      this.jtp_RepetirPassword.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_TituloVentana = new javax.swing.JLabel();
        jl_NombreUsuario = new javax.swing.JLabel();
        jl_Password = new javax.swing.JLabel();
        jl_TipoUsuario = new javax.swing.JLabel();
        jt_NombreUsuario = new javax.swing.JTextField();
        jtp_Password = new javax.swing.JPasswordField();
        jcb_TipoUsuario = new javax.swing.JComboBox<>();
        jl_RepetirPassword = new javax.swing.JLabel();
        jl_Cedula = new javax.swing.JLabel();
        jl_NombreCompleto = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jt_NombreCompleto = new javax.swing.JTextField();
        jtp_RepetirPassword = new javax.swing.JPasswordField();
        panel_Botones1 = new vista.Panel_Botones();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jl_TituloVentana.setFont(new java.awt.Font("Gautami", 1, 24)); // NOI18N
        jl_TituloVentana.setText("Registro de usuario");

        jl_NombreUsuario.setText("Nombre usuario");

        jl_Password.setText("Contraseña");

        jl_TipoUsuario.setText("Tipo de usuario");

        jt_NombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_NombreUsuarioKeyPressed(evt);
            }
        });

        jtp_Password.setEnabled(false);

        jcb_TipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Docente", "Administrador" }));
        jcb_TipoUsuario.setEnabled(false);

        jl_RepetirPassword.setText("Repetir contraseña");

        jl_Cedula.setText("Cedula");

        jl_NombreCompleto.setText("Nombre completo");

        jt_Cedula.setEnabled(false);

        jt_NombreCompleto.setEnabled(false);

        jtp_RepetirPassword.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jl_TituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_NombreUsuario)
                            .addComponent(jl_Password)
                            .addComponent(jl_TipoUsuario)
                            .addComponent(jl_RepetirPassword)
                            .addComponent(jl_Cedula)
                            .addComponent(jl_NombreCompleto))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jt_Cedula)
                            .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jt_NombreUsuario)
                            .addComponent(jtp_Password)
                            .addComponent(jcb_TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtp_RepetirPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_TituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Cedula)
                    .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreCompleto)
                    .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreUsuario)
                    .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Password, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtp_Password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_RepetirPassword)
                    .addComponent(jtp_RepetirPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_TipoUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcb_TipoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //metodo que escucha al teclear enter en el campo de nombre usuario
    private void jt_NombreUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_NombreUsuarioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            controlador.buscar();
        }
    }//GEN-LAST:event_jt_NombreUsuarioKeyPressed

    //metodo que actualiza el archivo plano si antes se selecciono y muestra la ventana principal
    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        resetearGUI();
        if(metodos.frm_SeleccionInicial.verificarArchivosPlanos())
            metodos.escribirEnArchivo();
        frm_VentanaPrincipal.setVisible(true);
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jcb_TipoUsuario;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_NombreCompleto;
    private javax.swing.JLabel jl_NombreUsuario;
    private javax.swing.JLabel jl_Password;
    private javax.swing.JLabel jl_RepetirPassword;
    private javax.swing.JLabel jl_TipoUsuario;
    private javax.swing.JLabel jl_TituloVentana;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_NombreCompleto;
    private javax.swing.JTextField jt_NombreUsuario;
    private javax.swing.JPasswordField jtp_Password;
    private javax.swing.JPasswordField jtp_RepetirPassword;
    private vista.Panel_Botones panel_Botones1;
    // End of variables declaration//GEN-END:variables
}
