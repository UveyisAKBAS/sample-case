package com.example.samplecase.ui.report

import com.example.samplecase.BR
import com.example.samplecase.R
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.view.base.BaseRecyclerBindingAdapter

class ReportListRecyclerAdapter() : BaseRecyclerBindingAdapter<ReportItem>(
    R.layout.recycler_item_report,
    BR.reportItem
)
