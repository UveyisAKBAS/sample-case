package com.example.samplecase.di.modules

import com.example.samplecase.ui.report.ReportListRecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
class ReportListRecyclerAdapterModule {

    @Provides
    fun provideReportListRecyclerAdapter(): ReportListRecyclerAdapter {
        return ReportListRecyclerAdapter()
    }
}
