package com.example.samplecase.domain.report.usecase

import com.example.samplecase.data.Repository
import com.example.samplecase.domain.report.model.ReportItem
import java.util.*
import javax.inject.Inject

class ReportUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun getAllReports(startDate: Date): List<ReportItem>? {
        return repository.getAllReports(startDate)
    }

    suspend fun updateReports(startDate: Date): List<ReportItem>? {
        return repository.updateReports(startDate)
    }
}
