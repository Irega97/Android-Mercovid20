package edu.upc.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.unity3d.player.UnityPlayerActivity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import edu.upc.login.Entidades.Inventario;
import edu.upc.login.Entidades.Mapa;
import edu.upc.login.Entidades.PartidaAdd;
import edu.upc.login.Fragments.FragmentHome;

public class apiUnity {

    public static String getObjetos(){
        List<Inventario> objetos = Singleton.getInstance().getObjetos();
        StringBuffer o = new StringBuffer();
        for(int i=0; i<objetos.size(); i++){
            o.append(objetos.get(i).getIdObjeto()+"/");
            if(i!=objetos.size()-1) o.append(objetos.get(i).getCantidad()+"/");
            else o.append(objetos.get(i).getCantidad());
        }
        return o.toString();
    }

    public static void setObjetos(int idObjeto){
        String token = Singleton.getInstance().getToken();
        Singleton.getInstance().updateObjetos(idObjeto,token);
    }

    public static String getMapa(int idMapa){
        List<Mapa> mapas = Singleton.getInstance().getMapas();
        String mapa = mapas.get(idMapa-1).getMapa();
        return mapa;
    }

    public static String getEnemigos(int idNivel){
        Singleton.getInstance().requestEnemigos(idNivel);
        String enemigos = Singleton.getInstance().getEnemigos();
        return null;
    }

    public static void guardarStats(String duracion, int puntos){
        PartidaAdd p = new PartidaAdd();
        int nivelMax = 1;
        String token = Singleton.getInstance().getToken();

        if (puntos>=80 && puntos<200) nivelMax=2;
        else if (puntos>=200 && puntos<350) nivelMax=3;
        else if(puntos>=350 && puntos<400) nivelMax=4;
        else if(puntos>=400) nivelMax=5;

        p.setDuracion(duracion);
        p.setIdPartida(0);
        p.setNivelMax(nivelMax);
        p.setPuntos(puntos);
        p.setIdJugador(token);

        Singleton.getInstance().addGame(p);
        Singleton.getInstance().addPuntos(token,puntos);
    }

}