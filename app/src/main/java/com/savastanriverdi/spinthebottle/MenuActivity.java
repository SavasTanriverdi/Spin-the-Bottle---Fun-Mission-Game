package com.savastanriverdi.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void startGame(View view) {
        // Oyun ektivitesini başlatmak için Intent oluşturur.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}