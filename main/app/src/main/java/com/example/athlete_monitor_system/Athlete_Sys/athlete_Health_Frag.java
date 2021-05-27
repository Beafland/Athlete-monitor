package com.example.athlete_monitor_system.Athlete_Sys;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.athlete_monitor_system.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class athlete_Health_Frag extends Fragment {
    private EditText weight, waistline, height, muscle_mass, name, fat_mass;
    private Button SUBMIT;
    private String[] array;
    private String cache = "";
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("health_data");
    private FirebaseAuth mAuth;
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_health_data, container, false);
        weight = root.findViewById(R.id.weight);
        waistline = root.findViewById(R.id.waistline);
        height = root.findViewById(R.id.height);
        muscle_mass = root.findViewById(R.id.muscle_mass);
        name = root.findViewById(R.id.name);
        fat_mass = root.findViewById(R.id.fat_mass);
        SUBMIT = root.findViewById(R.id.SUBMIT);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*if(mAuth.getCurrentUser() != null){
            mDatabase.child(mAuth.getCurrentUser().getDisplayName()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    cache = dataSnapshot.getValue(String.class);
                    array = cache.split("&&&");
                    name.setText(array[0]);
                    height.setText(array[1]);
                    weight.setText(array[2]);
                    waistline.setText(array[3]);
                    muscle_mass.setText(array[4]);
                    fat_mass.setText(array[5]);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.w("athlete_health_data","Failed to read value.", databaseError.toException());
                }
            });
        }*/
        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkEmpty()) {
                    String data = name.getText().toString().trim() + "&&&"
                            + height.getText().toString().trim() + "&&&"
                            + weight.getText().toString().trim() + "&&&"
                            + waistline.getText().toString().trim() + "&&&"
                            + muscle_mass.getText().toString().trim() + "&&&"
                            + fat_mass.getText().toString().trim();
                    mDatabase.child(name.getText().toString().trim()).setValue(data);
                    Message("Information uploaded successfully");
                }
            }
        });
    }

    public boolean checkEmpty() {
        if(name.getText().toString().trim().length()==0){
            Message("Please enter your name");
            return false;
        }else if(height.getText().toString().trim().length()==0){
            Message("Please enter your height");
            return false;
        }else if(weight.getText().toString().trim().length()==0){
            Message("Please enter your weight");
            return false;
        }else if(waistline.getText().toString().trim().length()==0){
            Message("Please enter your waistline");
            return false;
        }else if(muscle_mass.getText().toString().trim().length()==0){
            Message("Please enter your muscle_mass");
            return false;
        }else if(fat_mass.getText().toString().trim().length()==0){
            Message("Please enter your fat_mass");
            return false;
        }
        return true;
    }

    public void Message(String s){
        mContext = getActivity();
        Toast toast = Toast.makeText(mContext,s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}

