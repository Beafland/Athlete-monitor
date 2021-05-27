package com.example.athlete_monitor_system.Coach_Sys;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.athlete_monitor_system.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class coach_Calendar_Frag extends Fragment {
    private MultiAutoCompleteTextView plan1, plan2, plan3;
    private DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("MON"),
            myRef2 = FirebaseDatabase.getInstance().getReference().child("WED"),
            myRef3 = FirebaseDatabase.getInstance().getReference().child("FRI");
    private Button submit;
    private Context mContext;
    String cache = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_coach_calendar, container, false);

        plan1 = root.findViewById(R.id.view1);
        plan2 = root.findViewById(R.id.view2);
        plan3 = root.findViewById(R.id.view3);
        submit = root.findViewById(R.id.submit);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef1.setValue(plan1.getText().toString());
                myRef2.setValue(plan2.getText().toString());
                myRef3.setValue(plan3.getText().toString());
                Message("Modification has been uploaded");
            }
        });

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

    public void Message(String s) {
        mContext = getActivity();
        Toast toast = Toast.makeText(mContext, s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}