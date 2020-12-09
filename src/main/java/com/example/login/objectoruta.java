package com.example.login;

public class objectoruta {
    int id;
    String origen,destino,costo;

    public objectoruta() {
    }

    public objectoruta(int id, String origen, String destino, String costo) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Desde: " + origen +'\n'+ " Hasta: " + destino +'\n'+ " Tiene un costo de: $" + costo +"";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
}
