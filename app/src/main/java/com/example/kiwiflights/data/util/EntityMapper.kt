package com.example.kiwiflights.data.util

import com.example.kiwiflights.data.model.FlightsResponseEntity
import com.example.kiwiflights.domain.model.Flight

fun FlightsResponseEntity.toFlightList(): List<Flight> {
    return data.map {
        Flight(
            it.cityTo,
            it.price,
            currency,
            it.mapIdto,
            it.dTime,
            it.aTime,
            it.fly_duration,
            it.availability.seats.toString()
        )
    }
}