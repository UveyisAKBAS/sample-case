package com.example.samplecase.domain.report.usecase

import com.example.samplecase.data.Repository
import com.example.samplecase.domain.base.usecase.BaseReportUseCase
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.util.ReportIdlingResource
import java.util.*
import javax.inject.Inject

class GetReportsUseCase @Inject constructor(
    private val repository: Repository
) : BaseReportUseCase() {

    fun execute(
        startDate: Date?,
        reportIdlingResource: ReportIdlingResource?,
        callback: suspend (List<ReportItem>?) -> Unit
    ) {
        super.execute(
            startDate,
            reportIdlingResource,
            repositoryCallback = { date -> repository.getAllReports(date) },
            liveDataCallback = callback
        )
    }
}
