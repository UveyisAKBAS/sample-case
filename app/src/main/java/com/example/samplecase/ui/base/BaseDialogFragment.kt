package com.example.samplecase.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.samplecase.di.ViewModelFactory
import dagger.android.support.DaggerDialogFragment
import javax.inject.Inject

abstract class BaseDialogFragment : DaggerDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null)
            initViews()

        observeEvents()
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initViews()

    protected open fun observeEvents() = Unit
}
