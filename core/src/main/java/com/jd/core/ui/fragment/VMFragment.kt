package com.jd.core.ui.fragment

import androidx.lifecycle.ViewModel

abstract class VMFragment<T:ViewModel>:BaseFragment()
{
    protected val mViewModel:T by lazy {

        loadViewModel()
    }

    abstract fun loadViewModel():T
}