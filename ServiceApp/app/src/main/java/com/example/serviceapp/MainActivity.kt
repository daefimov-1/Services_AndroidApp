package com.example.serviceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var goToSecondActivityButton: Button
    lateinit var startButton: Button
    lateinit var stopButton: Button
    lateinit var startButton2: Button
    lateinit var stopButton2: Button
    lateinit var text: TextView
    lateinit var text2: TextView
    lateinit var sendButton: Button
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        goToSecondActivityButton = findViewById(R.id.btn_goToSecondActivity)
        goToSecondActivityButton.setOnClickListener {
            Intent(this, MainActivity2::class.java).also {
                startActivity(it)
            }
        }

        startButton = findViewById(R.id.btn_start)
        stopButton = findViewById(R.id.btn_stop)
        text = findViewById(R.id.tv_info)

        startButton.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                text.text = "IntentService running"
            }
        }

        stopButton.setOnClickListener {
            MyIntentService.stopService()
            text.text = "IntentService stopped"
        }

        startButton2 = findViewById(R.id.btn_start_2)
        stopButton2 = findViewById(R.id.btn_stop_2)
        text2 = findViewById(R.id.tv_info_2)
        sendButton = findViewById(R.id.btn_sendData)
        editText = findViewById(R.id.et_stringData)

        startButton2.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                text2.text = "Service running"
            }
        }

        stopButton2.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                text2.text = "Service stopped"
            }
        }

        sendButton.setOnClickListener {
            Intent(this, MyService::class.java)
                .putExtra("EXTRA_DATA", editText.text.toString())
                .also {
                    startService(it)
                    text2.text = "Service running"
            }
        }
    }
}