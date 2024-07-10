package com.example.project

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class Adapter(var ArrayList: ArrayList<productdata>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {


     class MyViewHolder(view:View):RecyclerView.ViewHolder(view){

         val RvItem = view.findViewById<RecyclerView>(R.id.rvpost)

         val TvOffer = view.findViewById<TextView>(R.id.TvOffer)
         val TvDiscount = view.findViewById<TextView>(R.id.TvDiscount)
         val TvPrice = view.findViewById<TextView>(R.id.TvPrice)
         val ItemList = view.findViewById<TextView>(R.id.ItemList)
         val IvWhtch = view.findViewById<ImageView>(R.id.IvWhtch)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d("Adapter","onCreateViewHolder")
        var view =LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return ArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.d("Adapter","onBindViewHolder")


        val productdatas = ArrayList[position]
//
//        holder.ItemList.text = productdatas.item
//        holder.TvPrice.setText(productdatas.price)
//        holder.TvDiscount.setText(productdatas.Discount)
//        holder.TvOffer.setText(productdatas.Offer)
//        holder.IvWhtch.setImageResource(productdatas.img)

    }
}