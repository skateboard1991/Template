package com.jd.intelligentfreezer.account.viewmodel

import android.widget.EditText
import com.jd.core.viewmodel.BaseViewModel

class AccountViewModel : BaseViewModel()
{

    private val INVALID = "invalid"

    private val USERNAME_INVALID = "username_invalid"

    private val PASSWORD_INVALID = "password_invalid"

    fun checkIsInvalide(userNameET: EditText, passwordET: EditText): Boolean
    {
        val userName = userNameET.editableText.toString()
        val password = passwordET.editableText.toString()
        val userNameInvalid = checkIsInvalidedUserName(userName)
        if (userNameInvalid != INVALID)
        {
            userNameET.error = userNameInvalid
            return false
        }
        val passwordInvalid = checkIsInvalidedPassword(password)
        if (passwordInvalid != INVALID)
        {
            passwordET.error = passwordInvalid
            return false
        }
        return true
    }

    private fun checkIsInvalidedUserName(userName: String?): String
    {

        return if (userName?.isNotEmpty() == true)
        {

            INVALID
        } else
        {
            USERNAME_INVALID
        }
    }

    private fun checkIsInvalidedPassword(password: String?): String
    {

        return if (password?.isNotEmpty() == true)
        {

            INVALID
        } else
        {
            PASSWORD_INVALID
        }


    }
}