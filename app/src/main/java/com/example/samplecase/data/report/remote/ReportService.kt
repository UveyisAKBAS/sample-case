package com.example.samplecase.data.report.remote

import com.example.samplecase.data.report.remote.model.ReportResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ReportService {

    @GET("everything?q=football&sortBy=popularity&apiKey=ae68088e70d04639b4950bdc9d546924")
    suspend fun getAllReports(@Query("from") startDate: String): ReportResponse
}
