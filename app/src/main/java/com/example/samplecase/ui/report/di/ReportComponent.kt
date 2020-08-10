package com.example.samplecase.ui.report.di

import com.example.samplecase.ui.report.ReportListFragment
import dagger.Subcomponent

@Subcomponent(modules = [ReportModule::class])
interface ReportComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ReportComponent
    }

    fun inject(fragment: ReportListFragment)
}
