package com.example.samplecase.domain.base.usecase

import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.util.ReportIdlingResource
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

abstract class BaseReportUseCase : BaseUseCase() {

    @Inject
    lateinit var reportIdlingResource: ReportIdlingResource

    fun execute(
        startDate: Date?,
        repositoryCallback: suspend (Date) -> List<ReportItem>?,
        liveDataCallback: suspend (List<ReportItem>?) -> Unit
    ) {
        if (startDate == null) return

        CoroutineScope(Dispatchers.IO).launch {
            reportIdlingResource.setIsIdle(false)

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

        reportIdlingResource.setIsIdle(true)
    }
}
