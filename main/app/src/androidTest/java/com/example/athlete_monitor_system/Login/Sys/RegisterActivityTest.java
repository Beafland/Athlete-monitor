package com.example.athlete_monitor_system.Login.Sys;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.annotation.UiThreadTest;
import androidx.test.rule.ActivityTestRule;

import com.example.athlete_monitor_system.R;
import com.example.athlete_monitor_system.Login_Sys.LoginActivity;
import com.example.athlete_monitor_system.Login_Sys.RegisterActivity;

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

public class RegisterActivityTest {

    @Rule
    public ActivityTestRule<RegisterActivity> rActivityTestRule = new ActivityTestRule<>(RegisterActivity.class);

    private RegisterActivity rActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false);

    @Before
    public void setUp(){
        rActivity = rActivityTestRule.getActivity();
    }

    /**
     * Conform the main Signup page is loading correctly
     * Signup page and Signup button is loaded on the screen
     */
    @Test
    public void testLaunch(){
        View view = rActivity.findViewById(R.id.RegisterPage);
        assertNotNull(view);
        assertNotNull(rActivity.findViewById(R.id.btn));
    }

    /**
     * Conform the register button is working
     * the signup page is working correctly
     */
    @Test
    public void testLoginButton(){
        assertNotNull(rActivity.findViewById(R.id.login));
        onView(withId(R.id.login)).perform(click());
        Activity loginActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,3000);

        assertNotNull(loginActivity);

        loginActivity.finish();
    }

    /**
     * check if user do not enter any of the information
     */
    @Test
    @UiThreadTest
    public void testUserNullInput() {
        rActivity.setUser("","", "", "");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("1","", "", "");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("","1", "", "");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("","", "1", "");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("","", "", "1");
        assertFalse(rActivity.checkUserInput());
    }

    /**
     * Check if user enter email with wrong format
     * format(****@**.**(word only))
     */
    @Test
    @UiThreadTest
    public void testUserWrongEmail() {
        rActivity.setUser("test","123", "123456", "123456");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","*&^&*^%%*", "123456", "123456");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","123@", "123456", "123456");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","123@q", "123456", "123456");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","123@#.com", "123456", "123456");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","123#.com", "123456", "123456");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","123#1.com", "123456", "123456");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","123@1.com", "123456", "123456");
        assertTrue(rActivity.checkUserInput());
    }

    /**
     * test if user enter password in wrong foramt
     * including the wrong confirm password in second time
     */
    @Test
    @UiThreadTest
    public void testUserWrongPwd() {
        rActivity.setUser("test","123@123.com", "", "123456");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","123@123.com", "123", "123456");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","123@123.com", "123456", "12345");
        assertFalse(rActivity.checkUserInput());
        rActivity.setUser("test","123@123.com", "123456", "");
        assertFalse(rActivity.checkUserInput());
    }

    /**
     * Check if user enter information in format
     */
    @Test
    @UiThreadTest
    public void testUserCorrectInput() {
        rActivity.setUser("test","123@123.com", "123456", "123456");
        assertTrue(rActivity.checkUserInput());
        rActivity.setUser("test","123@dal.ca", "123456", "123456");
        assertTrue(rActivity.checkUserInput());
        rActivity.setUser("test","qweasd123@dal.ca", "123456", "123456");
        assertTrue(rActivity.checkUserInput());
    }

    @After
    public void tearDown(){

        rActivity = null;

    }
}