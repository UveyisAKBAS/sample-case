package com.example.samplecase.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReportRemoteDataSource {

    var reportService: ReportService

    init {
        val baseUrl = "https://newsapi.org/v2/"
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()

        reportService = retrofit.create(ReportService::class.java)
    }


}