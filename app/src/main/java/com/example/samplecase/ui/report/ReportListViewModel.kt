package com.example.samplecase.ui.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.domain.report.usecase.ReportUseCase
import com.example.samplecase.util.ReportIdlingResource
import java.util.*
import javax.inject.Inject

class ReportListViewModel @Inject constructor(
    private val useCase: ReportUseCase
) : ViewModel() {

    val reportList = MutableLiveData<List<ReportItem>?>()

    fun getReports(startDate: Date?, reportIdlingResource: ReportIdlingResource?) {
        UseCaseExecutor.execute(
            startDate,
            reportIdlingResource,
            { date -> useCase.getAllReports(date) },
            { response -> reportList.value = response }
        )
    }

    fun updateReports(startDate: Date?, reportIdlingResource: ReportIdlingResource?) {
        UseCaseExecutor.execute(
            startDate,
            reportIdlingResource,
            { date -> useCase.updateReports(date) },
            { response -> reportList.value = response }
        )
    }
}
