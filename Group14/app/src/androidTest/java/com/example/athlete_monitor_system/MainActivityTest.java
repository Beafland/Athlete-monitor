package com.example.athlete_monitor_system;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.Login_Sys.LoginActivity;
import com.example.athlete_monitor_system.Shop_Sys.shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor1 = getInstrumentation().addMonitor(coach.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(Athlete.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor3 = getInstrumentation().addMonitor(shop.class.getName(),null,false);

    @Before
    public void setUp() {
        mActivity = mActivityTestRule.getActivity();
    }


    /**
     * Conform the main main page is loading correctly
     * main text and Logout button is loaded on the screen
     */
    @Test
    public void testLaunch(){
        assertNotNull(mActivity.findViewById(R.id.userInfor));
        assertNotNull(mActivity.findViewById(R.id.logout));
    }


    /**
     * Conform the logout button is working
     * the logout page is working correctly
     */
    @Test
    public void testLogoutButton(){
        assertNotNull(mActivity.findViewById(R.id.logout));
        onView(withId(R.id.logout)).perform(click());
        Activity loginActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,3000);

        assertNotNull(loginActivity);
        loginActivity.finish();
    }
/*

    @Test
    public void testCoachButton(){
        assertNotNull(mActivity.findViewById(R.id.coach));
        onView(withId(R.id.coach)).perform(click());
        Activity coach = getInstrumentation().waitForMonitorWithTimeout(monitor1,3000);

        assertNotNull(coach);
        coach.finish();
    }

    @Test
    public void testAthleteButton(){
        assertNotNull(mActivity.findViewById(R.id.athlete));
        onView(withId(R.id.athlete)).perform(click());
        Activity Athlete = getInstrumentation().waitForMonitorWithTimeout(monitor2,3000);

        assertNotNull(Athlete);
        Athlete.finish();
    }
*/

    @Test
    public void testShopButton(){
        assertNotNull(mActivity.findViewById(R.id.shop));
        onView(withId(R.id.shop)).perform(click());
        Activity shop = getInstrumentation().waitForMonitorWithTimeout(monitor3,3000);

        assertNotNull(shop);
        shop.finish();
    }

    @After
    public void tearDown() {
        mActivity = null;
    }
}