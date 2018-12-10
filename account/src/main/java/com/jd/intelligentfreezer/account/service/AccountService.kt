package com.jd.intelligentfreezer.account.service

import com.jd.core.bean.User
import com.jd.core.service.account.IAccountService

class AccountService : IAccountService
{
    override fun getUserInfo(): User
    {
        return User()
    }
}