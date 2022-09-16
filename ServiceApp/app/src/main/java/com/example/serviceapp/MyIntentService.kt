package com.example.serviceapp

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    init {
        instance = this
    }

    companion object{
        private lateinit var instance : MyIntentService
        var isRunning = false

        fun stopService() {
            Log.i("MyService", "IntentService is stopped!")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(p0: Intent?) {
        isRunning = true

        try{
            while (isRunning){
                Log.i("MyService", "IntentService is running!")
                Thread.sleep(1000)
            }
        }catch (e: InterruptedException){
            Thread.currentThread().interrupt()
        }
    }
}