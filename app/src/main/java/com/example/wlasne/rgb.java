package com.example.wlasne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import java.util.Random;
public class rgb extends AppCompatActivity {

    private Button cofnij;
    private SeekBar red, green, blue;
    private LinearLayout kolorek;
    private int r = 0, g = 0, b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgb);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);
        kolorek = findViewById(R.id.kolorek);
        cofnij=findViewById(R.id.cofnij);
        red.setMax(255);
        green.setMax(255);
        blue.setMax(255);

        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                r = progress;
                ustawKolor(r, g, b);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cofnij = new Intent(rgb.this, MainActivity.class);
                startActivity(cofnij);
            }
        });
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                g = progress;
                ustawKolor(r, g, b);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                b = progress;
                ustawKolor(r, g, b);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void ustawKolor(int r, int g, int b){
        kolorek.setBackgroundColor(Color.rgb(r, g, b));
    }

    public void losuj(View view) {
        Random r = new Random();
        Random g = new Random();
        Random b = new Random();
        int x = r.nextInt(256);
        int y = g.nextInt(256);
        int z = b.nextInt(256);
        red.setProgress(x);
        green.setProgress(y);
        blue.setProgress(z);
        ustawKolor(x, y, z);

    }
}

