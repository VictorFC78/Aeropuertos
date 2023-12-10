/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.aeropuertos.componentes;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.logica.LogicaNegocio;
import com.aeropuertos.persistencia.Persistencia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author 34675
 */
public class EditorPropiedadesApirestFull extends javax.swing.JPanel implements Serializable{

    /**
     * Creates new form EditorPropiedadesApirestFull
     */
   
    private List<Aeropuerto> listaAeropuertos=new ArrayList<>();
    public EditorPropiedadesApirestFull() {
        initComponents();
        listaAeropuertos.add(new Aeropuerto("BIO", "Aeropuerto Bilbao", "48020"));
        listaAeropuertos.add(new Aeropuerto("BCN", "Aeropuerto Josep Tarradellas Barcelona-El Prat", "08019"));
        listaAeropuertos.add(new Aeropuerto("AGP", "Aeropuerto de Málaga-Costa del Sol", "29067"));
        listaAeropuertos.add(new Aeropuerto("GRX", "Aeropuerto Federico García Lorca Granada-Jaén", "18059"));
        listaAeropuertos.add(new Aeropuerto("MAD", "Aeropuerto Adolfo Suárez Madrid-Barajas", "28079"));
        listaAeropuertos.add(new Aeropuerto("TFN", "Aeropuerto de Tenerife Norte-Ciudad de La Laguna", "38023"));
        listaAeropuertos.add(new Aeropuerto("TFS", "Aeropuerto de Tenerife Sur", "38017"));
        listaAeropuertos.add(new Aeropuerto("ZAZ", "Aeropuerto de Zaragoza", "50297"));
        DefaultComboBoxModel<Aeropuerto> modelo = new DefaultComboBoxModel<>();
        modelo.addAll(listaAeropuertos);
        comboAeropuerto.setModel(modelo);
        comboAeropuerto.setSelectedIndex(0);
 
       
    }
    public DtoEditorApiRestFull getSelectedValue(){
        String municipio=((Aeropuerto)comboAeropuerto.getSelectedItem()).getMunicipio();
        DtoEditorApiRestFull datospeticion=new DtoEditorApiRestFull(municipio,txtApiKey.getText());
        return datospeticion;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtApiKey = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboAeropuerto = new javax.swing.JComboBox<>();

        jLabel1.setText("AEROPUERTO");

        jLabel2.setText("APIKEY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtApiKey, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(comboAeropuerto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApiKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Aeropuerto> comboAeropuerto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtApiKey;
    // End of variables declaration//GEN-END:variables
}
