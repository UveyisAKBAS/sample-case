package com.example.samplecase.domain.report.usecase

import com.example.samplecase.data.report.ReportRepository
import com.example.samplecase.domain.base.usecase.BaseReportUseCase
import com.example.samplecase.domain.report.model.ReportItem
import java.util.*
import javax.inject.Inject

class UpdateReportsUseCase @Inject constructor(
    private val reportRepository: ReportRepository
) : BaseReportUseCase() {

    fun execute(
        startDate: Date?,
        callback: suspend (List<ReportItem>?) -> Unit
    ) {
        super.execute(
            startDate,
            repositoryCallback = { date -> reportRepository.updateReports(date) },
            liveDataCallback = callback
        )
    }
}
