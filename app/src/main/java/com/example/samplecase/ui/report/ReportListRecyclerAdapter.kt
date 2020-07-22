package com.example.samplecase.ui.report

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplecase.R
import com.example.samplecase.domain.report.model.Report
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item_report.view.*

class ReportListRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var reports: List<Report> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReportViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_report, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ReportViewHolder -> {
                holder.bind(reports.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return reports.size
    }

    fun assignReports(reportList: List<Report>) {
        reports = reportList
        notifyDataSetChanged()
    }

    class ReportViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val reportImageView = itemView.imageViewReportImage
        val reportTitleView = itemView.textViewReportTitle
        val reportDescriptionView = itemView.textViewReportDescription

        fun bind(report: Report) {

            Picasso.get()
                .load(report.urlToImage)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(reportImageView)
            reportTitleView.text = report.title
            reportDescriptionView.text = report.description
        }
    }
}

