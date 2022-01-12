package com.example.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ForeGroundService : Service() {

    override fun onBind(intent: Intent): IBinder? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        GlobalScope.launch {
            var num = 0
            while(num<5) {
                Log.i("log", "foreground service")
                delay(2000)
                num+=1
            }
            stopSelf()
        }
        val notificationChannel = NotificationChannel("channelId","channelId",NotificationManager.IMPORTANCE_LOW)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)

        val notificationBuilder = NotificationCompat.Builder(this, "channelId")
            .setContentTitle("ForeGround service ")
            .setContentText("foreGround service notification")
            .setSmallIcon(R.drawable.ic_launcher_background)

        startForeground(101,notificationBuilder.build())
        return START_STICKY
    }
}