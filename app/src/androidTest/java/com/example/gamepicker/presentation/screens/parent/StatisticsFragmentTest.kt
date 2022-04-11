package com.example.gamepicker.presentation.screens.parent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import com.example.gamepicker.R
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StatisticsFragmentTest  {
    private lateinit var scenario: FragmentScenario<StatisticsFragment>

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