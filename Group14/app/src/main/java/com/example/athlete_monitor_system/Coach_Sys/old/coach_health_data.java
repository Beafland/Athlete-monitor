package com.example.athlete_monitor_system.Coach_Sys.old;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.athlete_monitor_system.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class coach_health_data extends AppCompatActivity {
    private TextView weight;
    private TextView waistline;
    private TextView height;
    private TextView muscle_mass;
    private TextView name;
    private TextView fat_mass;
    private Button search;
    private EditText searchName;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    String[] array;
    String d;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_health_data);
        weight = findViewById(R.id.weight);
        waistline = findViewById(R.id.waistline);
        height = findViewById(R.id.height);
        muscle_mass = findViewById(R.id.muscle_mass);
        name = findViewById(R.id.name);
        fat_mass = findViewById(R.id.fat_mass);
        search = findViewById(R.id.search);
        searchName = findViewById(R.id.searchName);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = searchName.getText().toString();
                DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child(key);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        d = dataSnapshot.getValue(String.class);
                        array = d.split("&&&");
                        name.setText(array[0]);
                        height.setText(array[1]);
                        weight.setText(array[2]);
                        waistline.setText(array[3]);
                        muscle_mass.setText(array[4]);
                        fat_mass.setText(array[5]);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w("coach_health_data","Failed to read value.", databaseError.toException());
                    }
                });
            }
        });
    }
    public void Messag(String s){
        Toast toast = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
