package com.jd.core.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.jd.core.R
import com.jd.core.application.SystemBroadCast
import com.jd.core.util.LogUtil
import kotlinx.android.synthetic.main.toolbar_layout.view.*


abstract class BaseActivity : AppCompatActivity()
{

    protected var isReadyToScann = true

    val TAG = "CoreScanner"

    private val SCANN_DELAY = 2000L

    private var handler = Handler()

    protected var toolBar: Toolbar? = null

    private val scannerReceiver = object : BroadcastReceiver()
    {
        override fun onReceive(context: Context, intent: Intent)
        {
            when (intent.action)
            {
                SystemBroadCast.SCN_CUST_ACTION_SCODE ->
                {
                    try
                    {
                        var message = ""
                        message = intent.getStringExtra(SystemBroadCast.SCN_CUST_EX_SCODE).toString()
                        onScannedData(message)
                    } catch (e: Exception)
                    {
                        e.printStackTrace()
                        onScannedError(e.message ?: "")
                    } finally
                    {
                        closeScanner(true)
                    }
                }

                SystemBroadCast.SCN_CUST_ACTION_START -> onScanStart()

                SystemBroadCast.SCN_CUST_ACTION_CANCEL -> onScanCancel()
            }

        }
    }

    override fun onContentChanged()
    {
        super.onContentChanged()
        toolBar = findViewById<Toolbar>(R.id.toolBar)
        toolBar?.let {
            it.title=""
            setSupportActionBar(it)
            val titleTV = it.findViewById<TextView>(R.id.titleTV)
            titleTV.text = getToolBarTitle()
        }
    }

    open fun getToolBarTitle(): String
    {
        return ""
    }

    open fun onScanStart()
    {
        LogUtil.logD(TAG, "scann start")
    }

    open fun onScanCancel()
    {
        LogUtil.logD(TAG, "scann cancel")
    }

    open fun onScannedData(message: String)
    {
        LogUtil.logD(TAG, "scann data is $message")
    }

    open fun onScannedError(message: String)
    {

    }


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        registerScannerReceiver()
    }

    private fun registerScannerReceiver()
    {

        val intentFilter = IntentFilter(SystemBroadCast.SCN_CUST_ACTION_SCODE)
        registerReceiver(scannerReceiver, intentFilter)
    }


    override fun onDestroy()
    {
        super.onDestroy()
        unregisterReceiver(scannerReceiver)
    }

    override fun dispatchKeyEvent(event: KeyEvent?): Boolean
    {
        if (event?.keyCode == 782 && isReadyToScann)
        {

            if (event.action == KeyEvent.ACTION_DOWN)
            {
                openScanner()
                return true
            } else if (event.action == KeyEvent.ACTION_UP)
            {

                closeScanner(false)
                return true
            }


        }
        return super.dispatchKeyEvent(event)
    }

    private fun openScanner()
    {
        val intent = Intent(SystemBroadCast.SCN_CUST_ACTION_START)
        sendBroadcast(intent)
        onScanStart()
    }

    private fun closeScanner(isGetResult: Boolean)
    {
        isReadyToScann = false
        val intent = Intent(SystemBroadCast.SCN_CUST_ACTION_CANCEL)
        sendBroadcast(intent)
        onScanCancel()
        if (!isGetResult)
        {
            isReadyToScann = true
        } else
        {
            handler.postDelayed(Runnable {
                isReadyToScann = true
            }, SCANN_DELAY)
        }

    }
}