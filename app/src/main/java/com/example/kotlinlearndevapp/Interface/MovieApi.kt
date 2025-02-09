package com.example.kotlinlearndevapp.Interface

import model.Moview
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("popular")

    suspend fun getPopularMovies(@Query("api_key") api_key : String) : Response<Moview>
}