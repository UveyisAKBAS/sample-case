package com.example.samplecase.ui.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.domain.report.usecase.ReportUseCase
import com.example.samplecase.util.ReportIdlingResource
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

class ReportListViewModel @Inject constructor(
    private val useCase: ReportUseCase
) : ViewModel() {

    val reportList = MutableLiveData<List<ReportItem>?>()
    //TODO Review duplicate code
    fun getReports(startDate: Date?, reportIdlingResource: ReportIdlingResource?) {
        if (startDate == null) return

        CoroutineScope(Dispatchers.IO).launch {
            reportIdlingResource?.setIsIdle(false)

            try {
                if (isActive) {
                    val response = useCase.getAllReports(startDate)
                    withContext(Dispatchers.Main) {
                        reportList.value = response
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    reportList.value = null
                }
            }

            reportIdlingResource?.setIsIdle(true)
        }
    }
    //TODO Review duplicate code
    fun updateReports(startDate: Date?) {
        if (startDate == null) return

        CoroutineScope(Dispatchers.IO).launch {
            try {
                if (isActive) {
                    val response = useCase.updateReports(startDate)
                    withContext(Dispatchers.Main) {
                        reportList.value = response
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    reportList.value = null
                }
            }
        }

    }
}
