/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.modelos;

import com.aeropuertos.dto.VueloDiario;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *@author Victor Fernandez
 * Hereda de {@link AbstractTableModel} para el modelo de datos de JDialog que muestra vuelos da un destino 
 */
public class TableVueloDestinoModel extends AbstractTableModel {
    private List<VueloDiario> listaVuelos;
    
    private String []columnames;
    private Class<?>[]columclass;
    public TableVueloDestinoModel(List<VueloDiario> listaVuelos) {
        this.listaVuelos = listaVuelos;
        columnames=new String[]{"CODIGO","FECHA","H.SALIDA","H.LLEGADA"};
        columclass=new Class<?>[]{String.class,String.class,LocalTime.class,LocalTime.class};
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columclass[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnames[column];
    }
    @Override
    public int getRowCount() {
       return listaVuelos.size();
    }

    @Override
    public int getColumnCount() {
        return columnames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       VueloDiario vd=listaVuelos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vd.getCodigo();
            case 1:
                SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
                return  formato.format(vd.getFechaVuelo());
            case 2:
                return vd.getHoraSlida();   
        }
      return vd.getHoraLlegada();
    }
    
}
