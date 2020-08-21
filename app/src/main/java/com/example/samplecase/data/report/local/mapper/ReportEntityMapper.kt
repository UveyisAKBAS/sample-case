package com.example.samplecase.data.report.local.mapper

import com.example.samplecase.data.base.mapper.BaseMapper
import com.example.samplecase.data.report.local.model.ReportEntity
import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.report.model.ReportItem

class ReportEntityMapper : BaseMapper<ReportEntity, ReportItem> {
    override fun map(response: ReportEntity): ReportItem {
        return ReportItem(
            title = response.title,
            description = response.description,
            url = response.url,
            urlToImage = response.urlToImage
        )
    }

    fun mapIntoReportEntity(reportResponse: ReportResponse): List<ReportEntity>? {
        return reportResponse.reports?.map {
            ReportEntity(
                author = it.author,
                title = it.title,
                description = it.description,
                url = it.url,
                urlToImage = it.urlToImage,
                publishedAt = it.publishedAt,
                content = it.content
            )
        }
    }
}
