package com.example.samplecase.di.components

import com.example.samplecase.di.modules.UtilModule
import com.example.samplecase.di.scopes.DateScope
import com.example.samplecase.util.DateUtil
import dagger.Subcomponent

@DateScope
@Subcomponent(modules = [UtilModule::class])
interface UtilComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): UtilComponent
    }

    fun getDateUtil(): DateUtil
}
