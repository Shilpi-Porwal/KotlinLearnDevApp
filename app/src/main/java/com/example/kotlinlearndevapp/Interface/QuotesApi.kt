package com.example.kotlinlearndevapp.Interface

import model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes(): Response<Quote>
}