package com.skateboard.core.ui.activity

import androidx.lifecycle.ViewModel
import android.os.Bundle

abstract class VMActivity<T:ViewModel>:BaseActivity()
{
    protected val mViewModel:T by lazy {

        loadViewModel()
    }

    abstract fun loadViewModel():T
}