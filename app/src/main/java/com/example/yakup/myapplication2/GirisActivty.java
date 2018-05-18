package com.example.yakup.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GirisActivty extends AppCompatActivity {

    Button GirisYap;
    EditText KullanıcıAdı , KullanıcıSifre;
    String KulAdi;
    String Sıfre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_activty);
        GirisYap =findViewById(R.id.btnGiris);
        KullanıcıAdı = findViewById(R.id.kullaniciAdi);
        KullanıcıSifre = findViewById(R.id.kullaniciSifre);


        GirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               KulAdi = KullanıcıAdı.getText().toString();
               Sıfre = KullanıcıSifre.getText().toString();

                if (KulAdi.equals("yakup") && Sıfre.equals("1234")){
                    Toast.makeText(GirisActivty.this, "Kullanıcı Giriş Başarılı", Toast.LENGTH_SHORT).show();
                    Intent gorev = new Intent(GirisActivty.this,MainActivity.class);
                    startActivity(gorev);
                }

                else{
                    Toast.makeText(GirisActivty.this, "Hatalı Giriş", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
