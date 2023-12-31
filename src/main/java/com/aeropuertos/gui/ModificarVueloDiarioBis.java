/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aeropuertos.gui;

import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.dto.VueloDiario;
import com.aeropuertos.logica.LogicaNegocio;
import com.aeropuertos.logica.ValidadorDatos;
import com.aeropuertos.persistencia.Persistencia;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author 34675
 */
public class ModificarVueloDiarioBis extends javax.swing.JDialog {

    /**
     * Creates new form ModificarVueloDiarioBis
     */
    private VueloDiario vueloDairio;
    private VueloDiario copiaVueloDiario;
    private ModificarVueloDiario modificarVueloDiario;
    public ModificarVueloDiarioBis(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("MODIFICAR VUELO DIARIO");
        modificarVueloDiario=(ModificarVueloDiario)parent;
        vueloDairio=modificarVueloDiario.getVueloDiarioSeleccionado();
        copiaVueloDiario=new VueloDiario(vueloDairio.getCodigo(),vueloDairio.getFechaVuelo(),
        vueloDairio.getHoraSlida(),vueloDairio.getHoraLlegada(),vueloDairio.getPlazasOcupadas(),
        vueloDairio.getPrecio());
        spnFecha.setEditor(new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy"));
        spnHSalida.setEditor(new JSpinner.DateEditor(spnHSalida, "HH:mm"));
        spnHLlegada.setEditor(new JSpinner.DateEditor(spnHLlegada, "HH:mm"));
        refrescarDatos();
    }
    private void refrescarDatos(){
        lblCodigo.setText(vueloDairio.getCodigo());
        lblFecha.setText(Persistencia.parseDateString(vueloDairio.getFechaVuelo()));
        lblHSalida.setText(Persistencia.parseLocalTimeString(vueloDairio.getHoraSlida()));
        lblHLlegada.setText(Persistencia.parseLocalTimeString(vueloDairio.getHoraLlegada()));
        lblPlazas.setText(String.valueOf(vueloDairio.getPlazasOcupadas()));
        lblPrecio.setText(String.valueOf(vueloDairio.getPrecio()));
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
        lblPrecio = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHSalida = new javax.swing.JLabel();
        lblHLlegada = new javax.swing.JLabel();
        lblPlazas = new javax.swing.JLabel();
        spnFecha = new javax.swing.JSpinner();
        spnHSalida = new javax.swing.JSpinner();
        spnHLlegada = new javax.swing.JSpinner();
        spnPlazas = new javax.swing.JSpinner();
        txtPrecio = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Fecha ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("H.Salida");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("H.Legada");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel5.setText("Plazas");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Precio");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(0, 150, 150));
        lblPrecio.setText("Precio");

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(0, 150, 150));
        lblCodigo.setText("Codigo");

        lblFecha.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 150, 150));
        lblFecha.setText("Fecha ");

        lblHSalida.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblHSalida.setForeground(new java.awt.Color(0, 150, 150));
        lblHSalida.setText("H.Salida");

        lblHLlegada.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblHLlegada.setForeground(new java.awt.Color(0, 150, 150));
        lblHLlegada.setText("H.Legada");

        lblPlazas.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblPlazas.setForeground(new java.awt.Color(0, 150, 150));
        lblPlazas.setText("Plazas");

        spnFecha.setModel(new javax.swing.SpinnerDateModel());
        spnFecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        spnHSalida.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        spnHSalida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        spnHLlegada.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        spnHLlegada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        spnPlazas.setModel(new javax.swing.SpinnerNumberModel());
        spnPlazas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("DATOS ACTUALES");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("DATOS NUEVOS");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnDeshacer.setText("Deshacer");
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCodigo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFecha)
                                    .addComponent(lblHSalida)
                                    .addComponent(lblHLlegada)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblPrecio)
                                        .addComponent(lblPlazas)))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeshacer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addGap(23, 23, 23)
                        .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(spnHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(spnHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(spnPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblFecha))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblHSalida))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblHLlegada))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblPlazas))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblPrecio))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalir)
                        .addComponent(btnDeshacer)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Date fecha=(Date)spnFecha.getValue();
        Date dateHSalida=(Date)spnHSalida.getValue();
        Date dateHLlegada=(Date)spnHLlegada.getValue();
        LocalTime horaSalida=ValidadorDatos.parseDateLocalTimeHora(dateHSalida);//formatea la hora a localtime HH:mm
        LocalTime horaLlegada=ValidadorDatos.parseDateLocalTimeHora(dateHLlegada);
        int plazas=(Integer)spnPlazas.getValue();
        String precio=txtPrecio.getText();
        VueloBase vueloBase=LogicaNegocio.getVueloBaseListaActual(vueloDairio.getCodigo());
         //comprobamos que la fecha seleccionada el dia coincida con los dia que opera el vuelo base
        if (ValidadorDatos.fechaCorrectaCreacionVuelos(fecha)==-1){
            JOptionPane.showMessageDialog(this, "La fecha no puede ser inferiora a la fecha actual", "VALIDACION FECHA", JOptionPane.ERROR_MESSAGE);
        }
        else if (!ValidadorDatos.coincidenciaFechaDiasOpera(fecha, vueloBase)){
            JOptionPane.showMessageDialog(this, "La fecha no coincide con dias que opera", "VALIDACION FECHA", JOptionPane.ERROR_MESSAGE);
        }
        //comprobamos que la hora de llegada se produzca despues de la de salida
        else if (ValidadorDatos.compararHoras(dateHLlegada, dateHSalida)==-1||ValidadorDatos.compararHoras(dateHLlegada, dateHSalida)==0 ){
            JOptionPane.showMessageDialog(this, "Hora de salida menor o igual que hora de llegada", "COINCIDENCIA HORAS", JOptionPane.ERROR_MESSAGE);
        }else if (plazas>vueloBase.getPlazas()){
            JOptionPane.showMessageDialog(this, "Plazas superior a plazas totales", "PLAZAS TOTALES", JOptionPane.ERROR_MESSAGE);
        }else if(!ValidadorDatos.formatoPrecio(precio)){
            JOptionPane.showMessageDialog(this, "Formatos correctos:100,00-100", "FORMATO PRECIO", JOptionPane.ERROR_MESSAGE);
            // comprobamos que no exista ya un vuelo diero  para esas fechas y horas en la lista del vuelo base
        }else{
            
            Double precioFinal=Double.valueOf(precio.replace(',', '.'));
            VueloDiario vd=new VueloDiario(vueloDairio.getCodigo(),fecha,
                horaSalida,horaLlegada,plazas,precioFinal);
            //creamos el vuelo y intentamos añadirlo si es capaz de añadirlo , si es capaz lo añade retoen atrue
            if (LogicaNegocio.modificarVueloDiario(vueloDairio, vd)){
               refrescarDatos();
               modificarVueloDiario.refrescarDatos();
            }else{
                JOptionPane.showMessageDialog(this, "Existe coincidencia con otro vuelo", "COINCIDENCIA VUELO", JOptionPane.ERROR_MESSAGE);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        LogicaNegocio.modificarVueloDiario(vueloDairio, copiaVueloDiario);
        refrescarDatos();


        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeshacerActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHLlegada;
    private javax.swing.JLabel lblHSalida;
    private javax.swing.JLabel lblPlazas;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JSpinner spnHLlegada;
    private javax.swing.JSpinner spnHSalida;
    private javax.swing.JSpinner spnPlazas;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
