package com.example.kiwiflights.data.util

import com.example.kiwiflights.data.model.FlightsResponseEntity
import com.example.kiwiflights.domain.model.Flight

fun FlightsResponseEntity.toFlightList(): List<Flight> {
    return data.map {
        Flight(
            it.id,
            it.cityTo,
            it.price,
            currency,
            it.mapIdto,
            it.dTimeUTC,
            it.aTimeUTC,
            it.fly_duration,
            it.availability.seats.toString()
        )
    }
}