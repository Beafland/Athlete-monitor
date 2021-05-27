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

public class athlete_Calendar_Frag extends Fragment {
    private DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("MON"),
            myRef2 = FirebaseDatabase.getInstance().getReference().child("WED"),
            myRef3 = FirebaseDatabase.getInstance().getReference().child("FRI");
    private TextView plan1, plan2, plan3;
    String cache = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_athlete_calendar, container, false);
        plan1 = root.findViewById(R.id.view1);
        plan2 = root.findViewById(R.id.view2);
        plan3 = root.findViewById(R.id.view3);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);

                if (cache!= null && cache.length() != 0) {
                    plan1.setText(cache);
                    cache = "";
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard", "Failed to read value.", databaseError.toException());
            }
        });
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);

                if (cache!= null && cache.length() != 0) {
                    plan2.setText(cache);
                    cache = "";
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard", "Failed to read value.", databaseError.toException());
            }
        });
        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);

                if (cache!= null && cache.length() != 0) {
                    plan3.setText(cache);
                    cache = "";
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard", "Failed to read value.", databaseError.toException());
            }
        });

    }
}

