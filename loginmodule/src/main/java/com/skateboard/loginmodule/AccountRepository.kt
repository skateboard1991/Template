package com.skateboard.loginmodule

import androidx.lifecycle.LiveData
import com.skateboard.core.model.BaseModel
import com.skateboard.core.network.NetWorkUtil
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

class AccountRepository
{
    fun login(userName: String, password: String): LiveData<BaseModel> = NetWorkUtil.transToLiveData<BaseModel>(NetWorkUtil.create(IAccountService::class.java).login(userName, password))


}

interface IAccountService
{
    @POST("")
    fun register(@Field("userName")userName:String,@Field("password")password:String)

    @GET()
    fun login(@Field("userName")userName: String, @Field("password")password: String): Observable<BaseModel>
}