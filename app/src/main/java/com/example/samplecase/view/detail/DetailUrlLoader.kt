package com.example.samplecase.view.detail

import android.webkit.WebView
import androidx.databinding.BindingAdapter

@BindingAdapter("detailUrl")
fun WebView.loadUrl(url: String?) {
    url?.let {
        this.loadUrl(url)
    }
}