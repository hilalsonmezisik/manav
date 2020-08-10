package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Urunlerim extends AppCompatActivity {


    ImageView al;
    RecyclerView mrecyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urunlerim);

        //al=(ImageView) findViewById(R.id.ImageView2);

        Intent intent = getIntent();

    //mrecyclerView = findViewById(R.id.rcBir);
        mrecyclerView.setHasFixedSize(true);

        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("2");
    }

    protected void onStart(){
        super.onStart();

        FirebaseRecyclerAdapter<Member,ViewHolder>firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Member,ViewHolder>(
                        Member.class,
                        R.layout.image,
                        ViewHolder.class,
                        reference
                ){
                    protected void populateViewHolder(ViewHolder viewHolder, Member member, int i){

                        viewHolder.setdetails(getApplicationContext(),member.getTitle(),member.getImage());

                    }
                };
        Object clerAdapter;
        mrecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    private class FirebaseRecyclerAdapter<T, T1> extends RecyclerView.Adapter {
        public FirebaseRecyclerAdapter(Class<T> memberClass, int image, Class<T1> viewHolderClass, DatabaseReference reference) {
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
