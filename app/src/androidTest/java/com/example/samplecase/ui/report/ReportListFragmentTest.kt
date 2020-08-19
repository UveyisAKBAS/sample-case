package com.example.samplecase.ui.report

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.samplecase.R
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.ui.rules.NavigationRule
import com.example.samplecase.util.ReportIdlingResource
import com.example.samplecase.view.base.BaseViewHolder
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ReportListFragmentTest : FragmentScenario.FragmentAction<ReportListFragment> {

    private val TEST_ITEM_POSITION = 10

    private lateinit var reportListScenario: FragmentScenario<ReportListFragment>

    private var reportIdlingResource: ReportIdlingResource? = null

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
                perform(fragment)
            }
        }
    }

    @Test
    fun testUIComponentsVisibility() {
        onView(withId(R.id.buttonDate)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewReportList)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigationFromReportListFragmentToReportDetailFragment() {
        onView(withId(R.id.recyclerViewReportList)).perform(
            RecyclerViewActions.scrollToPosition<BaseViewHolder<ReportItem>>(TEST_ITEM_POSITION)
        )
        onView(withId(R.id.recyclerViewReportList)).perform(
            RecyclerViewActions.actionOnItemAtPosition<BaseViewHolder<ReportItem>>(
                TEST_ITEM_POSITION,
                click()
            )
        )
        assertThat(navigationRule.navController?.currentDestination?.id).isEqualTo(R.id.fragment_report_details)
    }

    @Test
    fun testNavigationFromReportListFragmentToDatePickerFragment() {
        onView(withId(R.id.buttonDate)).perform(click())
        assertThat(navigationRule.navController?.currentDestination?.id).isEqualTo(R.id.dialog_date_picker)
    }

    @After
    fun unregisterIdlingResource() {
        if (reportIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(reportIdlingResource);
        }
    }

    override fun perform(fragment: ReportListFragment) {
        reportIdlingResource = fragment.getIdlingResource()
        IdlingRegistry.getInstance().register(reportIdlingResource);
    }
}
