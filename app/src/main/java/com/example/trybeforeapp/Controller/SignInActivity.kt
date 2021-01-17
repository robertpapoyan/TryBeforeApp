package com.example.trybeforeapp.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyboardShortcutInfo
import android.view.View
import android.widget.Toast
import com.example.trybeforeapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signInButton.setOnClickListener {
            val signInUserEmail = signInEmailText.text.toString()
            val signInUserPassword = signInPasswordText.text.toString()

            if (signInUserEmail == "") {

                Toast.makeText(this, "Fill email please", Toast.LENGTH_LONG).show()

            } else if (signInUserPassword == "") {

                Toast.makeText(this, "Fill password please", Toast.LENGTH_LONG).show()

            } else {
                mAuth.signInWithEmailAndPassword(signInUserEmail,signInUserPassword)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Log.i("SignIn", "login: ${mAuth.uid}")
                            val loggedInUserProfilePage = Intent(this, LoggedInUserProfilePage::class.java)
                            startActivity(loggedInUserProfilePage)
                        }  else  {
                            Toast.makeText(this, "something went wrong you prick", Toast.LENGTH_LONG).show()
                        }
                    }
            }

        }


    }

//    fun signInButtonClicked(view: View){
//        login()
//    }
}