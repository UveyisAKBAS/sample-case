package com.example.samplecase.domain.datepicker

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    private fun formatDate(year: Int, month: Int, day: Int): String {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)

        return dateFormat.format(calendar.time)
    }
}