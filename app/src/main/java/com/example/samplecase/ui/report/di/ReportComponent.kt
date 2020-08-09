package com.example.samplecase.ui.report.di

import com.example.samplecase.di.ViewModelFactory
import com.example.samplecase.di.scopes.ViewModelScope
import com.example.samplecase.ui.report.ReportListFragment
import dagger.Subcomponent
import javax.inject.Singleton

@Subcomponent(modules = [ReportModule::class])
interface ReportComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ReportComponent
    }

    fun inject(fragment: ReportListFragment)
}
