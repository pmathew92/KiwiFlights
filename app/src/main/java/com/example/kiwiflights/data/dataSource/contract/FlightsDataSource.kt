package com.example.kiwiflights.data.dataSource.contract

import com.example.kiwiflights.data.model.FlightsResponseEntity

/**
 * contract for flight data source
 */
interface FlightsDataSource {
    suspend fun getFlights(departAfter: String, departBefore: String): FlightsResponseEntity
}