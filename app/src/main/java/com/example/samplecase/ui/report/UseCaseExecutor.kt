package com.example.samplecase.ui.report

import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.util.ReportIdlingResource
import kotlinx.coroutines.*
import java.util.*

object UseCaseExecutor {

    fun execute(
        startDate: Date?,
        reportIdlingResource: ReportIdlingResource?,
        callbackOne: suspend (Date) -> List<ReportItem>?,
        callbackTwo: suspend (List<ReportItem>?) -> Unit
    ) {
        if (startDate == null) return

        CoroutineScope(Dispatchers.IO).launch {
            reportIdlingResource?.setIsIdle(false)

            try {
                if (isActive) {
                    val response = callbackOne(startDate)
                    withContext(Dispatchers.Main) {
                        callbackTwo(response)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    callbackTwo(null)
                }
            }
        }

        reportIdlingResource?.setIsIdle(true)
    }
}
