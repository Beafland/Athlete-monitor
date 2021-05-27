package com.example.athlete_monitor_system.Coach_Sys;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public class coach_LB_Frag extends Fragment {
    private EditText l1, l2, l3, l4, l5;
    private EditText[] name;
    private Button upload;
    private DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("Leaderboard1"),
            myRef2 = FirebaseDatabase.getInstance().getReference().child("Leaderboard2"),
            myRef3 = FirebaseDatabase.getInstance().getReference().child("Leaderboard3"),
            myRef4 = FirebaseDatabase.getInstance().getReference().child("Leaderboard4"),
            myRef5 = FirebaseDatabase.getInstance().getReference().child("Leaderboard5");
    private Context mContext;
    String cache = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_coach_leaderboard, container, false);
        l1 = root.findViewById(R.id.l1);
        l2 = root.findViewById(R.id.l2);
        l3 = root.findViewById(R.id.l3);
        l4 = root.findViewById(R.id.l4);
        l5 = root.findViewById(R.id.l5);
        upload = root.findViewById(R.id.upload);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                l1.setText(cache);
                cache ="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());
            }
        });
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                l2.setText(cache);
                cache ="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());
            }
        });
        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                l3.setText(cache);
                cache ="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());
            }
        });
        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                l4.setText(cache);
                cache ="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());
            }
        });
        myRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                l5.setText(cache);
                cache ="";
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("coach_leaderboard","Failed to read value.", databaseError.toException());
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef1.setValue(l1.getText().toString());
                myRef2.setValue(l2.getText().toString());
                myRef3.setValue(l3.getText().toString());
                myRef4.setValue(l4.getText().toString());
                myRef5.setValue(l5.getText().toString());
                Message("Modification has been uploaded");
            }
        });
    }

    public void Message(String s){
        mContext = getActivity();
        Toast toast = Toast.makeText(mContext,s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

}