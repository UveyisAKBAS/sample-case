package com.example.samplecase.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    const val DATE_PATTERN = "yyyy-MM-dd"

    fun getDate(day: Int, month: Int, year: Int): String {
        val dateFormat = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())

        val calendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_MONTH, day)
            set(Calendar.MONTH, month)
            set(Calendar.YEAR, year)
        }

        return dateFormat.format(calendar.time)
    }
}