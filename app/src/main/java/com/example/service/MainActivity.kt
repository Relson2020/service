package com.example.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var boundService : BoundService
    var isbound = false

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val intent = Intent(this,BoundService::class.java)
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE)

        binding.buttonStartService.setOnClickListener {
            Log.i("log","main activity ")
             Intent(this,ForeGroundService::class.java).apply {
                putExtra("dataId","hey there it service")
                startForegroundService(this)
            }
        }
        binding.buttonStopService.setOnClickListener {
            boundService.toast()
        }
    }

    private val serviceConnection  =  object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val temp = service as BoundService.MyLocalBinder
            boundService = temp.getService()
            Log.i("log"," kkkkkkkkkkkkkkkkkk $boundService")
            isbound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isbound = false
        }

    }
}