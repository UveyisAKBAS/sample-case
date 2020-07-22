package com.example.samplecase.ui.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplecase.R
import kotlinx.android.synthetic.main.fragment_report_list.*

class ReportListFragment : Fragment() {

    val viewModel: ReportListViewModel by viewModels()

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
            adapter = reportListRecyclerAdapter


        }

        buttonDate.setOnClickListener() {
            findNavController().navigate(ReportListFragmentDirections.actionReportListToReportDetails())
        }
    }

    private fun observeEvents() {

        viewModel.reportList.observe(viewLifecycleOwner, Observer {
            reportListRecyclerAdapter.assignReports(it.toList())
        })
    }
}