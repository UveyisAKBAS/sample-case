package com.example.samplecase.data.report.local

import com.example.samplecase.data.report.local.entity.ReportEntity
import com.example.samplecase.domain.base.BaseDataSource

interface LocalDataSource : BaseDataSource {

    suspend fun loadAllReports(): List<ReportEntity>

    suspend fun insertAllReports(reportEntityList: List<ReportEntity>)

    suspend fun getRowCount(): Int

    suspend fun deleteAll()
}
