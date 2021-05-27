package com.example.athlete_monitor_system.Shop_Sys;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class cartTest {
    @Rule
    public ActivityTestRule<buy_product> activityTestRule = new ActivityTestRule<>(buy_product.class);

    @Before
    public void setUp() {
        Intents.init();
        onView(ViewMatchers.withId(R.id.cart_button)).perform(click());
    }

    @Test
    public void testCart(){
        intended(hasComponent(Cart.class.getName()));
    }
}
