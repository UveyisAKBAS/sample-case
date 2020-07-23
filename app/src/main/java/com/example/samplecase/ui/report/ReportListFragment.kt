package com.example.samplecase.ui.report

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplecase.R
import com.example.samplecase.domain.report.model.Report
import kotlinx.android.synthetic.main.fragment_report_list.*

class ReportListFragment : Fragment() {

    private val TAG = "examination"

    private val viewModel: ReportListViewModel by activityViewModels()

    private val reportListRecyclerAdapter by lazy {
        ReportListRecyclerAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_report_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null)
            initViews()

        observeEvents()
    }


    private fun initViews() {

        viewModel.getReports("2020-07-22")

        recyclerViewReportList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = reportListRecyclerAdapter.apply {
                setItemClickListener {
                    findNavController().navigate(
                        ReportListFragmentDirections.actionReportListToReportDetails(it)
                    )
                }
            }

        }

        buttonDate.setOnClickListener() {
            findNavController().navigate(ReportListFragmentDirections.actionFragmentReportListToDialogDatePicker())
        }
    }

    private fun observeEvents() {

        viewModel.reportList.observe(viewLifecycleOwner, Observer {
            reportListRecyclerAdapter.assignReports(it.toList())
            Log.i(TAG,"reportList updated")
        })
    }
}