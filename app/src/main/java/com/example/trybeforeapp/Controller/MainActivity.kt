package com.example.trybeforeapp.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trybeforeapp.Adapters.CategoryAdapter
import com.example.trybeforeapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Check if user is signed in or signed up
        var user = Firebase.auth.currentUser
        if (user != null) {
        // User is signed in
        val loggedInUserProfilePage = Intent(this, LoggedInUserProfilePage::class.java)
        startActivity(loggedInUserProfilePage)


        } else {

        // User is not signed in
        //On sign in button click

            profileSignInButton.setOnClickListener {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }

            //On sign up button click
            profileSignUpButton.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)

            }

        }



//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        val navController = findNavController(R.id.fragment)
//        bottomNavigationView.setupWithNavController(navController)
    }
}