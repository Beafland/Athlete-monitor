package com.example.athlete_monitor_system.Coach_Sys.old;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;

import com.example.athlete_monitor_system.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class coach_leaderboard extends AppCompatActivity {
    private  EditText l1;
    private  EditText l2;
    private  EditText l3;
    private  EditText l4;
    private  EditText l5;
    private Button upload;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("Leaderboard1");
    private DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference().child("Leaderboard2");
    private DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference().child("Leaderboard3");
    private DatabaseReference myRef4 = FirebaseDatabase.getInstance().getReference().child("Leaderboard4");
    private DatabaseReference myRef5 = FirebaseDatabase.getInstance().getReference().child("Leaderboard5");
    String d;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        upload = findViewById(R.id.upload);

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                l1.setText(d);
                d="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());

            }
        });
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                l2.setText(d);
                d="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());

            }
        });
        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                l3.setText(d);
                d="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());

            }
        });
        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                l4.setText(d);
                d="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());

            }
        });
        myRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);
                l5.setText(d);
                d="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());

            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Leaderboard1").setValue(l1.getText().toString());
                mDatabase.child("Leaderboard2").setValue(l2.getText().toString());
                mDatabase.child("Leaderboard3").setValue(l3.getText().toString());
                mDatabase.child("Leaderboard4").setValue(l4.getText().toString());
                mDatabase.child("Leaderboard5").setValue(l5.getText().toString());
                Message("Modification has been uploaded");

            }
        });
    }


    public void Message(String s){
        Toast toast = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

}
