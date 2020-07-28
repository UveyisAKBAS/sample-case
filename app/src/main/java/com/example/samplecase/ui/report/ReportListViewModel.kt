package com.example.samplecase.ui.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecase.data.report.ReportRemoteDataSource
import com.example.samplecase.domain.report.model.ReportItem
import kotlinx.coroutines.launch

class ReportListViewModel : ViewModel() {

    internal val reportList = MutableLiveData<List<ReportItem>>()

    fun getReports(startDate: String) {

        viewModelScope.launch {

            val response = ReportRemoteDataSource.getAllReports(startDate)
            reportList.value = response
        }
    }
}


