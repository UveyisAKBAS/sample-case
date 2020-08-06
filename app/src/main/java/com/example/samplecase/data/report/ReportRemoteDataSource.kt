package com.example.samplecase.data.report

import com.example.samplecase.data.report.mapper.ReportMapper
import com.example.samplecase.domain.report.model.ReportItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReportRemoteDataSource @Inject constructor(
    private val reportService: ReportService, private val reportMapper: ReportMapper
) {

    suspend fun getAllReports(startDate: String): List<ReportItem>? {
        val reportResponse = reportService.getAllReports(startDate)
        return reportMapper.map(reportResponse)
    }
}
