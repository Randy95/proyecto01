/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_MantenimientoCursos;

/**
 *
 * @author RandyGUTI
 */
//clase de tipo JPanel con campos de texto para hacer uso en los cursos
public class Panel_Cursos extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Cursos
     */
    Controlador_FRM_MantenimientoCursos controlador;
    public Panel_Cursos() {
        initComponents();
        cargarCreditos();
        deshabilitarCampos();
    }
    //metodo que carga valores en el checkbox de creditos
    public void cargarCreditos()
    {
      this.jcb_Creditos.removeAllItems();
      for(int contador=0;contador<=10;contador++)
      {
        this.jcb_Creditos.addItem(""+contador);
      }
      this.jcb_Creditos.setSelectedIndex(4);
    }
    //metodo que verifica si estan los espacios vacios 
    public boolean espaciosVacios()
    {
      if(jt_Sigla.getText().equals("") || jt_Horario.getText().equals("") || jt_Nombre.getText().equals("") )
          return true;
      else
          return false;
    }
    //metodo que envia el controlador de cursos al boton y el campo de texto de sigla
    public void agregarEventos(Controlador_FRM_MantenimientoCursos controlador)
    {
      this.controlador=controlador;
      this.btn_ConsultaRapida.addActionListener(controlador);
      this.jt_Sigla.addActionListener(controlador);
    }
    //metodo que devuelve el texto en la sigla
    public String devolverSigla()
    {
     return this.jt_Sigla.getText();
    }
    //metodo que devuelve un arreglo con los textos en los campos
    public String[] devolverInformacion()
    {
        String informacion[]=new String[4];
        informacion[0]=this.jt_Sigla.getText();
        informacion[1]=this.jt_Nombre.getText();
        informacion[2]=""+this.jcb_Creditos.getSelectedIndex();
        informacion[3]=this.jt_Horario.getText();
        
        return informacion;
    }
    //metodo que habilita los campos y el check box
    public void habilitarEdicion()
    {
      this.jt_Sigla.setEnabled(false);
      this.jt_Nombre.setEnabled(true);
      this.jcb_Creditos.setEnabled(true);
      this.jt_Horario.setEnabled(true);
    }
    //metodo para mostrar texto en los campos y seleccionar un item en el check box
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_Nombre.setText(arreglo[0]);
        this.jcb_Creditos.setSelectedIndex(Integer.parseInt(arreglo[1]));
        this.jt_Horario.setText(arreglo[2]);
    }
    //metodo que deshabilita los campos y el check box y los limpia
    public void deshabilitarCampos()
    {
        this.jt_Sigla.setEnabled(true);
        this.jt_Sigla.setText("");
        
        this.jt_Nombre.setText("");
        this.jt_Nombre.setEnabled(false);
        
        this.jt_Horario.setEnabled(false);
        this.jt_Horario.setText("");
        
        this.jcb_Creditos.setSelectedIndex(4);
        this.jcb_Creditos.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jt_Sigla = new javax.swing.JTextField();
        jl_Sigla = new javax.swing.JLabel();
        jl_Nombre = new javax.swing.JLabel();
        jt_Nombre = new javax.swing.JTextField();
        jl_Creditos = new javax.swing.JLabel();
        jcb_Creditos = new javax.swing.JComboBox<>();
        btn_ConsultaRapida = new javax.swing.JButton();
        jl_Horario = new javax.swing.JLabel();
        jt_Horario = new javax.swing.JTextField();

        jt_Sigla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_SiglaKeyPressed(evt);
            }
        });

        jl_Sigla.setText("Sigla");

        jl_Nombre.setText("Nombre");

        jl_Creditos.setText("Créditos");

        jcb_Creditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_ConsultaRapida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapida.setActionCommand("ConsultaRapida");

        jl_Horario.setText("Horario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Nombre)
                    .addComponent(jl_Sigla)
                    .addComponent(jl_Creditos)
                    .addComponent(jl_Horario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ConsultaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jt_Nombre)
                    .addComponent(jt_Horario)
                    .addComponent(jcb_Creditos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_Sigla))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_ConsultaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Nombre)
                    .addComponent(jt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Creditos)
                    .addComponent(jcb_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Horario)
                    .addComponent(jt_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //metodo que busca mediante el enter en la sigla
    private void jt_SiglaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_SiglaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            this.controlador.buscar();
        }
    }//GEN-LAST:event_jt_SiglaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaRapida;
    private javax.swing.JComboBox<String> jcb_Creditos;
    private javax.swing.JLabel jl_Creditos;
    private javax.swing.JLabel jl_Horario;
    private javax.swing.JLabel jl_Nombre;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Horario;
    private javax.swing.JTextField jt_Nombre;
    private javax.swing.JTextField jt_Sigla;
    // End of variables declaration//GEN-END:variables
}
