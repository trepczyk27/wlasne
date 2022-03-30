package com.example.wlasne;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button rgb,oczko,galeria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgb = findViewById(R.id.rgb);

        rgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, rgb.class);
                startActivity(intent);
            }
        });
        galeria= findViewById(R.id.galeria);

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, galeria.class);
                startActivity(intent);
            }
        });
        oczko = findViewById(R.id.dalej);

        oczko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, oczko.class);
                startActivity(intent);
            }
        });
    }
}