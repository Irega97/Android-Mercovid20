package edu.upc.login.Entidades;

public class Mapa {

    public int idMapa;
    public String mapa;

    public Mapa(){}

    public Mapa(int idMapa, String mapa){
        this();
        this.mapa=mapa;
        this.idMapa=idMapa;
    }

    public int getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(int idMapa) {
        this.idMapa = idMapa;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }
}
