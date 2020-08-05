package com.example.samplecase.net

interface ResponseCallback<T> {

    fun onResponse(response: T?)

    fun onError(error: Throwable)
}
