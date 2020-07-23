package com.example.samplecase.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.samplecase.R
import kotlinx.android.synthetic.main.fragment_report_details.*

class ReportDetailsFragment : Fragment() {

    private val args: ReportDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_report_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null)
            initViews()

    }

    private fun initViews() {
        args.argumentReportUrl?.url.let {reportUrl ->
            webViewReportDescription.loadUrl(reportUrl)
        }

    }
}