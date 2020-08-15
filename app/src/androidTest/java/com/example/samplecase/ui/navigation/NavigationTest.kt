package com.example.samplecase.ui.navigation

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.samplecase.R
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.ui.main.MainActivity
import com.example.samplecase.view.base.BaseViewHolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNavigation() {
        onView(withId(R.id.buttonDate)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonDate)).perform(click())

        onView(withId(R.id.datePicker)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonSelectDate)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonSelectDate)).perform(click())

        onView(withId(R.id.buttonDate)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewReportList)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewReportList)).perform(
            RecyclerViewActions.actionOnItemAtPosition<BaseViewHolder<ReportItem>>(0, click())
        )

        onView(withId(R.id.webViewReportDescription)).check(matches(isDisplayed()))
    }
}