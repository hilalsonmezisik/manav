package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button uyeButonu;
    private Button girisButonu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uyeButonu = findViewById(R.id.uyeButonu);
        girisButonu = findViewById(R.id.girisButonu);

        uyeButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent uye = new Intent(MainActivity.this,uyeOlSayfasi.class);
                startActivity(uye);

            }
        });

        girisButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent giris = new Intent(MainActivity.this,girisSayfasi.class);
                startActivity(giris);



            }
        });


        mAuth=FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()==null)
        {
            //Intent loginIntent = new Intent(MainActivity.this,uyeOlSayfasi.class);
            //startActivity(loginIntent);
            Toast.makeText(getApplicationContext(),"Lütfen giriş yapınız",Toast.LENGTH_SHORT).show();
        }
    }
}
