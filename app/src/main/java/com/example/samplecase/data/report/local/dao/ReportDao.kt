package com.example.samplecase.data.report.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.samplecase.data.report.local.entity.ReportEntity

@Dao
interface ReportDao {

    @Query("SELECT * FROM ReportEntity")
    fun getAllReports() : List<ReportEntity>

    @Insert
    fun insertReportEntity(reportEntity: ReportEntity)

    @Delete
    fun deleteReportEntity(reportEntity: ReportEntity)
}