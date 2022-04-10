package com.example.gamepicker.presentation.screens

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.gamepicker.R
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CategoriesListFragmentTest {

    private lateinit var scenario: FragmentScenario<CategoriesListFragment>

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

    @Test
    fun categoriesViewShouldHaveProperStringReference() {
        onView(
            withId(R.id.textViewCategoriesHeader)
        ).check(
            matches(
                withText(R.string.categories)
            )
        )
    }

    @After
    fun finishScenario() {
        scenario.close()
    }
}