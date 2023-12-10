/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aeropuertos.gui;

import com.aeropuertos.dto.VueloDiario;
import com.aeropuertos.logica.LogicaNegocio;
import com.aeropuertos.modelos.TablePanelVuelosModel;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author 34675
 */
public class PanelLlegadas extends javax.swing.JDialog {

    /**
     * Creates new form PanelLlegadas
     */
    private List<VueloDiario> lista;
    private TablePanelVuelosModel modelo;
    public PanelLlegadas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        spnFecha.setEditor(new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy"));
        refrescarTabla();
    }
    private void refrescarTabla(){
      lista=LogicaNegocio.getVuelosDiariosFecha((Date)spnFecha.getValue(), false);
      if (lista!=null){
        modelo=new TablePanelVuelosModel(lista,
                LogicaNegocio.getListaActualVuelosBase(), false);
        tabla.setModel(modelo);
        //jTable1.setVisible(true);
      }else{
          //jTable1.setVisible(false);
          JOptionPane.showMessageDialog(this, "No se muestran vuelos con fechas anteriores a la actual");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        spnFecha = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(tabla);

        spnFecha.setModel(new javax.swing.SpinnerDateModel());
        spnFecha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnFechaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spnFechaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnFechaStateChanged
        refrescarTabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_spnFechaStateChanged

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
