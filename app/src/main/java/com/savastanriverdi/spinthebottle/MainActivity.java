package com.savastanriverdi.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private BottleSpinner bottleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);
        bottleSpinner = new BottleSpinner(bottle);
    }
    public void spinBottle(View v) {
        bottleSpinner.spinBottle();
    }
}