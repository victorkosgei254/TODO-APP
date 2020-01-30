package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ClassCastException

class MainActivity : AppCompatActivity() {

//    val drawerToggle by lazy {
//        ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    navigationView.setNavigationItemSelectedListener {
        selectDrawerIter(it)
        true
    }
    }

    private fun selectDrawerIter(item:MenuItem){
        var fragment : Fragment ?= null
        val fragmentClass = when(item.itemId){
            R.id.first_fragment -> FragmentSample::class.java
            R.id.second_fragment -> Fragment2::class.java
            R.id.third_fragment -> Fragment3::class.java
            else -> FragmentSample::class.java //this is a class reference, means to access that class object

        }
        try {

            fragment=fragmentClass.newInstance() as Fragment
        } catch (e:ClassCastException){

            e.printStackTrace()
        }

        replaceFragment(fragment)
        drawerLayout.closeDrawer(GravityCompat.START)

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
            R.id.third_fragment->{
                val fragment = Fragment3.newInstance()
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
    private fun replaceFragment(fragment: Fragment?)
    {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FragmentContainer, fragment!!)
        fragmentTransaction.commit()
    }
}
