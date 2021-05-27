package com.example.athlete_monitor_system;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.Coach_Sys.old.coach_chat_room;
import com.example.athlete_monitor_system.Coach_Sys.old.coach_health_data;
import com.example.athlete_monitor_system.Coach_Sys.old.coach_leaderboard;
import com.example.athlete_monitor_system.Coach_Sys.old.coach_train;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class coachTest {

    @Rule
    public ActivityTestRule<coach> cActivityTestRule = new ActivityTestRule<>(coach.class);

    private coach cActivity = null;

    Instrumentation.ActivityMonitor monitor1 = getInstrumentation().addMonitor(coach_chat_room.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(coach_leaderboard.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor3 = getInstrumentation().addMonitor(coach_train.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor4 = getInstrumentation().addMonitor(coach_health_data.class.getName(),null,false);

    @Before
    public void setUp() {
        cActivity = cActivityTestRule.getActivity();
    }

    @Test
    public void testButton1() {
        assertNotNull(cActivity.findViewById(R.id.talk));
        onView(withId(R.id.talk)).perform(click());
        Activity coach_chat_room = getInstrumentation().waitForMonitorWithTimeout(monitor1, 3000);
        assertNotNull(coach_chat_room);
        coach_chat_room.finish();
    }
    @Test
    public void testButton2() {
        assertNotNull(cActivity.findViewById(R.id.leaderboard));
        onView(withId(R.id.leaderboard)).perform(click());
        Activity coach_leaderboard  = getInstrumentation().waitForMonitorWithTimeout(monitor2, 3000);
        assertNotNull(coach_leaderboard );
        coach_leaderboard .finish();
    }
    @Test
    public void testButton3() {
        assertNotNull(cActivity.findViewById(R.id.train));
        onView(withId(R.id.train)).perform(click());
        Activity coach_train = getInstrumentation().waitForMonitorWithTimeout(monitor3, 3000);
        assertNotNull(coach_train);
        coach_train.finish();
    }
    @Test
    public void testButton4() {
        assertNotNull(cActivity.findViewById(R.id.healthData));
        onView(withId(R.id.healthData)).perform(click());
        Activity coach_health_data = getInstrumentation().waitForMonitorWithTimeout(monitor4, 3000);
        assertNotNull(coach_health_data);
        coach_health_data.finish();
    }
}