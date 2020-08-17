package com.example.samplecase.mocks

import com.example.samplecase.domain.report.model.ReportItem

class MockReportItemFactory {

    fun getReportItemList(totalResults: Int): List<ReportItem> {
        return createReportItemList(totalResults)
    }

    private fun createReportItemList(totalResults: Int): List<ReportItem> {
        val reportItemList = arrayListOf<ReportItem>()
        for (index in 1..totalResults) {
            reportItemList.add(
                createReportItem(
                    title = "Test Title $index",
                    description = "Test Description $index"
                )
            )
        }
        return reportItemList
    }

    private fun createReportItem(
        title: String = "Default title",
        description: String = "Default Description"
    ) = ReportItem(
        title = title,
        description = description,
        url = "https://lifehacker.com/instead-of-buying-bitcoin-play-this-bitcoin-trading-ga-1826671289",
        urlToImage = "https://i.kinja-img.com/gawker-media/image/upload/s--Dq77h-xL--/c_fill,fl_progressive,g_center,h_900,q_80,w_1600/i9pblfcvortm2ojd89nq.png"
    )
}
