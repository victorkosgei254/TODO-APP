package com.example.recyclerexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        adding recycler view to the project
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        val users = listOf<User>(
            User(name = "Victor",address = "134-Baltimore"),
            User(name = "Victor",address = "134-Baltimore"),
            User(name = "Victor",address = "134-Baltimore"),
            User(name = "Victor",address = "134-Baltimore"),
            User(name = "Victor",address = "134-Baltimore")
        )

        val adapter = CustomAdapter(users)
        recyclerView.adapter=adapter

    }
}
