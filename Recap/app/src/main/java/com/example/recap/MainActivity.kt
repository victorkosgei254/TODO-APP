package com.example.recap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.recap.fragments.FirstFragment
import com.example.recap.fragments.FragmentThree
import com.example.recap.fragments.FragmentTwo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.first_fragment -> {
                val fragment = FirstFragment.newInstance()
                replaceFragment(fragment)
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
}
