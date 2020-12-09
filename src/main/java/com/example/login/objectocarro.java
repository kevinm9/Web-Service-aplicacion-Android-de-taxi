package com.example.login;

public class objectocarro {
    int id,idchofer;
    String matricula,modelo,anio;


    public objectocarro() {
    }

    public objectocarro(int id, int idchofer, String matricula, String modelo, String anio) {
        this.id = id;
        this.idchofer = idchofer;
        this.matricula = matricula;
        this.modelo = modelo;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdchofer() {
        return idchofer;
    }

    public void setIdchofer(int idchofer) {
        this.idchofer = idchofer;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
}
