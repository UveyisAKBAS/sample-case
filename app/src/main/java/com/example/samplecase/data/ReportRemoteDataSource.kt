package com.example.samplecase.data

import com.example.samplecase.data.mapper.ReportMapper
import com.example.samplecase.data.model.ReportResponse
import com.example.samplecase.data.net.ReportService
import com.example.samplecase.data.net.ResponseCallback
import com.example.samplecase.data.net.ServiceProvider
import com.example.samplecase.domain.report.model.Report
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ReportRemoteDataSource {

    private val reportService: ReportService by lazy {
        ServiceProvider.provideService(ReportService::class.java)
    }

    fun getAllReports(startDate: String, callback: ResponseCallback<List<Report>>) {
        reportService.getAllReports(startDate).enqueue(object : Callback<ReportResponse> {
            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                callback.onError(t)
            }

            override fun onResponse(
                call: Call<ReportResponse>,
                response: Response<ReportResponse>
            ) {
                //callback.onResponse(response.body()!!)
                ReportMapper.mapToReport(response.body())?.let {
                    callback.onResponse(it)
                }
            }

        })
    }

}