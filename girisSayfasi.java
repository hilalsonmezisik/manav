package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class girisSayfasi extends AppCompatActivity {
    private EditText editbir, editiki;
    private Button gonder;



    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_sayfasi);

        editbir = findViewById(R.id.editbir);
        editiki = findViewById(R.id.editiki);

        gonder = findViewById(R.id.gonder);

        firebaseAuth = FirebaseAuth.getInstance();



        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddr = editbir.getText().toString();
                String pass = editiki.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(emailAddr, pass)
                        .addOnCompleteListener(girisSayfasi.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(girisSayfasi.this, anasayfa.class));
                                } else {
                                    Log.e("Giriş Hatası", task.getException().getMessage());
                                }
                            }
                        });
            }
        });




    }
}
