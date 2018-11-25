package com.skateboard.loginmodule.serviceimp

import com.skateboard.core.bean.User
import com.skateboard.core.service.account.AccountService

class AccountServiceImp:AccountService
{
    override fun getUserInfo(): User
    {
       return User()
    }
}