package com.example.testtt

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Define the data class representing the model
data class User(val priceChange: String, val symbol: String)

// Define the API service interface
interface ApiService {
    @GET("ticker/24hr") // Replace with the actual API endpoint
    fun getUsers(): Call<List<User>>
}

object ApiClient {
    private const val BASE_URL = "https://data.binance.com/api/v3/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}


