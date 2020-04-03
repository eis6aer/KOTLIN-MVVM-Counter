package com.globant.counter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun onPressIncUpdateLabel() {
        onView(withId(R.id.countBtnInc)).perform(click())
        onView(withId(R.id.countLabel)).check(matches(withText(ONE)))
    }

    @Test
    fun onPressDecUpdateLabel() {
        onView(withId(R.id.countBtnDec)).perform(click())
        onView(withId(R.id.countLabel)).check(matches(withText(MINUS_ONE)))
    }

    @Test
    fun onPressResetUpdateLabel() {
        onView(withId(R.id.resetBtn)).perform(click())
        onView(withId(R.id.countLabel)).check(matches(withText(ZERO)))
    }

    companion object {
        private const val ZERO = "0"
        private const val MINUS_ONE = "-1"
        private const val ONE = "1"
    }
}
