package com.jd.core.ui.activity

import androidx.lifecycle.ViewModel

abstract class VMActivity<T:ViewModel>:BaseActivity()
{
    protected val mViewModel:T by lazy {

        loadViewModel()
    }

    abstract fun loadViewModel():T
}