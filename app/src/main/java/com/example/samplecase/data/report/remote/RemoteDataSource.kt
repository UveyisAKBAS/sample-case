package com.example.samplecase.data.report.remote

import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.base.BaseDataSource
import io.reactivex.Observable
import java.util.*

interface RemoteDataSource : BaseDataSource {

    fun fetchReports(startDate: Date): Observable<ReportResponse>
}
