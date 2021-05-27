package com.example.athlete_monitor_system.Coach_Sys;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
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

public class talk extends AppCompatActivity {
    private Button send;
    private MultiAutoCompleteTextView coach_talk;
    private TextView athlete_send, sender;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("coach_message"),
            myRef = FirebaseDatabase.getInstance().getReference().child("athlete_message");
    String cache = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        coach_talk = findViewById(R.id.user_mes);
        athlete_send = findViewById(R.id.sender_mes);
        sender = findViewById(R.id.sender);
        send = findViewById(R.id.send_button);
        getMessage();
        sentMessage();
    }

    /**
     * Receive athlete message from the firebase database
     */
    public void getMessage() {
        sender.setText("Coach:");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cache = dataSnapshot.getValue(String.class);
                if (cache != null)
                    athlete_send.setText(cache);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("talk", "Failed to read value.", databaseError.toException());
            }
        });
    }

    /**
     * Sent coach message to the firebase database
     * add current user name after the massage
     */
    public void sentMessage() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache = coach_talk.getText().toString().trim();
                mDatabase.setValue(cache);
                coach_talk.setText("");
                Message("Your send operation was successful");
            }
        });
    }

    public void Message(String s) {
        Toast toast = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}

