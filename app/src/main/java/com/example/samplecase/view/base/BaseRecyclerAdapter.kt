package com.example.samplecase.view.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private var itemList: List<T> = ArrayList()
    private var onItemClick: ((T) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val viewHolder = createViewHolder(parent)

        onItemClick?.let { listener ->
            viewHolder.setItemClickListener { position ->
                getItem(position)?.let { item ->
                    listener(item)
                }
            }
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setItemClickListener(onItemClick: ((T) -> Unit)) {
        this.onItemClick = onItemClick
    }

    fun setItems(itemList: List<T>?) {
        this.itemList = itemList.orEmpty()
        notifyDataSetChanged()
    }

    fun getItem(position: Int): T? {
        return itemList.getOrNull(position)
    }

    abstract fun createViewHolder(parent: ViewGroup): BaseViewHolder<T>
}
