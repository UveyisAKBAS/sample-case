package com.example.samplecase.data.report.local

import com.example.samplecase.data.report.local.model.ReportEntity
import com.example.samplecase.domain.base.BaseDataSource
import io.reactivex.Maybe

interface LocalDataSource : BaseDataSource {

    fun loadAllReports(): Maybe<List<ReportEntity>>

    fun insertReport(reportEntityList: List<ReportEntity>)

    fun getRowCount(): Maybe<Int>

    fun deleteAll()
}
