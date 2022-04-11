package com.example.gamepicker.presentation

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gamepicker.R
import org.junit.Test
import org.junit.runner.RunWith

    @RunWith(AndroidJUnit4::class)
    class MainActivityTest {

        @Test fun mainActivityStartsWithHomeFragment() {
            launchActivity<MainActivity>().use {
                onView(withId(R.id.homeFragment)).check(matches(isDisplayed()))
            }
        }


    }
