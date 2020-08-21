package com.example.samplecase.domain.base.usecase

import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.util.ReportIdlingResource
import kotlinx.coroutines.*
import java.util.*

abstract class BaseReportUseCase : BaseUseCase() {

    fun execute(
        startDate: Date?,
        reportIdlingResource: ReportIdlingResource?,
        repositoryCallback: suspend (Date) -> List<ReportItem>?,
        liveDataCallback: suspend (List<ReportItem>?) -> Unit
    ) {
        if (startDate == null) return

        CoroutineScope(Dispatchers.IO).launch {
            reportIdlingResource?.setIsIdle(false)

            try {
                if (isActive) {
                    val response = repositoryCallback(startDate)
                    withContext(Dispatchers.Main) {
                        liveDataCallback(response)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    liveDataCallback(null)
                }
            }
        }

        reportIdlingResource?.setIsIdle(true)
    }
}