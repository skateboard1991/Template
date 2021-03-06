package com.skateboard.template.application

import com.alibaba.android.arouter.launcher.ARouter
import com.skateboard.core.application.BaseApplication
import com.skateboard.core.application.ModulesConfig

class AppApplication : BaseApplication()
{
    override fun onCreate()
    {
        super.onCreate()
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

    override fun initModuleApp()
    {
        for (moduleName in ModulesConfig.MODULE_NAMES)
        {
            try
            {
                val cla = Class.forName(moduleName)
                val application = cla.newInstance() as BaseApplication
                application.initModuleApp()
            }
            catch (e: ClassNotFoundException)
            {
                e.printStackTrace()
            }
            catch (e: Exception)
            {
                e.printStackTrace()
            }
        }
    }
}