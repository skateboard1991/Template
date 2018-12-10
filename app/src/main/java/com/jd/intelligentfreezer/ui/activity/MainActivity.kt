package com.jd.intelligentfreezer.ui.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import com.jd.core.application.Constants
import com.jd.core.ui.activity.VMActivity
import com.jd.intelligentfreezer.R
import com.jd.intelligentfreezer.viewmodel.MainViewModel

@Route(path = Constants.MODULE_APP_MAINACTIVITY)
class MainActivity : VMActivity<MainViewModel>(), View.OnClickListener
{
    override fun loadViewModel(): MainViewModel
    {
        return ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_main)


    }

    override fun onClick(p0: View?)
    {


    }

    override fun getToolBarTitle(): String
    {
        return getString(R.string.app_name)
    }
}
