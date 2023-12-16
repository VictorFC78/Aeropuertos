/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aeropuertos.gui;

import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.dto.VueloDiario;
import com.aeropuertos.logica.LogicaNegocio;
import com.aeropuertos.logica.ValidadorDatos;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author 34675
 */
public class DarAltaVueloDiario extends javax.swing.JDialog {

    /**
     * Creates new form DarAltaVueloDiario
     */
    private ConsultarVuelosDiarios consultarVuelosDiarios;
    private ConsultarVuelosBase consultarVuelosBase;
    public DarAltaVueloDiario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha,"dd/MM/yyyy"));//formato de muestra fecha 
        spinnerHSalida.setEditor (new JSpinner.DateEditor(spinnerHSalida,"HH:mm"));
        spinnerHLlegada.setEditor(new JSpinner.DateEditor(spinnerHLlegada,"HH:mm"));
        DefaultComboBoxModel<VueloBase> modelocombo=new DefaultComboBoxModel<>();
        modelocombo.addAll(LogicaNegocio.getListaActualVuelosBase());
        comboxCodigo.setModel(modelocombo);
        comboxCodigo.setSelectedIndex(0);
        consultarVuelosDiarios=new ConsultarVuelosDiarios(this, false);
        consultarVuelosBase=new ConsultarVuelosBase(this, false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboxCodigo = new javax.swing.JComboBox<>();
        spinnerFecha = new javax.swing.JSpinner();
        spinnerHSalida = new javax.swing.JSpinner();
        spinnerHLlegada = new javax.swing.JSpinner();
        spinnerPlazas = new javax.swing.JSpinner();
        txtPrecio = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel1.setText("Codigo Vuelo Base");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("H Salida");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("H Llegada");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel5.setText("Plazas Ocupadas");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Precio Total");

        spinnerFecha.setModel(new javax.swing.SpinnerDateModel());

        spinnerHSalida.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));

        spinnerHLlegada.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));

        spinnerPlazas.setModel(new javax.swing.SpinnerNumberModel());

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultar)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(spinnerHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(spinnerPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
                    .addComponent(btnConsultar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Date fecha=(Date)spinnerFecha.getValue();//recupara la fecha
        Date dateSalida=(Date)spinnerHSalida.getValue();//recupera hora de salida
        Date dateLlegada=(Date)spinnerHLlegada.getValue();//recupera hora llegada
        LocalTime horaSalida=ValidadorDatos.parseDateLocalTimeHora(dateSalida);//formatea la hora a localtime HH:mm
        LocalTime horaLlegada=ValidadorDatos.parseDateLocalTimeHora(dateLlegada);
        String codigo=comboxCodigo.getSelectedItem().toString();
        String precio=txtPrecio.getText();
        int plazas=(Integer)spinnerPlazas.getValue();
        VueloBase vueloBase=(VueloBase)comboxCodigo.getSelectedItem();//vuelo vase seleccionado

        //comprobamos que la fecha seleccionada el dia coincida con los dia que opera el vuelo base
        if (ValidadorDatos.fechaCorrectaCreacionVuelos(fecha)==-1){
            JOptionPane.showMessageDialog(this, "La fecha no puede ser inferiora a la fecha actual", "VALIDACION FECHA", JOptionPane.ERROR_MESSAGE);
        }
        else if (!ValidadorDatos.coincidenciaFechaDiasOpera(fecha, vueloBase)){
            JOptionPane.showMessageDialog(this, "La fecha no coincide con dias que opera", "VALIDACION FECHA", JOptionPane.ERROR_MESSAGE);
        }
        //comprobamos que la hora de llegada se produzca despues de la de salida
        else if (ValidadorDatos.compararHoras(dateLlegada, dateSalida)==-1||ValidadorDatos.compararHoras(dateLlegada, dateSalida)==0 ){
            JOptionPane.showMessageDialog(this, "Hora de salida menor o igual que hora de llegada", "COINCIDENCIA HORAS", JOptionPane.ERROR_MESSAGE);
        }else if (plazas>vueloBase.getPlazas()){
            JOptionPane.showMessageDialog(this, "Plazas superior a plazas totales", "PLAZAS TOTALES", JOptionPane.ERROR_MESSAGE);
        }else if(!ValidadorDatos.formatoPrecio(precio)){
            JOptionPane.showMessageDialog(this, "Formatos correctos:100,00-100", "FORMATO PRECIO", JOptionPane.ERROR_MESSAGE);
            // comprobamos que no exista ya un vuelo diero  para esas fechas y horas en la lista del vuelo base
        }else{
            
            Double precioFinal=Double.valueOf(precio.replace(',', '.'));
            VueloDiario vd=new VueloDiario(codigo,fecha,
                horaSalida,horaLlegada,plazas,precioFinal);
            //creamos el vuelo y intentamos añadirlo si es capaz de añadirlo , si es capaz lo añade retoen atrue
            if (LogicaNegocio.anaidirVueloDiarioVueloBase(vueloBase,vd)){
                 //consultarVuelosDiarios.refrescarDatos();
            }else{
                JOptionPane.showMessageDialog(this, "Existe coincidencia con otro vuelo", "COINCIDENCIA VUELO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        //consultarVuelosDiarios.setVisible(true);
        consultarVuelosBase.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox<VueloBase> comboxCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner spinnerFecha;
    private javax.swing.JSpinner spinnerHLlegada;
    private javax.swing.JSpinner spinnerHSalida;
    private javax.swing.JSpinner spinnerPlazas;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
