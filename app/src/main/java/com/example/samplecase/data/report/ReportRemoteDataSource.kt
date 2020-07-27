package com.example.samplecase.data.report

import com.example.samplecase.data.report.mapper.ReportMapper
import com.example.samplecase.data.report.model.ReportResponse
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.net.ResponseCallback
import com.example.samplecase.net.ServiceProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ReportRemoteDataSource {

    private val reportService: ReportService by lazy {
        ServiceProvider.provideService(ReportService::class.java)
    }

    fun getAllReports(startDate: String, callback: ResponseCallback<List<ReportItem>>) {
        reportService.getAllReports(startDate).enqueue(object : Callback<ReportResponse> {
            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                callback.onError(t)
            }

            override fun onResponse(
                call: Call<ReportResponse>,
                response: Response<ReportResponse>
            ) {

                response.body()?.let { reportResponse ->
                    ReportMapper.map(reportResponse).let {
                        callback.onResponse(it)
                    }
                }

            }

        })
    }

}