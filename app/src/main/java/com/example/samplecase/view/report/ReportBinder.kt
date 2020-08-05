package com.example.samplecase.view.report

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.ui.report.ReportListRecyclerAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl", "error")
fun AppCompatImageView.bindImage(imageUrl: String?, error: Drawable) =
    Picasso.get().load(imageUrl).error(error).into(this)

@Suppress("UNCHECKED_CAST")
@BindingAdapter("items")
fun setItems(view: RecyclerView, itemList: List<ReportItem>?) {

    itemList?.let {
        (view.adapter as ReportListRecyclerAdapter<ReportItem>).setItems(it)
    }

}