package com.example.samplecase.data.report.remote.model

import com.example.samplecase.data.base.model.BaseResponse
import com.example.samplecase.data.report.remote.model.Report
import com.google.gson.annotations.SerializedName

data class ReportResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val reports: ArrayList<Report>?
) : BaseResponse()
