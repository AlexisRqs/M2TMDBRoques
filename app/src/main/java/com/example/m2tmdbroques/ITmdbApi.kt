package com.example.m2tmdbroques

import retrofit2.http.GET
import retrofit2.http.Query

const val TMDB_API_KEY = "a4ace1a70eb8d5cddaccff08426040fc"

interface ITmdbApi {
    @GET("person/popular")
    fun getPopularPerson(
        @Query("api_key") apiKey: String,
        @Query("page") pageNumber: Int
    )
}