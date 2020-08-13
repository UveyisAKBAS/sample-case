package com.example.samplecase.ui.report

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.samplecase.R
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.ui.rules.NavigationRule
import com.example.samplecase.view.base.BaseViewHolder
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ReportListFragmentTest {

    lateinit var reportListScenario: FragmentScenario<ReportListFragment>

    @get: Rule
    var navigationRule = NavigationRule(R.navigation.navigation_graph, R.id.fragment_report_list)

    @Before
    fun launchFragment() {
        reportListScenario = launchFragmentInContainer {
            ReportListFragment().also { fragment ->
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        Navigation.setViewNavController(
                            fragment.requireView(),
                            navigationRule.navController
                        )
                    }
                }
            }
        }
        //TODO change Thread.Sleep with idling resources
        Thread.sleep(3000)
    }

    @Test
    fun verifyUIVisibility() {
        onView(withId(R.id.buttonDate)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewReportList)).check(matches(isDisplayed()))
    }

    @Test
    fun testVisibilityOfFirstItemOfRecyclerView() {
        onView(withId(R.id.recyclerViewReportList)).perform(
            RecyclerViewActions.scrollToPosition<BaseViewHolder<ReportItem>>(
                0
            )
        )
        //TODO change the way of getting text
        onView(withText("Twitch gives traditional sporting streams their own category")).check(
            matches(isDisplayed())
        )
    }

    @Test
    fun testNavigationFromReportListFragmentToDatePickerFragment() {
        onView(withId(R.id.buttonDate)).perform(ViewActions.click())
        assertThat(navigationRule.navController?.currentDestination?.id).isEqualTo(R.id.dialog_date_picker)
    }
}
