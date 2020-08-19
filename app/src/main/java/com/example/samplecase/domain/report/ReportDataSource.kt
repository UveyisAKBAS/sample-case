package com.example.samplecase.domain.report

import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.base.BaseDataSource
import com.example.samplecase.domain.report.model.ReportItem
import java.util.*

interface ReportDataSource : BaseDataSource {

    suspend fun getAllReports(startDate: Date): ReportResponse
}
