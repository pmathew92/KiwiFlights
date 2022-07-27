package com.example.kiwiflights

import com.example.kiwiflights.data.model.Availability
import com.example.kiwiflights.data.model.Data
import com.example.kiwiflights.domain.model.Flight


val data1 = Data(
    1011,
    1011,
    Availability(5),
    "Rome",
    5055,
    5055,
    "3h 15m",
    "1",
    "rome",
    263
)

val data2 = Data(
    2022,
    2022,
    Availability(3),
    "London",
    6066,
    6066,
    "4h 15m",
    "4",
    "london",
    345
)

val data3 = Data(
    3033,
    3033,
    Availability(9),
    "Istanbul",
    7077,
    7077,
    "2h 45m",
    "7",
    "istanbul",
    127
)


val flightList = listOf(data1, data2, data3).map {
    Flight(
        it.id,
        it.cityTo,
        it.price,
        "EUR",
        it.mapIdto,
        it.dTimeUTC,
        it.aTimeUTC,
        it.fly_duration,
        it.availability.seats.toString()
    )
}

