package com.example.samplecase.domain.report.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(
    var id : String?,
    var name : String?
) : BaseItem()