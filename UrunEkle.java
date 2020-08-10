package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UrunEkle extends AppCompatActivity {
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference reference = storage.getReference();


    ImageView ImageView;
    Button SelectImageBtn;
    static  final int SELECT_IMAGE=12;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_ekle);

        ImageView = findViewById(R.id.ImageView);
        SelectImageBtn = findViewById(R.id.SelectImageBtn);

        SelectImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_IMAGE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==SELECT_IMAGE && resultCode==RESULT_OK) {
            Uri uri = data.getData();
            ImageView.setImageURI(imageUri);
            StorageReference ref = reference.child(uri.getLastPathSegment());
            ref.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Toast.makeText(UrunEkle.this, "Yükleme tamamlandı.", Toast.LENGTH_SHORT).show();

                }
            });


        }
    }

    public void Ekle(View view) {
        Intent intent = new Intent(getApplicationContext(),Urunlerim.class);
        //intent.putExtras(ImageView.getText().toString());
        startActivity(intent);
    }


}
