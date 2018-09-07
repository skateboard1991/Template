package com.skateboard.template

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.skateboard.core.network.Api
import com.skateboard.core.service.ServiceFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moduleATV.text = ServiceFactory.moduleAService?.getModuleAName()
        moduleBTV.text = ServiceFactory.moduleBService?.getModuleBName()
    }
}
