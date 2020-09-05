package com.example.samplecase.ui.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.domain.report.usecase.GetReportsUseCase
import com.example.samplecase.domain.report.usecase.UpdateReportsUseCase
import java.util.*
import javax.inject.Inject

class ReportListViewModel @Inject constructor(
    private val getReportsUseCase: GetReportsUseCase,
    private val updateReportsUseCase: UpdateReportsUseCase
) : ViewModel() {

    val reportList = MutableLiveData<List<ReportItem>?>()

    fun getReports(startDate: Date?) {
        getReportsUseCase.execute(
            startDate
        ) { response -> reportList.value = response }
    }

    fun updateReports(startDate: Date?) {
        updateReportsUseCase.execute(
            startDate
        ) { response -> reportList.value = response }
    }

    override fun onCleared() {
        super.onCleared()
        getReportsUseCase.dispose()
        updateReportsUseCase.dispose()
    }
}
