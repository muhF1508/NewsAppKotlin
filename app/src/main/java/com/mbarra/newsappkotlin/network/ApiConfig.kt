package com.mbarra.newsappkotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    fun create(): ApiService{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://newsapi.org/v2/")
            .build()
        return retrofit.create(ApiService::class.java)
    }
}