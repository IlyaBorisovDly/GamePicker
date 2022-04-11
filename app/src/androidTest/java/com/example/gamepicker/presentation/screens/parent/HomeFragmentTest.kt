package com.example.gamepicker.presentation.screens.parent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.gamepicker.R
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HomeFragmentTest {
    private lateinit var scenario: FragmentScenario<HomeFragment>

    @Before
    fun initScenario() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_GamePicker)
    }

    @Test
    fun fragmentShouldHaveItsOwnContext() {
        scenario.onFragment { fragment ->
            Assert.assertNotNull(fragment.context)
        }
    }

    @After
    fun finishScenario() {
        scenario.close()
    }
}