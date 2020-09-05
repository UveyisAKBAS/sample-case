package com.example.samplecase.data.report.remote

import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.util.convertToString
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class ReportRemoteDataSource @Inject constructor(
    private val reportService: ReportService
) : RemoteDataSource {

    override fun fetchReports(startDate: Date): Observable<ReportResponse> {
        return reportService.getAllReports(
            startDate.convertToString()
        )
    }
}
