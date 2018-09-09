package com.skateboard.core.service

import com.skateboard.core.service.modulea.ModuleAService
import com.skateboard.core.service.moduleb.ModuleBService
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

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