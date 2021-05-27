package com.example.athlete_monitor_system;

import com.example.athlete_monitor_system.Coach_Sys.old.coach_chat_room;
import com.example.athlete_monitor_system.Coach_Sys.old.coach_health_data;
import com.example.athlete_monitor_system.Coach_Sys.old.coach_leaderboard;
import com.example.athlete_monitor_system.Coach_Sys.old.coach_train;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class coach extends AppCompatActivity {
    private Button talk;
    private Button train;
    private Button leaderboard;
    private Button HealthData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);
        talk = findViewById(R.id.talk);
        train = findViewById(R.id.train);
        leaderboard = findViewById(R.id.leaderboard);
        HealthData = findViewById(R.id.healthData);
        talk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(coach.this, coach_chat_room.class));

            }
        });
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(coach.this, coach_train.class));

            }
        });
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(coach.this, coach_leaderboard.class));

            }
        });
        HealthData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(coach.this, coach_health_data.class));
            }
        });
    }
}

