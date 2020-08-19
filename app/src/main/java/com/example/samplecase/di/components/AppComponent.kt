package com.example.samplecase.di.components

import com.example.samplecase.App
import com.example.samplecase.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DataModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        ViewModelBuilderModule::class,
        AndroidSupportInjectionModule::class,
        RoomModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }
}
