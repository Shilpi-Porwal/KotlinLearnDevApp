package com.example.kotlinlearndevapp.Helper

import com.example.kotlinlearndevapp.Interface.MovieApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // fun getInstance(): Retrofit{
       val api : MovieApi by lazy{
           Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/")
               .addConverterFactory(GsonConverterFactory.create())
               .build()
               .create(MovieApi::class.java)
       //}

     }
}