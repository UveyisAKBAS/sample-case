package com.example.samplecase.di.modules

import com.example.samplecase.data.report.ReportRemoteDataSource
import com.example.samplecase.data.report.ReportService
import com.example.samplecase.data.report.mapper.ReportMapper
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ReportRemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideReportRemoteDataSource(
        reportService: ReportService, reportMapper: ReportMapper
    ): ReportRemoteDataSource {
        return ReportRemoteDataSource(reportService, reportMapper)
    }

    @Singleton
    @Provides
    fun provideReportService(): ReportService {
        return Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ReportService::class.java)
    }

    @Singleton
    @Provides
    fun provideReportMapper(): ReportMapper {
        return ReportMapper()
    }
}
