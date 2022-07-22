package com.example.kiwiflights.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpNetworkTransport(private val okHttpClient: OkHttpClient) {

    val retrofit: Retrofit by lazy { createBaseRestAdapter() }

    private fun createBaseRestAdapter(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.skypicker.com/flights?þ")
            .build()
    }
}
