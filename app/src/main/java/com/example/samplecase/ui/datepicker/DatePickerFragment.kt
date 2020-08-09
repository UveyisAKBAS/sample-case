package com.example.samplecase.ui.datepicker

import android.content.Context
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.samplecase.App
import com.example.samplecase.R
import com.example.samplecase.di.ViewModelFactory
import com.example.samplecase.ui.base.BaseDialogFragment
import com.example.samplecase.ui.report.ReportListViewModel
import com.example.samplecase.util.DateUtil
import kotlinx.android.synthetic.main.fragment_date_picker.*
import javax.inject.Inject

class DatePickerFragment : BaseDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<ReportListViewModel> { viewModelFactory }

    private lateinit var dateUtil: DateUtil

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

    override fun onAttach(context: Context) {
        super.onAttach(context)

        //TODO initialize viewModelFactory
        dateUtil = (requireActivity().application as App).appComponent.addUtilComponent().create()
            .getDateUtil()
    }
}
