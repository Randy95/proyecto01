/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Matricula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
import modelo.MetodosMatricula;

/**
 *
 * @author RandyGUTI
 */
public class FRM_Matricula extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Matricula
     */
    DefaultTableModel modelo;
    Controlador_FRM_Matricula controlador;
    MetodosMatricula metodosMatricula;
    
    public FRM_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes, FRM_MantenimientoCursos frm_MantenimientoCursos,ConexionBD conexion,FRM_SeleccionInicial frm_SeleccionInicial) {
        initComponents();
        controlador = new Controlador_FRM_Matricula(frm_MantenimientoEstudiantes,frm_MantenimientoCursos,this,conexion,frm_SeleccionInicial);
        metodosMatricula=controlador.metodosMatricula;
        modelo=new DefaultTableModel();
        this.setVisible(false);
        this.setLocation(200, 200);
        colocarTitulosTabla();
        agregarEventos();
    }
    public void agregarEventos()
    {
      btn_BusquedaCedula.addActionListener(controlador);
      btn_BusquedaCurso.addActionListener(controlador);
      btn_Finalizar.addActionListener(controlador);
      jt_Cedula.addActionListener(controlador);
      jt_Sigla.addActionListener(controlador);
      this.panel_Botones1.agregarEventos(controlador);
    }
    public boolean siglaVacia()
    {
      if(jt_Sigla.getText().equals(""))
          return true;
      else
          return false;
    }
    public void colocarTitulosTabla()
    {
      this.tbl_Tabla.setModel(modelo);
      modelo.addColumn("Código");
      modelo.addColumn("Cédula");
      modelo.addColumn("Estudiante");
      modelo.addColumn("Sigla");
    }
    public void colocarCodigo()
    {
      this.jt_Codigo.setText(metodosMatricula.devolverCodigo());
    }
    public void mostrarEstudiante(String arreglo[])
    {
       this.jt_NombreEstudiante.setText(arreglo[0]); 
    }
    public void mostrarCurso(String arreglo[])
    {
       this.jt_NombreCurso.setText(arreglo[0]); 
    }
    public String devolverCedula()
    {
        return this.jt_Cedula.getText();
    }
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    public String devolverCodigo()
    {
        return this.jt_Codigo.getText();
    }
    public int getCantidadFilas()
    {
      return modelo.getRowCount();
    }
    public String devolverDato(int fila, int columna)
    {
      return ""+modelo.getValueAt(fila, columna);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void habilitarAgregar()
    {
        this.panel_Botones1.habilitarAgregar();
        this.btn_Finalizar.setEnabled(true);
    }
    public void deshabilitarSiglaYCedula()
    {
      this.jt_Cedula.setEnabled(false);
      this.jt_Sigla.setEnabled(false);
    }
    public void habilitarSiglaYCedula()
    {
      this.jt_Cedula.setEnabled(true);
      this.jt_Sigla.setEnabled(true);
    }
    public void habilitarFinalizar()
    {
        this.btn_Finalizar.setEnabled(true);
    }
    public void deshabilitarAgregar()
    {
        this.panel_Botones1.deshabilitarBotones();
    }
    public void deshabilitarFinalizar()
    {
      this.btn_Finalizar.setEnabled(false);
    }
    public void habilitarBotones()
    {
      this.panel_Botones1.habilitarEliminar();
    }
    public int devolverFilaSeleccionada()
    {
       return this.tbl_Tabla.getSelectedRow();
    }
    public void eliminarFilaTabla()
    {
      modelo.removeRow(this.tbl_Tabla.getSelectedRow());
    }
    public void agregarInformacionTabla()
    {
      String arreglo[]=new String[4];
      arreglo[0]=jt_Codigo.getText();
      arreglo[1]=jt_Cedula.getText();
      arreglo[2]=jt_NombreEstudiante.getText();
      arreglo[3]=jt_Sigla.getText();
      modelo.addRow(arreglo);
    }
    public void agregarInformacionTabla(String arreglo[])
    {
      modelo.addRow(arreglo);
      this.jt_NombreEstudiante.setText(arreglo[2]);
      this.jt_Cedula.setText(arreglo[1]);
    }
    public void resetearGUI()
    {
      this.jt_NombreCurso.setText("");
      this.jt_NombreEstudiante.setText("");
      this.jt_Cedula.setText("");
      this.jt_Sigla.setText("");
      this.jt_Codigo.setEnabled(true);
      habilitarSiglaYCedula();
      deshabilitarAgregar();
      int tamanio=modelo.getRowCount();
      for(int contador=0;contador<tamanio;contador++)
      {
        modelo.removeRow(0);
      }
    }
    public void limpiarTabla()
    {
      int tamanio=modelo.getRowCount();
      for(int contador=0;contador<tamanio;contador++)
      {
        modelo.removeRow(0);
      }
    }
    public String devolverSiglaSeleccionada()
    {
      return ""+modelo.getValueAt(tbl_Tabla.getSelectedRow(), 3 );
    }
    public void deshabilitarEliminar()
    {
      this.panel_Botones1.deshabilitarEliminar();
    }
    public void resetearSigla()
    {
      this.jt_Sigla.setText("");
      this.jt_Sigla.setEnabled(true);
      this.jt_NombreCurso.setText("");
    }
    public void deshabilitarCodigo()
    {
      this.jt_Codigo.setEnabled(false);
    }
    public void resetearCedula()
    {
        this.jt_Cedula.setText("");
      this.jt_NombreEstudiante.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Tabla = new javax.swing.JTable();
        jl_Cedula = new javax.swing.JLabel();
        jl_NombreEstudiante = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        btn_BusquedaCedula = new javax.swing.JButton();
        jt_NombreEstudiante = new javax.swing.JTextField();
        jl_Sigla = new javax.swing.JLabel();
        jl_NombreCurso = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jt_NombreCurso = new javax.swing.JTextField();
        btn_BusquedaCurso = new javax.swing.JButton();
        panel_Botones1 = new vista.Panel_Botones();
        jl_codigo = new javax.swing.JLabel();
        jt_Codigo = new javax.swing.JTextField();
        btn_Finalizar = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        tbl_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Tabla);

        jl_Cedula.setText("Cedula");

        jl_NombreEstudiante.setText("Nombre Estudiante");

        jt_Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_CedulaKeyPressed(evt);
            }
        });

        btn_BusquedaCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_BusquedaCedula.setActionCommand("BuscarEstudiante");

        jt_NombreEstudiante.setEnabled(false);

        jl_Sigla.setText("Sigla");

        jl_NombreCurso.setText("Nombre Curso");

        jt_Sigla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_SiglaKeyPressed(evt);
            }
        });

        jt_NombreCurso.setEnabled(false);

        btn_BusquedaCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_BusquedaCurso.setActionCommand("BuscarCurso");

        jl_codigo.setText("Código Matrícula");

        btn_Finalizar.setText("Finalizar Matricula");
        btn_Finalizar.setActionCommand("Finalizar");
        btn_Finalizar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jl_codigo)
                        .addGap(18, 18, 18)
                        .addComponent(jt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jl_NombreEstudiante)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jt_NombreEstudiante))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jl_Cedula)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_BusquedaCedula)))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jl_NombreCurso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jl_Sigla)
                                        .addGap(18, 18, 18)
                                        .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_BusquedaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Finalizar)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_codigo)
                    .addComponent(jt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_BusquedaCedula)
                            .addComponent(btn_BusquedaCurso))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreEstudiante)
                            .addComponent(jt_NombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_NombreCurso)
                            .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Sigla)
                            .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_Cedula)
                            .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_CedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_CedulaKeyPressed
        if(evt.getKeyCode()==10)
        {
            this.controlador.buscarEstudiante();
            
        }
    }//GEN-LAST:event_jt_CedulaKeyPressed

    private void jt_SiglaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_SiglaKeyPressed
        
        if(evt.getKeyCode()==10)
        {
            this.controlador.buscarCurso();
            
        }
    }//GEN-LAST:event_jt_SiglaKeyPressed

    private void tbl_TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TablaMouseClicked
        // TODO add your handling code here:
        this.jt_NombreEstudiante.setText(""+modelo.getValueAt(tbl_Tabla.getSelectedRow(), 2 ));
        this.jt_Sigla.setText(devolverSiglaSeleccionada());
        this.jt_Cedula.setText(""+modelo.getValueAt(tbl_Tabla.getSelectedRow(), 1 ));
        this.jt_Codigo.setText(""+modelo.getValueAt(tbl_Tabla.getSelectedRow(), 0 ));
        this.controlador.buscarCurso();
        habilitarBotones();
    }//GEN-LAST:event_tbl_TablaMouseClicked

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        resetearGUI();
        if(controlador.metodosMatricula.frm_SeleccionInicial.verificarArchivosPlanos())
            controlador.metodosMatricula.escribirEnArchivo();
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BusquedaCedula;
    private javax.swing.JButton btn_BusquedaCurso;
    private javax.swing.JButton btn_Finalizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_NombreCurso;
    private javax.swing.JLabel jl_NombreEstudiante;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JLabel jl_codigo;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_Codigo;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_NombreEstudiante;
    private javax.swing.JTextField jt_Sigla;
    private vista.Panel_Botones panel_Botones1;
    private javax.swing.JTable tbl_Tabla;
    // End of variables declaration//GEN-END:variables
}
