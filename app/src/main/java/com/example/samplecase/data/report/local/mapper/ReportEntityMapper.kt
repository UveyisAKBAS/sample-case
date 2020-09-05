package com.example.samplecase.data.report.local.mapper

import com.example.samplecase.data.base.mapper.BaseMapper
import com.example.samplecase.data.report.local.model.ReportEntity
import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.report.model.ReportItem

class ReportEntityMapper : BaseMapper<List<ReportEntity>, List<ReportItem>> {

    override fun map(response: List<ReportEntity>): List<ReportItem> {
        return response.map {
            ReportItem(
                title = it.title,
                description = it.description,
                url = it.url,
                urlToImage = it.urlToImage
            )
        }
    }

    fun mapIntoReportEntity(response: ReportResponse): List<ReportEntity> {
        return response.reports!!.map {
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
