/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.modelos;

import com.aeropuertos.componentes.ApirestFullTemperaturas;
import com.aeropuertos.componentes.DatosClima;
import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.dto.VueloDiario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *@author Victor Fernandez
 * Hereda de {@link AbstractTableModel} para el modelo de datos de JDialog que muestra vuelos de salida y llegada
 */
public class TablePanelVuelosModel extends AbstractTableModel{
    private List<VueloDiario> listaVuelosDiarios;
    private List<VueloBase> listaVuelosBase;
    private boolean tipoVuelo;
    private String[]columnames;
    private Class<?>[]columclass;
    private Object[][]rows;
    private List<Object> rowsinicial;
    private SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
    public TablePanelVuelosModel(List<VueloDiario> listaVuelosDiarios, List<VueloBase> listaVuelosBase, boolean tipoVuelo) {
        this.listaVuelosDiarios = listaVuelosDiarios;
        this.listaVuelosBase = listaVuelosBase;
        this.tipoVuelo = tipoVuelo;
        rowsinicial=new ArrayList<>();
        ArrayList rowsTotal=new ArrayList<>();
        
        columclass=new Class<?>[]{Aeropuerto.class,String.class,LocalTime.class,LocalTime.class,String.class,String.class};
        if (tipoVuelo){//si el vuelo es de salida para cada vuelo recuperamos el aeropuerto de destino
            columnames=new String[]{"ARPTO DESTINO","FECHA","H.SALIDA","H.LLEGADA"};
            for (VueloDiario vd:listaVuelosDiarios){
                VueloBase vb =getVueloBaseCodigo(listaVuelosBase,vd.getCodigo());
                rowsinicial.add(vb.getDestino());
                rowsinicial.add(formato.format(vd.getFechaVuelo()));
                rowsinicial.add(vd.getHoraSlida());
                rowsinicial.add(vd.getHoraLlegada());
                Object[] filaCompleta=rowsinicial.toArray();
                rowsTotal.add(filaCompleta);
                rowsinicial.clear();
            }
            rows=new Object[rowsTotal.size()][];
            for (int i=0;i<rows.length;i++){
                rows[i]=(Object[])(rowsTotal.get(i));
            }
        }else{//si el vuelo es de llegada
            columnames=new String[]{"ARPTO ORIGEN","FECHA","H.SALIDA","H.LLEGADA"};
            for (VueloDiario vd:listaVuelosDiarios){
                VueloBase vb =getVueloBaseCodigo(listaVuelosBase,vd.getCodigo());
                rowsinicial.add(vb.getOrigen());
                rowsinicial.add(formato.format(vd.getFechaVuelo()));
                rowsinicial.add(vd.getHoraSlida());
                rowsinicial.add(vd.getHoraLlegada());
                Object[] filaCompleta=rowsinicial.toArray();
                rowsTotal.add(filaCompleta);
                rowsinicial.clear();
            }
            rows=new Object[rowsTotal.size()][4];
            for (int i=0;i<rowsTotal.size();i++){
                rows[i]=(Object[])(rowsTotal.get(i)); 
            }
        }
    }
    private VueloBase getVueloBaseCodigo(List<VueloBase>lista,String codigo){
        for (VueloBase v:lista){
            if (v.getCodigo().equals(codigo))return v;
        }
        return null;
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
       return rows.length;
    }

    @Override
    public int getColumnCount() {
        return columnames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return rows[rowIndex][columnIndex];
    }
    
}
