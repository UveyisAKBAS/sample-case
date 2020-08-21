package com.example.samplecase.data.report

import com.example.samplecase.data.report.local.LocalDataSource
import com.example.samplecase.data.report.local.mapper.ReportEntityMapper
import com.example.samplecase.data.report.local.model.ReportEntity
import com.example.samplecase.data.report.remote.RemoteDataSource
import com.example.samplecase.data.report.remote.mapper.ReportMapper
import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.report.model.ReportItem
import java.util.*
import javax.inject.Inject

class ReportRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val reportMapper: ReportMapper,
    private val reportEntityMapper: ReportEntityMapper
) {

    suspend fun getAllReports(startDate: Date): List<ReportItem>? {
        return if (isReportTableHasData()) loadAllReports() else fetchAndSave(startDate)
    }

    suspend fun updateReports(startDate: Date): List<ReportItem>? {
        deleteAllReports()
        return fetchAndSave(startDate)
    }

    private suspend fun fetchReports(startDate: Date): ReportResponse =
        remoteDataSource.fetchReports(startDate)

    private suspend fun loadAllReports(): List<ReportItem>? {
        return localDataSource.loadAllReports().map {
            reportEntityMapper.map(it)
        }
    }

    private suspend fun insertAllReports(reportEntityList: List<ReportEntity>) =
        localDataSource.insertAllReports(reportEntityList)

    private suspend fun deleteAllReports() =
        localDataSource.deleteAll()

    private suspend fun fetchAndSave(startDate: Date): List<ReportItem>? {
        val reportResponse = fetchReports(startDate)
        reportEntityMapper.mapIntoReportEntity(reportResponse)?.let {
            insertAllReports(it)
        }
        return reportMapper.map(reportResponse)
    }

    private suspend fun isReportTableHasData(): Boolean = localDataSource.getRowCount() != 0
}
