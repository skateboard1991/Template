package com.skateboard.core.application

import android.app.Application

open class BaseApplication : Application()
{
    override fun onCreate()
    {
        super.onCreate()
        initModuleApp()
    }

    open fun initModuleApp()
    {

    }
}