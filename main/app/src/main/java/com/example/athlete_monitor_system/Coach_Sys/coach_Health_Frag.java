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
import android.widget.TextView;
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

public class coach_Health_Frag extends Fragment {
    private TextView weight, waistline, height, muscle_mass, name, fat_mass;
    private Button search;
    private EditText searchName;
    String[] array;
    String cache = "";
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_coach_health_data, container, false);

        weight = root.findViewById(R.id.weight);
        waistline = root.findViewById(R.id.waistline);
        height = root.findViewById(R.id.height);
        muscle_mass = root.findViewById(R.id.muscle_mass);
        name = root.findViewById(R.id.name);
        fat_mass = root.findViewById(R.id.fat_mass);
        search = root.findViewById(R.id.search);
        searchName = root.findViewById(R.id.searchName);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = searchName.getText().toString();
                DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("health_data").child(key);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        cache = dataSnapshot.getValue(String.class);
                        if(cache==null)
                        {
                            Message("There is no athlete with this name.\n");
                        }
                        else{
                            array = cache.split("&&&");
                            name.setText(array[0]);
                            height.setText(array[1]);
                            weight.setText(array[2]);
                            waistline.setText(array[3]);
                            muscle_mass.setText(array[4]);
                            fat_mass.setText(array[5]);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("read", "Failed to read value.", error.toException());
                    }
                });
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