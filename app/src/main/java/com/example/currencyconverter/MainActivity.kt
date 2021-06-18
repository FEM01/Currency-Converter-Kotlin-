package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    lateinit var tgl : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drL : DrawerLayout = findViewById(R.id.Home)
        val nV  : NavigationView = findViewById(R.id.HomeNaviView)

        tgl = ActionBarDrawerToggle(this, drL, R.string.open, R.string.close)
        drL.addDrawerListener(tgl)
        tgl.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nV.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeMenuAbout -> Toast.makeText(applicationContext, "About", Toast.LENGTH_SHORT).show()
                R.id.homeMenuSetting -> Toast.makeText(applicationContext, "Setting", Toast.LENGTH_SHORT).show()
                R.id.homeMenuFeedback -> Toast.makeText(applicationContext, "Feedback", Toast.LENGTH_SHORT).show()

            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (tgl.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}