package edu.upc.login.Entidades;

public class PartidaAdd {

    public int idPartida;
    public String idJugador;
    public String duracion;
    public int puntos;
    public int nivelMax;

    public PartidaAdd(){}

    public PartidaAdd(int idPartida, String idJugador, String duracion, int puntos, int nivelMax) {
        this.idPartida = idPartida;
        this.idJugador = idJugador;
        this.duracion = duracion;
        this.puntos = puntos;
        this.nivelMax = nivelMax;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getNivelMax() {
        return nivelMax;
    }

    public void setNivelMax(int nivelMax) {
        this.nivelMax = nivelMax;
    }

    @Override
    public String toString() {
        return "PartidaAdd{" +
                "idPartida=" + idPartida +
                ", idJugador='" + idJugador + '\'' +
                ", duracion='" + duracion + '\'' +
                ", puntos=" + puntos +
                ", nivelMax=" + nivelMax +
                '}';
    }
}
