package com.example.recyclerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerexample.adapters.BlogRecyclerAdapter
import com.example.recyclerexample.data.DataSource
import com.example.recyclerexample.ui.TopSpacingDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var blogAdapter : BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecylerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data= DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    private fun initRecylerView(){
        recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            addItemDecoration(TopSpacingDecoration(30))
            blogAdapter = BlogRecyclerAdapter()
            adapter=blogAdapter
        }
    }
}
