package com.example.athlete_monitor_system.Athlete_Sys;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.athlete_monitor_system.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class athlete_LB_Fragment extends Fragment {
    private TextView a_l1, a_l2, a_l3, a_l4, a_l5;

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("Leaderboard1");
    private DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference().child("Leaderboard2");
    private DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference().child("Leaderboard3");
    private DatabaseReference myRef4 = FirebaseDatabase.getInstance().getReference().child("Leaderboard4");
    private DatabaseReference myRef5 = FirebaseDatabase.getInstance().getReference().child("Leaderboard5");

    String cache = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_athlete_leaderboard, container, false);

        a_l1 = root.findViewById(R.id.a_l1);
        a_l2 = root.findViewById(R.id.a_l2);
        a_l3 = root.findViewById(R.id.a_l3);
        a_l4 = root.findViewById(R.id.a_l4);
        a_l5 = root.findViewById(R.id.a_l5);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                a_l1.setText(cache);
                cache = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                a_l2.setText(cache);
                cache = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });

        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                a_l3.setText(cache);
                cache = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });

        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                a_l4.setText(cache);
                cache = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });
        myRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                a_l5.setText(cache);
                cache = "";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("athlete_leaderboard","Failed to read value.", databaseError.toException());
            }
        });
    }
}
