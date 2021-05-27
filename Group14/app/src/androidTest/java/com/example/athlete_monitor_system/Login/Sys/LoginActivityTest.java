package com.example.athlete_monitor_system.Login.Sys;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.annotation.UiThreadTest;
import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.Login_Sys.LoginActivity;
import com.example.athlete_monitor_system.Login_Sys.RegisterActivity;
import com.example.athlete_monitor_system.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> lActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    private LoginActivity lActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(RegisterActivity.class.getName(),null,false);

    @Before
    public void setUp() {
        lActivity = lActivityTestRule.getActivity();
    }

    /**
     * Conform the main login page is loading correctly
     * Login page and login button is loaded on the screen
     */
    @Test
    public void testLaunch(){
        View view = lActivity.findViewById(R.id.loginPage);
        assertNotNull(view);
        assertNotNull(lActivity.findViewById(R.id.login));
    }

    /**
     * Conform the register button is working
     * the signup page is working correctly
     */
    @Test
    public void testRegisterButton(){
        assertNotNull(lActivity.findViewById(R.id.register));
        onView(withId(R.id.register)).perform(click());
        Activity registerActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,3000);

        assertNotNull(registerActivity);

        registerActivity.finish();
    }

    /**
     * check if user do not enter any of the information
     */
    @Test
    @UiThreadTest
    public void testUserNullInput() {
        lActivity.setUser("", "");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("1", "");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("", "1");
        assertFalse(lActivity.checkUserInput());
    }

    /**
     * Check if user enter email with wrong format
     * format(****@**.**(word only))
     */
    @Test
    @UiThreadTest
    public void testUserWrongEmail() {
        lActivity.setUser("123", "123456");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("@#$%^&*", "123456");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("123@", "123456");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("123@q", "123456");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("123@#.com", "123456");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("123#.com", "123456");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("123#1.com", "123456");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("123@1.com", "123456");
        assertTrue(lActivity.checkUserInput());
    }

    /**
     * test if user enter password in wrong foramt
     * including the wrong confirm password in second time
     */
    @Test
    @UiThreadTest
    public void testUserWrongPwd() {
        lActivity.setUser("123@123.com", "");
        assertFalse(lActivity.checkUserInput());
        lActivity.setUser("123@123.com", "123");
        assertFalse(lActivity.checkUserInput());
    }

    /**
     * Check if user enter information in format
     */
    @Test
    @UiThreadTest
    public void testUserCorrectInput() {
        lActivity.setUser("123@123.com", "123456");
        assertTrue(lActivity.checkUserInput());
        lActivity.setUser("123@dal.ca", "123456");
        assertTrue(lActivity.checkUserInput());
        lActivity.setUser("qweasd123@dal.ca", "123456");
        assertTrue(lActivity.checkUserInput());
    }

    @After
    public void tearDown(){

        lActivity = null;

    }
}