package com.example.samplecase.data.model

import com.example.samplecase.domain.report.model.Report

data class ReportResponse(
    val status: String?,
    val totalResults: Int?,
    val articles: ArrayList<Report>?
)