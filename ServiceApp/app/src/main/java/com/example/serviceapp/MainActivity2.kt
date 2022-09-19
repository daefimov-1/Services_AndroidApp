package com.example.serviceapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    var boundService = MyBoundService()
    lateinit var button : Button
    lateinit var textView: TextView
    lateinit var serviceInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()

        var intent = Intent(this, MyBoundService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)

        button = findViewById(R.id.btn_getTime)
        textView = findViewById(R.id.tv_time)
        serviceInfo = findViewById(R.id.tv_info_3)


        button.setOnClickListener {
            textView.text = boundService.getSystemTime()
        }
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            var binder : MyBoundService.MyLocalBinder = p1 as MyBoundService.MyLocalBinder
            boundService = binder.getBoundService()
            Log.d("MyService", "Bound service is connected")
            serviceInfo.text = "BoundService is connected"
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.d("MyService", "Bound service is disconnected")
            serviceInfo.text = "BoundService is disconnected"
        }

    }

}