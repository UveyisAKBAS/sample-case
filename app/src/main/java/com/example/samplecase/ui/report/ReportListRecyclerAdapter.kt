package com.example.samplecase.ui.report

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.samplecase.R
import com.example.samplecase.domain.report.model.Report
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item_report.view.*

class ReportListRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var reports: List<Report> = ArrayList()

    private var onItemClick: ((Report) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val reportViewHolder = ReportViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_report, parent, false)
        )

        onItemClick?.let { listener ->
            reportViewHolder.setItemClickListener { position ->
                getItem(position)?.let { item ->
                    listener(item)
                }
            }
        }

        return reportViewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ReportViewHolder).bind(reports.get(position))
    }

    override fun getItemCount(): Int {
        return reports.size
    }

    fun assignReports(reportList: List<Report>) {
        reports = reportList
        notifyDataSetChanged()
    }

    fun setItemClickListener(onItemClick: ((Report) -> Unit)) {
        this.onItemClick = onItemClick
    }

    private fun getItem(position: Int): Report? {
        return reports.getOrNull(position)
    }

}

class ReportViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private var onItemClick: ((Int) -> Unit)? = null

    private val reportImageView: AppCompatImageView? = itemView.imageViewReportImage
    private val reportTitleView: AppCompatTextView? = itemView.textViewReportTitle
    private val reportDescriptionView: AppCompatTextView? = itemView.textViewReportDescription
    // Kotlin android recyclerview ...

    fun bind(report: Report) {

        Picasso.get()
            .load(report.urlToImage)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(reportImageView)
        reportTitleView?.text = report.title
        reportDescriptionView?.text = report.description
    }

    fun setItemClickListener(onItemClick: (Int) -> Unit) {
        this.onItemClick = onItemClick
        this.itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        onItemClick?.invoke(adapterPosition)
    }
}

