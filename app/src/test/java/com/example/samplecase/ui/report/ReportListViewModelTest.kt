package com.example.samplecase.ui.report

import com.example.samplecase.domain.report.ReportDataSource
import com.example.samplecase.mocks.MockReportItemFactory
import com.example.samplecase.ui.InstantExecutorExtension
import com.example.samplecase.util.ReportIdlingResource
import com.example.samplecase.util.toDate
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith

private const val START_DATE = "2020-08-15"

@ExtendWith(InstantExecutorExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReportListViewModelTest {

    private var reportItemList = MockReportItemFactory().getReportItemList(2)

    private val reportDataSource: ReportDataSource = mockk()
    private val reportIdlingResource: ReportIdlingResource = mockk()
    private val reportListViewModel = ReportListViewModel(reportDataSource)

    @BeforeEach
    fun setUp() {
        clearMocks(reportDataSource)
        coEvery { reportDataSource.getAllReports(START_DATE.toDate()!!) } returns reportItemList
        coEvery { reportIdlingResource.setIsIdle(any()) } just runs
    }

    @Test
    fun `getReports Calls getAllReports Method Of ReportDataSource`() {
        reportListViewModel.getReports(START_DATE.toDate()!!, reportIdlingResource)
        coVerify { reportDataSource.getAllReports(START_DATE.toDate()!!) }
    }

    @Test
    fun `getReports Update reportList LiveData`() {
        //TODO Use observer.onChanged() instead of manual update checking
        assertThat(reportListViewModel.reportList.value?.isEmpty())
        reportListViewModel.getReports(START_DATE.toDate()!!, reportIdlingResource)
        assertThat(reportListViewModel.reportList.value?.isNotEmpty())
        assertThat(reportListViewModel.reportList.value?.get(0)?.title).isEqualTo(reportItemList[0].title)
    }
}
