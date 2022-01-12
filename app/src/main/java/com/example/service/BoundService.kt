package com.example.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.widget.Toast

class BoundService : Service() {

    private val binder : IBinder  = MyLocalBinder()

    override fun onBind(intent: Intent): IBinder{
        return binder
    }

    inner class MyLocalBinder: Binder() {
        fun getService() : BoundService {
            return this@BoundService
        }
    }

    fun toast (){
        Toast.makeText(applicationContext,"hey its work some how ",Toast.LENGTH_SHORT).show()
    }

}
