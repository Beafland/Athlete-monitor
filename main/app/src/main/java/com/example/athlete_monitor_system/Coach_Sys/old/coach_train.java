package com.example.athlete_monitor_system.Coach_Sys.old;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.athlete_monitor_system.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class coach_train extends AppCompatActivity {
    private MultiAutoCompleteTextView plan1;
    private MultiAutoCompleteTextView plan2;
    private MultiAutoCompleteTextView plan3;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("MON");
    private DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference().child("WED");
    private DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference().child("FRI");
    private Button submit;
    String d;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_trian);

        plan1 = findViewById(R.id.view1);
        plan2 = findViewById(R.id.view2);
        plan3 = findViewById(R.id.view3);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("MON").setValue(plan1.getText().toString());
                mDatabase.child("WED").setValue(plan2.getText().toString());
                mDatabase.child("FRI").setValue(plan3.getText().toString());
                Message("Modification has been uploaded");
            }
        });

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d = dataSnapshot.getValue(String.class);

                if(d.length()!=0){
                    plan1.setText(d);
                    d = "";
                }

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

                if(d.length()!=0){
                    plan2.setText(d);
                    d = "";
                }

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

                if(d.length()!=0){
                    plan3.setText(d);
                    d = "";
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());

            }
        });


    }
    public void Message(String s){
        Toast toast = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }



}
