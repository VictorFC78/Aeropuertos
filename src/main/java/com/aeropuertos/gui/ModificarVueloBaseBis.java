/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aeropuertos.gui;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.logica.LogicaNegocio;
import com.aeropuertos.logica.ValidadorDatos;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author 34675
 */
public class ModificarVueloBaseBis extends javax.swing.JDialog {

 private DefaultComboBoxModel<Aeropuerto> modeloLoistaArptos;
 private DefaultComboBoxModel<Aeropuerto> modeloarptoBase;
 private ModificarVueloBase modificarVueloBase;
 private VueloBase vueloBase;
 private VueloBase copiaVueloBase;
    public ModificarVueloBaseBis(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modificarVueloBase=(ModificarVueloBase)parent;//copia del dialogo modificarVueloBase para recuperar el vuelo seleccionado
        vueloBase=modificarVueloBase.getVueloSeleccionado();//recupera el vuelo seleccionado
        copiaVueloBase=new VueloBase(vueloBase.getCodigo(),vueloBase.getOrigen(),vueloBase.getDestino(),
                vueloBase.getPlazas(),vueloBase.getHoraSalida(),vueloBase.getHoraLlegada(),vueloBase.getDiasOpera());
        modeloLoistaArptos=new DefaultComboBoxModel<>();//modelo lista completa de aeropuertos sin aeropuerto base
        modeloarptoBase=new DefaultComboBoxModel<>();//modelo solo para aeropuerto base
        spnHLlegada.setEditor(new JSpinner.DateEditor(spnHLlegada, "HH:mm"));//formato HH:mm para Spinner hOra LLegada
        spnHSalida.setEditor(new JSpinner.DateEditor(spnHSalida, "HH:mm"));
        ButtonGroup grupoRbtn=new ButtonGroup();//radio grupo para los radioboton
        modeloLoistaArptos.addAll(LogicaNegocio.getListaAeropuetosDestino());
        modeloarptoBase.addElement(LogicaNegocio.getAeropuertoOrigen());
        grupoRbtn.add(rbtnSalida);//añadimos radiobutton al grupo
        grupoRbtn.add(rbtnLlegada);
        rbtnSalida.setSelected(true);
        refrescarDatos();
    }
    private void refrescarDatos(){
        lblCodigo.setText(vueloBase.getCodigo());
        lblArptoSalida.setText(vueloBase.getOrigen().getNombre());
        lblArptoLlegada.setText(vueloBase.getDestino().getNombre());
        lblHSalida.setText(vueloBase.getHoraSalida().toString());
        lblHLlegada.setText(vueloBase.getHoraLlegada().toString());
        lblDiasOpera.setText(vueloBase.getDiasOpera());
        lblPlazas.setText(String.valueOf(vueloBase.getPlazas()));
        if (rbtnSalida.isSelected()){
            comboAOrigen.setModel(modeloarptoBase);
            comboADestino.setModel(modeloLoistaArptos);
            comboADestino.setSelectedIndex(0);
        }else{
            comboAOrigen.setModel(modeloLoistaArptos);
            comboADestino.setModel(modeloarptoBase);
            comboAOrigen.setSelectedIndex(0);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spnCodigo = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblArptoSalida = new javax.swing.JLabel();
        lblArptoLlegada = new javax.swing.JLabel();
        lblHSalida = new javax.swing.JLabel();
        lblHLlegada = new javax.swing.JLabel();
        lblDiasOpera = new javax.swing.JLabel();
        comboAOrigen = new javax.swing.JComboBox<>();
        comboADestino = new javax.swing.JComboBox<>();
        spnHSalida = new javax.swing.JSpinner();
        spnHLlegada = new javax.swing.JSpinner();
        txtDiasOpera = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        rbtnSalida = new javax.swing.JRadioButton();
        rbtnLlegada = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        spnPlazas = new javax.swing.JSpinner();
        lblPlazas = new javax.swing.JLabel();

        spnCodigo.setModel(new javax.swing.SpinnerNumberModel());
        spnCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(570, 430));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("DATOS ACTUALES");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("DATOS NUEVOS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Codigo");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("Arpto Salida");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel5.setText("Arpto Llegada");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Hora Salida");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel7.setText("Hora Llegada");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel8.setText("Dias Opera");

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(0, 150, 150));
        lblCodigo.setText("jLabel9");

        lblArptoSalida.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblArptoSalida.setForeground(new java.awt.Color(0, 150, 150));
        lblArptoSalida.setText("jLabel10");

        lblArptoLlegada.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblArptoLlegada.setForeground(new java.awt.Color(0, 150, 150));
        lblArptoLlegada.setText("jLabel11");

        lblHSalida.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblHSalida.setForeground(new java.awt.Color(0, 150, 150));
        lblHSalida.setText("jLabel12");

        lblHLlegada.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblHLlegada.setForeground(new java.awt.Color(0, 150, 150));
        lblHLlegada.setText("jLabel13");

        lblDiasOpera.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblDiasOpera.setForeground(new java.awt.Color(0, 150, 150));
        lblDiasOpera.setText("jLabel14");

        comboAOrigen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboAOrigen.setMinimumSize(new java.awt.Dimension(200, 22));
        comboAOrigen.setName(""); // NOI18N

        comboADestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        spnHSalida.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        spnHSalida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        spnHLlegada.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        spnHLlegada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel15.setText("Tipo de Vuelo");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnDeshacer.setText("Deshacer");
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        rbtnSalida.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbtnSalida.setText("Salida");
        rbtnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSalidaActionPerformed(evt);
            }
        });

        rbtnLlegada.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbtnLlegada.setText("Llegada");
        rbtnLlegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnLlegadaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel9.setText("Plazas");

        spnPlazas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPlazas.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblPlazas.setForeground(new java.awt.Color(0, 150, 150));
        lblPlazas.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeshacer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArptoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArptoLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiasOpera, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spnHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spnHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDiasOpera, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(rbtnSalida)
                                            .addComponent(rbtnLlegada)))
                                    .addComponent(spnPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboADestino, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboAOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(360, 360, 360))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCodigo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblArptoSalida)
                    .addComponent(comboAOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblArptoLlegada)
                    .addComponent(comboADestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spnPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlazas))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblHSalida)
                    .addComponent(spnHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHLlegada)
                    .addComponent(jLabel7)
                    .addComponent(rbtnSalida))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnLlegada))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiasOpera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiasOpera)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnDeshacer)
                    .addComponent(btnModificar))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSalidaActionPerformed
        comboAOrigen.setModel(modeloarptoBase);
            comboADestino.setModel(modeloLoistaArptos);
            comboADestino.setSelectedIndex(0);
    }//GEN-LAST:event_rbtnSalidaActionPerformed

    private void rbtnLlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnLlegadaActionPerformed
        comboAOrigen.setModel(modeloLoistaArptos);
        comboADestino.setModel(modeloarptoBase);
        comboAOrigen.setSelectedIndex(0);
// TODO add your handling code here:
    }//GEN-LAST:event_rbtnLlegadaActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int nCodigo=(Integer)spnCodigo.getValue();
        Aeropuerto aeropuertoOrigen=(Aeropuerto)comboAOrigen.getSelectedItem();
        Aeropuerto aeropuertoDestino=(Aeropuerto)comboADestino.getSelectedItem();
        Date dateSalida=(Date)spnHSalida.getValue();
        Date dateLegada=(Date)spnHLlegada.getValue();
        
        int plazas=(Integer)spnPlazas.getValue();
        String diasOpera=txtDiasOpera.getText();
        if(diasOpera.isEmpty()){
            JOptionPane.showMessageDialog(this, "Hay campos en blanco", "CAMPOS COMPAÑIA", JOptionPane.ERROR_MESSAGE);
        }else if (nCodigo<0 || nCodigo>9999){
            JOptionPane.showMessageDialog(this, "Numero entero entre 1 y 9999", "CODIGO VUELO", JOptionPane.ERROR_MESSAGE);
        }
        else if (ValidadorDatos.compararHoras(dateLegada, dateSalida)==-1||ValidadorDatos.compararHoras(dateLegada, dateSalida)==0 ){
          JOptionPane.showMessageDialog(this, "Hora de salida menor-igual que hora de llegada", "COINCIDENCIA HORAS", JOptionPane.ERROR_MESSAGE);  
        }else if (!ValidadorDatos.formatoDiasOpera(diasOpera, this)){}
        else {
            LocalTime horaSalida=ValidadorDatos.parseDateLocalTimeHora(dateSalida);
            LocalTime horaLlegada=ValidadorDatos.parseDateLocalTimeHora(dateLegada);
            //modificamos el vuelo si esta todo correcto y si no existe coicidencia con otros vuelos
            StringBuilder codigoCompania=new StringBuilder();
            codigoCompania.append(vueloBase.getCodigo().charAt(0));
            codigoCompania.append(vueloBase.getCodigo().charAt(1));
            String codigo=codigoCompania.toString()+nCodigo;
            VueloBase datosNuevos=new VueloBase(codigo, aeropuertoOrigen, aeropuertoDestino, plazas, horaSalida, horaLlegada, diasOpera);
            if (LogicaNegocio.modificarVueloBase(vueloBase, datosNuevos)){
                modificarVueloBase.refrescatTabla();
                refrescarDatos();
            }
            else  JOptionPane.showMessageDialog(this, "El vuelo ya existe", "COINCIDENCIA VUELO BASE", JOptionPane.ERROR_MESSAGE);      
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        System.out.println("vuelo cambiado:"+vueloBase.getCodigo());
        System.out.println("vuelo original:"+vueloBase.getCodigo());
        LogicaNegocio.modificarVueloBase(vueloBase, copiaVueloBase);
        refrescarDatos();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeshacerActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Aeropuerto> comboADestino;
    private javax.swing.JComboBox<Aeropuerto> comboAOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblArptoLlegada;
    private javax.swing.JLabel lblArptoSalida;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDiasOpera;
    private javax.swing.JLabel lblHLlegada;
    private javax.swing.JLabel lblHSalida;
    private javax.swing.JLabel lblPlazas;
    private javax.swing.JRadioButton rbtnLlegada;
    private javax.swing.JRadioButton rbtnSalida;
    private javax.swing.JSpinner spnCodigo;
    private javax.swing.JSpinner spnHLlegada;
    private javax.swing.JSpinner spnHSalida;
    private javax.swing.JSpinner spnPlazas;
    private javax.swing.JTextField txtDiasOpera;
    // End of variables declaration//GEN-END:variables
}
