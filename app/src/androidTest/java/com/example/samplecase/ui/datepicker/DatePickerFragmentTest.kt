package com.example.samplecase.ui.datepicker

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragment
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.samplecase.R
import com.example.samplecase.ui.rules.NavigationRule
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatePickerFragmentTest {

    lateinit var datePickerScenario: FragmentScenario<DatePickerFragment>

    @get: Rule
    var navigationRule = NavigationRule(R.navigation.navigation_graph, R.id.dialog_date_picker)

    @Before
    fun launchFragment() {
        datePickerScenario = launchFragment<DatePickerFragment>()
        datePickerScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navigationRule.navController)
        }
    }

    @Test
    fun testUIComponentsVisibility() {
        datePickerScenario.onFragment { fragment ->
            assertThat(fragment.dialog).isNotNull()
            assertThat(fragment.requireDialog().isShowing).isTrue()
        }
        onView(withId(R.id.buttonSelectDate)).check(matches(isDisplayed()))
        onView(withId(R.id.datePicker)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigationFromDatePickerFragmentToReportListFragment() {
        onView(withId(R.id.buttonSelectDate)).perform(ViewActions.click())
        assertThat(navigationRule.navController?.currentDestination?.id).isEqualTo(R.id.fragment_report_list)
    }
}
