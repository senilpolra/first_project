package com.example.project

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class Login : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var database: DatabaseReference
    private var  progressDilog: Dialog? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        database = Firebase.database.reference
        var pref: SharedPreferences? = null
        var EmailId =findViewById<AppCompatEditText>(R.id.edusre)
        var passwordss = findViewById<AppCompatEditText>(R.id.password)


        var login = findViewById<AppCompatButton>(R.id.buttlogin)


        login.setOnClickListener(View.OnClickListener {

            auth.signInWithEmailAndPassword(EmailId.text.toString(),passwordss.text.toString()).addOnCompleteListener(this){

                if (it.isSuccessful){
                    val emailid = it.result.user?.uid
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()

                    progressDilog?.dismiss()

                    startActivity(Intent(this,Homepage::class.java))

                }
                else {

                    Toast.makeText(this, "Not Successful", Toast.LENGTH_SHORT).show()

                    progressDilog?.dismiss()

                }

            }
            showprogree()



        })




        val SignUp = findViewById<AppCompatTextView>(R.id.Signup)

        SignUp.setOnClickListener(){
            startActivity(Intent(this,Register::class.java))
        }

        val forgotpassword = findViewById<AppCompatTextView>(R.id.tvforgot)

        forgotpassword.setOnClickListener(){
            startActivity(Intent(this,ForgotPassword::class.java))
        }
    }
    private fun showprogree(){
        progressDilog = Dialog(this)
        progressDilog?.setContentView(R.layout.progressbar)
        progressDilog?.setCancelable(false)
        progressDilog?.show()
    }


}