package com.example.samplecase.data.net

interface ResponseCallback<T>{

    fun onResponse(response:T)

    fun onError(error:Throwable)
}