package com.jd.intelligentfreezer.account.service

import com.skateboard.core.bean.User
import com.skateboard.core.service.account.IAccountService

class AccountService : IAccountService
{
    override fun getUserInfo(): User
    {
        return User()
    }
}