package com.example.samplecase

import android.app.Application
import com.example.samplecase.di.components.AppComponent
import com.example.samplecase.di.components.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}
