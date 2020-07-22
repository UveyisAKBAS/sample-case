package com.example.samplecase.domain.report.model

data class Report(
    val source : Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?

)
