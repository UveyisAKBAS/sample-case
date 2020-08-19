package com.example.samplecase.di.modules

import com.example.samplecase.data.report.local.LocalDataSource
import com.example.samplecase.data.report.local.ReportLocalDataSource
import com.example.samplecase.data.report.local.mapper.ReportEntityMapper
import com.example.samplecase.data.report.remote.RemoteDataSource
import com.example.samplecase.data.report.remote.ReportRemoteDataSource
import com.example.samplecase.data.report.remote.mapper.ReportMapper
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

        @Singleton
        @Provides
        fun provideReportEntityMapper(): ReportEntityMapper {
            return ReportEntityMapper()
        }
    }

    @Binds
    @Singleton
    abstract fun provideReportRemoteDataSource(reportRemoteDataSource: ReportRemoteDataSource): RemoteDataSource

    @Binds
    @Singleton
    abstract fun provideReportLocalDataSource(reportLocalDataSource: ReportLocalDataSource): LocalDataSource
}
