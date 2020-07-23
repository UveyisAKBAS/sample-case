package com.example.samplecase.ui.report

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.samplecase.data.ReportRemoteDataSource
import com.example.samplecase.data.model.ReportResponse
import com.example.samplecase.domain.report.model.Report
import retrofit2.Call
import retrofit2.Response

class ReportListViewModel : ViewModel() {

    private val TAG = "examination"

    internal val reportList = MutableLiveData<List<Report>>()

    private val reportService by lazy() {
        ReportRemoteDataSource.reportService
    }

    fun getReports(startDate: String) {

        reportService.getAllReports(startDate).enqueue(object : retrofit2.Callback<ReportResponse> {

            override fun onResponse(
                call: Call<ReportResponse>,
                response: Response<ReportResponse>
            ) {
                reportList.value = response.body()?.articles
                Log.i(TAG, "reportService succeeded")
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                Log.i(TAG, "reportService failed")
            }

        })
    }

}


