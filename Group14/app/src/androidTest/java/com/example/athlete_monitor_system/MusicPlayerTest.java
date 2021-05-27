package com.example.athlete_monitor_system;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MusicPlayerTest {
    private MusicPlayer mActivity = null;

    @Rule
    public ActivityTestRule<MusicPlayer> musicPlayerActivityTestRule = new ActivityTestRule<>(MusicPlayer.class);

    @Before
    public void setUp() {
        mActivity = musicPlayerActivityTestRule.getActivity();
    }


    @Test
    public void testLaunch(){
        assertNotNull(mActivity.findViewById(R.id.music_start));
        assertNotNull(mActivity.findViewById(R.id.music_pause));
    }

    @Test
    public void mediaPlayer(){
        assertNotNull(mActivity.mediaPlayer);
    }
}