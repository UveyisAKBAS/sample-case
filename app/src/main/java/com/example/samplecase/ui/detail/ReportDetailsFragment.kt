package com.example.samplecase.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.samplecase.R
import com.example.samplecase.databinding.FragmentReportDetailsBinding

class ReportDetailsFragment : Fragment() {

    private val args: ReportDetailsFragmentArgs by navArgs()

    lateinit var binding: FragmentReportDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_report_details, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null)
            initViews()
    }

    private fun initViews() {

        args.argumentReportItem?.url?.let {
            binding.url = it
        }
    }
}