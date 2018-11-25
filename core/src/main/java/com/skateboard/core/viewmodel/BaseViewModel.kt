package com.skateboard.core.viewmodel

import androidx.lifecycle.ViewModel
import com.skateboard.core.network.CommonTransformer
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer


open class BaseViewModel : ViewModel()
{

    val disposables = mutableListOf<Disposable>()


    fun <T> request(observable: Observable<T>, onNext: (T) -> Unit, onError: (Throwable) -> Unit, onCompleted: () -> Unit = { hideLoading() }, onSubscribe: (Disposable) -> Unit =
            { showLoading() })
    {

        val disposable = observable.compose(CommonTransformer())
                .subscribe(onNext, onError, onCompleted, onSubscribe)
        disposables.add(disposable)
    }

    fun <T> request(observable: Observable<T>, onNext: Consumer<T>, onError: Consumer<Throwable>, onCompleted: Action = Action {
        hideLoading()
    }, onSubscribe: Consumer<Disposable> =
                            Consumer<Disposable> {
                                showLoading()
                            })
    {

        val disposable = observable.compose(CommonTransformer())
                .subscribe(onNext, onError, onCompleted, onSubscribe)
        disposables.add(disposable)

    }

    fun showLoading()
    {


    }

    fun hideLoading()
    {

    }


    override fun onCleared()
    {
        super.onCleared()
        for (disposable in disposables)
        {
            if (!disposable.isDisposed)
            {
                disposable.dispose()
            }
        }
    }
}