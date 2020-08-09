package com.example.samplecase.ui.report

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecase.data.report.ReportRemoteDataSource
import com.example.samplecase.domain.report.model.ReportItem
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReportListViewModel @Inject constructor(private val reportRemoteDataSource: ReportRemoteDataSource) :
    ViewModel() {

    val reportList = MutableLiveData<List<ReportItem>?>()

    fun getReports(startDate: String) {

        viewModelScope.launch {

            try {
                if (isActive) {
                    val response = reportRemoteDataSource.getAllReports(startDate)
                    reportList.value = response
                }
            } catch (e: Exception) {
                reportList.value = null
            }
        }
    }
}
