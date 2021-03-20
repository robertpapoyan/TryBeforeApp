package com.example.trybeforeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trybeforeapp.Controller.SignInActivity
import com.example.trybeforeapp.Controller.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_fourth.*


class FourthFragment : Fragment() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        Log.i("SignIn", "login: ${mAuth.uid}")

        //On sign in button click
//        profileSignInButton.setOnClickListener {
//            val intent = Intent(view.context, SignInActivity::class.java)
//            startActivity(intent)
//        }
//
//        //On sign up button click
//        profileSignUpButton.setOnClickListener {
//            val intent = Intent(view.context, SignUpActivity::class.java)
//            startActivity(intent)
//        }
        signOut.setOnClickListener {
            Log.i("SignIn", "login: ${mAuth.uid}")
            mAuth.signOut()
            Log.i("SIGNOUT", "LOGUT")
            Log.i("SignIn", "login: ${mAuth.uid}")
        }
    }
}