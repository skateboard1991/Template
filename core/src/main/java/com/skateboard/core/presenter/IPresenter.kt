package com.skateboard.core.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

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
