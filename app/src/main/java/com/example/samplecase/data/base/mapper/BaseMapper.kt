package com.example.samplecase.data.base.mapper

interface BaseMapper<Response, Item> {

    suspend fun map(response: Response): Item?
}
