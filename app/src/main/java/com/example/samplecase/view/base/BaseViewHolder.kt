package com.example.samplecase.view.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.samplecase.databinding.RecyclerItemReportBinding
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<T>(itemBinding: RecyclerItemReportBinding) :
    RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener, LayoutContainer {

    override val containerView: View?
        get() = itemView

    var onItemClick: ((Int) -> Unit)? = null

    abstract fun bind(item: T)

    fun setItemClickListener(onItemClick: (Int) -> Unit) {
        this.onItemClick = onItemClick
        this.itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        onItemClick?.invoke(adapterPosition)
    }

}