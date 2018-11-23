package com.skateboard.core.model

abstract class BaseModel
{
    var errorMessage:String=""

    abstract fun isSuccess():Boolean

}