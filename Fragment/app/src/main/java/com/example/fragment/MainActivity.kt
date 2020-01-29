package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.first_fragment -> {
                val fragment = FragmentSample.newInstatnce()
                replaceFragment(fragment)
                true
            }
            R.id.second_fragment -> {
                val fragment = Fragment2.newInstance()
                replaceFragment(fragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fragment_menu,menu)
        return true
    }
    private fun replaceFragment(fragment: Fragment)
    {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}
