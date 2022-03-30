package com.example.wlasne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
public class oczko extends AppCompatActivity {
    private Button NextCard, EndGame,NewGame ,cofnij2;
    private ImageView RandomCard,RandomCard2;
    private TextView dane,dane2;

    private listyKart wszystkieKarty = new listyKart();
    private int[][] listaKart = wszystkieKarty.getKartyRodzaje();
    private Random random1= new Random();
    private Random random2= new Random();
    private Random random3= new Random();
    private Random random4= new Random();

    private static int[] punktyLista = {2,3, 4, 5, 6,7,8,9,10,
            2,3, 4,11
    };

    int[] MyKarty = new int[10];
    int[] krupierKarty = new int[10];
    int Points = 0;
    int IleCards = 0;
    int PointsK =0;
    int IleKartK =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oczko);
        NextCard = findViewById(R.id.b1);
        EndGame = findViewById(R.id.b2);
        RandomCard = findViewById(R.id.imgS1);
        RandomCard2=findViewById(R.id.ImgS2);
        dane = findViewById(R.id.W1);
        dane2=findViewById(R.id.W2);
        NewGame=findViewById(R.id.b3);

    cofnij2=findViewById(R.id.oczkoCofnij);
        cofnij2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cofnij = new Intent(oczko.this, MainActivity.class);
                startActivity(cofnij);
            }
        });
        NextCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                losujKarte();
                losujKarteKupier();
            }
        });

        EndGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dane.setText("Twoje punkty: " + Points);
                NextCard.setEnabled(false);
                dane2.setText("Punkty Krupiera:"+ PointsK);
                NextCard.setEnabled(false);


            }
        });
        NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaKart=wszystkieKarty.getKartyRodzaje();
                MyKarty=new int[10];
                krupierKarty=new int[10];
                Points=0;
                PointsK=0;
                dane.setText("");
                dane2.setText("");
                IleCards=0;
                NextCard.setEnabled(true);

            }
        });


    }

    public void losujKarte(){
        int numer = random1.nextInt(13);
        int rodzaj = random2.nextInt(4);

        RandomCard.setImageResource(listaKart[numer][rodzaj]);

        MyKarty[IleCards] = punktyLista[numer];

        Points += punktyLista[numer];
        dane.setText(Points+"");
        IleCards++;
        if(Points < 21){

            dane.setText(Points + "");
        }else if(Points == 21){
            dane.setText("WYGRANA" + " twoje punkty: " + Points);
        }else if(Points > 21){
            if(Points == 22){
                if(MyKarty.length == 2){
                    dane.setText("WYGRANA" + " Pawie oczko");
                }else{
                    dane.setText("PRZEGRANA   " + Points);
                    NextCard.setEnabled(false);
                }
            }else{
                dane.setText("PRZEGRANA   " + Points);
                NextCard.setEnabled(false);
            }
        }

    }

    public void losujKarteKupier(){

        int numer = random3.nextInt(13);
        int rodzaj = random4.nextInt(4);
        RandomCard2.setImageResource(listaKart[numer][rodzaj]);
        krupierKarty[IleCards]=punktyLista[numer];
        PointsK += punktyLista[numer];
        dane2.setText(PointsK+"");
        IleCards++;
        if(PointsK < 21){

            dane2.setText(PointsK + "");
        }else if(PointsK == 21){
            dane2.setText("WYGRANA" + " twoje punkty: " + PointsK);
        }else if(PointsK > 21){
            if(PointsK == 22){
                if(MyKarty.length == 2){
                    dane2.setText("WYGRANA" + " Pawie oczko");
                }else{
                    dane2.setText("PRZEGRANA   " + PointsK);
                    NextCard.setEnabled(false);
                }
            }else{
                dane2.setText("PRZEGRANA   " + PointsK);
                NextCard.setEnabled(false);
            }
        }
    }
    }
