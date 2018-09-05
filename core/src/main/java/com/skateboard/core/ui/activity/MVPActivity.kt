package com.skateboard.core.ui.activity

import android.os.Bundle
import com.skateboard.core.presenter.IPresenter
import com.skateboard.core.presenter.IView

abstract class MVPActivity<V : IView, P : IPresenter<V>> : BaseActivity(),IView
{

    private var mPresenter: P? = null

    abstract fun loadPresenter(): P

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mPresenter = loadPresenter()
        mPresenter?.attach(this as V)
        getLayoutId()
    }

    override fun onDestroy()
    {
        super.onDestroy()
        mPresenter?.detach()
    }
}