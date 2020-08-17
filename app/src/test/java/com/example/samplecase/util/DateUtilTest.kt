package com.example.samplecase.util

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

private const val DAY = 15
private const val MONTH = 7
private const val YEAR = 2020
private const val EXPECTED_DATE = "2020-08-15"

class DateUtilTest {

    @Test
    fun getDate_ReturnCorrectFormat() {
        assertThat(DateUtil.getDate(DAY, MONTH, YEAR).convertToString()).isEqualTo(EXPECTED_DATE)
    }
}
