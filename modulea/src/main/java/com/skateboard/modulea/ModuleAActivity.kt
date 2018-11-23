package com.skateboard.modulea

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.skateboard.core.service.ServiceFactory
import kotlinx.android.synthetic.main.activity_modulea.*

@Route(path = "/a/activity")
class ModuleAActivity : AppCompatActivity(), View.OnClickListener
{


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modulea)
        enterModuleB.setOnClickListener(this)
        getDataButton.setOnClickListener(this)
    }

    override fun onClick(v: View?)
    {

        when (v?.id)
        {
            R.id.enterModuleB ->
            {
                ARouter.getInstance().build("/moduleb/activity").navigation()
            }

            R.id.getDataButton ->
            {
                dataTV.text = ServiceFactory.moduleBService?.getModuleBName()?:"empty"
            }
        }

    }
}