package com.example.samplecase.data.base.mapper

interface BaseMapper<Response, Item> {

    fun map(response: Response): Item
}
