package com.example.samplecase.ui.report

import android.content.Context
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplecase.App
import com.example.samplecase.R
import com.example.samplecase.databinding.FragmentReportListBinding
import com.example.samplecase.di.ViewModelFactory
import com.example.samplecase.ui.base.BaseMvvmFragment
import com.example.samplecase.ui.datepicker.DatePickerFragment
import com.example.samplecase.util.onResult
import com.example.samplecase.util.toDate
import kotlinx.android.synthetic.main.fragment_report_list.*
import java.util.*
import javax.inject.Inject

class ReportListFragment : BaseMvvmFragment<ReportListViewModel, FragmentReportListBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel by viewModels<ReportListViewModel> { viewModelFactory }

    lateinit var reportListRecyclerAdapter: ReportListRecyclerAdapter

    override fun getLayoutId(): Int = R.layout.fragment_report_list

    override fun initViews() {
        viewModel.getReports("2020-07-22".toDate())

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

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as App).appComponent.addReportComponent().create()
            .inject(this)

        reportListRecyclerAdapter =
            (requireActivity().application as App).appComponent.addReportListRecyclerAdapterComponent()
                .create()
                .getReportListRecyclerAdapter()
    }

    override fun observeEvents() {
        super.observeEvents()

        onResult<Date>(DatePickerFragment.EXTRA_SELECTED_DATE) { date ->
            viewModel.getReports(date)
        }
    }
}
