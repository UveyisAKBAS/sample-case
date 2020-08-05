package com.example.samplecase.ui.detail

import androidx.navigation.fragment.navArgs
import com.example.samplecase.R
import com.example.samplecase.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_report_details.*

class ReportDetailsFragment : BaseFragment() {

    private val args: ReportDetailsFragmentArgs by navArgs()

    override fun getLayoutId(): Int = R.layout.fragment_report_details

    override fun initViews() {
        args.argumentReportItem?.url?.let {
            webViewReportDescription.loadUrl(it)
        }
    }
}
