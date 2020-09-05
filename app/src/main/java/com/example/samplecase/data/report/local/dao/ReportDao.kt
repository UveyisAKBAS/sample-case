package com.example.samplecase.data.report.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.samplecase.data.report.local.model.ReportEntity
import io.reactivex.Completable
import io.reactivex.Maybe

@Dao
interface ReportDao {

    @Query("SELECT * FROM ReportEntity")
    fun loadAll(): Maybe<List<ReportEntity>>

    @Query("SELECT COUNT(*) FROM ReportEntity")
    fun getRowCount(): Maybe<Int>

    @Insert
    fun insert(reportEntity: List<ReportEntity>)

    @Delete
    fun delete(reportEntity: ReportEntity): Completable

    @Query("DELETE FROM ReportEntity")
    fun deleteAll()
}
