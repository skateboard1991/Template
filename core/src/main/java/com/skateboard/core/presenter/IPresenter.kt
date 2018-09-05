package com.skateboard.core.presenter

class IPresenter<V : IView>
{
    private var mView: V? = null

    open fun attach(view: V)
    {

        mView = view
    }

    open fun detach()
    {
        mView = null
    }
}
