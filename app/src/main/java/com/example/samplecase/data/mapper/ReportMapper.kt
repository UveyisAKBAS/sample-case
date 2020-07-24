package com.example.samplecase.data.mapper

import com.example.samplecase.data.model.ReportResponse
import com.example.samplecase.domain.report.model.Report

object ReportMapper {

    fun mapToReport(response: ReportResponse?) : List<Report>? {
        return response?.articles?.toList()
    }
}