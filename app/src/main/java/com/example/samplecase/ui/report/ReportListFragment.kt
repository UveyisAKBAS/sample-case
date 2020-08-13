package com.example.samplecase.ui.report

import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplecase.R
import com.example.samplecase.databinding.FragmentReportListBinding
import com.example.samplecase.ui.base.BaseMvvmFragment
import com.example.samplecase.ui.datepicker.DatePickerFragment
import com.example.samplecase.util.ReportIdlingResource
import com.example.samplecase.util.onResult
import com.example.samplecase.util.toDate
import kotlinx.android.synthetic.main.fragment_report_list.*
import java.util.*

class ReportListFragment : BaseMvvmFragment<ReportListViewModel, FragmentReportListBinding>() {

    override val viewModel by viewModels<ReportListViewModel> { viewModelFactory }

    private val reportListRecyclerAdapter: ReportListRecyclerAdapter by lazy {
        ReportListRecyclerAdapter()
    }

    private var reportIdlingResource: ReportIdlingResource? = null

    override fun getLayoutId(): Int = R.layout.fragment_report_list

    override fun initViews() {

        viewModel.getReports("2020-07-22".toDate(), reportIdlingResource)

        binding.reportViewModel = viewModel

        with(recyclerViewReportList) {
            layoutManager = LinearLayoutManager(context)
            adapter = reportListRecyclerAdapter.apply {
                setItemClickListener {
                    findNavController().navigate(
                        ReportListFragmentDirections.actionReportListToReportDetails(
                            it
                        )
                    )
                }
            }
        }

        buttonDate.setOnClickListener() {
            findNavController().navigate(ReportListFragmentDirections.actionFragmentReportListToDialogDatePicker())
        }
    }

    override fun observeEvents() {
        super.observeEvents()

        onResult<Date>(DatePickerFragment.EXTRA_SELECTED_DATE) { date ->
            viewModel.getReports(date, reportIdlingResource)
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun getIdlingResource(): ReportIdlingResource {
        if (reportIdlingResource == null) {
            reportIdlingResource = ReportIdlingResource()
        }
        return reportIdlingResource!!
    }
}
