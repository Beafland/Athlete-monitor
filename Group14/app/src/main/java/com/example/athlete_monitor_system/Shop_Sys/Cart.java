package com.example.athlete_monitor_system.Shop_Sys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.athlete_monitor_system.R;
import com.example.athlete_monitor_system.Shop_Sys.CartAdapter;
import com.example.athlete_monitor_system.Shop_Sys.Product;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    ArrayList<Product> list;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        list = (ArrayList<Product>) getIntent().getSerializableExtra("List");
        recyclerView = findViewById(R.id.cart_rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CartAdapter cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);
    }
}