package com.example.samplecase.data.report.remote

import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.report.ReportDataSource
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.util.convertToString
import java.util.*
import javax.inject.Inject

class ReportRemoteDataSource @Inject constructor(
    private val reportService: ReportService
) : ReportDataSource {

    override suspend fun getAllReports(startDate: Date): ReportResponse {
        return reportService.getAllReports(
            startDate.convertToString()
        )
    }
}
