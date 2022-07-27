package com.example.kiwiflights.data.model

data class Data(
    val aTime: Int,
    val aTimeUTC: Int,
    val availability: Availability,
    val cityTo: String,
    val dTime: Int,
    val dTimeUTC: Int,
    val fly_duration: String,
    val id: String,
    val mapIdto: String,
    val price: Int
)