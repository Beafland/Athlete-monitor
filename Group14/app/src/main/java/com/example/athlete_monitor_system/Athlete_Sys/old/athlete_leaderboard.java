package com.example.athlete_monitor_system.Athlete_Sys.old;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.athlete_monitor_system.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class athlete_leaderboard extends AppCompatActivity {
    private  TextView a_l1;
    private  TextView a_l2;
    private  TextView a_l3;
    private  TextView a_l4;
    private  TextView a_l5;

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("Leaderboard1");
    private DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference().child("Leaderboard2");
    private DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference().child("Leaderboard3");
    private DatabaseReference myRef4 = FirebaseDatabase.getInstance().getReference().child("Leaderboard4");
    private DatabaseReference myRef5 = FirebaseDatabase.getInstance().getReference().child("Leaderboard5");

    String d;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_leaderboard);
        a_l1 = findViewById(R.id.a_l1);
        a_l2 = findViewById(R.id.a_l2);
        a_l3 = findViewById(R.id.a_l3);
        a_l4 = findViewById(R.id.a_l4);
        a_l5 = findViewById(R.id.a_l5);

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                a_l1.setText(d);
                d = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                a_l2.setText(d);
                d = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });

        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                a_l3.setText(d);
                d = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });

        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                a_l4.setText(d);
                d = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });
        myRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                a_l5.setText(d);
                d = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });
    }
}

