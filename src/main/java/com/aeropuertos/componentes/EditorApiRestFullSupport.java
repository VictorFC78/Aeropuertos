/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.componentes;

import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.io.Serializable;

/**
 *
 * @author 34675
 */
public class EditorApiRestFullSupport extends PropertyEditorSupport implements Serializable{
    private EditorPropiedadesApirestFull editor=new EditorPropiedadesApirestFull();

    @Override
    public boolean supportsCustomEditor() {//le decimos que si soporta un editor de proìedades custumizado
        return true;
    }

    @Override
    public Component getCustomEditor() {//retorna una instancia del editor custumizado
        return editor;
    }

    @Override
    public String getJavaInitializationString() {//creamos una instancia del objeto que devuelve el editor el modo string
        DtoEditorApiRestFull dtoEditorApiRestFull=editor.getSelectedValue();
        return "new com.aeropuertos.componentes.DtoEditorApiRestFull(\" "+dtoEditorApiRestFull.getMunicipio()+"\",\""+
                dtoEditorApiRestFull.getApikey()+"\")";
        
    }

    @Override
    public Object getValue() {//retornamos el objecto que se genera con el editor
        return editor.getSelectedValue();
        
    }
    
    
}
