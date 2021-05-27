package com.example.athlete_monitor_system.Shop_Sys;

import android.app.Instrumentation;
import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.R;
import com.example.athlete_monitor_system.Shop_Sys.buy_product;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class buy_productTest {

    @Rule
    public ActivityTestRule<buy_product> SActivityTestRule = new ActivityTestRule<>(buy_product.class);

    private buy_product SActivity = null;


    @Before
    public void setUp() {
        SActivity = SActivityTestRule.getActivity();
    }
    
    @Test
    public void testLaunch(){
        assertNotNull(SActivity.findViewById(R.id.view_pager));
    }
}