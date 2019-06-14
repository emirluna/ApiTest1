package com.example.myapplication.ui

import android.media.session.MediaSession
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.common.Constantes
import com.example.myapplication.common.SharedPreferencesManager

class DashboardActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        var Name = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_NAME)
        var Token = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_TOKEN)

        Toast.makeText(this, "Hi ."+Name, Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Hi ."+Token, Toast.LENGTH_LONG).show()

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
