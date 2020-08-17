package com.example.samplecase.mocks

import com.example.samplecase.data.report.model.Report
import com.example.samplecase.data.report.model.ReportResponse
import com.example.samplecase.data.report.model.Source

class MockReportResponseFactory {

    fun getMockReportResponse(totalResults: Int): ReportResponse {
        return createReportResponse(totalResults = totalResults)
    }

    private fun createReportResponse(
        status: String = "ok",
        totalResults: Int
    ) = ReportResponse(
        status = status,
        totalResults = totalResults,
        reports = createReportList(totalResults)
    )

    private fun createReportList(totalResults: Int): ArrayList<Report> {
        val reportList = arrayListOf<Report>()
        for (index in 1..totalResults) {
            reportList.add(
                createReport(
                    title = "Test Title $index",
                    description = "Test Description $index"
                )
            )
        }
        return reportList
    }

    private fun createReport(
        title: String = "Default title",
        description: String = "Default Description"
    ) = Report(
        createSource(),
        author = "Default Author",
        title = title,
        description = description,
        url = "https://lifehacker.com/instead-of-buying-bitcoin-play-this-bitcoin-trading-ga-1826671289",
        urlToImage = "https://i.kinja-img.com/gawker-media/image/upload/s--Dq77h-xL--/c_fill,fl_progressive,g_center,h_900,q_80,w_1600/i9pblfcvortm2ojd89nq.png",
        publishedAt = "2018-06-08T17:30:00Z",
        content = "Default Content"
    )

    private fun createSource(
        sourceId: String = "Default Source Id",
        sourceName: String = "Default Source Name"
    ) = Source(
        id = sourceId,
        name = sourceName
    )
}
