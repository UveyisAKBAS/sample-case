package com.example.samplecase.data.report.remote

import com.example.samplecase.data.report.remote.mapper.ReportMapper
import com.example.samplecase.domain.report.ReportDataSource
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.util.convertToString
import java.util.*
import javax.inject.Inject

class ReportRemoteDataSource @Inject constructor(
    private val reportService: ReportService,
    private val reportMapper: ReportMapper
) : ReportDataSource {

    override suspend fun getAllReports(startDate: Date): List<ReportItem>? {
        val reportResponse = reportService.getAllReports(
            startDate.convertToString()
        )
        return reportMapper.map(reportResponse)
    }
}
