
package com.aeropuertos.componentes;

import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 34675
 */
public class TablaApirestFullModel extends AbstractTableModel{
    //como sabemos formato de la tabla creamos su columnames y columclass
    private String[]columnanes=new String[2];
    private Class<?> []columClass=new Class<?>[2];
    private ApirestFullTemperaturas consultaApiRest;
    private DatosClima datosClima;
    private DtoEditorApiRestFull dtoeditor;
    private Object[][]rows=new Object[1][2];
    public TablaApirestFullModel(DtoEditorApiRestFull dtoEditor) {
        dtoeditor=dtoEditor;
        columnanes[0]="T.MAXIMA";
        columnanes[1]="T.MINIMA";
        columClass[0]=String.class;
        columClass[1]=String.class;
        if(dtoeditor!=null){
            realizarConsulta();
        }
    }
    private void realizarConsulta(){
        try {
            consultaApiRest=new ApirestFullTemperaturas(dtoeditor.getMunicipio(), dtoeditor.getApikey());//realizamos consulta
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JDialog(),"Existe un error en la ApiKey", "ERROR APIKEY",JOptionPane.ERROR_MESSAGE);
        }
        datosClima= consultaApiRest.getDatosClima();
        rows[0][0]=datosClima.getTmax();
        rows[0][1]=datosClima.getTmin();
    }
    @Override
    public int getRowCount() {
      return rows.length;
    }

    @Override
    public int getColumnCount() {
       return columnanes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columClass[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnanes[column];
    }
    
}
