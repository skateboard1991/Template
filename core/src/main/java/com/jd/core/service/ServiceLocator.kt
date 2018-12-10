package com.jd.core.service

import com.jd.core.service.account.IAccountService
import com.jd.core.service.modulea.ModuleAService



object ServiceLocator
{
    var moduleAService: ModuleAService? = null

    var accountService: IAccountService?= null

}