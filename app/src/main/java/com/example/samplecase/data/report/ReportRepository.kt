package com.example.samplecase.data.report

import com.example.samplecase.data.report.local.LocalDataSource
import com.example.samplecase.data.report.local.mapper.ReportEntityMapper
import com.example.samplecase.data.report.remote.RemoteDataSource
import com.example.samplecase.data.report.remote.mapper.ReportMapper
import com.example.samplecase.data.report.remote.model.ReportResponse
import com.example.samplecase.domain.report.model.ReportItem
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class ReportRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val reportMapper: ReportMapper,
    private val reportEntityMapper: ReportEntityMapper
) {

    fun getAllReports(startDate: Date): Observable<List<ReportItem>> {
        return isReportTableHasData().subscribeOn(Schedulers.io()).toObservable()
            .flatMap {
                if (it) loadAllReports() else fetchAndSave(startDate)
            }
    }

    fun updateReports(startDate: Date): Observable<List<ReportItem>> {
        return fetchAndSave(startDate).doOnSubscribe { localDataSource.deleteAll() }
    }

    private fun fetchReports(startDate: Date): Observable<ReportResponse> {
        return remoteDataSource.fetchReports(startDate)
    }

    private fun loadAllReports(): Observable<List<ReportItem>> {
        return localDataSource.loadAllReports().toObservable()
            .map {
                reportEntityMapper.map(it)
            }
    }

    private fun insertAllReports(reportResponse: ReportResponse) {
        localDataSource.insertReport(reportEntityMapper.mapIntoReportEntity(reportResponse))
    }

    private fun fetchAndSave(startDate: Date): Observable<List<ReportItem>> {
        return fetchReports(startDate).subscribeOn(Schedulers.io())
            .filter {
                it.reports != null
            }.doOnNext {
                insertAllReports(it)
            }.map {
                reportMapper.map(it.reports!!)
            }
    }

    private fun isReportTableHasData(): Maybe<Boolean> {
        return localDataSource.getRowCount().map {
            it != 0
        }
    }
}
