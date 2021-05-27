package com.example.athlete_monitor_system.Athlete_Sys.old;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.athlete_monitor_system.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class health_data extends AppCompatActivity {
    private EditText weight, waistline, height, muscle_mass, name, fat_mass;
    private Button SUBMIT;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_data);
        weight = findViewById(R.id.weight);
        waistline = findViewById(R.id.waistline);
        height = findViewById(R.id.height);
        muscle_mass = findViewById(R.id.muscle_mass);
        name = findViewById(R.id.name);
        fat_mass = findViewById(R.id.fat_mass);
        SUBMIT = findViewById(R.id.SUBMIT);
        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().length() == 0)
                {
                    name.setText("   ");
                }
                if(weight.getText().toString().length() == 0)
                {
                    weight.setText("   ");
                }
                if(waistline.getText().toString().length() == 0)
                {
                    waistline.setText("   ");
                }
                if(height.getText().toString().length() == 0)
                {
                    height.setText("   ");
                }
                if(muscle_mass.getText().toString().length() == 0)
                {
                    muscle_mass.setText("   ");
                }
                if(fat_mass.getText().toString().length() == 0)
                {
                    fat_mass.setText("   ");
                }
                String data = name.getText().toString()+ "&&&" +height.getText().toString()+"&&&" + weight.getText().toString()+"&&&"+
                        waistline.getText().toString()+"&&&"+muscle_mass.getText().toString()+"&&&"+fat_mass.getText().toString();
                String n = name.getText().toString();
                mDatabase.child(n).setValue(data);
                Messag("Information uploaded successfully");
            }
        });
    }

    public void Messag(String s){
        Toast toast = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
