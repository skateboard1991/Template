package com.skateboard.core.service

import com.skateboard.core.service.account.IAccountService
import com.skateboard.core.service.modulea.ModuleAService



object ServiceLocator
{
    var moduleAService: ModuleAService? = null

    var accountService: IAccountService?= null

}