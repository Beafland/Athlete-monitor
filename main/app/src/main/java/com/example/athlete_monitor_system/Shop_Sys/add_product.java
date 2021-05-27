package com.example.athlete_monitor_system.Shop_Sys;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.athlete_monitor_system.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class add_product extends AppCompatActivity {

    private EditText name;
    private EditText price;
    private Button submit;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
//        initialize the activity
        super.onCreate(savedInstanceState);
      /*  Define UI, set the activity content from the 'activity_add_product' layout resource.
          The 'activity_add_product' will be inflated, adding all top-level views to the activity
      */
        setContentView(R.layout.activity_add_product);
//        name of the product, the name of the product need to be saved in the shopping class
        name = findViewById(R.id.name);
//        non-zero value, data type should be double
        price = findViewById(R.id.price);
//        Here needed to be tested when input empty/wrong value in name and price
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Price = price.getText().toString();
                if(condition2(Name,Price)){
                   add(view);
                   Message("Uploaded successfully");
               }
               else{
                   Message("Can not be empty");
               }

            }
        });
    }

    public void add (View v) {
        String newname = name.getText().toString();
        String newprice = price.getText().toString();
        //set a map to store the information

        Map<String, Object> product = new HashMap<>();
        condition(newname,newprice,product);

        db.collection("ProductList")
                .add(product)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("add", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("add", "Error adding document", e);
                    }
                });
    }

    public void Message(String s){
        Toast toast = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public void condition(String newname, String newprice,Map<String, Object> product){
        if(newname != null && newprice !=null) {
            product.put("name", newname);
            product.put("price", newprice);
        }
    }
    public boolean condition2(String name, String price) {
        return name.length() != 0 && price.length() != 0;
    }
}
