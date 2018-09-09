package com.skateboard.moduleb

import com.alibaba.android.arouter.launcher.ARouter
import com.skateboard.core.application.BaseApplication
import com.skateboard.core.service.ServiceFactory

class ModuleBApplication : BaseApplication()
{
    override fun onCreate()
    {
        super.onCreate()
        ARouter.init(this)
    }

    override fun initModuleApp()
    {
        ServiceFactory.registerModuleBService(ModuleBServiceImp())
    }
}