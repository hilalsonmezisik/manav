package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class uyeOlSayfasi extends AppCompatActivity {
    private EditText editAd;
    private EditText editSoyad;
    private EditText editCep;
    private EditText editSifre;
    private EditText editMail;
    private  EditText editAdres;

    private CheckBox kadin;
    private CheckBox erkek;
    private CheckBox kullanim;

    private Button uyeBtn;
    private ProgressDialog progres;


    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_ol_sayfasi);

        editAd = (EditText) findViewById(R.id.editAd);
        editSoyad = (EditText) findViewById(R.id.editSoyad);
        editCep = (EditText) findViewById(R.id.editCep);
        editSifre = (EditText) findViewById(R.id.editSifre);
        editMail = (EditText) findViewById(R.id.editMail);
        editAdres = (EditText) findViewById(R.id.editAdres);

        kadin = (CheckBox) findViewById(R.id.kadin);
        erkek = (CheckBox) findViewById(R.id.erkek);
        kullanim = (CheckBox) findViewById(R.id.kullanim);

        uyeBtn = (Button) findViewById(R.id.uyeBtn);

        progres = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        uyeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mail = editMail.getText().toString();
                final String sifre = editSifre.getText().toString();
                final String ad = editAd.getText().toString();
                final String soyad = editSoyad.getText().toString();
                final String tel = editCep.getText().toString();
                final String adres = editAdres.getText().toString();


                firebaseAuth.createUserWithEmailAndPassword(mail, sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            System.out.println("oldu");
                            final String id =firebaseAuth.getCurrentUser().getUid();
                            mDatabase = FirebaseDatabase.getInstance().getReference().child("uyeler").child(id);

                            HashMap<String,String> uyeler = new HashMap<>();

                            uyeler.put("ad",ad);
                            uyeler.put("soyad",soyad);
                            uyeler.put("sifre",sifre);
                            uyeler.put("mail",mail);
                            uyeler.put("adres",adres);
                            uyeler.put("cepTelefonu",tel);
                            if(erkek.isChecked()){
                                uyeler.put("cinsiyet","erkek");
                            }
                            else if(kadin.isChecked()){
                                uyeler.put("cinsiyet","kadin");
                            }
                            mDatabase.setValue(uyeler);

                            Intent intent = new Intent(uyeOlSayfasi.this,girisSayfasi.class);
                            startActivity(intent);

                        }
                        else
                            Toast.makeText(getApplicationContext(),"hata "+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}

