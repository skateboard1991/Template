package com.jd.intelligentfreezer.account.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.jd.intelligentfreezer.account.R
import com.jd.intelligentfreezer.account.viewmodel.AccountViewModel
import com.jd.core.application.Constants
import com.jd.core.ui.activity.VMActivity
import com.jd.core.util.navigation
import kotlinx.android.synthetic.main.account_activity_login.*

@Route(path = Constants.MODULE_ACCOUNT_LOGINACTIVITY)
class LoginActivity : VMActivity<AccountViewModel>()
{
    override fun loadViewModel(): AccountViewModel = AccountViewModel()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_activity_login)
        loginBT.setOnClickListener {
            if (mViewModel.checkIsInvalide(userNameET, passwordET))
            {
                navigation(Constants.MODULE_APP_MAINACTIVITY)
                finish()
            }

        }
    }

}