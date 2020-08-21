package com.example.samplecase.domain.report.usecase

import com.example.samplecase.data.report.ReportRepository
import com.example.samplecase.domain.base.usecase.BaseReportUseCase
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.util.ReportIdlingResource
import java.util.*
import javax.inject.Inject

class GetReportsUseCase @Inject constructor(
    private val reportRepository: ReportRepository
) : BaseReportUseCase() {

    fun execute(
        startDate: Date?,
        reportIdlingResource: ReportIdlingResource?,
        callback: suspend (List<ReportItem>?) -> Unit
    ) {
        super.execute(
            startDate,
            reportIdlingResource,
            repositoryCallback = { date -> reportRepository.getAllReports(date) },
            liveDataCallback = callback
        )
    }
}
