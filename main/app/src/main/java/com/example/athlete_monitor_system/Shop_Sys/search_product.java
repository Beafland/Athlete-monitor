package com.example.athlete_monitor_system.Shop_Sys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.athlete_monitor_system.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class search_product extends AppCompatActivity {
    FirebaseFirestore db;
    ArrayList<Product> list;
    RecyclerView recyclerView;
    SearchView searchView;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        db = FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.product_recycler_view);
        searchView = findViewById(R.id.search_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

//    protected void onStart() {
//        super.onStart();
//        db.collection("ProductList")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
//                                Map<String, Object> map = document.getData();
//                                String name = (String)map.get("name");
//                                String price = (String)map.get("price");
//                                Product newProduct = new Product(name, price);
//                                list.add(newProduct);
//                            }
//                            ProductAdapter productAdapter = new ProductAdapter(list);
//                            recyclerView.setAdapter(productAdapter);
//                        } else {
//
//                        }
//                    }
//                });
//        if (searchView != null){
//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    search(newText);
//                    return true;
//                }
//            });
//        }
//    }

//    public void search(String str) {
//        ArrayList<Product> myList = new ArrayList<>();
//        for(Product product: list){
//            if(product.getName().toLowerCase().contains(str.toLowerCase())){
//                myList.add(product);
//            }
//        }
//        ProductAdapter productAdapter = new ProductAdapter(myList);
//        recyclerView.setAdapter(productAdapter);
//    }
}