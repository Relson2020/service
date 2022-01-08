package com.example.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.buttonStartService.setOnClickListener {
            Log.i("log","main activity ")
             Intent(this,MyService::class.java).apply {
                putExtra("dataId","hey there it service")
                startService(this)
            }
        }
        binding.buttonStopService.setOnClickListener {
            Intent(this,MyService::class.java).apply {
                putExtra("dataId","hey there it service")
                stopService(this)
            }
        }

    }
}