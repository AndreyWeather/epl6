package com.example.epl6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enkod.enkodpushlibrary.enkodConnect

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enkodConnect("andrey_p_client","test1_new@enkod.io").start(this)

    }
}