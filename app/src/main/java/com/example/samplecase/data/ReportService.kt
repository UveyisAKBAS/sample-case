package com.example.samplecase.data

import com.example.samplecase.data.model.ReportResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReportService {

    @GET("everything?q=football&sortBy=publishedAt&apiKey=ae68088e70d04639b4950bdc9d546924")
    fun getAllReports(@Query("from") startDate: String) : Call<ReportResponse>
}


