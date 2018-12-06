package com.skateboard.core.util

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter


fun Context.navigation(path:String){

    ARouter.getInstance().build(path).navigation()
}

