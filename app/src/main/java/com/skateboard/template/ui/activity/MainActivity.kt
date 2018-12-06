package com.skateboard.template.ui.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.launcher.ARouter
import com.skateboard.core.ui.activity.VMActivity
import com.skateboard.template.R
import com.skateboard.template.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : VMActivity<MainViewModel>(), View.OnClickListener
{
    override fun loadViewModel(): MainViewModel
    {
        return ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moduleABT.setOnClickListener(this)
        moduleBBT.setOnClickListener(this)
        lifecycle.addObserver(mViewModel)

    }

    override fun onClick(p0: View?)
    {

        when (p0?.id)
        {
            R.id.moduleABT ->
            {
                ARouter.getInstance().build("/a/activity").navigation()
            }

            R.id.moduleBBT ->
            {
                ARouter.getInstance().build("/b/activity").navigation()
            }
        }


    }
}
