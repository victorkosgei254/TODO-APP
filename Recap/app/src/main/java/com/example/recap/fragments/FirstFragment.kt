package com.example.recap.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recap.R
import com.example.recap.adapters.UserAdapter
import com.example.recap.data.UserData
import kotlinx.android.synthetic.main.first_fragment_layout.*

class FirstFragment : Fragment(){
    private lateinit var userAdapter : UserAdapter

    companion object{
        fun newInstance() = FirstFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        addDataSet()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment_layout,container,false)

    }
    private fun addDataSet(){
        val data = UserData.createDataSet()
        userAdapter.submitList(data)
    }
    private fun  initRecyclerView(){
        recyclerView.apply {
            layoutManager= LinearLayoutManager(activity)
            userAdapter= UserAdapter()
            adapter=userAdapter
        }
    }
}