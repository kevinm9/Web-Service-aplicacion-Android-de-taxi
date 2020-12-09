package com.example.login;

public class objectosdelviaje {
    int idviaje,idchofer,idpasajero,idruta;
    String chofer,pasajero,origen,destino,fecha;

    public objectosdelviaje() {
    }

    public objectosdelviaje(int idviaje, int idchofer, int idpasajero, int idruta, String chofer, String pasajero, String origen, String destino, String fecha) {
        this.idviaje = idviaje;
        this.idchofer = idchofer;
        this.idpasajero = idpasajero;
        this.idruta = idruta;
        this.chofer = chofer;
        this.pasajero = pasajero;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }

    public int getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(int idviaje) {
        this.idviaje = idviaje;
    }

    public int getIdchofer() {
        return idchofer;
    }

    public void setIdchofer(int idchofer) {
        this.idchofer = idchofer;
    }

    public int getIdpasajero() {
        return idpasajero;
    }

    public void setIdpasajero(int idpasajero) {
        this.idpasajero = idpasajero;
    }

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public String getPasajero() {
        return pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
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

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Ruta de :" +'\n'+ origen +" hasta " + destino +'\n'+"Conductor:" +'\n'+ chofer +'\n'+"Pasajeros:" +'\n'+ pasajero +'\n'+"Fecha y Hora:" +'\n'+ fecha +"";


    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
