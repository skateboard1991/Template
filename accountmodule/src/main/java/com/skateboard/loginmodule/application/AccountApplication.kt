package com.skateboard.loginmodule.application

import com.skateboard.core.application.BaseApplication
import com.skateboard.core.service.ServiceLocator
import com.skateboard.loginmodule.serviceimp.AccountServiceImp

class AccountApplication : BaseApplication()
{
    override fun initModuleApp()
    {
        super.initModuleApp()
        ServiceLocator.accountService = AccountServiceImp()
    }
}