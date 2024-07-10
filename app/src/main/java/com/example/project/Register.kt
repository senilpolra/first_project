package com.example.project

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class Register : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var database: DatabaseReference

    private lateinit var Email:EditText
    private lateinit var Password:EditText
    private lateinit var ConfirmPassword:EditText
    private lateinit var register:Button
    private var  progressDilog: Dialog? = null


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth
        database = Firebase.database.reference

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        var pref: SharedPreferences? = null

        register = findViewById(R.id.Buttcreateaccount)
        Email =findViewById(R.id.etusre)
        Password = findViewById(R.id.etpassword)
        ConfirmPassword = findViewById(R.id.ConfirmPassword)



        register.setOnClickListener(/* l = */ View.OnClickListener {

//            auth.createUserWithEmailAndPassword(Email.text.toString(), Password.text.toString())
//                .addOnCompleteListener(this) {
//
//                    if (it.isSuccessful) {
//                        val userId = it.result.user?.uid
//                        Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
//                        startActivity(Intent(this, Homepage::class.java))
//
//                    } else {
//                        Toast.makeText(this, "Not Successful", Toast.LENGTH_SHORT).show()
//                    }
//                }
            val emails = Email.text.toString()
            val passwords = Password.text.toString()
            val confirmpasswords = ConfirmPassword.text.toString()


            showprogree()


        val users = User(emails,passwords, confirmpasswords)
            database.child("userds").setValue(users).addOnCompleteListener{
                Toast.makeText(this,"yessss",Toast.LENGTH_SHORT).show()
                            progressDilog?.dismiss()
                startActivity(Intent(this,Homepage::class.java))

            }.addOnFailureListener {

                Toast.makeText(this,"noooooooo",Toast.LENGTH_SHORT).show()
                            progressDilog?.dismiss()

            }
        })


            val Login = findViewById<AppCompatTextView>(R.id.Login)

            Login.setOnClickListener() {
                startActivity(Intent(this, Login::class.java))
            }
        }


    private fun showprogree(){
        progressDilog = Dialog(this)
        progressDilog?.setContentView(R.layout.progressbar)
        progressDilog?.setCancelable(false)
        progressDilog?.show()
    }
}

