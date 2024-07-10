package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class Introduction_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction2)

        val btnLogin = findViewById<AppCompatTextView>(R.id.getstarte)

        btnLogin.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
    }
}