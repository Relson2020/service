package com.example.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.i("log","service is running")
        GlobalScope.launch {
            val data = intent?.getStringExtra("dataId").toString()
            Log.i("log",data)
        }
        stopSelf()
        Log.i("log","service is stop")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("log","service is destroy")
    }
}