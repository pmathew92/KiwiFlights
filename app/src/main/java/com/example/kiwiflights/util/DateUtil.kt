package com.example.kiwiflights.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    private const val DATE_FORMAT = "dd/MM/yyyy"
    private const val TIME_FORMAT = "hh:mm aa"

    fun getTodayDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return dateFormatter.format(Date(calendar.timeInMillis))
    }

    fun getDaysDateFromToday(days: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, days)
        val dateFormatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return dateFormatter.format(Date(calendar.timeInMillis))
    }

    fun getUtcTimeInAmPM(utcTime: Int): String {
        val timeFormat = SimpleDateFormat(TIME_FORMAT, Locale.getDefault())
        return timeFormat.format(utcTime)
    }
}