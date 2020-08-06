package com.example.samplecase.ui.datepicker

import androidx.fragment.app.activityViewModels
import com.example.samplecase.R
import com.example.samplecase.ui.base.BaseDialogFragment
import com.example.samplecase.ui.report.ReportListViewModel
import com.example.samplecase.util.DateUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_date_picker.*
import javax.inject.Inject

@AndroidEntryPoint
class DatePickerFragment : BaseDialogFragment() {

    private val viewModel: ReportListViewModel by activityViewModels()

    @Inject
    lateinit var dateUtil: DateUtil

    override fun getLayoutId(): Int = R.layout.fragment_date_picker

    override fun initViews() {
        buttonSelectDate.setOnClickListener {
            viewModel.getReports(getDate())
            dismiss()
        }
    }

    private fun getDate(): String {
        val year = datePicker.year
        val month = datePicker.month
        val day = datePicker.dayOfMonth

        return dateUtil.getDate(day, month, year)
    }
}
