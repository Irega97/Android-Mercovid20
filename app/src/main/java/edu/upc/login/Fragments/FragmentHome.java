package edu.upc.login.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.unity3d.player.UnityPlayerActivity;

import edu.upc.login.API;
import edu.upc.login.QuitActivity;
import edu.upc.login.R;
import edu.upc.login.Singleton;

public class FragmentHome extends Fragment {

    Button play;
    private API api;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.main_fragment,container,false);
        Singleton.getInstance().setToken(obtenerToken());
        Singleton.getInstance().requestObjetos();
        play = view.findViewById(R.id.playBtn);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().requestMapas();
                Intent intent = new Intent(getContext(), QuitActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private String obtenerToken(){
        SharedPreferences preferences = this.getActivity().getSharedPreferences("tokenUsuario", Context.MODE_PRIVATE);
        String token = preferences.getString("token", "Login required");
        return token;
    }
}
