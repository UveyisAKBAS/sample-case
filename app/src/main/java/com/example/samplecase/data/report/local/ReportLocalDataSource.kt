package com.example.samplecase.data.report.local

import com.example.samplecase.data.report.local.dao.ReportDao
import com.example.samplecase.data.report.local.model.ReportEntity
import io.reactivex.Maybe
import javax.inject.Inject

class ReportLocalDataSource @Inject constructor(
    private val reportDao: ReportDao
) : LocalDataSource {

    override fun loadAllReports(): Maybe<List<ReportEntity>> {
        return reportDao.loadAll()
    }

    override fun insertReport(reportEntityList: List<ReportEntity>) {
        reportDao.insert(reportEntityList)
    }

    override fun getRowCount(): Maybe<Int> {
        return reportDao.getRowCount()
    }

    override fun deleteAll() {
        reportDao.deleteAll()
    }
}
