package com.example.samplecase.domain.report.model

import com.example.samplecase.domain.base.model.BaseItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReportItem(
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?
) : BaseItem()
