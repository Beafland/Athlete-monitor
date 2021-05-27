package com.example.athlete_monitor_system.Shop_Sys;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.athlete_monitor_system.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class buy_product extends AppCompatActivity implements ProductClickListener{
    private  ViewPager view_pager;
    private List<Integer> my_data = new ArrayList<>();
    FirebaseFirestore db;
    ArrayList<Product> list;
    ArrayList<Product> addedList;
    RecyclerView recyclerView;
    SearchView searchView;
    Button cart;
    private RecyclerView.LayoutManager layoutManager;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);
        initView();
        initData();
        db = FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.product_recycler_view);
        searchView = findViewById(R.id.search_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        cart = findViewById(R.id.cart_button);
        addedList = new ArrayList<>();

        db.collection("ProductList")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        showList(task);
                    }
                });
        if (searchView != null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }
        if(cart !=null){
            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(buy_product.this, Cart.class);
                    intent.putExtra("List", addedList);
                    startActivity(intent);
                }
            });
        }
    }


    public void showList(Task<QuerySnapshot> task){
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                Map<String, Object> map = document.getData();
                String name = (String)map.get("name");
                String price = (String)map.get("price");
                Product newProduct = new Product(name, price);
                list.add(newProduct);
            }
            ProductAdapter productAdapter = new ProductAdapter(list, this);
            recyclerView.setAdapter(productAdapter);
        }
    }

    public void search(String str) {
        ArrayList<Product> myList = new ArrayList<>();
        for(Product product: list){
            if(product.getName().toLowerCase().contains(str.toLowerCase())){
                myList.add(product);
            }
        }
        ProductAdapter productAdapter = new ProductAdapter(myList, this);
        recyclerView.setAdapter(productAdapter);
    }

    private void initData() {
        my_data.add(R.mipmap.shoes1);
        my_data.add(R.mipmap.shoes2);
        my_data.add(R.mipmap.shoes3);
        mPagerAdapter.notifyDataSetChanged();
        view_pager.setCurrentItem(Integer.MAX_VALUE / 2 + 1);
    }

    private void initView() {
        view_pager = this.findViewById(R.id.view_pager);
        view_pager.setAdapter(mPagerAdapter);


    }

    private PagerAdapter mPagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View item = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_item_pager, container, false);
            ImageView iv = item.findViewById(R.id.cover);
            int realPosition = position % my_data.size();
            iv.setImageResource(my_data.get(realPosition));
            if(iv.getParent() instanceof ViewGroup)
            {
                ((ViewGroup) iv.getParent()).removeView(iv);
            }
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }
    };


    @Override
    public void productClicked(View v, int position) {
        addedList.add(list.get(position));
    }
}
