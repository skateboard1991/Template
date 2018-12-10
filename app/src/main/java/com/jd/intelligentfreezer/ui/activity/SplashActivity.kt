package com.jd.intelligentfreezer.ui.activity

import android.os.Bundle
import android.os.Handler
import com.alibaba.android.arouter.facade.annotation.Route
import com.jd.core.application.AppStatusManager
import com.jd.core.application.Constants
import com.jd.core.ui.activity.BaseActivity
import com.jd.core.util.navigation
import com.jd.intelligentfreezer.R

@Route(path = Constants.MODULE_APP_SPLASHACTIVITY)
class SplashActivity : BaseActivity()
{

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_splash)
        handler.postDelayed({
            AppStatusManager.notifyInitlized()
            navigation(Constants.MODULE_ACCOUNT_LOGINACTIVITY)
            finish()
        }, 2000L)
    }
}