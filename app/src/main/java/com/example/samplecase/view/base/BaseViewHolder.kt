package com.example.samplecase.view.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class BaseViewHolder<T>(val itemBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener, LayoutContainer {

    override val containerView: View?
        get() = itemView

    var onItemClick: ((Int) -> Unit)? = null

    fun setItemClickListener(onItemClick: (Int) -> Unit) {
        this.onItemClick = onItemClick
        this.itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        onItemClick?.invoke(adapterPosition)
    }

}