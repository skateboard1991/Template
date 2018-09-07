package com.skateboard.modulea

import com.skateboard.core.application.BaseApplication
import com.skateboard.core.service.ServiceFactory

class ModuleAApplication : BaseApplication()
{

    override fun initModuleApp()
    {
        ServiceFactory.registerModuleAService(ModuleAServiceImp())
    }
}