package com.example.samplecase.ui.report

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.samplecase.R
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.view.base.BaseRecyclerAdapter
import com.example.samplecase.view.base.BaseViewHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item_report.*

class ReportListRecyclerAdapter : BaseRecyclerAdapter<ReportItem>() {

    override fun onBindViewHolder(holder: BaseViewHolder<ReportItem>, position: Int) {
        holder.bind(itemList.get(position))
    }

    override fun createViewHolder(parent: ViewGroup): BaseViewHolder<ReportItem> {
        return ReportViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_report, parent, false)
        )
    }
}


class ReportViewHolder(itemView: View) : BaseViewHolder<ReportItem>(itemView) {

    override fun bind(item: ReportItem) {

        Picasso.get()
            .load(item.urlToImage)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(imageViewReportImage)
        textViewReportTitle?.text = item.title
        textViewReportDescription?.text = item.description
    }
}

