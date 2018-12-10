package com.jd.intelligentfreezer.ui.activity

import android.os.Bundle
import com.jd.core.application.AppStatusManager
import com.jd.core.application.Constants
import com.jd.core.service.ServiceLocator
import com.jd.core.ui.activity.BaseActivity
import com.jd.core.util.navigation

class LaunchDispatchActivity : BaseActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        if (!AppStatusManager.isInitlized())
        {
            enterSplashActivity()

        } else
        {
            if (ServiceLocator.accountService?.getUserInfo()?.userName?.isNotEmpty() == true)
            {
                enterMainActivity()
            } else
            {
                enterLoginActivity()
            }
        }
    }

    private fun enterMainActivity()
    {

        navigation(Constants.MODULE_APP_MAINACTIVITY)

        finish()

    }

    private fun enterSplashActivity()
    {

        navigation(Constants.MODULE_APP_SPLASHACTIVITY)

        finish()
    }

    private fun enterLoginActivity()
    {
        navigation(Constants.MODULE_ACCOUNT_LOGINACTIVITY)

        finish()
    }
}