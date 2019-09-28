package com.example.gamefiguras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Launcher extends AppCompatActivity {

    private final int DURACION_SPLASH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Launcher.this,MainActivity.class);
                Launcher.this.startActivity(mainIntent);
                Launcher.this.finish();

            }
        },
     DURACION_SPLASH);
    }
}
