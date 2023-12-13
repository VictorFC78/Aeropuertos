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
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 34675
 */
public class TableRecaudacionModel extends AbstractTableModel {
private List<VueloDiario> listaVuelosDiarios;
private List<VueloBase> listaVuelosBase;
private String []columnanes;
private Class<?>[]columnclass;
private SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
    public TableRecaudacionModel(List<VueloDiario> listaVuelosDiarios, List<VueloBase> listaVuelosBase) {
        this.listaVuelosDiarios = listaVuelosDiarios;
        this.listaVuelosBase = listaVuelosBase;
        columnanes=new String[]{"CODIGO","ARPTO.ORIGEN","ARPTO.DESTINO","FECHA","H.SALIDA","H.LLEGADA","RECAUDACION"};
        columnclass=new Class<?>[]{String.class,Aeropuerto.class,Aeropuerto.class,String.class,LocalTime.class,LocalTime.class,Double.class};
    }
    private VueloBase getVueloBase(VueloDiario vueloDiario){
        for (VueloBase vb:listaVuelosBase){
            if(vb.getCodigo().equals(vueloDiario.getCodigo())) return vb;
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       return columnclass[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnanes[column];
    }
    
    @Override
    public int getRowCount() {
        return listaVuelosDiarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnanes.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VueloDiario vueloDiario=listaVuelosDiarios.get(rowIndex);
        VueloBase vueloBase=getVueloBase(vueloDiario);
        switch(columnIndex){
            case 0:
               return vueloDiario.getCodigo();
            case 1:
                return vueloBase.getOrigen();
            case 2:
                return vueloBase.getDestino();
            case 3:
                return formato.format(vueloDiario.getFechaVuelo());
            case 4:
                return vueloDiario.getHoraSlida();
            case 5:
                return vueloDiario.getHoraLlegada();
        }
        return vueloDiario.getPlazasOcupadas()*vueloDiario.getPrecio();
    }
    
}
