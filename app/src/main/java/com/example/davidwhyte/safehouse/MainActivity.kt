package com.example.davidwhyte.safehouse

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    private lateinit var mDrawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        checkLogin()
        mDrawerLayout = findViewById(R.id.drawer_layout)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }


        val navigationView: NavigationView = findViewById(R.id.nav_view)
        displayFragment(0)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here
            displayFragment(menuItem.itemId)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                Log.v("home","95")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
    fun displayFragment(item_id:Int){
        var fragment:Fragment?=null
        if(item_id==R.id.nav_dash){
            fragment=DashFragment()
        }
        if(item_id==0){
            fragment=DashFragment()
        }
        if(item_id==R.id.nav_profile){
            fragment=ProfileFragment()
        }

        if(fragment!=null){
            Log.v("loaded_f","yes")
            val transaction:FragmentTransaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.content_frame,fragment)
            transaction.commit()
        }

    }



    fun checkLogin(){
        var a=0
        if(a==0){
            val intent=Intent(this,LoginActivity::class.java)
            val invest_intent=Intent(this,InvestActivity::class.java)
            startActivity(invest_intent)
        }
    }
}
