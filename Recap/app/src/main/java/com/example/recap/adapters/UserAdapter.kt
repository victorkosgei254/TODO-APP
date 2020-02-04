package com.example.recap.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recap.R
import com.example.recap.models.User
import kotlinx.android.synthetic.main.list_items.view.*
import kotlinx.android.synthetic.main.second_layout_fragment.view.*

class UserAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
//    THis is to hold all users in the
    private var users : List<User> = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is UserViewHolder ->{
                holder.bind(users.get(position))
            }
        }
    }


    fun submitList(userList :List<User>){
        users = userList
    }
    class UserViewHolder constructor(userView:View):RecyclerView.ViewHolder(userView){
        val username = userView.username
        val contact = userView.contact
        val profile = userView.profile

//        Binding data to these views
        fun bind(user: User){
            username.setText(user.username)
            contact.setText(user.contact)

            //Glide module to be set here to parse images
            val requestOptions = RequestOptions().placeholder(R.drawable.user_image).error(R.drawable.user_image)
            Glide.with(profile.context).applyDefaultRequestOptions(requestOptions).load(user.profile).into(profile)

        }
    }

}