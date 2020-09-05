package com.example.samplecase.domain.base.usecase

import android.util.Log
import com.example.samplecase.domain.report.model.ReportItem
import com.example.samplecase.util.ReportIdlingResource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

abstract class BaseReportUseCase : BaseUseCase() {

    @Inject
    lateinit var reportIdlingResource: ReportIdlingResource
    private val disposable = CompositeDisposable()
    private val tag = BaseReportUseCase::class.simpleName

    fun execute(
        startDate: Date?,
        repositoryCallback: (Date) -> Observable<List<ReportItem>>,
        liveDataCallback: (List<ReportItem>?) -> Unit
    ) {
        if (startDate == null) return

        reportIdlingResource.setIsIdle(false)

        disposable.add(
            repositoryCallback(startDate).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeBy(
                    onNext = { liveDataCallback(it) },
                    onError = { Log.e(tag, "error: $it") }
                )
        )

        reportIdlingResource.setIsIdle(true)
    }

    fun dispose() {
        disposable.dispose()
    }
}
