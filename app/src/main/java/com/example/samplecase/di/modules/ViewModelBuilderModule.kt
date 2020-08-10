package com.example.samplecase.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.samplecase.di.ViewModelFactory
import com.example.samplecase.di.ViewModelKey
import com.example.samplecase.ui.report.ReportListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelBuilderModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ReportListViewModel::class)
    abstract fun bindReportListViewModel(viewModel: ReportListViewModel): ViewModel
}
