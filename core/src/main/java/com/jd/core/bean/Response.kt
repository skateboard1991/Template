package com.jd.core.bean

class Response<T>
{

    var code = 0

    var message: String = ""

    var data: T? = null

    fun isSuccess(): Boolean = code in 200..399


}