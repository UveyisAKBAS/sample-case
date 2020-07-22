package com.example.samplecase.data

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReportRemoteDataSource {

    companion object{

        fun getReportRemoteDataSource() : Retrofit {
            return Retrofit.Builder().
            baseUrl("https://newsapi.org/v2/").
            addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}