package com.example.learningretrofit


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class CustomViewHolder(val view:View):RecyclerView.ViewHolder(view) {

}
class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    val itemsFromNet = listOf<String>("One","Two","Three")

//    Get total size of list
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        here we are creating a view to  display out our list items, thus function receives a view grouf  and returns a view holder
        val layoutInflater = LayoutInflater.from(parent?.context)

//        So in place for activity_main we use a fragment used to display list elements

        val cellForRow = layoutInflater.inflate(R.layout.activity_main,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val videoTitle = itemsFromNet.get(position)
//        holder!!.view!!.textView_video_title!!.text = itemsFromNet
    }
}


