package com.example.samplecase.di.modules

import androidx.room.Room
import com.example.samplecase.App
import com.example.samplecase.data.AppDatabase
import com.example.samplecase.data.report.local.dao.ReportDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideAppDatabase(app: App): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java, "app-database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideGeoAlertDao(appDatabase: AppDatabase): ReportDao {
        return appDatabase.reportDao()
    }
}
