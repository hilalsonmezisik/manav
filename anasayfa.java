package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class anasayfa extends AppCompatActivity {

    private Button btBir ,btIki,btUc,btDort,btBes,btAlti ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        btBir = findViewById(R.id.btBir);
        btIki = findViewById(R.id.btIki);
        btUc = findViewById(R.id.btUc);
        btDort = findViewById(R.id.btDort);
        btBes = findViewById(R.id.btBes);
        btAlti = findViewById(R.id.btAlti);

        btBir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this,anasayfa.class);
                startActivity(intent);
            }
        });

        btIki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this,Profilim.class);
                startActivity(intent);
            }
        });

        btUc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this,Bana_Verilen_Siparisler.class);
                startActivity(intent);
            }
        });

        btDort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this,BenimVerdigimSiparisler.class);
                startActivity(intent);
            }
        });

        btBes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this,Urunlerim.class);
                startActivity(intent);
            }
        });

        btAlti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(anasayfa.this,UrunEkle.class);
                startActivity(intent);
            }
        });

    }
}
