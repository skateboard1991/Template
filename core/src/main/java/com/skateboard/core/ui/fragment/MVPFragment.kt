package com.skateboard.core.ui.fragment

import android.os.Bundle
import com.skateboard.core.presenter.IPresenter
import com.skateboard.core.presenter.IView

abstract class MVPFragment<V : IView, P : IPresenter<V>> : BaseFragment(), IView
{
    private var mPresenter: P? = null

    abstract fun loadPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mPresenter = loadPresenter()
        mPresenter?.attach(this as V)
    }

    override fun onDestroy()
    {
        super.onDestroy()
        mPresenter?.detach()
    }
}