package com.example.samplecase.di.modules

import com.example.samplecase.di.scopes.FragmentScope
import com.example.samplecase.ui.datepicker.DatePickerFragment
import com.example.samplecase.ui.detail.ReportDetailsFragment
import com.example.samplecase.ui.payment.PaymentFragment
import com.example.samplecase.ui.report.ReportListFragment
import com.example.samplecase.ui.report.ReportListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDatePickerFragment(): DatePickerFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ReportListModule::class])
    abstract fun bindReportListFragment(): ReportListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindReportDetailsFragment(): ReportDetailsFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindPaymentFragment(): PaymentFragment
}
