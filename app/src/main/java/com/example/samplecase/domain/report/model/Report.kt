package com.example.samplecase.domain.report.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Report(
    val source : Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?

) : BaseItem()
