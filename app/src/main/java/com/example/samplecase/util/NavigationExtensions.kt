package com.example.samplecase.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

fun <T> Fragment.setResult(key: String, result: T) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
    finish()
}

fun Fragment.finish() {
    findNavController().popBackStack()
}

fun <T> Fragment.onResult(key: String, callback: (T?) -> Unit) {
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key, null)
        ?.observe(viewLifecycleOwner, Observer { result ->
            callback(result)
        })
}
