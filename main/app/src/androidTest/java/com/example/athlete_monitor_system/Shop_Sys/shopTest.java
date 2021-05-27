package com.example.athlete_monitor_system.Shop_Sys;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.R;
import com.example.athlete_monitor_system.Shop_Sys.add_product;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class shopTest {
    @Rule
    public ActivityTestRule<shop> SActivityTestRule = new ActivityTestRule<>(shop.class);

    private shop SActivity = null;

    Instrumentation.ActivityMonitor monitor1 = getInstrumentation().addMonitor(buy_product.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(add_product.class.getName(),null,false);

    @Before
    public void setUp() {
        SActivity = SActivityTestRule.getActivity();
    }

    @Test
    public void testShopping() {
        assertNotNull(SActivity.findViewById(R.id.shopping));
        onView(withId(R.id.shopping)).perform(click());
        Activity buy_product = getInstrumentation().waitForMonitorWithTimeout(monitor1, 3000);
        assertNotNull(buy_product);
        buy_product.finish();
    }

    @Test
    public void testAddProduct() {
        assertNotNull(SActivity.findViewById(R.id.add_product));
        onView(withId(R.id.add_product)).perform(click());
        Activity add_product = getInstrumentation().waitForMonitorWithTimeout(monitor2, 3000);
        assertNotNull(add_product);
        add_product.finish();
    }

}