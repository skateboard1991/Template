package com.jd.core.util

import android.util.Log
import com.jd.core.BuildConfig

class LogUtil
{
    companion object
    {

       fun logD(tag:String,message:String){

           if(BuildConfig.DEBUG){

               Log.d(tag,message)
           }
       }

        fun logE(tag:String,message:String){

            if(BuildConfig.DEBUG){

                Log.e(tag,message)
            }
        }

        fun logI(tag:String,message:String){

            if(BuildConfig.DEBUG){

                Log.i(tag,message)
            }
        }

    }

}