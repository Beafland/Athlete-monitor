package com.example.athlete_monitor_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.athlete_monitor_system.Athlete_Sys.old.athlete_chat_room;
import com.example.athlete_monitor_system.Athlete_Sys.old.athlete_leaderboard;
import com.example.athlete_monitor_system.Athlete_Sys.old.athlete_train;
import com.example.athlete_monitor_system.Athlete_Sys.old.health_data;

public class Athlete extends AppCompatActivity {
    private Button a_leaderboard;
    private Button a_plan;
    private Button a_coach;
    private Button healthData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete);
        a_leaderboard = findViewById(R.id.a_leaderboard);
        a_plan = findViewById(R.id.a_plan);
        a_coach = findViewById(R.id.a_coach);
        healthData = findViewById(R.id.healthdata);


        healthData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Athlete.this, health_data.class));

            }
        });
        a_leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Athlete.this, athlete_leaderboard.class));

            }
        });
        a_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Athlete.this, athlete_train.class));

            }
        });
        a_coach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Athlete.this, athlete_chat_room.class));

            }
        });
    }
}

