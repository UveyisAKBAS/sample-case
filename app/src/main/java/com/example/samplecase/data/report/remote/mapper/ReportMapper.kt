package com.example.samplecase.data.report.remote.mapper

import com.example.samplecase.data.base.mapper.BaseMapper
import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.report.model.ReportItem

class ReportMapper : BaseMapper<ReportResponse, List<ReportItem>> {

    override fun map(response: ReportResponse): List<ReportItem> {
        return response.reports!!.map {
            ReportItem(
                title = it.title,
                description = it.description,
                url = it.url,
                urlToImage = it.urlToImage
            )
        }
    }
}
