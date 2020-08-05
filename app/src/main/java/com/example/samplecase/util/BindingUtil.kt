package com.example.samplecase.util

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.samplecase.view.base.BaseRecyclerAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl", "error")
fun AppCompatImageView.bindImage(imageUrl: String?, error: Drawable) =
    Picasso.get().load(imageUrl).error(error).into(this)

@Suppress("UNCHECKED_CAST")
@BindingAdapter("items")
fun <T> setItems(view: RecyclerView, itemList: List<T>?) {
    (view.adapter as BaseRecyclerAdapter<T>).setItems(itemList)
}
