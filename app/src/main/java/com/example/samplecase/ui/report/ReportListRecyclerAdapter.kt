package com.example.samplecase.ui.report

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.samplecase.databinding.RecyclerItemReportBinding
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.view.base.BaseRecyclerAdapter
import com.example.samplecase.view.base.BaseViewHolder

class ReportListRecyclerAdapter : BaseRecyclerAdapter<ReportItem>() {

    override fun onBindViewHolder(holder: BaseViewHolder<ReportItem>, position: Int) {
        holder.bind(itemList.get(position))
    }

    override fun createViewHolder(parent: ViewGroup): BaseViewHolder<ReportItem> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerItemReportBinding.inflate(inflater)
        return ReportViewHolder(binding)
    }
}


class ReportViewHolder(private val reportItemBinding: RecyclerItemReportBinding) :
    BaseViewHolder<ReportItem>(reportItemBinding) {

    override fun bind(item: ReportItem) {
        reportItemBinding.reportItem = item
        reportItemBinding.executePendingBindings()
    }
}
