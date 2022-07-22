package com.example.kiwiflights.data.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class HttpClientProvider {

    val okHttpClient: OkHttpClient by lazy { createOkHttpClient() }

    private fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT_VALUE_SECONDS, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_VALUE_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_VALUE_SECONDS, TimeUnit.SECONDS)
        .callTimeout(TIMEOUT_VALUE_SECONDS, TimeUnit.SECONDS)
        .build()

    companion object {
        private const val TIMEOUT_VALUE_SECONDS = 10L
    }
}