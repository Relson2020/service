package com.example.service

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.i("log","service is running")
        GlobalScope.launch {
            while (true) {
                val data = intent?.getStringExtra("dataId").toString()
                Log.i("log", data)
                delay(2000)
            }
        }
        stopSelf()
        Log.i("log","service is stop")

//        //
//        val pendingIntent: PendingIntent =
//            Intent(this, ExampleActivity::class.java).let { notificationIntent ->
//                PendingIntent.getActivity(this, 0, notificationIntent, 0)
//            }
//
//        val notification: Notification = Notification.Builder(this, CHANNEL_DEFAULT_IMPORTANCE)
//            .setContentTitle("notification Title")
//            .setContentText("notification message ")
//            .setSmallIcon(R.drawable.ic_launcher_background)
//            .setContentIntent(pendingIntent)
//            .setTicker(getText(R.string.ticker_texts))
//            .build()
//
//// Notification ID cannot be 0.
//        startForeground(1, notification)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("log","service is destroy")
    }
}