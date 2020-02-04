package com.example.recap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recap.adapters.UserAdapter
import com.example.recap.data.UserData
import com.example.recap.fragments.FirstFragment
import com.example.recap.fragments.FragmentThree
import com.example.recap.fragments.FragmentTwo
import kotlinx.android.synthetic.main.first_fragment_layout.*

class MainActivity : AppCompatActivity() {
//    private lateinit var userAdapter : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        initRecyclerView()
//        addDataSet()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.first_fragment -> {
                val fragment = FirstFragment.newInstance()
                replaceFragment(fragment)
//                initRecyclerView()
//                addDataSet()
                true
            }

            R.id.second_fragment -> {
                val fragment = FragmentTwo.newInstance()
                replaceFragment(fragment)
                true
            }
            R.id.third_fragment ->{
                val fragment = FragmentThree.newInstance()
                replaceFragment(fragment)
                true
            }
            else -> onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.myFrame,fragment)
        fragmentTransaction.commit()
    }


//    private fun addDataSet(){
//        val data = UserData.createDataSet()
//        userAdapter.submitList(data)
//    }
//    private fun  initRecyclerView(){
//        recyclerView.apply {
//            layoutManager=LinearLayoutManager(this@MainActivity)
//            userAdapter=UserAdapter()
//            adapter=userAdapter
//        }
//    }

}
