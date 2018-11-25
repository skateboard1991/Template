package com.skateboard.core.service

import com.skateboard.core.service.account.AccountService
import com.skateboard.core.service.modulea.ModuleAService


object ServiceLocator
{
    var moduleAService: ModuleAService? = null

    var accountService:AccountService?=null



}