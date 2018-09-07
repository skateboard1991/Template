package com.skateboard.moduleb

import com.skateboard.core.application.BaseApplication
import com.skateboard.core.service.ServiceFactory

class ModuleBApplication : BaseApplication()
{
    override fun initModuleApp()
    {
        ServiceFactory.registerModuleBService(ModuleBServiceImp())
    }
}