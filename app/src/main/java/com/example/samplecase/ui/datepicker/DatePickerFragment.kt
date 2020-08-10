package com.example.samplecase.ui.datepicker

import com.example.samplecase.R
import com.example.samplecase.ui.base.BaseDialogFragment
import com.example.samplecase.util.DateUtil
import com.example.samplecase.util.finish
import com.example.samplecase.util.setResult
import kotlinx.android.synthetic.main.fragment_date_picker.*
import java.util.*

class DatePickerFragment : BaseDialogFragment() {

    override fun getLayoutId(): Int = R.layout.fragment_date_picker

    override fun initViews() {
        buttonSelectDate.setOnClickListener {
            setResult(EXTRA_SELECTED_DATE, getDate())
            finish()
        }
    }

    private fun getDate(): Date {
        val year = datePicker.year
        val month = datePicker.month
        val day = datePicker.dayOfMonth

        return DateUtil.getDate(day, month, year)
    }

    companion object {
        const val EXTRA_SELECTED_DATE = "EXTRA_SELECTED_DATE"
    }
}
