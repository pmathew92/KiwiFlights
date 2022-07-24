package com.example.kiwiflights.data.dataSource.contract

import com.example.kiwiflights.data.model.FlightsEntity

interface FlightsDataSource {
    suspend fun getFlights(departAfter: String, departBefore: String): FlightsEntity
}