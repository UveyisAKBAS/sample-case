package com.example.samplecase.data.report.remote.mapper

import com.example.samplecase.data.base.mapper.BaseMapper
import com.example.samplecase.data.report.remote.model.Report
import com.example.samplecase.domain.report.model.ReportItem

class ReportMapper : BaseMapper<List<Report>, List<ReportItem>> {

    override fun map(response: List<Report>): List<ReportItem> {
        return response.map {
            ReportItem(
                title = it.title,
                description = it.description,
                url = it.url,
                urlToImage = it.urlToImage
            )
        }
    }
}
