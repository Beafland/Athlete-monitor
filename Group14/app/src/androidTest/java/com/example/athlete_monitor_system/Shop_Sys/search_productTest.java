package com.example.athlete_monitor_system.Shop_Sys;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class search_productTest {

    @Rule
    public ActivityTestRule<search_product> sActivityTestRule = new ActivityTestRule<>(search_product.class);

    private search_product sActivity = null;


    @Before
    public void setUp(){
        sActivity = sActivityTestRule.getActivity();
    }

    @Test
    public void search() {
        ArrayList<Product> myList = new ArrayList<>();
        ArrayList<Product> List = new ArrayList<>();
        String name = "name";
        String price = "price";
        Product newProduct = new Product(name, price);
        myList.add(newProduct);
//        sActivity.search("name", List, myList);
        assertTrue(myList.contains(newProduct));
    }
}
