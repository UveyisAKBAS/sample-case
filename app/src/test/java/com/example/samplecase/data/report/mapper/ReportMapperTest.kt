package com.example.samplecase.data.report.mapper

import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.data.report.remote.mapper.ReportMapper
import com.example.samplecase.mocks.MockReportResponseFactory
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ReportMapperTest {

    private lateinit var reportResponse: ReportResponse

    @Before
    fun getMockReportResponse() {
        val mockReportResponseFactory = MockReportResponseFactory()
        reportResponse = mockReportResponseFactory.getMockReportResponse(2)
    }

    @Test
    fun map_ReportResponseMappedReportItemList() = runBlocking {
        val reportMapper = ReportMapper()
        val reportItemList = reportMapper.map(reportResponse)
        reportItemList!!.let { list ->
            assertThat(list[0].title).isEqualTo(reportResponse.reports!![0].title)
            assertThat(list[1].title).isEqualTo(reportResponse.reports!![1].title)
        }
    }
}
