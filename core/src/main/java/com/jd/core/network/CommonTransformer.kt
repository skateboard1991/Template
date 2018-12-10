package com.jd.core.network

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CommonTransformer<T>:ObservableTransformer<T,T>
{
    override fun apply(upstream: Observable<T>): ObservableSource<T>
    {
        return upstream.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
    }


}