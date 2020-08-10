package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Profilim extends AppCompatActivity {
    private EditText adBir,soyadBir,telBir,mailBir,sifreBir,adresBir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilim);

        adBir = findViewById(R.id.adBir);
        soyadBir = findViewById(R.id.soyadBir);
        telBir = findViewById(R.id.telBir);
        mailBir = findViewById(R.id.mailBir);
        sifreBir = findViewById(R.id.sifreBir);
        adresBir = findViewById(R.id.adresBir);

    }
}
