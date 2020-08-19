package com.example.samplecase.data

import com.example.samplecase.data.report.remote.mapper.ReportMapper
import com.example.samplecase.domain.report.ReportDataSource
import com.example.samplecase.domain.report.model.ReportItem
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val reportDataSource: ReportDataSource,
    private val reportMapper: ReportMapper
) {

    suspend fun getAllReports(startDate: Date): List<ReportItem>? {
        val reportResponse = reportDataSource.getAllReports(startDate)
        return reportMapper.map(reportResponse)
    }
}
