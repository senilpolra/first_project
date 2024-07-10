package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class Homepage : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var productData:ArrayList<productdata>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)


        recyclerView = findViewById<RecyclerView>(R.id.rvpost)

        var ImgArray = arrayOf(
            R.drawable.mask_group ,
            R.drawable.mask_group1,
            R.drawable.mask_group2,
        )

        var headingArray = arrayOf(
            "IWC Schaffhausen 2021 Pilot's Watch 'SIHH 2019' 44mm ", "₹650" ,"------","60% off",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            )

//        val dataForAdapter = Adapter(productData)


//        recyclerView.layoutManager = LinearLayoutManager(this)
//        productData = arrayListOf<Rv_item>()
//
//        for ( index in ImgArray.indices){
//            val news = Rv_item(headingArray[index],ImgArray[index])
//            productData .add(news)
//        }
//
//        recyclerView.adapter = Adapter(productdata,this)
//
//        recyclerview.adapter = dataForAdapter

//        val data = ArrayList<productdata>()
//
//        for (i in 1..1){
//
//            data.add(productdata(R.layout.rv_item, "img" + i))
//
//            Toast.makeText(this@Homepage,"yess",Toast.LENGTH_SHORT).show()
//
//        }
//
//        val adapter = Adapter(data)

//        recyclerview.adapter = adapter

        val dataTaker = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                productData.addAll(productData)
                     snapshot.child("posts")
                Toast.makeText(this@Homepage,"yess",Toast.LENGTH_SHORT).show()

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }

        var Ivsettings = findViewById<ImageView>(R.id.Ivsettings)

        Ivsettings.setOnClickListener(){
            startActivity(Intent(this,Exit::class.java))
        }
    }

}
