package com.example.samplecase.ui.report

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.samplecase.data.ReportRemoteDataSource
import com.example.samplecase.data.ReportService
import com.example.samplecase.data.model.ReportResponse
import com.example.samplecase.domain.report.model.Report
import retrofit2.Call
import retrofit2.Response

class ReportListViewModel : ViewModel() {

    internal val reportList = MutableLiveData<List<Report>>()

    fun getReports(startDate: String) {
        ReportRemoteDataSource.getReportRemoteDataSource().create(ReportService::class.java)
            .getAllReports(startDate).enqueue(object : retrofit2.Callback<ReportResponse> {

                override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                    Log.i("examination", "Fail")
                }

                override fun onResponse(
                    call: Call<ReportResponse>, response: Response<ReportResponse>
                ) {
                    Log.i("examination", "Success")
                    var reports = response.body()?.articles
                    reportList.value = reports
                }
            })
    }

}


