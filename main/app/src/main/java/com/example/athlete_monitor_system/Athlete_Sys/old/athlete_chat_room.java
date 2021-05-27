package com.example.athlete_monitor_system.Athlete_Sys.old;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.athlete_monitor_system.Athlete_Sys.Athlete_talk;
import com.example.athlete_monitor_system.Athlete_Sys.athlete_talk2;
import com.example.athlete_monitor_system.Athlete_Sys.athlete_talk3;
import com.example.athlete_monitor_system.Athlete_Sys.athlete_talk4;
import com.example.athlete_monitor_system.R;


public class athlete_chat_room extends AppCompatActivity {

    private Button room1, room2, room3, room4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_chat_room);
        room1 = findViewById(R.id.room1);
        room2 = findViewById(R.id.room2);
        room3 = findViewById(R.id.room3);
        room4 = findViewById(R.id.room4);

        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(athlete_chat_room.this, Athlete_talk.class));
            }
        });

        room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(athlete_chat_room.this, athlete_talk2.class));
            }
        });

        room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(athlete_chat_room.this, athlete_talk3.class));
            }
        });

        room4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(athlete_chat_room.this, athlete_talk4.class));
            }
        });
    }


}