package com.example.kiwiflights.data.util

import com.example.kiwiflights.data.model.FlightsResponseEntity
import com.example.kiwiflights.domain.model.Flight
import java.text.SimpleDateFormat

private val dateFormat = SimpleDateFormat("hh:mm aa")

fun FlightsResponseEntity.toFlightList(): List<Flight> {
    return data.map {
        Flight(
            it.cityTo,
            it.price,
            currency,
            "https://images.kiwi.com/photos/600x330/${it.mapIdto}.jpg",
            dateFormat.format(it.dTime),
            dateFormat.format(it.aTime),
            it.fly_duration,
            it.availability.seats.toString()
        )
    }
}