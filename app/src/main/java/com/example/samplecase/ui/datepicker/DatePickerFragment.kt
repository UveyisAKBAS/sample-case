package com.example.samplecase.ui.datepicker

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.samplecase.R
import com.example.samplecase.ui.report.ReportListViewModel
import kotlinx.android.synthetic.main.fragment_date_picker.*
import java.text.SimpleDateFormat
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private val viewModel: ReportListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_date_picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {

        buttonSelectDate.setOnClickListener {

            viewModel.getReports(getDate())
            dismiss()
        }
    }

    private fun getDate(): String {

        val datePattern = "yyyy-MM-dd"
        val dateFormat = SimpleDateFormat(datePattern, Locale.getDefault())

        val year = datePicker.year
        val month = datePicker.month
        val day = datePicker.dayOfMonth

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)

        return dateFormat.format(calendar.time)
    }


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

    }

}