package com.aeropuertos.componentes;


public class DatosClima {
    private String tmin;
    private String tmax;

    public DatosClima(String tmin, String tmax) {
        this.tmin = tmin;
        this.tmax = tmax;
    }

    public String getTmin() {
        return tmin;
    }

    public void setTmin(String tmin) {
        this.tmin = tmin;
    }

    public String getTmax() {
        return tmax;
    }

    public void setTmax(String tmax) {
        this.tmax = tmax;
    }

}
