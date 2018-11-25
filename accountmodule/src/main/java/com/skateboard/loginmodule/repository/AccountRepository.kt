package com.skateboard.loginmodule.repository


import com.skateboard.core.bean.Response
import com.skateboard.core.bean.User
import com.skateboard.core.network.NetWorkUtil
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.POST

object AccountRepository
{

    fun login(userName: String, password: String): Observable<Response<User>> = NetWorkUtil.create(IAccountService::class.java).login(userName, password)

    fun register(userName: String, password: String): Observable<Response<String>> = NetWorkUtil.create(IAccountService::class.java).register(userName, password)

}


interface IAccountService
{
    @POST("")
    fun register(@Field("userName") userName: String, @Field("password") password: String): Observable<Response<String>>

    @POST()
    fun login(@Field("userName") userName: String, @Field("password") password: String): Observable<Response<User>>
}