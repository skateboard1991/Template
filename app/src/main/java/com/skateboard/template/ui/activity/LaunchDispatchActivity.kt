package com.skateboard.template.ui.activity

import android.content.Intent
import android.os.Bundle
import com.skateboard.core.application.AppStatusManager
import com.skateboard.core.application.Constants
import com.skateboard.core.service.ServiceLocator
import com.skateboard.core.ui.activity.BaseActivity
import com.skateboard.core.util.navigation

class LaunchDispatchActivity : BaseActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        if (!AppStatusManager.isInitlized)
        {
            enterSplashActivity()

        } else
        {
            if(ServiceLocator.accountService?.getUserInfo()?.userName?.isNotEmpty() == true){
                enterMainActivity()
            }
            else{
                enterLoginActivity()
            }
        }
    }

    private fun enterMainActivity()
    {

        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)

        finish()

    }

    private fun enterSplashActivity()
    {

        val intent = Intent(this, SplashActivity::class.java)

        startActivity(intent)

        finish()
    }

    private fun enterLoginActivity(){
        navigation(Constants.MODULE_ACCOUNT_LOGINACTIVITY)
        finish()
    }
}