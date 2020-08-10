package com.example.samplecase.data.report

import com.example.samplecase.data.report.mapper.ReportMapper
import com.example.samplecase.domain.report.model.ReportItem
import java.util.*

class ReportRemoteDataSource constructor(
    private val reportService: ReportService, private val reportMapper: ReportMapper
) {
    suspend fun getAllReports(startDate: Date): List<ReportItem>? {
        val reportResponse = reportService.getAllReports(
            startDate.toString()
        )
        return reportMapper.map(reportResponse)
    }
}
