package com.example.paging3demoapplication.model.network

import com.example.paging3demoapplication.model.data.RickAndMortyList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {


    @GET("character")
    suspend fun getDataFromAPI(@Query("page") query: Int): RickAndMortyList
}