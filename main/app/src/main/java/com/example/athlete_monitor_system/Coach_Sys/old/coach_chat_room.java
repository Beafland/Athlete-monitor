package com.example.athlete_monitor_system.Coach_Sys.old;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.athlete_monitor_system.Coach_Sys.talk;
import com.example.athlete_monitor_system.Coach_Sys.talk2;
import com.example.athlete_monitor_system.Coach_Sys.talk3;
import com.example.athlete_monitor_system.Coach_Sys.talk4;
import com.example.athlete_monitor_system.R;


public class coach_chat_room extends AppCompatActivity {

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
                startActivity(new Intent(coach_chat_room.this, talk.class));
            }
        });

        room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(coach_chat_room.this, talk2.class));
            }
        });

        room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(coach_chat_room.this, talk3.class));
            }
        });
        room4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(coach_chat_room.this, talk4.class));
            }
        });
    }


}