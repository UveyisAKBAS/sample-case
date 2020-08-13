package com.example.samplecase

import com.example.samplecase.ui.datepicker.DatePickerFragmentTest
import com.example.samplecase.ui.main.MainActivityTest
import com.example.samplecase.ui.report.ReportListFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    DatePickerFragmentTest::class,
    ReportListFragmentTest::class,
    MainActivityTest::class
)
class TestSuite
