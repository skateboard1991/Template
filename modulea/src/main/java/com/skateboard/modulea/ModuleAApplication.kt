package com.skateboard.modulea

import com.alibaba.android.arouter.launcher.ARouter
import com.skateboard.core.application.BaseApplication
import com.skateboard.core.service.ServiceFactory

class ModuleAApplication : BaseApplication()
{

    override fun onCreate()
    {
        super.onCreate()
        ARouter.init(this)
    }

    override fun initModuleApp()
    {
        ServiceFactory.registerModuleAService(ModuleAServiceImp())
    }
}