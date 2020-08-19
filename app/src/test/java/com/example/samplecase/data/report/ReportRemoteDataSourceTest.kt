package com.example.samplecase.data.report

import com.example.samplecase.data.report.remote.ReportRemoteDataSource
import com.example.samplecase.data.report.remote.ReportService
import com.example.samplecase.data.report.remote.mapper.ReportMapper
import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.mocks.MockReportItemFactory
import com.example.samplecase.mocks.MockReportResponseFactory
import com.example.samplecase.util.toDate
import com.google.common.truth.Truth.assertThat
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

private const val START_DATE = "2020-08-15"

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReportRemoteDataSourceTest {

    private lateinit var reportResponse: ReportResponse
    private lateinit var reportItemList: List<ReportItem>

    private val reportService: ReportService = mockk()
    private val reportMapper: ReportMapper = mockk()
    private val reportRemoteDataSource = ReportRemoteDataSource(reportService, reportMapper)

    @BeforeEach
    fun setUp() {
        clearMocks(reportService, reportMapper)

        val mockReportResponseFactory = MockReportResponseFactory()
        reportResponse = mockReportResponseFactory.getMockReportResponse(2)

        val mockReportItemFactory = MockReportItemFactory()
        reportItemList = mockReportItemFactory.getReportItemList(2)

        coEvery { reportService.getAllReports(START_DATE) } returns reportResponse
        coEvery { reportMapper.map(reportResponse) } returns reportItemList
    }

    @Test
    fun `getAllReports Should Return Correct ReportItemList For A Given ReportResponse`() =
        runBlocking {
            val resultReportItemList = reportRemoteDataSource.getAllReports(START_DATE.toDate()!!)
            resultReportItemList!!.let {
                assertThat(it[0].title).isEqualTo(reportResponse.reports!![0].title)
                assertThat(it[1].title).isEqualTo(reportResponse.reports!![1].title)
            }
            coVerify { reportService.getAllReports(START_DATE) }
        }
}
