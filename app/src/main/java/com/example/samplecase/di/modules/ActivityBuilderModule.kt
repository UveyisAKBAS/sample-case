package com.example.samplecase.di.modules

import com.example.samplecase.di.scopes.ActivityScope
import com.example.samplecase.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
