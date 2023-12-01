
package com.aeropuertos.dto;



import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class VueloBase {
    private String codigo;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int plazas;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private String diasOpera;
    private List<VueloDiario> vuelosDiario;
    public VueloBase() {
    }

    public List<VueloDiario> getVuelosDiario() {
        return vuelosDiario;
    }

    public void setVuelosDiario(List<VueloDiario> vuelosDiario) {
        this.vuelosDiario = vuelosDiario;
    }

    public VueloBase(String codigo, Aeropuerto origen, Aeropuerto destino, int plazas, LocalTime horaSalida, LocalTime horaLlegada, String diasOpera) {
        this.codigo=codigo;
        this.origen = origen;
        this.destino = destino;
        this.plazas = plazas;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.diasOpera = diasOpera;
        this.vuelosDiario=new ArrayList<>();
        
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getDiasOpera() {
        return diasOpera;
    }

    public void setDiasOpera(String diasOpera) {
        this.diasOpera = diasOpera;
    }

    public void anaidirVueloDiario(VueloDiario v){
        vuelosDiario.add(v);
    }
    public VueloDiario buscarVueloDiario(LocalTime fecha){
        for (VueloDiario v:vuelosDiario){
            if(v.getFechaVuelo().equals(fecha)){
                return v;
            }
        }
        return null;
    }
     public boolean eliminarVueloDiario(Date fecha){
         Iterator<VueloDiario> it=vuelosDiario.iterator();
         VueloDiario v;
         while(it.hasNext()){
             v=it.next();
             if(v.getFechaVuelo().equals(fecha)){
                 it.remove();
                 return true;
         }
         }
         return false;
}

    @Override
    public boolean equals(Object obj) {
        VueloBase vuelo=(VueloBase)obj;
        return this.getCodigo().equals(vuelo.getCodigo());   
       
    }
    
}  
