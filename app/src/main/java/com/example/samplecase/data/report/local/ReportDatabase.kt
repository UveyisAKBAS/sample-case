package com.example.samplecase.data.report.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.samplecase.data.report.local.dao.ReportDao
import com.example.samplecase.data.report.local.entity.ReportEntity

@Database(entities = [ReportEntity::class], version = 1, exportSchema = false)
abstract class ReportDatabase : RoomDatabase() {
    abstract fun reportDao(): ReportDao
}
