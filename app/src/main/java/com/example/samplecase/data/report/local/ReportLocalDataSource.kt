package com.example.samplecase.data.report.local

import com.example.samplecase.data.report.local.dao.ReportDao
import com.example.samplecase.data.report.local.entity.ReportEntity
import javax.inject.Inject

class ReportLocalDataSource @Inject constructor(
    private val reportDao: ReportDao
) : LocalDataSource {

    override suspend fun loadAllReports(): List<ReportEntity> {
        return reportDao.loadAll()
    }

    override suspend fun insertAllReports(reportEntityList: List<ReportEntity>) {
        reportDao.insertAll(reportEntityList)
    }

    override suspend fun getRowCount(): Int {
        return reportDao.getRowCount()
    }

    override suspend fun deleteAll() {
        reportDao.deleteAll()
    }
}
