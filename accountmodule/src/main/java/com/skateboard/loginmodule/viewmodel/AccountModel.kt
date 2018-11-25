package com.skateboard.loginmodule.viewmodel


import androidx.lifecycle.MutableLiveData
import com.skateboard.core.bean.Response
import com.skateboard.core.bean.User
import com.skateboard.core.viewmodel.BaseViewModel
import com.skateboard.loginmodule.repository.AccountRepository
import io.reactivex.functions.Consumer

class AccountModel : BaseViewModel()
{
    val userInfo: MutableLiveData<User> by lazy {

        MutableLiveData<User>()
    }

    fun register(userName: String, password: String)
    {


    }

    fun login(userName: String, password: String)
    {

        request(AccountRepository.login(userName, password), Consumer<Response<User>> {

            userInfo.value=it.data

        }, Consumer<Throwable> {


        })
    }

}