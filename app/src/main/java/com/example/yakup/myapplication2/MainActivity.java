package com.example.yakup.myapplication2;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtSkor;
    TextView txtSayac;
    int skor = 0;
    ImageView fish1, fish2, fish3, fish4, fish5, fish6, fish7, fish8, fish9;
    ImageView[] fishArray;
    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tanımla(); //Java ile Xml Arasındaki kofları bu metodda eşleştirdik
        Hide(); //Program ilk açıldığında ekrandaki resimlerin kaybolması ve random resim atması için bunu yaptık.


        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtSayac.setText("Kalan Zaman = " + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {

                txtSayac.setText("Zaman Doldu Skorunuz : " + skor);
                txtSayac.setTextColor(Color.parseColor("#827717"));

                handler.removeCallbacks(runnable);
                ResimSakla();


            }
        }.start();
    }

    private void ResimSakla() {
        for (ImageView image : fishArray) {
            image.setVisibility(View.INVISIBLE);
        }/*
        for (int i = 0 ; i<fisharry.length;i++){
        fishArry[i].setVisibility(View.INVISIBLE);
        }*/
    }

    private void Hide() {



        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                ResimSakla();

                Random r = new Random();
                int fish = r.nextInt(8 - 0);
                fishArray[fish].setVisibility(View.VISIBLE);

                handler.postDelayed((Runnable) this, 1000);
            }
        };
        handler.post(runnable);
    }
    private void  Tanımla() {
        txtSkor = findViewById(R.id.txtSkor);
        fish1 = findViewById(R.id.imgOrtaUstSol);
        fish2 = findViewById(R.id.imgOrtaUstu);
        fish3 = findViewById(R.id.imgOrtaUstSağ);
        fish4 = findViewById(R.id.imgOrtaSol);
        fish5 = findViewById(R.id.imgOrta);
        fish6 = findViewById(R.id.imgOrtaSağ);
        fish7 = findViewById(R.id.imgOrtaAltSolu);
        fish8 = findViewById(R.id.imgOrtaAlt);
        fish9 = findViewById(R.id.imgOrtaAltSagı);
        txtSayac = findViewById(R.id.txtzmanZaman);

        fishArray = new ImageView[]{fish1, fish2, fish3, fish4, fish5, fish6, fish7, fish8, fish9};

    }
    public void  FishPress(View view){
    skor++;
    txtSkor.setText("Skor = "+skor);
    }}

