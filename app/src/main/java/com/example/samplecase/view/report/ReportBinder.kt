package com.example.samplecase.view.report

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samplecase.ui.report.ReportListRecyclerAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl", "error")
fun AppCompatImageView.bindImage(imageUrl: String?, error: Drawable) =
    Picasso.get().load(imageUrl).error(error).into(this)

@BindingAdapter("adapter", "layoutManager")
fun RecyclerView.setRecyclerView(
    adapter: ReportListRecyclerAdapter,
    layoutManager: LinearLayoutManager
) {
    this.layoutManager = layoutManager
    this.adapter = adapter
}