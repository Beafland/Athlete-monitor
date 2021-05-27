package com.example.athlete_monitor_system.Athlete_Sys.old;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.athlete_monitor_system.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class athlete_train extends AppCompatActivity {
    private DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("MON");
    private DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference().child("WED");
    private DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference().child("FRI");
    private  TextView plan1;
    private  TextView plan2;
    private  TextView plan3;
    String d;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_train);
        plan1 = findViewById(R.id.view1);
        plan2 = findViewById(R.id.view2);
        plan3 = findViewById(R.id.view3);

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
}
