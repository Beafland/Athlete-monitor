package com.example.athlete_monitor_system;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.Athlete_Sys.old.athlete_chat_room;
import com.example.athlete_monitor_system.Athlete_Sys.old.athlete_leaderboard;
import com.example.athlete_monitor_system.Athlete_Sys.old.athlete_train;
import com.example.athlete_monitor_system.Athlete_Sys.old.health_data;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class AthleteTest {
    @Rule
    public ActivityTestRule<Athlete> AActivityTestRule = new ActivityTestRule<>(Athlete.class);

    private Athlete AActivity = null;

    Instrumentation.ActivityMonitor monitor1 = getInstrumentation().addMonitor(athlete_leaderboard.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(athlete_chat_room.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor3 = getInstrumentation().addMonitor(athlete_train.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor4 = getInstrumentation().addMonitor(health_data.class.getName(),null,false);

    @Before
    public void setUp() {
        AActivity = AActivityTestRule.getActivity();
    }

    @Test
    public void testButton1() {
        assertNotNull(AActivity.findViewById(R.id.a_leaderboard));
        onView(withId(R.id.a_leaderboard)).perform(click());
        Activity athlete_leaderboard = getInstrumentation().waitForMonitorWithTimeout(monitor1, 3000);
        assertNotNull(athlete_leaderboard);
        athlete_leaderboard.finish();
    }

    @Test
    public void testButton2() {
        assertNotNull(AActivity.findViewById(R.id.a_coach));
        onView(withId(R.id.a_coach)).perform(click());
        Activity athlete_chat_room = getInstrumentation().waitForMonitorWithTimeout(monitor2, 3000);
        assertNotNull(athlete_chat_room);
        athlete_chat_room.finish();
    }

    @Test
    public void testButton3() {
        assertNotNull(AActivity.findViewById(R.id.a_plan));
        onView(withId(R.id.a_plan)).perform(click());
        Activity athlete_train = getInstrumentation().waitForMonitorWithTimeout(monitor3, 3000);
        assertNotNull(athlete_train);
        athlete_train.finish();
    }

    @Test
    public void testButton4() {
        assertNotNull(AActivity.findViewById(R.id.healthdata));
        onView(withId(R.id.healthdata)).perform(click());
        Activity health_data = getInstrumentation().waitForMonitorWithTimeout(monitor4, 3000);
        assertNotNull(health_data);
        health_data.finish();
    }
}