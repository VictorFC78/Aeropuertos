/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.modelos;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.dto.VueloDiario;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *@author Victor Fernandez
 * Hereda de {@link AbstractTableModel} para el modelo de datos de JDialog que muestra vuelos pertenecientes a una compañia
 */
public class TableVuelosCompaniaModel extends AbstractTableModel{

    private List<VueloDiario> listaVuelosDiarios;
    private List<VueloBase> listaVuelosBase;
    private String[] columnames;
    private Class<?>[] columclass;
    private Object[][] rows;
    public TableVuelosCompaniaModel(List<VueloDiario> listaVuelosDiarios, List<VueloBase> listaVuelosBase) {
        this.listaVuelosDiarios = listaVuelosDiarios;
        this.listaVuelosBase = listaVuelosBase;
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        //ordenamos la lista de vuelos diarios orden ascendente de hora
        //Collections.sort(this.listaVuelosDiarios, new ComparadorVuelosHoras());
        columnames=new String[]{"Codigo Vuelo","Fecha","Arpto Salida","Arpto Llegada","H.Salida","H.Llegada"};
        columclass=new Class<?>[]{String.class,String.class,Aeropuerto.class,Aeropuerto.class,LocalTime.class,LocalTime.class};
        ArrayList<Object> filaTemporal=new ArrayList<>();
        ArrayList filaCompleta=new ArrayList();
        for (VueloDiario vd:listaVuelosDiarios){
            VueloBase vb=getVueloBase(listaVuelosBase,vd.getCodigo());
            filaTemporal.add(vd.getCodigo());
            filaTemporal.add(formato.format(vd.getFechaVuelo()));
            filaTemporal.add(vb.getOrigen());
            filaTemporal.add(vb.getDestino());
            filaTemporal.add(vd.getHoraSlida());
            filaTemporal.add(vd.getHoraLlegada());
            Object[]filaArray=filaTemporal.toArray();
            filaTemporal.clear();
            filaCompleta.add(filaArray);
        }
        rows=new Object[filaCompleta.size()][];
        for(int i=0;i<rows.length;i++){
            rows[i]=(Object[])(filaCompleta.get(i));
        }
    }
    private VueloBase getVueloBase(List<VueloBase> lista,String codigo){
        for (VueloBase vb:lista){
            if (vb.getCodigo().equals(codigo)) return vb;
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
