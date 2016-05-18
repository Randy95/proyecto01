/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_VentanaPrincipal;
import modelo.ConexionBD;

/**
 *
 * @author tecnologiamultimedia
 */
//clase Principal del programa con metodo main. Esta interacta con el usuario despues de iniciar sesion o registrar al usuario
public class FRM_VentanaPrincipal extends javax.swing.JFrame {
    
    Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    ConexionBD conexion;
    
    public FRM_VentanaPrincipal() {
        initComponents();
        this.setLocation(200, 100);
        conexion=new ConexionBD();
        controlador_FRM_VentanaPrincipal=new Controlador_FRM_VentanaPrincipal(this,conexion);
        agregarEventos();
    }
    //metodo que envia el controlador para poner a escuchar a los menu item de la barra menu
    public void agregarEventos()
    {
        this.jm_Salir.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Estudiantes.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Cursos.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Matricula.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Registrar.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Login.addActionListener(controlador_FRM_VentanaPrincipal);
    }
    //serie de metodos que habilitan o deshabilitan los menu item
    public void habilitarEstudiantes()
    {
      this.jm_Estudiantes.setEnabled(true);
    }
    public void habilitarCursos()
    {
      this.jm_Cursos.setEnabled(true);
    }
    public void habilitarMatricula()
    {
      this.jm_Matricula.setEnabled(true);
    }
    public void habilitarRegistrar()
    {
      this.jm_Registrar.setEnabled(true);
    }
    public void deshabilitarEstudiantes()
    {
      this.jm_Estudiantes.setEnabled(false);
    }
    public void deshabilitarCursos()
    {
      this.jm_Cursos.setEnabled(false);
    }
    public void deshabilitarMatricula()
    {
      this.jm_Matricula.setEnabled(false);
    }
    public void deshabilitarRegistrar()
    {
      this.jm_Registrar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jm_BarraMenu = new javax.swing.JMenuBar();
        jm_Archivo = new javax.swing.JMenu();
        jm_Salir = new javax.swing.JMenuItem();
        jm_Registrar = new javax.swing.JMenuItem();
        jm_Login = new javax.swing.JMenuItem();
        jm_Mantenimientos = new javax.swing.JMenu();
        jm_Estudiantes = new javax.swing.JMenuItem();
        jm_Cursos = new javax.swing.JMenuItem();
        jm_Matricula = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N

        jm_Archivo.setText("Archivo");

        jm_Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jm_Salir.setText("Salir");
        jm_Archivo.add(jm_Salir);

        jm_Registrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jm_Registrar.setText("Registrar");
        jm_Registrar.setEnabled(false);
        jm_Archivo.add(jm_Registrar);

        jm_Login.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jm_Login.setText("Login");
        jm_Archivo.add(jm_Login);

        jm_BarraMenu.add(jm_Archivo);

        jm_Mantenimientos.setText("Mantenimientos");

        jm_Estudiantes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jm_Estudiantes.setText("Estudiantes");
        jm_Estudiantes.setEnabled(false);
        jm_Mantenimientos.add(jm_Estudiantes);

        jm_Cursos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jm_Cursos.setText("Cursos");
        jm_Cursos.setEnabled(false);
        jm_Mantenimientos.add(jm_Cursos);

        jm_Matricula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jm_Matricula.setText("Matricula");
        jm_Matricula.setEnabled(false);
        jm_Mantenimientos.add(jm_Matricula);

        jm_BarraMenu.add(jm_Mantenimientos);

        setJMenuBar(jm_BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_VentanaPrincipal().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jm_Archivo;
    private javax.swing.JMenuBar jm_BarraMenu;
    private javax.swing.JMenuItem jm_Cursos;
    private javax.swing.JMenuItem jm_Estudiantes;
    private javax.swing.JMenuItem jm_Login;
    private javax.swing.JMenu jm_Mantenimientos;
    private javax.swing.JMenuItem jm_Matricula;
    private javax.swing.JMenuItem jm_Registrar;
    private javax.swing.JMenuItem jm_Salir;
    // End of variables declaration//GEN-END:variables
}
