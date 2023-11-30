
package com.aeropuertos.dto;

import java.time.LocalTime;
import java.util.Date;


public class VueloDiario {
    private String codigo;
    private Date fechaVuelo;
    private LocalTime horaSlida;
    private LocalTime horaLlegada;
    private int plazasOcupadas;
    private double precio;

    public VueloDiario() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public VueloDiario(String codigo,Date fechaVuelo, LocalTime horaSlida, LocalTime horaLlegada, int plazasOcupadas, double precio) {
        this.codigo=codigo;
        this.fechaVuelo = fechaVuelo;
        this.horaSlida = horaSlida;
        this.horaLlegada = horaLlegada;
        this.plazasOcupadas = plazasOcupadas;
        this.precio = precio;
    }

    public Date getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(Date fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public LocalTime getHoraSlida() {
        return horaSlida;
    }

    public void setHoraSlida(LocalTime horaSlida) {
        this.horaSlida = horaSlida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public void setPlazasOcupadas(int plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object obj) {
        VueloDiario vueloD=(VueloDiario)obj;
        if(this.getFechaVuelo().equals(vueloD.getFechaVuelo())
                & this.getHoraSlida().equals(vueloD.getHoraSlida())
                & this.getHoraLlegada().equals(vueloD.getHoraLlegada()))return true;
        return false;
    }
    
}
