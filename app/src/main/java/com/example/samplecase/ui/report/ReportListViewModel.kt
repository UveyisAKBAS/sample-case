package com.example.samplecase.ui.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplecase.domain.report.ReportDataSource
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.util.ReportIdlingResource
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class ReportListViewModel @Inject constructor(
    private val reportDataSource: ReportDataSource
) : ViewModel() {

    val reportList = MutableLiveData<List<ReportItem>?>()

    fun getReports(startDate: Date?, reportIdlingResource: ReportIdlingResource?) {
        if (startDate == null) return

        viewModelScope.launch {
            reportIdlingResource?.setIsIdle(false)

            try {
                if (isActive) {
                    val response = reportDataSource.getAllReports(startDate)
                    reportList.value = response
                }
            } catch (e: Exception) {
                reportList.value = null
            }

            reportIdlingResource?.setIsIdle(true)
        }
    }
}
