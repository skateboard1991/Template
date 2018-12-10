package com.jd.core.application

object AppStatusManager
{
    private var isInitlized = false

    private val statusListenerSet= mutableSetOf<AppStatusListener>()

    fun isInitlized():Boolean= isInitlized

    fun notifyInitlized(){

        isInitlized=true
        for(listener in statusListenerSet){

            listener.onInitlized()
        }
    }

    fun registerStatusListener(listener:AppStatusListener){

        statusListenerSet.add(listener)
    }

    fun removeStatusListener(listener: AppStatusListener){

        statusListenerSet.remove(listener)
    }
}

interface AppStatusListener{

    fun onInitlized()
}