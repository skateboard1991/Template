package com.skateboard.template.ui.activity

import android.os.Bundle
import android.os.Handler
import com.skateboard.core.application.AppStatusManager
import com.skateboard.core.application.Constants
import com.skateboard.core.ui.activity.BaseActivity
import com.skateboard.core.util.navigation
import com.skateboard.template.R

class SplashActivity : BaseActivity()
{

    private val handler=Handler()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler.postDelayed({
            AppStatusManager.isInitlized=true
            navigation(Constants.MODULE_ACCOUNT_LOGINACTIVITY)
            finish()
        },2000L)
    }
}