package com.example.samplecase.di.components

import android.content.Context
import com.example.samplecase.di.ViewModelBuilderModule
import com.example.samplecase.di.modules.AppModule
import com.example.samplecase.ui.report.di.ReportComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelBuilderModule::class, SubComponentsModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun addReportComponent(): ReportComponent.Factory
    fun addUtilComponent(): UtilComponent.Factory
    fun addReportListRecyclerAdapterComponent(): ReportListRecyclerAdapterComponent.Factory
}

@Module(subcomponents = [ReportComponent::class, UtilComponent::class, ReportListRecyclerAdapterComponent::class]
)
object SubComponentsModule
