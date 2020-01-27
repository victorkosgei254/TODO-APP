package com.example.boxes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickable:List<View> = listOf(box_one_text,box_two_text,box_five_text,box_three_text,box_four_text,mi_layout)
        val colors:List<String> = listOf("#FF5733","#213A58","#E10BEF","#0BBFEF","#CBB017")
        for (item in clickable)
        {
            item.setOnClickListener{
                it.setBackgroundColor(Color.parseColor(colors.random()))
            }
        }
    }

}
