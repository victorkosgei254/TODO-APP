package com.example.recyclerexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val userList :List<User>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(item : View):RecyclerView.ViewHolder(item){
        val textViewName = item.findViewById(R.id.textViewName) as TextView
        val textViewAddress = item.findViewById(R.id.textViewAddress) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_view,parent,false)
        return ViewHolder(view)
        }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user : User = userList[position]
        holder.textViewName.text=user.name
        holder.textViewAddress.text = user.address
        }
}