package com.skateboard.template.application

import com.skateboard.core.application.BaseApplication
import com.skateboard.core.application.ModulesConfig

class AppApplication:BaseApplication()
{
    override fun initModuleApp()
    {
        for (moduleName in ModulesConfig.MODULE_NAMES)
        {
            try
            {
                val cla = Class.forName(moduleName)
                val application = cla.newInstance() as BaseApplication
                application.initModuleApp()
            } catch (e: ClassNotFoundException)
            {
                e.printStackTrace()
            } catch (e: Exception)
            {
                e.printStackTrace()
            }
        }
    }
}