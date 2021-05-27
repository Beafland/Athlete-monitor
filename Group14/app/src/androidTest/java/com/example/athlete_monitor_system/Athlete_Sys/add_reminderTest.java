package com.example.athlete_monitor_system.Athlete_Sys;

import android.content.Context;

import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.Login_Sys.RegisterActivity;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class add_reminderTest {

    @Test
    public void insertCalendarEvent1() {
        Context context = null;
        String title = "miles";
        String description = "123";
        long beginTimeMillis = 123;
        long endTimeMillis = 124;
        assertFalse(add_reminder.insertCalendarEvent(context,title,description,beginTimeMillis,endTimeMillis));
    }
    @Test
    public void insertCalendarEvent2() {
        Context context = null;
        String title = "miles";
        String description = "";
        long beginTimeMillis = 123;
        long endTimeMillis = 124;
        assertFalse(add_reminder.insertCalendarEvent(context,title,description,beginTimeMillis,endTimeMillis));
    }
}