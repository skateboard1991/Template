package com.jd.intelligentfreezer.account.applicaton

import com.jd.intelligentfreezer.account.service.AccountService
import com.jd.core.application.BaseApplication
import com.jd.core.service.ServiceLocator

class AccountApplication:BaseApplication()
{
    override fun initModuleApp()
    {
        super.initModuleApp()
        ServiceLocator.accountService=AccountService()
    }
}