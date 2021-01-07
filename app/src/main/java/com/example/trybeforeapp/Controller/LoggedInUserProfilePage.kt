package com.example.trybeforeapp.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.trybeforeapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoggedInUserProfilePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in_user_profile_page)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)
    }
}