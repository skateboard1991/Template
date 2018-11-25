package com.skateboard.loginmodule.ui

import com.skateboard.core.ui.activity.VMActivity
import com.skateboard.loginmodule.viewmodel.AccountModel

class RegisterActivity:VMActivity<AccountModel>()
{
    override fun loadViewModel(): AccountModel
    {
        return AccountModel()
    }
}