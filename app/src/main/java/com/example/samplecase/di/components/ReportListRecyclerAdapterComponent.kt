package com.example.samplecase.di.components

import com.example.samplecase.di.modules.ReportListRecyclerAdapterModule
import com.example.samplecase.ui.report.ReportListFragment
import com.example.samplecase.ui.report.ReportListRecyclerAdapter
import dagger.Component
import dagger.Subcomponent

@Subcomponent(modules = [ReportListRecyclerAdapterModule::class])
interface ReportListRecyclerAdapterComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ReportListRecyclerAdapterComponent
    }

    fun getReportListRecyclerAdapter(): ReportListRecyclerAdapter
}
