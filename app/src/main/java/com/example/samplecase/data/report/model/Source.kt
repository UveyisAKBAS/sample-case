package com.example.samplecase.data.report.model

import com.example.samplecase.data.base.model.BaseResponse
import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
) : BaseResponse()
