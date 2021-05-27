package com.example.athlete_monitor_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.athlete_monitor_system.Login_Sys.LoginActivity;
import com.example.athlete_monitor_system.Shop_Sys.shop;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button coach, athlete, shop, music;
    private FirebaseAuth mAuth;
    private TextView helloText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        helloText = findViewById(R.id.userInfor);
        if(currentUser != null) {
            String name = currentUser.getDisplayName();
            helloText.setText("Welcome " + name);
        }

        music = findViewById(R.id.music);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MusicPlayer.class));
            }
        });

        coach = findViewById(R.id.coach);
        coach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CoachNev.class));
            }
        });
        athlete = findViewById(R.id.athlete);
        athlete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AthleteNev.class));
            }
        });
        shop = findViewById(R.id.shop);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, shop.class));
            }
        });
        logout();
    }

    private void logout(){
        Button btn_logout = findViewById(R.id.logout);
        mAuth.signOut();
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
}

