package com.example.athlete_monitor_system.Shop_Sys;

import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class add_productTest {

    @Rule
    public ActivityTestRule<add_product> aActivityTestRule = new ActivityTestRule<>(add_product.class);

    private add_product aActivity = null;


    @Before
    public void setUp(){
        aActivity = aActivityTestRule.getActivity();
    }


    @Test
    public void message() {
        assertNotNull(aActivity.findViewById(R.id.submit));
        assertNotNull(aActivity.findViewById(R.id.name));
        assertNotNull(aActivity.findViewById(R.id.price));
    }

    @Test
    public void condition() {
        String name = null;
        String price= null;
        Map<String, Object> product = new HashMap<>();
        aActivity.condition(name,price,product);
        assertTrue(product.isEmpty());
    }
    @Test
    public void condition2() {
        String name = "";
        String price = "";
        assertFalse(aActivity.condition2(name,price));
    }
}