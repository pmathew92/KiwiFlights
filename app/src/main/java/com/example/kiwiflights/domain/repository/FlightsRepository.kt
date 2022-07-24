package com.example.kiwiflights.domain.repository

import com.example.kiwiflights.data.model.FlightsEntity

interface FlightsRepository {
    suspend fun getFlights(departAfter: String, departBefore: String): FlightsEntity
}