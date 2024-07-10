package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class Introduction : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        val btnnext = findViewById<AppCompatTextView>(R.id.tvnext1)

        btnnext.setOnClickListener{
            startActivity(Intent(this,Introduction_1::class.java))
        }
    }
}