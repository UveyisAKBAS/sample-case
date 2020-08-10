package com.example.samplecase.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    const val DATE_PATTERN = "yyyy-MM-dd"

    fun getDate(day: Int, month: Int, year: Int): Date {

        val calendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_MONTH, day)
            set(Calendar.MONTH, month)
            set(Calendar.YEAR, year)
        }

        return calendar.time
    }
}

fun String.toDate(): Date? {
    return SimpleDateFormat(DateUtil.DATE_PATTERN, Locale.getDefault()).parse(this)
}

fun Date.convertToString(): String {
    return SimpleDateFormat(DateUtil.DATE_PATTERN, Locale.getDefault()).format(this)
}
