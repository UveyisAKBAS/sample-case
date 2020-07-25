package com.example.samplecase.ui.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.samplecase.data.ReportRemoteDataSource
import com.example.samplecase.data.net.ResponseCallback
import com.example.samplecase.domain.report.model.Report

class ReportListViewModel : ViewModel() {

    internal val reportList = MutableLiveData<List<Report>>()

    fun getReports(startDate: String) {

        ReportRemoteDataSource.getAllReports(startDate, object : ResponseCallback<List<Report>> {
            override fun onResponse(response: List<Report>) {
                reportList.value = response
            }

            override fun onError(error: Throwable) {
            }
        })
    }



}


