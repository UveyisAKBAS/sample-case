package com.example.samplecase.ui.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.samplecase.data.report.ReportRemoteDataSource
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.net.ResponseCallback

class ReportListViewModel : ViewModel() {

    internal val reportList = MutableLiveData<List<ReportItem>>()

    fun getReports(startDate: String) {

        ReportRemoteDataSource.getAllReports(
            startDate,
            object : ResponseCallback<List<ReportItem>> {

                override fun onError(error: Throwable) {
                }

                override fun onResponse(response: List<ReportItem>?) {
                    reportList.value = response
                }


            })
    }


}


