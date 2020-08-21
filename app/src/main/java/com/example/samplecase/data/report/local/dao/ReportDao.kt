package com.example.samplecase.data.report.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.samplecase.data.report.local.model.ReportEntity

@Dao
interface ReportDao {

    @Query("SELECT * FROM ReportEntity")
    fun loadAll(): List<ReportEntity>

    @Query("SELECT COUNT(*) FROM ReportEntity")
    fun getRowCount(): Int

    @Insert
    fun insertAll(reportEntityList: List<ReportEntity>)

    @Delete
    fun delete(reportEntity: ReportEntity)

    @Query("DELETE FROM ReportEntity")
    fun deleteAll()
}
