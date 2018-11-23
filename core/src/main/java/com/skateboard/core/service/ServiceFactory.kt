package com.skateboard.core.service

import com.skateboard.core.service.modulea.ModuleAService
import com.skateboard.core.service.moduleb.ModuleBService


object ServiceFactory
{
    var moduleAService: ModuleAService? = null

    var moduleBService: ModuleBService? = null


    fun registerModuleAService(service: ModuleAService)
    {
        moduleAService = service
    }

    fun registerModuleBService(service: ModuleBService)
    {
        moduleBService = service
    }

}