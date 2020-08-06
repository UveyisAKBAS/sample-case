package com.example.samplecase.data.report.mapper

import com.example.samplecase.data.base.mapper.BaseMapper
import com.example.samplecase.data.report.model.ReportResponse
import com.example.samplecase.domain.report.model.ReportItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReportMapper @Inject constructor() : BaseMapper<ReportResponse, List<ReportItem>> {

    override suspend fun map(response: ReportResponse): List<ReportItem>? {
        return response.reports?.map {
            ReportItem(title = it.title,
                description = it.description,
                url = it.url,
                urlToImage = it.urlToImage
            )
        }
    }
}
