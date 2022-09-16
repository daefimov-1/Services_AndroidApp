package com.example.serviceapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    val TAG = "MyService"

    init {
        Log.i(TAG, "Service is running!")
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val extraData = intent?.getStringExtra("EXTRA_DATA")
        extraData?.let {
            Log.i(TAG, extraData)
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Service is killed!")
    }
}