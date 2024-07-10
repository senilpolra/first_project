package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class Introduction_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction1)

        val btnLogin = findViewById<AppCompatTextView>(R.id.tvnext2)

        btnLogin.setOnClickListener{
            startActivity(Intent(this,Introduction_2::class.java))
        }
    }
}