package com.skateboard.template

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.skateboard.core.network.Api
import com.skateboard.core.service.ServiceFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moduleABT.setOnClickListener(this)
        moduleBBT.setOnClickListener(this)
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
