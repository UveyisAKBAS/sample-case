package com.example.samplecase.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.samplecase.data.report.local.dao.ReportDao
import com.example.samplecase.data.report.local.model.ReportEntity

@Database(entities = [ReportEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reportDao(): ReportDao
}
