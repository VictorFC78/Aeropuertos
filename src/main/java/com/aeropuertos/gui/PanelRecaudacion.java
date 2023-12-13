/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aeropuertos.gui;

import com.aeropuertos.dto.VueloDiario;
import com.aeropuertos.logica.LogicaNegocio;
import com.aeropuertos.logica.ValidadorDatos;
import com.aeropuertos.modelos.TableRecaudacionModel;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author 34675
 */
public class PanelRecaudacion extends javax.swing.JDialog {

    /**
     * Creates new form PanelRecaudacion
     */
    private TableRecaudacionModel modelo;
    private List<VueloDiario> listaVuelosDiarios;
    public PanelRecaudacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        spnFecha.setEditor(new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy"));
        listaVuelosDiarios=LogicaNegocio.getListaVuelosDiariosRecaudacion((Date)spnFecha.getValue());
        refrescarDatos();
        
    }
    private void refrescarDatos(){
        modelo=new TableRecaudacionModel(listaVuelosDiarios
                , LogicaNegocio.getListaActualVuelosBase());
        tabla.setModel(modelo);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spnFecha = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        spnFecha.setModel(new javax.swing.SpinnerDateModel());
        spnFecha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnFechaStateChanged(evt);
            }
        });

        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spnFechaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnFechaStateChanged
        if ((listaVuelosDiarios=LogicaNegocio.getListaVuelosDiariosRecaudacion((Date)spnFecha.getValue()))!=null){
            refrescarDatos();
        }else{
            JOptionPane.showMessageDialog(this, "Solo se muestra vuelos ya han despegado", "ERROR FECHA",JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_spnFechaStateChanged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}