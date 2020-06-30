package edu.upc.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.unity3d.player.UnityPlayerActivity;

public class QuitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getApplicationContext(), UnityPlayerActivity.class);
        startActivity(intent);
    }
}