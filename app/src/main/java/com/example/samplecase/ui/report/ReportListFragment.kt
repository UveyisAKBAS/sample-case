package com.example.samplecase.ui.report

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplecase.R
import com.example.samplecase.databinding.FragmentReportListBinding
import com.example.samplecase.ui.base.BaseMvvmFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_report_list.*
import javax.inject.Inject

@AndroidEntryPoint
class ReportListFragment : BaseMvvmFragment<ReportListViewModel, FragmentReportListBinding>() {

    override val viewModel: ReportListViewModel by activityViewModels()

    @Inject
    lateinit var reportListRecyclerAdapter: ReportListRecyclerAdapter

    override fun getLayoutId(): Int = R.layout.fragment_report_list

    override fun initViews() {
        viewModel.getReports("2020-07-22")

        binding.reportViewModel = viewModel

        with(recyclerViewReportList) {
            layoutManager = LinearLayoutManager(context)
            adapter = reportListRecyclerAdapter.apply {
                setItemClickListener {
                    findNavController().navigate(ReportListFragmentDirections.actionReportListToReportDetails(
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
}
