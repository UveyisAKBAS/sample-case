package com.example.samplecase.data.report

import com.example.samplecase.data.report.mapper.ReportMapper
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.net.ServiceProvider

object ReportRemoteDataSource {

    private val reportService: ReportService by lazy {
        ServiceProvider.provideService(ReportService::class.java)
    }

    suspend fun getAllReports(startDate: String): List<ReportItem>? {

        val reportResponse = reportService.getAllReports(startDate)
        return ReportMapper.map(reportResponse)
    }
}