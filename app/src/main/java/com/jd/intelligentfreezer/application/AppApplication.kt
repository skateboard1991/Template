package com.jd.intelligentfreezer.application

import com.alibaba.android.arouter.launcher.ARouter
import com.jd.core.application.BaseApplication
import com.jd.core.application.ModulesConfig
import com.jd.intelligentfreezer.BuildConfig

class AppApplication : BaseApplication()
{
    override fun onCreate()
    {
        super.onCreate()
        if (BuildConfig.DEBUG)
        {
            ARouter.openLog()
            ARouter.openDebug()
        }
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