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
        onView(withId(R.id.textViewCategoriesHeader))
            .check(matches(withText(R.string.categories)))
    }

    @Test
    fun categoriesMenuItemsShouldHaveCorrectValues() {
        onView(withId(R.id.textViewCategoriesCreators)).check(matches(withText(R.string.categories_creators)))
        onView(withId(R.id.textViewCategoriesPublishers)).check(matches(withText(R.string.categories_publishers)))
        onView(withId(R.id.textViewCategoriesDevelopers)).check(matches(withText(R.string.categories_developers)))
        onView(withId(R.id.textViewCategoriesGenres)).check(matches(withText(R.string.categories_genres)))
        onView(withId(R.id.textViewCategoriesPlatforms)).check(matches(withText(R.string.categories_platforms)))
    }

    @After
    fun finishScenario() {
        scenario.close()
    }
}