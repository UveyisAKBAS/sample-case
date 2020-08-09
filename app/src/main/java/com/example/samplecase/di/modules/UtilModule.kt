package com.example.samplecase.di.modules

import com.example.samplecase.di.scopes.DateScope
import com.example.samplecase.util.DateUtil
import dagger.Module
import dagger.Provides

@Module
class UtilModule {

    @DateScope
    @Provides
    fun provideDateUtil(): DateUtil {
        return DateUtil()
    }
}
