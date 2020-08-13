package com.example.samplecase.ui.rules

import androidx.lifecycle.ViewModelStore
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import org.junit.rules.ExternalResource


class NavigationRule(
    private val navigationGraphId: Int,
    private val currentDestinationId: Int
) :
    ExternalResource() {

    var navController: TestNavHostController? = null

    override fun before() {
        navController =
            TestNavHostController(ApplicationProvider.getApplicationContext()).apply {
                setViewModelStore(ViewModelStore())
                setGraph(navigationGraphId)
                setCurrentDestination(currentDestinationId)
            }
    }
}
