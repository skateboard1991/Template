package com.skateboard.core.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

open class IPresenter<V : IView>:LifecycleObserver
{
    private var mView: V? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun attach(view: V)
    {

        mView = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun detach()
    {
        mView = null
    }
}
