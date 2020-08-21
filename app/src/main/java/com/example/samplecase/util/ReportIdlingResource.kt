package com.example.samplecase.util

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.IdlingResource.ResourceCallback
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

class ReportIdlingResource @Inject constructor() : IdlingResource {

    private var callback: ResourceCallback? = null
    private var isIdle = AtomicBoolean(true)

    override fun getName(): String = this.javaClass.name

    override fun isIdleNow(): Boolean = isIdle.get()

    override fun registerIdleTransitionCallback(callback: ResourceCallback?) {
        this.callback = callback
    }

    fun setIsIdle(isIdle: Boolean) {
        this.isIdle.set(isIdle)
        if (isIdle && callback != null) {
            callback!!.onTransitionToIdle()
        }
    }
}
