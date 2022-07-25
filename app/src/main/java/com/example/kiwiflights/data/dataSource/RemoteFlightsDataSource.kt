package com.example.kiwiflights.data.dataSource

import com.example.kiwiflights.data.dataSource.contract.FlightsDataSource
import com.example.kiwiflights.data.model.FlightsResponseEntity
import com.example.kiwiflights.data.network.api.FlightsApi

/**
 * Implementation of [RemoteFlightsDataSource] responsible for fetching flight data from
 * remote end point
 */
class RemoteFlightsDataSource(private val flightsApi: FlightsApi) : FlightsDataSource {
    override suspend fun getFlights(
        departAfter: String,
        departBefore: String
    ): FlightsResponseEntity {
        return flightsApi.getFlights()
    }
}