package com.example.serviceapp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*

class MyBoundService : Service() {

    val myLocalBinder = MyLocalBinder()

    override fun onBind(intent: Intent): IBinder {
        return myLocalBinder
    }

    fun getSystemTime() : String {
        var simpleDateFormat = SimpleDateFormat("hh:mm:ss")
        return simpleDateFormat.format(Date())
    }

    inner class MyLocalBinder : Binder() {
        fun getBoundService() : MyBoundService{
            return this@MyBoundService
        }
    }
}