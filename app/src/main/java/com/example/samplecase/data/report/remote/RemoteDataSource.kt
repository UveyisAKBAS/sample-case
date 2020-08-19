package com.example.samplecase.data.report.remote

import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.base.BaseDataSource
import java.util.*

interface RemoteDataSource : BaseDataSource {

    suspend fun fetchReports(startDate: Date): ReportResponse
}
