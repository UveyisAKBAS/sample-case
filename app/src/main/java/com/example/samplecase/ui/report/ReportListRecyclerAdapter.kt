package com.example.samplecase.ui.report

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.samplecase.view.base.BaseRecyclerAdapter
import com.example.samplecase.view.base.BaseViewHolder

class ReportListRecyclerAdapter<T>(val layoutId: Int, val bindingItemId: Int) :
    BaseRecyclerAdapter<T>() {

    override fun createViewHolder(parent: ViewGroup): BaseViewHolder<T> {

        val binding: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)

        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.itemBinding.setVariable(bindingItemId, getItem(position))
    }
}