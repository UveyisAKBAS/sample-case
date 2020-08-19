package com.example.samplecase.di.modules

import com.example.samplecase.data.report.remote.ReportRemoteDataSource
import com.example.samplecase.data.report.remote.mapper.ReportMapper
import com.example.samplecase.domain.report.ReportDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Module
    companion object {
        @Singleton
        @Provides
        fun provideReportMapper(): ReportMapper {
            return ReportMapper()
        }
    }

    @Binds
    @Singleton
    abstract fun provideReportRemoteDataSource(reportRemoteDataSource: ReportRemoteDataSource): ReportDataSource
}
