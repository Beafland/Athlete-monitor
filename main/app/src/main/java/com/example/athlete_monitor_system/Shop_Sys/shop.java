package com.example.athlete_monitor_system.Shop_Sys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.athlete_monitor_system.R;

public class shop extends AppCompatActivity {
    private Button shopping;
    private Button add_product;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        shopping = findViewById(R.id.shopping);
        add_product = findViewById(R.id.add_product);
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(shop.this, buy_product.class));
            }
        });

        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(shop.this, com.example.athlete_monitor_system.Shop_Sys.add_product.class));
            }
        });

    }


}
