package com.example.samplecase.ui.report.di

import androidx.lifecycle.ViewModel
import com.example.samplecase.di.ViewModelKey
import com.example.samplecase.ui.report.ReportListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ReportModule {

    @Binds
    @IntoMap
    @ViewModelKey(ReportListViewModel::class)
    abstract fun bindViewModel(viewModel: ReportListViewModel): ViewModel
}
