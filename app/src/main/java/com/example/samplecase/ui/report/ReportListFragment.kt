package com.example.samplecase.ui.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplecase.R
import com.example.samplecase.databinding.FragmentReportListBinding
import com.example.samplecase.domain.report.model.ReportItem
import kotlinx.android.synthetic.main.fragment_report_list.*

class ReportListFragment : Fragment() {

    private val viewModel: ReportListViewModel by activityViewModels()

    private val reportListRecyclerAdapter by lazy {
        ReportListRecyclerAdapter<ReportItem>(R.layout.recycler_item_report, BR.reportItem)
    }

    lateinit var binding: FragmentReportListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_report_list, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null)
            initViews()
    }


    private fun initViews() {

        viewModel.getReports("2020-07-22")

        binding.reportViewModel = viewModel

        binding.recyclerViewReportList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewReportList.adapter = reportListRecyclerAdapter.apply {
            setItemClickListener {
                findNavController().navigate(
                    ReportListFragmentDirections.actionReportListToReportDetails(it)
                )
            }
        }

        buttonDate.setOnClickListener() {
            findNavController().navigate(ReportListFragmentDirections.actionFragmentReportListToDialogDatePicker())
        }
    }
}