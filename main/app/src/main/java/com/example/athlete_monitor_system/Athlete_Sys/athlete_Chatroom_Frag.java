package com.example.athlete_monitor_system.Athlete_Sys;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.athlete_monitor_system.R;

public class athlete_Chatroom_Frag extends Fragment {
    private Button room1, room2, room3, room4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chat_room, container, false);
        room1 = root.findViewById(R.id.room1);
        room2 = root.findViewById(R.id.room2);
        room3 = root.findViewById(R.id.room3);
        room4 = root.findViewById(R.id.room4);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(), Athlete_talk.class));
            }
        });

        room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(), athlete_talk2.class));
            }
        });

        room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(), athlete_talk3.class));
            }
        });

        room4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(), athlete_talk4.class));
            }
        });
    }
}
