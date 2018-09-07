package com.skateboard.core.service

import com.skateboard.core.service.modulea.ModuleAService
import com.skateboard.core.service.moduleb.ModuleBService
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

object ServiceFactory
{
    var moduleAService: ModuleAService? = null
        get()
        {
            if (field == null)
            {
                field = Proxy.newProxyInstance(ModuleAService::class.java.classLoader, arrayOf(ModuleAService::class.java), object : InvocationHandler
                {
                    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any?
                    {
                        return null
                    }
                }) as ModuleAService?

            }
            return field
        }

    var moduleBService: ModuleBService? = null
        get()
        {
            if (field == null)
            {
                field = Proxy.newProxyInstance(ModuleBService::class.java.classLoader, arrayOf(ModuleBService::class.java), object : InvocationHandler
                {
                    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any?
                    {
                        return null
                    }
                }) as ModuleBService?

            }
            return field
        }


    fun registerModuleAService(service: ModuleAService)
    {
        moduleAService = service
    }

    fun registerModuleBService(service: ModuleBService)
    {
        moduleBService = service
    }

}