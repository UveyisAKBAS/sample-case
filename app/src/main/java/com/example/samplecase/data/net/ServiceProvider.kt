package com.example.samplecase.data.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceProvider {

    private val BASE_URL = "https://newsapi.org/v2/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun <T> provideService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)

    }

}